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
        
        //Recebe o arquivo xml
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("https://s3.amazonaws.com/posgraduacao/programas.xml");
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        //Pega o elemento do root do xml
        Element root = jdomDocument.getRootElement();
        
        
        //Pega o filho do root com nome de programa
        Element child = root.getChild("programa");
       
        //Pega o valor do atributo de nome: "nome"
        String nomePrograma = child.getAttributeValue("nome");
        
        //Seta o nome do programa como o valor do atributo
        programa.setNome(nomePrograma);
    }
    
    /*
        Método de leitura do arquivo XML que contém o nome das linhas e dos professores
    */
    public void leituraDeLinhasEProfessores(Programa programa) throws ParserConfigurationException, SAXException, IOException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        
        //Cria o link para pegar o xml
        String nomeArquivoInicial = "https://s3.amazonaws.com/posgraduacao/";
        String nomePrograma = programa.getNome();
        String nomeArquivo = nomeArquivoInicial.concat(nomePrograma).concat("/contents.xml");
        
        //Recebe o arquivo xml
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse(nomeArquivo);
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        //Pega o elemento do root do xml
        Element root = jdomDocument.getRootElement();
        
        //Pega os filhos linha do elemento root
        List<Element> filhosRoot = root.getChildren();
        
        //Para cada um dos filhos linha de root
        for(int i=0; i<filhosRoot.size(); i++) {
            
            //Cria uma linha de pesquisa e seta seu nome como o valor o atributo nome
            LinhaDePesquisa linha = new LinhaDePesquisa();
            String nomeLinha = filhosRoot.get(i).getAttributeValue("nome");
            linha.setNome(nomeLinha);
            
            //Adiciona linha o programa
            programa.adicionaLinha(linha);
            
            //Pega os filhos professor de cada linha
            List<Element> filhosLinha = filhosRoot.get(i).getChildren();
            
            //Para cada filho professor da linha
            for(int j=0; j<filhosLinha.size(); j++) {
                
                //Cria um profesor e seta seu nome como o valor o atributo nome
                //E o seu código como o valor do atributo codigo
                Professor professor = new Professor();
                String codigoProfessor = filhosLinha.get(j).getAttributeValue("codigo");
                professor.setCodigo(codigoProfessor);
                
                String nomeProfessor = filhosLinha.get(j).getAttributeValue("nome");
                professor.setNome(nomeProfessor);
                
                //Adiciona o professor a linha
               linha.adicionaProfessor(professor);
            }
        }
    
    }
    
    /*
        Método para a leitura de currículo
    */
    public void leituraDeCurriculos(Programa programa, String anoInicio, String anoFim) throws SAXException, IOException, ParserConfigurationException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        
        //Cria link para receber o xml dos curriculos
        String nomeArquivoInicial = "https://s3.amazonaws.com/posgraduacao/";
        String nomePrograma = programa.getNome();
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()){
                
                //Continuação da criação do link correto
                String nomeArquivo = nomeArquivoInicial.concat(nomePrograma).concat("/").concat(professor.getCodigo()).concat(".zip");
                
                //Chama função para descompactar os zip com os curriculos
                DescompactarZip arquivoZip = new DescompactarZip();
                
                //Recebe arquivo xml
                File arquivoXML = arquivoZip.descompactarArquivo(nomeArquivo, professor.getCodigo());
                org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("file:///"+arquivoXML.getAbsolutePath());
                DOMBuilder jdomBuilder = new DOMBuilder();

                Document jdomDocument = jdomBuilder.build(docProgramas);
                
                //Pega o elemento do root do xml
                Element root = jdomDocument.getRootElement();
                
                //Pega os filhos de root
                List<Element> filhosRoot = root.getChildren();
                
                //Chama função para achar determinados filhos
                procurarTag(professor, filhosRoot, anoInicio, anoFim);
                
                //Deleta arquivo xml do curriculo baixado e escrito no disco
                arquivoXML.delete();
            }
    }
    
    /*
        Método para procurar determinados elementos filhos do root no xml
    */
    private void procurarTag(Professor professor, List<Element> filhosRoot, String anoInicio, String anoFim) {
        
        //Para cada um dos elementos filhos de root
        for(int contadorFilhosRoot = 0; contadorFilhosRoot < filhosRoot.size(); contadorFilhosRoot++) {
            
            //Procura elementos com nome "PRODUCAO-BIBLIOGRAFICA"
            if(filhosRoot.get(contadorFilhosRoot).getName().equals("PRODUCAO-BIBLIOGRAFICA")) {
                //Cria lista de elementos filhos de "PRODUCAO-BIBLIOGRAFICA"
                List<Element> filhosPRODUCAOBBL = filhosRoot.get(contadorFilhosRoot).getChildren();
                
                //Para cada um desses filhos procura elementos com determinados nomes
                for(int contadorFilhosProducaoB=0; contadorFilhosProducaoB < filhosPRODUCAOBBL.size(); contadorFilhosProducaoB++) {
                    //Procura elementos com nome "TRABALHOS-EM-EVENTOS"
                    if(filhosPRODUCAOBBL.get(contadorFilhosProducaoB).getName().equals("TRABALHOS-EM-EVENTOS")) {
                        //Cria lista de elementos filhos de "TRABALHOS-EM-EVENTOS"
                        List<Element> filhosTrabalhosEmEventos = filhosPRODUCAOBBL.get(contadorFilhosProducaoB).getChildren();
                        
                        //Chama função para ler os Artigos em Evento
                        lerArtigosEventos(professor, filhosTrabalhosEmEventos, anoInicio, anoFim);
                    }
                    
                    //Procura elementos com nome "ARTIGOS-PUBLICADOS"
                    if(filhosPRODUCAOBBL.get(contadorFilhosProducaoB).getName().equals("ARTIGOS-PUBLICADOS")) {
                        //Cria lista de elementos filhos de "ARTIGOS-PUBLICADOS"
                        List<Element> filhosArtigosPublicados = filhosPRODUCAOBBL.get(contadorFilhosProducaoB).getChildren();
                        //Chama função para ler os Artigos em Revista
                        lerArtigosRevista(professor, filhosArtigosPublicados,  anoInicio, anoFim);
                    }
                }
            }
            
            //Procura elementos com nome "OUTRA-PRODUCAO"
            if(filhosRoot.get(contadorFilhosRoot).getName().equals("OUTRA-PRODUCAO")) {
                //Cria lista de elementos filhos de "OUTRA-PRODUCAO"
                List<Element> filhosOUTRAPROD = filhosRoot.get(contadorFilhosRoot).getChildren();
                
                //Para cada um dos filhos procura os que indicam orientações concluidas
                for(int contadorFilhosOutraProd=0; contadorFilhosOutraProd < filhosOUTRAPROD.size(); contadorFilhosOutraProd++) {
                    //Procura elementos com nome "ORIENTACOES-CONCLUIDAS"
                    if(filhosOUTRAPROD.get(contadorFilhosOutraProd).getName().equals("ORIENTACOES-CONCLUIDAS")) {
                        //Cria lista de elementos filhos de "ORIENTACOES-CONCLUIDAS"
                        List<Element> filhosOrientacoesConcluidas = filhosOUTRAPROD.get(contadorFilhosOutraProd).getChildren();
                        //Chama função que le as orientações concluidas do curriculo
                        lerOrientacoesConcluidas(professor, filhosOrientacoesConcluidas,  anoInicio, anoFim);
                    }
                }
            }
            
            //Procura elementos com nome "DADOS-COMPLEMENTARES"
            if(filhosRoot.get(contadorFilhosRoot).getName().equals("DADOS-COMPLEMENTARES")) {
                 //Cria lista de elementos filhos de "DADOS-COMPLEMENTARES"
                List<Element> filhosDADOSCOMPL = filhosRoot.get(contadorFilhosRoot).getChildren();
                
                 //Para cada um dos filhos procura os que indicam orientações em andamento e partipações em bancas
                for(int contadorFilhosDadosCompl=0; contadorFilhosDadosCompl < filhosDADOSCOMPL.size(); contadorFilhosDadosCompl++) {
                    switch(filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getName()) {
                        //Procura elementos com nome  "ORIENTACOES-EM-ANDAMENTO"
                        case "ORIENTACOES-EM-ANDAMENTO":
                            //Cria lista de elementos filhos de "ORIENTACOES-EM-ANDAMENTO"
                            List<Element> filhosOrientacoesAndamento = filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getChildren();
                            //Chama função que le as orientações em andamento do curriculo
                            lerOrientacoesAndamento(professor, filhosOrientacoesAndamento,  anoInicio, anoFim);
                            break;
                        
                            //Procura elementos com nome "PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO"
                        case "PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO":
                            //Cria lista de elementos filhos de "PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO"
                            List<Element> filhosParticipacaoBanca = filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getChildren();
                            //Chama função que le as participações em bancas do curriculo
                            lerParticipacoesBanca(professor, filhosParticipacaoBanca,  anoInicio, anoFim);
                            break;
                    }
                }
            }
        }
    }
    
    /*
        Método para ler os artigos de eventos de cada um dos professores
    
    */
    public void lerArtigosEventos(Professor professor, List<Element> filhosTrabalhosEmEventos, String  anoInicio, String anoFim) {
        
        //Lista com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        //Para cada um dos filhos do elemento de "TRABALHO-EM-EVENTO"
        for(int contadorFilhosTrabalhoEmEventos=0; contadorFilhosTrabalhoEmEventos < filhosTrabalhosEmEventos.size(); contadorFilhosTrabalhoEmEventos++) {
            //Cria lista de elementos filhos de "TRABALHO-EM-EVENTO"
            List<Element> filhosTrabalhosEmEventos2 = filhosTrabalhosEmEventos.get(contadorFilhosTrabalhoEmEventos).getChildren();

            //Para cada um dos filhos do elemento de TrabalhosEmEventos2
            for(int contadorFilhosTrabalhoEmEventos2 = 0; contadorFilhosTrabalhoEmEventos2< filhosTrabalhosEmEventos2.size(); contadorFilhosTrabalhoEmEventos2++) {
                //Procura os que tem nome igual a "DADOS-BASICOS-DO-TRABALHO"
                if(filhosTrabalhosEmEventos2.get(contadorFilhosTrabalhoEmEventos2).getName().equals("DADOS-BASICOS-DO-TRABALHO")) {
                    //Descobre o ano do trabalho, transforma em inteiro
                    String ano = filhosTrabalhosEmEventos2.get(contadorFilhosTrabalhoEmEventos2).getAttributeValue("ANO-DO-TRABALHO");
                    int anoTrabalho = Integer.parseInt(ano);
                    
                    //Transforma os anos passado em parâmetro em interios 
                    int anoIni = Integer.parseInt(anoInicio);
                    int anoF = Integer.parseInt(anoFim);
                    
                    //Verifica se o ano do trabalho está entre os anos passados como parâmetro
                    if((anoTrabalho >= anoIni) && (anoTrabalho <= anoF))
                        //Adiciona elemento como filho que será usado
                        filhosUsados.add(filhosTrabalhosEmEventos.get(contadorFilhosTrabalhoEmEventos));
                }   
            }
        }
        
        //Para cada um dos filhos válidos
        for(int contadorFilhosUsados=0; contadorFilhosUsados<filhosUsados.size(); contadorFilhosUsados++) {
                
            //Cria lista de elementos filhos "TRABALHO-EM-EVENTO"
            List<Element> filhosArtigos = filhosUsados.get(contadorFilhosUsados).getChildren();
                
            //Para cada um determina o nome do evento que foi publicado, seta esse nome como no regex do Artigo
            //Adiciona esse artigo a lista de ArtigosEvento do professor
            for(int contadorFilhosArtigos = 0; contadorFilhosArtigos < filhosArtigos.size(); contadorFilhosArtigos++) {
                if(filhosArtigos.get(contadorFilhosArtigos).getName().equals("DETALHAMENTO-DO-TRABALHO")) {
                    Artigo artigo = new Artigo("",filhosArtigos.get(contadorFilhosArtigos).getAttributeValue("NOME-DO-EVENTO"));
                    professor.adicionaArtigoEvento(artigo);
                }
            }
        }
    }

    /*
        Método para ler os artigos de revistas de cada um dos professores
    
    */
    private void lerArtigosRevista(Professor professor, List<Element> filhosArtigosPublicados, String  anoInicio, String anoFim) {
        
        //Lista com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        //Para cada um dos filhos do elemento de "ARTIGOS-PUBLICADOS"
        for(int contadorFilhosArtigosPublicados=0; contadorFilhosArtigosPublicados < filhosArtigosPublicados.size(); contadorFilhosArtigosPublicados++) {
            //Cria lista de elementos filhos de "ARTIGOS-PUBLICADOS"
            List<Element> filhosArtigoPublicado = filhosArtigosPublicados.get(contadorFilhosArtigosPublicados).getChildren();
            
            //Para cada um dos filhos do elemento de "ARTIGO-PUBLICADO"
            for(int contadorFilhosArtigoPublicado = 0; contadorFilhosArtigoPublicado< filhosArtigoPublicado.size(); contadorFilhosArtigoPublicado++) {
                //Procura os que tem nome igual a "DADOS-BASICOS-DO-ARTIGO"
                if(filhosArtigoPublicado.get(contadorFilhosArtigoPublicado).getName().equals("DADOS-BASICOS-DO-ARTIGO")) {
                    String ano = filhosArtigoPublicado.get(contadorFilhosArtigoPublicado).getAttributeValue("ANO-DO-ARTIGO");
                    int anoArtigo = Integer.parseInt(ano);
                    int anoIni = Integer.parseInt(anoInicio);
                    int anoF = Integer.parseInt(anoFim);
                    if((anoArtigo >= anoIni) && (anoArtigo <= anoF))
                        filhosUsados.add(filhosArtigosPublicados.get(contadorFilhosArtigosPublicados));
                }
            }
        }
        
        for(int contadorFilhosUsados=0; contadorFilhosUsados<filhosUsados.size(); contadorFilhosUsados++) {
            List<Element> filhosArtigo = filhosUsados.get(contadorFilhosUsados).getChildren();
                
            //Para cada um determina o nome da revista que foi publicado, seta esse nome como no regex do Artigo
            //Adiciona esse artigo a lista de ArtigosEvento do professor
            for(int contadorFilhosArtigo = 0; contadorFilhosArtigo < filhosArtigo.size(); contadorFilhosArtigo++) {
                if(filhosArtigo.get(contadorFilhosArtigo).getName().equals("DETALHAMENTO-DO-ARTIGO")) {
                    Artigo artigo = new Artigo("",filhosArtigo.get(contadorFilhosArtigo).getAttributeValue("TITULO-DO-PERIODICO-OU-REVISTA"));
                    professor.adicionaArtigoRevista(artigo);
                }
            }
        }
    }

    /*
        Método para ler as orientações concluídas de cada professor
    
    */
    private void lerOrientacoesConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, String  anoInicio, String anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        //M = Mestrado; D = Doutorado; G = Graduacao;
        List<Element> filhosUsadosM = new ArrayList<Element>();
        List<Element> filhosUsadosD = new ArrayList<Element>();
        List<Element> filhosUsadosG = new ArrayList<Element>();
        
        //Para cada um dos filhos do elemento de "ORIENTACOES-CONCLUIDAS"
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            
            switch(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getName()) {
                //Procura os que tem nome igual a  "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO"
                case "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO":
                    //Cria lista de elementos filhos de "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO"
                    List<Element> filhosOrientacoesMestrado = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                    //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroOrientacaoMestradoConcluidas(filhosUsadosM.size());
                    break;
                
                //Procura os que tem nome igual a  "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO"
                case "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO":
                    //Cria lista de elementos filhos de "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO"
                    List<Element> filhosOrientacoesDoutorado = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                    //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroOrientacaoDoutoradoConcluidas(filhosUsadosD.size());
                    break;
                
                //Procura os que tem nome igual a "OUTRAS-ORIENTACOES-CONCLUIDAS"
                case "OUTRAS-ORIENTACOES-CONCLUIDAS":
                    //Cria lista de elementos filhos de "OUTRAS-ORIENTACOES-CONCLUIDAS"
                    List<Element> filhosOrientacoesGraduacao = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                    //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroOrientacaoGraduacaoConcluidas(filhosUsadosG.size());
                    break;
            }
        }
    }
    
    /*
        Método para ler as orientações em andamento de cada professor
    
    */
    private void lerOrientacoesAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, String  anoInicio, String anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        //M = Mestrado; D = Doutorado; G = Graduacao;
        List<Element> filhosUsadosM = new ArrayList<Element>();
        List<Element> filhosUsadosD = new ArrayList<Element>();
        List<Element> filhosUsadosG = new ArrayList<Element>();
        
        //Para cada um dos filhos do elemento de "ORIENTACOES-EM-ANDAMENTO"
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            
            switch(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getName()) {
                //Procura os que tem nome igual a  "ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO"
                case "ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO":
                    //Cria lista de elementos filhos de "ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO"
                    List<Element> filhosOrientacoesMestrado = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                    //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroOrientacaoMestradoAndamento(filhosUsadosM.size());
                    break;
                
                //Procura os que tem nome igual a  "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO"
                case "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO":
                    //Cria lista de elementos filhos de "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO"
                    List<Element> filhosOrientacoesDoutorado = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                    //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroOrientacaoDoutoradoAndamento(filhosUsadosD.size());
                    break;
                
                //Procura os que tem nome igual a "ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO"
                case "ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO":
                    //Cria lista de elementos filhos de "ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO"
                    List<Element> filhosOrientacoesGraduacao = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                    //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroOrientacaoGraduacaoAndamento(filhosUsadosG.size());
                    break;
            }
        }
    }
    
    /*
        Método para ler as participações em banca de cada professor
    
    */
    private void lerParticipacoesBanca(Professor professor, List<Element> filhosParticipacaoBanca, String  anoInicio, String anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        //M = Mestrado; D = Doutorado; G = Graduacao;
        List<Element> filhosUsadosM = new ArrayList<Element>();
        List<Element> filhosUsadosD = new ArrayList<Element>();
        List<Element> filhosUsadosG = new ArrayList<Element>();
        
        //Para cada um dos filhos do elemento de "PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO"
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            
            switch(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getName()) {
                //Procura os que tem nome igual a "PARTICIPACAO-EM-BANCA-DE-MESTRADO"
                case "PARTICIPACAO-EM-BANCA-DE-MESTRADO":
                    //Cria lista de elementos filhos de "PARTICIPACAO-EM-BANCA-DE-MESTRADO"
                    List<Element> filhosBancaMestrado = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                     //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroBancasMestrado(filhosUsadosM.size());
                    break;
                
                //Procura os que tem nome igual a "PARTICIPACAO-EM-BANCA-DE-DOUTORADO"
                case "PARTICIPACAO-EM-BANCA-DE-DOUTORADO":
                    //Cria lista de elementos filhos de "PARTICIPACAO-EM-BANCA-DE-DOUTORADO"
                    List<Element> filhosBancaDoutorado = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                     //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroBancasDoutorado(filhosUsadosD.size());
                    break;
                   
                //Procura os que tem nome igual a "PARTICIPACAO-EM-BANCA-DE-GRADUACAO"
                case "PARTICIPACAO-EM-BANCA-DE-GRADUACAO":
                     //Cria lista de elementos filhos de "PARTICIPACAO-EM-BANCA-DE-GRADUACAO"
                    List<Element> filhosBancaGraduacao = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
                    //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
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
                    
                    //Seta o numero de orientações como o tamanho da lista de filhos usados
                    professor.setNumeroBancasGraduacao(filhosUsadosG.size());
                    break;
            }
        }
    }
    
    public void classificarArtigos(Professor professor) throws SAXException, ParserConfigurationException, IOException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        
        //Recebe o arquivo xml
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("https://s3.amazonaws.com/posgraduacao/qualis.xml");
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        //Pega o elemento do root do xml
        Element root = jdomDocument.getRootElement();
        
        //Pega os filhos linha do elemento root
        List<Element> filhosRoot = root.getChildren();
        
        //Para cada entrada do xml qualis procura se sua regex é igual a regex de cada artigo do professor
        for(int contadorEntry = 0; contadorEntry < filhosRoot.size(); contadorEntry++) {
            
            //Procura na lista de artigos de Eventos
            for(Artigo artigo : professor.getArtigosEventos())
               if(artigo.getRegex().equalsIgnoreCase(filhosRoot.get(contadorEntry).getAttributeValue("regex")))
                artigo.setClasse(filhosRoot.get(contadorEntry).getAttributeValue("class"));
            
            //Procura na lista de artigos de Revista
            for(Artigo artigo : professor.getArtigosRevista())
               if(artigo.getRegex().equalsIgnoreCase(filhosRoot.get(contadorEntry).getAttributeValue("regex")))
                artigo.setClasse(filhosRoot.get(contadorEntry).getAttributeValue("class"));
                   
        }
        
    }
}
