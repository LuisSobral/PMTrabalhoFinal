package ClassesDeXML;

import ClasseDeZip.DescompactarZip;
import ClassesObjetos.Artigo;
import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

/**
 * Classe para a leitura dos arquivos XML
 */
public class LeituraXML {
    
    /*
        Método de leitura do arquivo XML que contém o nome dos programas
    */
    public void leituraDeProgramas(Programa programa) throws ParserConfigurationException, SAXException, IOException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();        
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("https://s3.amazonaws.com/posgraduacao/programas.xml");
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        Element root = jdomDocument.getRootElement();
        
        Element child = root.getChild("programa");
       
        String nomePrograma = child.getAttributeValue("nome");
        
        programa.setNome(nomePrograma);
    }
    /*
        Método de leitura do arquivo XML que contém o nome das linhas e dos professores
    */
    public void leituraDeLinhasEProfessores(Programa programa) throws ParserConfigurationException, SAXException, IOException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        String nomeArquivoInicial = "https://s3.amazonaws.com/posgraduacao/";
        String nomePrograma = programa.getNome();
        String nomeArquivo = nomeArquivoInicial.concat(nomePrograma).concat("/contents.xml");
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse(nomeArquivo);
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        Element root = jdomDocument.getRootElement();
        
        List<Element> filhosRoot = root.getChildren();
        
        for(int i=0; i<filhosRoot.size(); i++) {
            
            LinhaDePesquisa linha = new LinhaDePesquisa();
            String nomeLinha = filhosRoot.get(i).getAttributeValue("nome");
            linha.setNome(nomeLinha);
            
            programa.adicionaLinha(linha);
            
            List<Element> filhosLinha = filhosRoot.get(i).getChildren();
            
            for(int j=0; j<filhosLinha.size(); j++) {
                
                Professor professor = new Professor();
                String codigoProfessor = filhosLinha.get(j).getAttributeValue("codigo");
                professor.setCodigo(codigoProfessor);
                
                String nomeProfessor = filhosLinha.get(j).getAttributeValue("nome");
                professor.setNome(nomeProfessor);
                
               linha.adicionaProfessor(professor);
            }
        }
    
    }
    
    public void leituraDeCurriculos(Programa programa, String anoInicio, String anoFim) throws SAXException, IOException, ParserConfigurationException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        String nomeArquivoInicial = "https://s3.amazonaws.com/posgraduacao/";
        String nomePrograma = programa.getNome();
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()){
                
                String nomeArquivo = nomeArquivoInicial.concat(nomePrograma).concat("/").concat(professor.getCodigo()).concat(".zip");
                DescompactarZip arquivoZip = new DescompactarZip();
                File arquivoXML = arquivoZip.descompactarArquivo(nomeArquivo, professor.getCodigo());
                org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("file:///"+arquivoXML.getAbsolutePath());
                DOMBuilder jdomBuilder = new DOMBuilder();

                Document jdomDocument = jdomBuilder.build(docProgramas);

                Element root = jdomDocument.getRootElement();

                List<Element> filhosRoot = root.getChildren();
                
                procurarTag(professor, filhosRoot, anoInicio, anoFim);
                
                if(arquivoXML.delete())
                    System.out.println("Currículo do Professor: " + professor.getNome() + " analisado.");
            }
        }
    
    /*
        Método para ler os artigos de eventos de cada um dos professores
    
    */
    public void lerArtigosEventos(Professor professor, List<Element> filhosTrabalhosEmEventos, String  anoInicio, String anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosTrabalhoEmEventos=0; contadorFilhosTrabalhoEmEventos < filhosTrabalhosEmEventos.size(); contadorFilhosTrabalhoEmEventos++) {
            List<Element> filhosTrabalhosEmEventos2 = filhosTrabalhosEmEventos.get(contadorFilhosTrabalhoEmEventos).getChildren();

            for(int contadorFilhosTrabalhoEmEventos2 = 0; contadorFilhosTrabalhoEmEventos2< filhosTrabalhosEmEventos2.size(); contadorFilhosTrabalhoEmEventos2++) {
                if(filhosTrabalhosEmEventos2.get(contadorFilhosTrabalhoEmEventos2).getName().equals("DADOS-BASICOS-DO-TRABALHO")) {
                    String ano = filhosTrabalhosEmEventos2.get(contadorFilhosTrabalhoEmEventos2).getAttributeValue("ANO-DO-TRABALHO");
                    int anoTrabalho = Integer.parseInt(ano);
                    int anoIni = Integer.parseInt(anoInicio);
                    int anoF = Integer.parseInt(anoFim);
                    if((anoTrabalho >= anoIni) && (anoTrabalho <= anoF))
                        filhosUsados.add(filhosTrabalhosEmEventos.get(contadorFilhosTrabalhoEmEventos));
                }
            }
                
            for(int contadorFilhosUsados=0; contadorFilhosUsados<filhosUsados.size(); contadorFilhosUsados++) {
                List<Element> filhosArtigos = filhosUsados.get(contadorFilhosUsados).getChildren();
                    
                for(int contadorFilhosArtigos = 0; contadorFilhosArtigos < filhosArtigos.size(); contadorFilhosArtigos++) {
                    if(filhosArtigos.get(contadorFilhosArtigos).getName().equals("DETALHAMENTO-DO-TRABALHO")) {
                        Artigo artigo = new Artigo("",filhosArtigos.get(contadorFilhosArtigos).getAttributeValue("NOME-DO-EVENTO"));
                        professor.adicionaArtigoEvento(artigo);
                    }
                }   
            }
        }
    }

    /*
        Método para ler os artigos de revistas de cada um dos professores
    
    */
    private void lerArtigosRevista(Professor professor, List<Element> filhosArtigosPublicados, String  anoInicio, String anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();

        for(int contadorFilhosArtigosPublicados=0; contadorFilhosArtigosPublicados < filhosArtigosPublicados.size(); contadorFilhosArtigosPublicados++) {
            List<Element> filhosArtigoPublicado = filhosArtigosPublicados.get(contadorFilhosArtigosPublicados).getChildren();
            
            for(int contadorFilhosArtigoPublicado = 0; contadorFilhosArtigoPublicado< filhosArtigoPublicado.size(); contadorFilhosArtigoPublicado++) {
                if(filhosArtigoPublicado.get(contadorFilhosArtigoPublicado).getName().equals("DADOS-BASICOS-DO-ARTIGO")) {
                    String ano = filhosArtigoPublicado.get(contadorFilhosArtigoPublicado).getAttributeValue("ANO-DO-ARTIGO");
                    int anoArtigo = Integer.parseInt(ano);
                    int anoIni = Integer.parseInt(anoInicio);
                    int anoF = Integer.parseInt(anoFim);
                    if((anoArtigo >= anoIni) && (anoArtigo <= anoF))
                        filhosUsados.add(filhosArtigosPublicados.get(contadorFilhosArtigosPublicados));
                }
            }
            
            for(int contadorFilhosUsados=0; contadorFilhosUsados<filhosUsados.size(); contadorFilhosUsados++) {
                List<Element> filhosArtigo = filhosUsados.get(contadorFilhosUsados).getChildren();
                
                for(int contadorFilhosArtigo = 0; contadorFilhosArtigo < filhosArtigo.size(); contadorFilhosArtigo++) {
                    if(filhosArtigo.get(contadorFilhosArtigo).getName().equals("DETALHAMENTO-DO-ARTIGO")) {
                        Artigo artigo = new Artigo("",filhosArtigo.get(contadorFilhosArtigo).getAttributeValue("TITULO-DO-PERIODICO-OU-REVISTA"));
                        professor.adicionaArtigoRevista(artigo);
                    }
                }
            }
        }
    }

    /*
        Método para ler as orientações concluídas de cada professor
    
    */
    private void lerOrientacoesConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, String  anoInicio, String anoFim) {
        
        List<Element> filhosUsadosM = new ArrayList<Element>();
        List<Element> filhosUsadosD = new ArrayList<Element>();
        List<Element> filhosUsadosG = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
             
            switch(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getName()) {
                case "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO":
                    List<Element> filhosOrientacoesMestrado = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();

                    for(int contadorFilhosMestrado = 0; contadorFilhosMestrado < filhosOrientacoesMestrado.size(); contadorFilhosMestrado++) {
                        if(filhosOrientacoesMestrado.get(contadorFilhosMestrado).getName().equals("DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")) {
                            String ano = filhosOrientacoesMestrado.get(contadorFilhosMestrado).getAttributeValue("ANO");
                            int anoOrientacoesMestrado = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoOrientacoesMestrado >= anoIni) && (anoOrientacoesMestrado <= anoF))
                                filhosUsadosM.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                        }
                    }
                    
                    professor.setNumeroOrientacaoMestradoConcluidas(filhosUsadosM.size());
                    break;
                    
                case "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO":
                    List<Element> filhosOrientacoesDoutorado = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();

                    for(int contadorFilhosDoutorado = 0; contadorFilhosDoutorado < filhosOrientacoesDoutorado.size(); contadorFilhosDoutorado++) {
                        if(filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getName().equals("DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO")) {
                            String ano = filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getAttributeValue("ANO");
                            int anoOrientacoesDoutorado = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoOrientacoesDoutorado >= anoIni) && (anoOrientacoesDoutorado <= anoF))
                                filhosUsadosD.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                        }
                    }
                    
                    professor.setNumeroOrientacaoDoutoradoConcluidas(filhosUsadosD.size());
                    break;
                    
                case "OUTRAS-ORIENTACOES-CONCLUIDAS":
                    List<Element> filhosOrientacoesGraduacao = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();

                    for(int contadorFilhosGraduacao = 0; contadorFilhosGraduacao < filhosOrientacoesGraduacao.size(); contadorFilhosGraduacao++) {
                        if(filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getName().equals("DADOS-BASICOS-DE-OUTRAS-ORIENTACOES-CONCLUIDAS")) {
                            String ano = filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getAttributeValue("ANO");
                            int anoOrientacoesGraduacao = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoOrientacoesGraduacao >= anoIni) && (anoOrientacoesGraduacao <= anoF))
                                filhosUsadosG.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                        }
                    }
                    
                    professor.setNumeroOrientacaoGraduacaoConcluidas(filhosUsadosG.size());
                    break;
            }
        }
    }
    
    /*
        Método para ler as orientações em andamento de cada professor
    
    */
    private void lerOrientacoesAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, String  anoInicio, String anoFim) {
                
        List<Element> filhosUsadosM = new ArrayList<Element>();
        List<Element> filhosUsadosD = new ArrayList<Element>();
        List<Element> filhosUsadosG = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            
            switch(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getName()) {
                case "ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO":
                    List<Element> filhosOrientacoesMestrado = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
                    for(int contadorFilhosMestrado = 0; contadorFilhosMestrado < filhosOrientacoesMestrado.size(); contadorFilhosMestrado++) {
                        if(filhosOrientacoesMestrado.get(contadorFilhosMestrado).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO")) {
                            String ano = filhosOrientacoesMestrado.get(contadorFilhosMestrado).getAttributeValue("ANO");
                            int anoOrientacoesMestrado = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoOrientacoesMestrado >= anoIni) && (anoOrientacoesMestrado <= anoF))
                                filhosUsadosM.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                        }
                    }
                    
                    professor.setNumeroOrientacaoMestradoAndamento(filhosUsadosM.size());
                    break;
                    
                case "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO":
                    List<Element> filhosOrientacoesDoutorado = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
                    for(int contadorFilhosDoutorado = 0; contadorFilhosDoutorado < filhosOrientacoesDoutorado.size(); contadorFilhosDoutorado++) {
                        if(filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO")) {
                            String ano = filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getAttributeValue("ANO");
                            int anoOrientacoesDoutorado = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoOrientacoesDoutorado >= anoIni) && (anoOrientacoesDoutorado <= anoF))
                                filhosUsadosD.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                        }
                    }
                    
                    professor.setNumeroOrientacaoDoutoradoAndamento(filhosUsadosD.size());
                    break;
                    
                case "ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO":
                    List<Element> filhosOrientacoesGraduacao = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
                    for(int contadorFilhosGraduacao = 0; contadorFilhosGraduacao < filhosOrientacoesGraduacao.size(); contadorFilhosGraduacao++) {
                        if(filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO")) {
                            String ano = filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getAttributeValue("ANO");
                            int anoOrientacoesGraduacao = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoOrientacoesGraduacao >= anoIni) && ( anoOrientacoesGraduacao <= anoF))
                                filhosUsadosG.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                        }
                    }
                    
                    professor.setNumeroOrientacaoGraduacaoAndamento(filhosUsadosG.size());
                    break;
            }
        }
    }
    
    /*
        Método para ler as participações em banca de cada professor
    
    */
    private void lerParticipacoesBanca(Professor professor, List<Element> filhosParticipacaoBanca, String  anoInicio, String anoFim) {
        
        List<Element> filhosUsadosM = new ArrayList<Element>();
        List<Element> filhosUsadosD = new ArrayList<Element>();
        List<Element> filhosUsadosG = new ArrayList<Element>();
        
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            
            switch(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getName()) {
                case "PARTICIPACAO-EM-BANCA-DE-MESTRADO":
                    List<Element> filhosBancaMestrado = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
                    for(int contadorBancaMestrado = 0; contadorBancaMestrado < filhosBancaMestrado.size(); contadorBancaMestrado++) {
                        if(filhosBancaMestrado.get(contadorBancaMestrado).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-MESTRADO")) {
                            String ano = filhosBancaMestrado.get(contadorBancaMestrado).getAttributeValue("ANO");
                            int anoBancaMestrado = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoBancaMestrado >= anoIni) && (anoBancaMestrado <= anoF))
                                filhosUsadosM.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                        }
                    }
                    
                    professor.setNumeroBancasMestrado(filhosUsadosM.size());
                    break;
                    
                case "PARTICIPACAO-EM-BANCA-DE-DOUTORADO":
                    List<Element> filhosBancaDoutorado = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
                    for(int contadorBancaDoutorado = 0; contadorBancaDoutorado < filhosBancaDoutorado.size(); contadorBancaDoutorado++) {
                        if(filhosBancaDoutorado.get(contadorBancaDoutorado).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-DOUTORADO")) {
                            String ano = filhosBancaDoutorado.get(contadorBancaDoutorado).getAttributeValue("ANO");
                            int anoBancaDoutorado = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoBancaDoutorado >= anoIni) && (anoBancaDoutorado <= anoF))
                                filhosUsadosD.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                        }
                    }
                    
                    professor.setNumeroBancasDoutorado(filhosUsadosD.size());
                    break;
                    
                case "PARTICIPACAO-EM-BANCA-DE-GRADUACAO":
                    List<Element> filhosBancaGraduacao = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
                    for(int contadorBancaGraduacao = 0; contadorBancaGraduacao < filhosBancaGraduacao.size(); contadorBancaGraduacao++) {
                        if(filhosBancaGraduacao.get(contadorBancaGraduacao).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-GRADUACAO")) {
                            String ano = filhosBancaGraduacao.get(contadorBancaGraduacao).getAttributeValue("ANO");
                            int anoBancaGraduacao = Integer.parseInt(ano);
                            int anoIni = Integer.parseInt(anoInicio);
                            int anoF = Integer.parseInt(anoFim);
                            if((anoBancaGraduacao >= anoIni) && (anoBancaGraduacao <= anoF))
                                filhosUsadosG.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                        }
                    }
                    
                    professor.setNumeroBancasGraduacao(filhosUsadosG.size());
                    break;
            }
        }
    }

    private void procurarTag(Professor professor, List<Element> filhosRoot, String anoInicio, String anoFim) {
        
        for(int contadorFilhosRoot = 0; contadorFilhosRoot < filhosRoot.size(); contadorFilhosRoot++) {
            
            if(filhosRoot.get(contadorFilhosRoot).getName().equals("PRODUCAO-BIBLIOGRAFICA")) {
                List<Element> filhosPRODUCAOBBL = filhosRoot.get(contadorFilhosRoot).getChildren();
                
                for(int contadorFilhosProducaoB=0; contadorFilhosProducaoB < filhosPRODUCAOBBL.size(); contadorFilhosProducaoB++) {
                    if(filhosPRODUCAOBBL.get(contadorFilhosProducaoB).getName().equals("TRABALHOS-EM-EVENTOS")) {
                        List<Element> filhosTrabalhosEmEventos = filhosPRODUCAOBBL.get(contadorFilhosProducaoB).getChildren();
                        lerArtigosEventos(professor, filhosTrabalhosEmEventos, anoInicio, anoFim);
                    }
                    
                    if(filhosPRODUCAOBBL.get(contadorFilhosProducaoB).getName().equals("ARTIGOS-PUBLICADOS")) {
                        List<Element> filhosArtigosPublicados = filhosPRODUCAOBBL.get(contadorFilhosProducaoB).getChildren();
                        lerArtigosRevista(professor, filhosArtigosPublicados,  anoInicio, anoFim);
                    }
                }
            }

            if(filhosRoot.get(contadorFilhosRoot).getName().equals("OUTRA-PRODUCAO")) {
                List<Element> filhosOUTRAPROD = filhosRoot.get(contadorFilhosRoot).getChildren();
                
                for(int contadorFilhosOutraProd=0; contadorFilhosOutraProd < filhosOUTRAPROD.size(); contadorFilhosOutraProd++) {
                    if(filhosOUTRAPROD.get(contadorFilhosOutraProd).getName().equals("ORIENTACOES-CONCLUIDAS")) {
                        List<Element> filhosOrientacoesConcluidas = filhosOUTRAPROD.get(contadorFilhosOutraProd).getChildren();
                        lerOrientacoesConcluidas(professor, filhosOrientacoesConcluidas,  anoInicio, anoFim);
                    }
                }
            }
            
            if(filhosRoot.get(contadorFilhosRoot).getName().equals("DADOS-COMPLEMENTARES")) {
                List<Element> filhosDADOSCOMPL = filhosRoot.get(contadorFilhosRoot).getChildren();
                
                for(int contadorFilhosDadosCompl=0; contadorFilhosDadosCompl < filhosDADOSCOMPL.size(); contadorFilhosDadosCompl++) {
                    switch(filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getName()) {
                        case "ORIENTACOES-EM-ANDAMENTO":
                            List<Element> filhosOrientacoesAndamento = filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getChildren();
                            lerOrientacoesAndamento(professor, filhosOrientacoesAndamento,  anoInicio, anoFim);
                            break;
                        
                        case "PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO":
                            List<Element> filhosParticipacaoBanca = filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getChildren();
                            lerParticipacoesBanca(professor, filhosParticipacaoBanca,  anoInicio, anoFim);
                            break;
                    }
                }
            }
        }
    }
}
