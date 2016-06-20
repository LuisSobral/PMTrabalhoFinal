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
public class LerCurriculo {
    
    /*
        Método para a leitura de currículo
    */
    public void leituraDeCurriculos(Programa programa, int anoInicio, int anoFim) throws SAXException, IOException, ParserConfigurationException {
        
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
                arquivoXML.delete();
            }
    }
    
    /*
        Método para procurar determinados elementos filhos do root no xml
    */
    private void procurarTag(Professor professor, List<Element> filhosRoot, int anoInicio, int anoFim) {

        importarArtigos(professor, filhosRoot, anoInicio, anoFim);
        importarOrientacoesConcluidas(professor, filhosRoot, anoInicio, anoFim);
        importarDadosComplementares(professor, filhosRoot, anoInicio, anoFim);
    }
    
    /*
        Método que importa do xml artigos
    */
    private void importarArtigos(Professor professor, List<Element> filhosRoot, int anoInicio, int anoFim) {
    
        for(int i=0; i<filhosRoot.size(); i++) {
            if(filhosRoot.get(i).getName().equals("PRODUCAO-BIBLIOGRAFICA")) {
                List<Element> filhosPRODUCAOB = filhosRoot.get(i).getChildren();
                
                importarArtigosEvento(filhosPRODUCAOB, professor, anoInicio, anoFim);
                importarArtigosRevista(filhosPRODUCAOB, professor, anoInicio, anoFim);
                
            }
        }
    }
    
    /*
        Método que importa do xml artigos de evento
    */
    private void importarArtigosEvento(List<Element> filhosPRODUCAOB, Professor professor, int anoInicio, int anoFim) {
        
        for(int contadorFilhosProducaoB=0; contadorFilhosProducaoB < filhosPRODUCAOB.size(); contadorFilhosProducaoB++) {
            if(filhosPRODUCAOB.get(contadorFilhosProducaoB).getName().equals("TRABALHOS-EM-EVENTOS")) {
                List<Element> filhosArtigosEmEventos = filhosPRODUCAOB.get(contadorFilhosProducaoB).getChildren();
                lerArtigosEventos(professor, filhosArtigosEmEventos, anoInicio, anoFim);
            }
        }
    }
    
    /*
        Método que importa do xml artigos de revista
    */
    private void importarArtigosRevista(List<Element> filhosPRODUCAOB, Professor professor, int anoInicio, int anoFim) {
        for(int contadorFilhosProducaoB=0; contadorFilhosProducaoB < filhosPRODUCAOB.size(); contadorFilhosProducaoB++) {
            if(filhosPRODUCAOB.get(contadorFilhosProducaoB).getName().equals("ARTIGOS-PUBLICADOS")) {
                List<Element> filhosArtigosEmRevista = filhosPRODUCAOB.get(contadorFilhosProducaoB).getChildren();
                lerArtigosRevista(professor, filhosArtigosEmRevista, anoInicio, anoFim);
            }
        }
    }
    
    /*
        Método que importa do xml orientacoes concluidas
    */
    private void importarOrientacoesConcluidas(Professor professor, List<Element> filhosRoot, int anoInicio, int anoFim) {
    
        for(int i=0; i<filhosRoot.size(); i++) {
            if(filhosRoot.get(i).getName().equals("OUTRA-PRODUCAO")) {
                List<Element> filhosOUTRAPROD = filhosRoot.get(i).getChildren();
                
                for(int contadorFilhosOutraProd=0; contadorFilhosOutraProd < filhosOUTRAPROD.size(); contadorFilhosOutraProd++)
                    if(filhosOUTRAPROD.get(contadorFilhosOutraProd).getName().equals("ORIENTACOES-CONCLUIDAS")) {
                        List<Element> filhosOrientacoesConcluidas = filhosOUTRAPROD.get(contadorFilhosOutraProd).getChildren();
                        lerOrientacoesConcluidas(professor, filhosOrientacoesConcluidas,  anoInicio, anoFim);
                    }    
            }
        }
    }
    
    /*
        Método que importa do xml dados complementares
    */
    private void importarDadosComplementares(Professor professor, List<Element> filhosRoot, int anoInicio, int anoFim) {
    
        for(int i=0; i<filhosRoot.size(); i++) {
            if(filhosRoot.get(i).getName().equals("DADOS-COMPLEMENTARES")) {
                List<Element> filhosDADOSCOMPL = filhosRoot.get(i).getChildren();

                importarOrientacoesAndamento(professor, filhosDADOSCOMPL, anoInicio, anoFim);
                importarBancas(professor, filhosDADOSCOMPL, anoInicio, anoFim);
            }
        }
    }
    
    /*
        Método que importa do xml orientações em andamento
    */
    private void importarOrientacoesAndamento(Professor professor, List<Element> filhosDADOSCOMPL, int anoInicio, int anoFim) {
        for(int contadorFilhosDadosCompl=0; contadorFilhosDadosCompl < filhosDADOSCOMPL.size(); contadorFilhosDadosCompl++) {
            if(filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getName().equals("ORIENTACOES-EM-ANDAMENTO")) {
                List<Element> filhosOrientacoesAndamento = filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getChildren();
                lerOrientacoesAndamento(professor, filhosOrientacoesAndamento,  anoInicio, anoFim);
            }
        }
    }
    
    /*
        Método que importa do xml participações em bancas
    */
    private void importarBancas(Professor professor, List<Element> filhosDADOSCOMPL, int anoInicio, int anoFim) {
        for(int contadorFilhosDadosCompl=0; contadorFilhosDadosCompl < filhosDADOSCOMPL.size(); contadorFilhosDadosCompl++) {
            if(filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getName().equals("PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO")) {
               List<Element> filhosParticipacaoBanca = filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getChildren();
               lerParticipacoesBanca(professor, filhosParticipacaoBanca,  anoInicio, anoFim);
            }
        }
    }
        
    /*
        Método para ler os artigos de eventos de cada um dos professores
    */
    private void lerArtigosEventos(Professor professor, List<Element> filhosArtigosEventos, int  anoInicio, int anoFim) {
        List<Element> filhosUsados = new ArrayList<Element>();
        filhosUsados = contabilizarArtigoEvento(filhosArtigosEventos, anoInicio, anoFim);
        for(int contadorFilhosUsados=0; contadorFilhosUsados<filhosUsados.size(); contadorFilhosUsados++) {
            adicionarArtigoEvento(professor, filhosUsados.get(contadorFilhosUsados));
        }
    }
    
    /*
        Método para contabilizar quantos artigos serão considerados dados os anos definidos
    */
    private List<Element> contabilizarArtigoEvento(List<Element> filhosArtigosEventos, int anoInicio, int anoFim) {
        List<Element> filhosUsados = new ArrayList<Element>();
            
        for(int contadorFilhosArtigosEventos=0; contadorFilhosArtigosEventos < filhosArtigosEventos.size(); contadorFilhosArtigosEventos++) {
            List<Element> filhosArtigosEmEventos = filhosArtigosEventos.get(contadorFilhosArtigosEventos).getChildren();
            
            for(int contadorFilhosArtigosEmEventos = 0; contadorFilhosArtigosEmEventos< filhosArtigosEmEventos.size(); contadorFilhosArtigosEmEventos++)
                if(filhosArtigosEmEventos.get(contadorFilhosArtigosEmEventos).getName().equals("DADOS-BASICOS-DO-TRABALHO")) {
                    String ano = filhosArtigosEmEventos.get(contadorFilhosArtigosEmEventos).getAttributeValue("ANO-DO-TRABALHO");
                    int anoTrabalho = Integer.parseInt(ano);
                    if((anoTrabalho >= anoInicio) && (anoTrabalho <= anoFim))
                        filhosUsados.add(filhosArtigosEventos.get(contadorFilhosArtigosEventos));
                }
        }
        
        return filhosUsados;
    }
    
    /*
        Método para adicionar um artigo em eventos a lista de artigos em eventos do professor
    */
    private void adicionarArtigoEvento(Professor professor, Element filhoUsado) {
        List<Element> filhosArtigos = filhoUsado.getChildren();
        for(int contadorFilhosArtigos = 0; contadorFilhosArtigos < filhosArtigos.size(); contadorFilhosArtigos++) {
            if(filhosArtigos.get(contadorFilhosArtigos).getName().equals("DETALHAMENTO-DO-TRABALHO")) {
                Artigo artigo = new Artigo("",filhosArtigos.get(contadorFilhosArtigos).getAttributeValue("NOME-DO-EVENTO"));
                professor.adicionaArtigoEvento(artigo);
            }
        }
    }
    
    
    /*
        Método para ler os artigos de revistas de cada um dos professores
    */
    private void lerArtigosRevista(Professor professor, List<Element> filhosArtigosPublicados, int  anoInicio, int anoFim) {
        List<Element> filhosUsados = new ArrayList<Element>();
        
        filhosUsados = contabilizarArtigoRevista(filhosArtigosPublicados, anoInicio, anoFim);
        
        for(int contadorFilhosUsados=0; contadorFilhosUsados<filhosUsados.size(); contadorFilhosUsados++) {
            adicionarArtigosRevista(professor, filhosUsados.get(contadorFilhosUsados));
        }
    }
    
    /*
        Método para contabilizar quantos artigos serão considerados dados os anos definidos
    */
    private List<Element> contabilizarArtigoRevista(List<Element> filhosArtigosPublicados, int anoInicio, int anoFim) {
        List<Element> filhosUsados = new ArrayList<Element>();  
            
        for(int contadorFilhosArtigosPublicados=0; contadorFilhosArtigosPublicados < filhosArtigosPublicados.size(); contadorFilhosArtigosPublicados++)  {
            List<Element> filhosArtigoPublicado = filhosArtigosPublicados.get(contadorFilhosArtigosPublicados).getChildren();
            
            for(int contadorFilhosArtigoPublicado = 0; contadorFilhosArtigoPublicado< filhosArtigoPublicado.size(); contadorFilhosArtigoPublicado++)
                if(filhosArtigoPublicado.get(contadorFilhosArtigoPublicado).getName().equals("DADOS-BASICOS-DO-ARTIGO")) {
                    String ano = filhosArtigoPublicado.get(contadorFilhosArtigoPublicado).getAttributeValue("ANO-DO-ARTIGO");
                    int anoArtigo = Integer.parseInt(ano);
                    if((anoArtigo >= anoInicio) && (anoArtigo <= anoFim))
                        filhosUsados.add(filhosArtigosPublicados.get(contadorFilhosArtigosPublicados));
                }

        }
        return filhosUsados;        
    }
    
    /*
        Método para adicionar um artigo em revista a lista de artigos em eventosrevistas do professor
    */
    private void adicionarArtigosRevista(Professor professor, Element filhoUsado) {
        
        List<Element> filhosArtigo = filhoUsado.getChildren();
        for(int contadorFilhosArtigo = 0; contadorFilhosArtigo < filhosArtigo.size(); contadorFilhosArtigo++) {
            if(filhosArtigo.get(contadorFilhosArtigo).getName().equals("DETALHAMENTO-DO-ARTIGO")) {
                Artigo artigo = new Artigo("",filhosArtigo.get(contadorFilhosArtigo).getAttributeValue("TITULO-DO-PERIODICO-OU-REVISTA"));
               
                professor.adicionaArtigoRevista(artigo);
            }
       }
    }
    
    /*
        Método para ler as orientações concluídas de cada professor
    
    */
    private void lerOrientacoesConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, int  anoInicio, int anoFim) {
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            if(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getName().equals("ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")) 
                    contabilizaOrientacaoMestradoConcluidas(professor, filhosOrientacoesConcluidas, anoInicio, anoFim);
                    
            if(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getName().equals("ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO"))
                    contabilizaOrientacaoDoutoradoConcluidas(professor, filhosOrientacoesConcluidas, anoInicio, anoFim);

            if(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getName().equals("OUTRAS-ORIENTACOES-CONCLUIDAS"))
                contabilizaOrientacaoGraduacaoConcluidas(professor, filhosOrientacoesConcluidas, anoInicio, anoFim);   
       }
    }
    
    /*
        Método para contabilizar quantas orientações de mestrado concluidas serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoMestradoConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, int anoInicio, int anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();
       
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            List<Element> filhosOrientacoesMestrado = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();
            
            for(int contadorFilhosMestrado = 0; contadorFilhosMestrado < filhosOrientacoesMestrado.size(); contadorFilhosMestrado++)
                if(filhosOrientacoesMestrado.get(contadorFilhosMestrado).getName().equals("DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")) {
                    String ano = filhosOrientacoesMestrado.get(contadorFilhosMestrado).getAttributeValue("ANO");
                    int anoOrientacoesMestrado = Integer.parseInt(ano);

                    if((anoOrientacoesMestrado >= anoInicio) && (anoOrientacoesMestrado <= anoFim))
                        filhosUsados.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                }
        }

        professor.setNumeroOrientacaoMestradoConcluidas(filhosUsados.size());
    
    }
    
    /*
        Método para contabilizar quantas orientações de doutorado concluidas serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoDoutoradoConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, int anoInicio, int anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            List<Element> filhosOrientacoesDoutorado = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();
                  
            for(int contadorFilhosDoutorado = 0; contadorFilhosDoutorado < filhosOrientacoesDoutorado.size(); contadorFilhosDoutorado++) {
                if(filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getName().equals("DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO")) {
                    String ano = filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getAttributeValue("ANO");
                    int anoOrientacoesDoutorado = Integer.parseInt(ano);
        
                    if((anoOrientacoesDoutorado >= anoInicio) && (anoOrientacoesDoutorado <= anoFim))
                        filhosUsados.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                }
            }
        }
                    
        professor.setNumeroOrientacaoDoutoradoConcluidas(filhosUsados.size());
    }
    
    /*
        Método para contabilizar quantas orientações de graduação concluidas serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoGraduacaoConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, int anoInicio, int anoFim) {
    
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            List<Element> filhosOrientacoesGraduacao = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();
                    
            for(int contadorFilhosGraduacao = 0; contadorFilhosGraduacao < filhosOrientacoesGraduacao.size(); contadorFilhosGraduacao++) {
                if(filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getName().equals("DADOS-BASICOS-DE-OUTRAS-ORIENTACOES-CONCLUIDAS")) {
                    String ano = filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getAttributeValue("ANO");
                    int anoOrientacoesGraduacao = Integer.parseInt(ano);
        
                    if((anoOrientacoesGraduacao >= anoInicio) && (anoOrientacoesGraduacao <= anoFim))
                        filhosUsados.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                        
                }
            }
        }

        professor.setNumeroOrientacaoGraduacaoConcluidas(filhosUsados.size());
    }
    
    /*
        Método para ler as orientações em andamento de cada professor
    
    */
    private void lerOrientacoesAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, int  anoInicio, int anoFim) {
        
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            if(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO")) 
                contabilizaOrientacaoMestradoAndamento(professor, filhosOrientacoesAndamento, anoInicio, anoFim);
            
            if(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO"))
                contabilizaOrientacaoDoutoradoAndamento(professor, filhosOrientacoesAndamento, anoInicio, anoFim);
            
            if(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO"))
                contabilizaOrientacaoGraduacaoAndamento(professor, filhosOrientacoesAndamento, anoInicio, anoFim);   
        }
    }
    
    /*
        Método para contabilizar quantas orientações de mestrado em andamento serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoMestradoAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, int anoInicio, int anoFim) {
         
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            List<Element> filhosOrientacoesMestrado = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
            for(int contadorFilhosMestrado = 0; contadorFilhosMestrado < filhosOrientacoesMestrado.size(); contadorFilhosMestrado++) {
                if(filhosOrientacoesMestrado.get(contadorFilhosMestrado).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO")) {
                    String ano = filhosOrientacoesMestrado.get(contadorFilhosMestrado).getAttributeValue("ANO");
                    int anoOrientacoesMestrado = Integer.parseInt(ano);
        
                    if((anoOrientacoesMestrado >= anoInicio) && (anoOrientacoesMestrado <= anoFim))
                        filhosUsados.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                }
            }
        }
                    
        professor.setNumeroOrientacaoMestradoAndamento(filhosUsados.size());
    }
    
    /*
        Método para contabilizar quantas orientações de doutorado em andamento serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoDoutoradoAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, int anoInicio, int anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            List<Element> filhosOrientacoesDoutorado = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
            for(int contadorFilhosDoutorado = 0; contadorFilhosDoutorado < filhosOrientacoesDoutorado.size(); contadorFilhosDoutorado++) {
                if(filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO")) {
                    String ano = filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getAttributeValue("ANO");
                    int anoOrientacoesDoutorado = Integer.parseInt(ano);
                
                    if((anoOrientacoesDoutorado >= anoInicio) && (anoOrientacoesDoutorado <= anoFim))
                        filhosUsados.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                }
            }
        }

        professor.setNumeroOrientacaoDoutoradoAndamento(filhosUsados.size());
    }
       
    /*
        Método para contabilizar quantas orientações de graduação em andamento serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoGraduacaoAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, int anoInicio, int anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            List<Element> filhosOrientacoesGraduacao = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
            for(int contadorFilhosGraduacao = 0; contadorFilhosGraduacao < filhosOrientacoesGraduacao.size(); contadorFilhosGraduacao++) {
                if(filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO")) {
                    String ano = filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getAttributeValue("ANO");
                    int anoOrientacoesGraduacao = Integer.parseInt(ano);
                
                    if((anoOrientacoesGraduacao >= anoInicio) && ( anoOrientacoesGraduacao <= anoFim))
                        filhosUsados.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                }
            }
        }

        professor.setNumeroOrientacaoGraduacaoAndamento(filhosUsados.size());
    }
    
    /*
        Método para ler as participações em banca de cada professor
    
    */
    private void lerParticipacoesBanca(Professor professor, List<Element> filhosParticipacaoBanca, int  anoInicio, int anoFim) {
        
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            if(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getName().equals("PARTICIPACAO-EM-BANCA-DE-MESTRADO")) 
                contabilizaParticipacaoMestrado(professor, filhosParticipacaoBanca, anoInicio, anoFim);
            
            if(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getName().equals("PARTICIPACAO-EM-BANCA-DE-DOUTORADO"))
                contabilizaParticipacaoDoutorado(professor, filhosParticipacaoBanca, anoInicio, anoFim);
            
            if(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getName().equals("PARTICIPACAO-EM-BANCA-DE-GRADUACAO"))
                contabilizaParticipacaoGraducao(professor, filhosParticipacaoBanca, anoInicio, anoFim);   
        }
    }
    
    /*
        Método para contabilizar quantas participações em banca de mestrados serão considerados dados os anos definidos
    */
    private void contabilizaParticipacaoMestrado(Professor professor, List<Element> filhosParticipacaoBanca, int anoInicio, int anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            List<Element> filhosBancaMestrado = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
            for(int contadorBancaMestrado = 0; contadorBancaMestrado < filhosBancaMestrado.size(); contadorBancaMestrado++) {
                if(filhosBancaMestrado.get(contadorBancaMestrado).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-MESTRADO")) {
                    String ano = filhosBancaMestrado.get(contadorBancaMestrado).getAttributeValue("ANO");
                    int anoBancaMestrado = Integer.parseInt(ano);
                
                    if((anoBancaMestrado >= anoInicio) && (anoBancaMestrado <= anoFim))
                        filhosUsados.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                }
            }
        }

        professor.setNumeroBancasMestrado(filhosUsados.size());
    }
    
    /*
        Método para contabilizar quantas participações em banca de doutorado serão considerados dados os anos definidos
    */
    private void contabilizaParticipacaoDoutorado(Professor professor, List<Element> filhosParticipacaoBanca, int anoInicio, int anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            List<Element> filhosBancaDoutorado = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
        
            for(int contadorBancaDoutorado = 0; contadorBancaDoutorado < filhosBancaDoutorado.size(); contadorBancaDoutorado++) {
                if(filhosBancaDoutorado.get(contadorBancaDoutorado).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-DOUTORADO")) {
                    String ano = filhosBancaDoutorado.get(contadorBancaDoutorado).getAttributeValue("ANO");
                    int anoBancaDoutorado = Integer.parseInt(ano);
        
                    if((anoBancaDoutorado >= anoInicio) && (anoBancaDoutorado <= anoFim))
                        filhosUsados.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                }
            }
        }
                    
        professor.setNumeroBancasDoutorado(filhosUsados.size());
    }
    
    /*
        Método para contabilizar quantas participações em banca de graduação serão considerados dados os anos definidos
    */
    private void contabilizaParticipacaoGraducao(Professor professor, List<Element> filhosParticipacaoBanca, int anoInicio, int anoFim) {
        
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            List<Element> filhosBancaGraduacao = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
            for(int contadorBancaGraduacao = 0; contadorBancaGraduacao < filhosBancaGraduacao.size(); contadorBancaGraduacao++) {
                if(filhosBancaGraduacao.get(contadorBancaGraduacao).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-GRADUACAO")) {
                    String ano = filhosBancaGraduacao.get(contadorBancaGraduacao).getAttributeValue("ANO");
                    int anoBancaGraduacao = Integer.parseInt(ano);
                
                    if((anoBancaGraduacao >= anoInicio) && (anoBancaGraduacao <= anoFim))
                        filhosUsados.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                }
            }
        }

        professor.setNumeroBancasGraduacao(filhosUsados.size());
    }
}
