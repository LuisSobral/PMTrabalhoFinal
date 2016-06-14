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
        
        //Cria link para receber o xml dos curriculos
        String nomeArquivoInicial = "https://s3.amazonaws.com/posgraduacao/";
        String nomePrograma = programa.getNome();
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()){
                
                //Continuação da criação do link correto
                String nomeArquivo = nomeArquivoInicial.concat(nomePrograma).concat("/").concat(professor.getCodigo()).concat(".zip");
                
                //Chama método para descompactar os zip com os curriculos
                DescompactarZip arquivoZip = new DescompactarZip();
                File arquivoXML = arquivoZip.descompactarArquivo(nomeArquivo, professor.getCodigo());
                org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("file:///"+arquivoXML.getAbsolutePath());
                DOMBuilder jdomBuilder = new DOMBuilder();

                Document jdomDocument = jdomBuilder.build(docProgramas);
                
                //Pega o elemento do root do xml
                Element root = jdomDocument.getRootElement();
                
                //Pega os filhos de root
                List<Element> filhosRoot = root.getChildren();
                
                //Chama método para achar determinados filhos
                procurarTag(professor, filhosRoot, anoInicio, anoFim);
                
                //Deleta arquivo xml do curriculo baixado e escrito no disco
                arquivoXML.delete();
            }
    }
    
    /*
        Método para procurar determinados elementos filhos do root no xml
    */
    private void procurarTag(Professor professor, List<Element> filhosRoot, int anoInicio, int anoFim) {

        //Procura elementos com nome "PRODUCAO-BIBLIOGRAFICA"
        for(int i=0; i<filhosRoot.size(); i++) {
            if(filhosRoot.get(i).getName().equals("PRODUCAO-BIBLIOGRAFICA")) {
                //Cria lista de elementos filhos de "PRODUCAO-BIBLIOGRAFICA"
                List<Element> filhosPRODUCAOB = filhosRoot.get(i).getChildren();

                //Para cada um desses filhos procura elementos com determinados nomes
                for(int contadorFilhosProducaoB=0; contadorFilhosProducaoB < filhosPRODUCAOB.size(); contadorFilhosProducaoB++) {
                    //Procura elementos com nome "TRABALHOS-EM-EVENTOS"
                    if(filhosPRODUCAOB.get(contadorFilhosProducaoB).getName().equals("TRABALHOS-EM-EVENTOS")) {
                        //Cria lista de elementos filhos de "TRABALHOS-EM-EVENTOS"
                        List<Element> filhosArtigosEmEventos = filhosPRODUCAOB.get(contadorFilhosProducaoB).getChildren();
                        lerArtigosEventos(professor, filhosArtigosEmEventos, anoInicio, anoFim);
                    }

                    //Procura elementos com nome "ARTIGOS-PUBLICADOS"
                    if(filhosPRODUCAOB.get(contadorFilhosProducaoB).getName().equals("ARTIGOS-PUBLICADOS")) {
                        List<Element> filhosArtigosEmRevista = filhosPRODUCAOB.get(contadorFilhosProducaoB).getChildren();
                        lerArtigosRevista(professor, filhosArtigosEmRevista, anoInicio, anoFim);
                    }
                }
            }

            //Procura elementos com nome "OUTRA-PRODUCAO"
            if(filhosRoot.get(i).getName().equals("OUTRA-PRODUCAO")) {
                //Cria lista de elementos filhos de "OUTRA-PRODUCAO"
                List<Element> filhosOUTRAPROD = filhosRoot.get(i).getChildren();

                //Para cada um dos filhos procura os que indicam orientações concluidas
                for(int contadorFilhosOutraProd=0; contadorFilhosOutraProd < filhosOUTRAPROD.size(); contadorFilhosOutraProd++)
                    //Procura elementos com nome "ORIENTACOES-CONCLUIDAS"
                    if(filhosOUTRAPROD.get(contadorFilhosOutraProd).getName().equals("ORIENTACOES-CONCLUIDAS")) {
                        List<Element> filhosOrientacoesConcluidas = filhosOUTRAPROD.get(contadorFilhosOutraProd).getChildren();
                        lerOrientacoesConcluidas(professor, filhosOrientacoesConcluidas,  anoInicio, anoFim);
                    }    
            }

            //Procura elementos com nome "DADOS-COMPLEMENTARES"
            if(filhosRoot.get(i).getName().equals("DADOS-COMPLEMENTARES")) {
                //Cria lista de elementos filhos de "DADOS-COMPLEMENTARES"
                List<Element> filhosDADOSCOMPL = filhosRoot.get(i).getChildren();

                //Para cada um dos filhos procura os que indicam orientações em andamento e partipações em bancas
                for(int contadorFilhosDadosCompl=0; contadorFilhosDadosCompl < filhosDADOSCOMPL.size(); contadorFilhosDadosCompl++) {
                    //Procura elementos com nome  "ORIENTACOES-EM-ANDAMENTO"
                    if(filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getName().equals("ORIENTACOES-EM-ANDAMENTO")) {
                        List<Element> filhosOrientacoesAndamento = filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getChildren();
                        lerOrientacoesAndamento(professor, filhosOrientacoesAndamento,  anoInicio, anoFim);
                    }
                     

                    //Procura elementos com nome "PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO"
                    if(filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getName().equals("PARTICIPACAO-EM-BANCA-TRABALHOS-CONCLUSAO")) {
                        List<Element> filhosParticipacaoBanca = filhosDADOSCOMPL.get(contadorFilhosDadosCompl).getChildren();
                        lerParticipacoesBanca(professor, filhosParticipacaoBanca,  anoInicio, anoFim);
                    }
                }
            }
        }
    }
    
    /*
        Método para ler os artigos de eventos de cada um dos professores
    */
    private void lerArtigosEventos(Professor professor, List<Element> filhosArtigosEventos, int  anoInicio, int anoFim) {
        
        //Lista com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        //Para cada um dos filhos do elemento de "TRABALHO-EM-EVENTO"
        filhosUsados = contabilizarArtigoEvento(filhosArtigosEventos, anoInicio, anoFim);     
        
        //Para cada um dos filhos válidos
        for(int contadorFilhosUsados=0; contadorFilhosUsados<filhosUsados.size(); contadorFilhosUsados++) {
            adicionarArtigoEvento(professor, filhosUsados.get(contadorFilhosUsados));
        }
    }
    
    /*
        Método para contabilizar quantos artigos serão considerados dados os anos definidos
    */
    private List<Element> contabilizarArtigoEvento(List<Element> filhosArtigosEventos, int anoInicio, int anoFim) {
    
        //Lista com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
            
        for(int contadorFilhosArtigosEventos=0; contadorFilhosArtigosEventos < filhosArtigosEventos.size(); contadorFilhosArtigosEventos++) {
            //Cria lista de elementos filhos de "TRABALHO-EM-EVENTO"
            List<Element> filhosArtigosEmEventos = filhosArtigosEventos.get(contadorFilhosArtigosEventos).getChildren();

            //Para cada um dos filhos do elemento de filhosArtigosEmEventos
            for(int contadorFilhosArtigosEmEventos = 0; contadorFilhosArtigosEmEventos< filhosArtigosEmEventos.size(); contadorFilhosArtigosEmEventos++)
                //Procura os que tem nome igual a "DADOS-BASICOS-DO-TRABALHO"
                if(filhosArtigosEmEventos.get(contadorFilhosArtigosEmEventos).getName().equals("DADOS-BASICOS-DO-TRABALHO")) {
                    //Descobre o ano do trabalho, transforma em inteiro
                    String ano = filhosArtigosEmEventos.get(contadorFilhosArtigosEmEventos).getAttributeValue("ANO-DO-TRABALHO");
                    int anoTrabalho = Integer.parseInt(ano);

                    //Verifica se o ano do trabalho está entre os anos passados como parâmetro
                    if((anoTrabalho >= anoInicio) && (anoTrabalho <= anoFim))
                        //Adiciona elemento como filho que será usado
                        filhosUsados.add(filhosArtigosEventos.get(contadorFilhosArtigosEventos));

                }
        }
        
        return filhosUsados;
    }
    
    /*
        Método para adicionar um artigo em eventos a lista de artigos em eventos do professor
    */
    private void adicionarArtigoEvento(Professor professor, Element filhoUsado) {

        //Cria lista de elementos filhos "TRABALHO-EM-EVENTO"
        List<Element> filhosArtigos = filhoUsado.getChildren();

        //Para cada um determina o nome do evento que foi publicado, seta esse nome como no regex do Artigo
        //Adiciona esse artigo a lista de ArtigosEvento do professor
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
        
        //Lista com elementos que seram usados de acordo com os anos passados como parâmetro
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
    
        //Lista com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();  
            
        for(int contadorFilhosArtigosPublicados=0; contadorFilhosArtigosPublicados < filhosArtigosPublicados.size(); contadorFilhosArtigosPublicados++)  {
            //Cria lista de elementos filhos de "ARTIGOS-PUBLICADOS"
            List<Element> filhosArtigoPublicado = filhosArtigosPublicados.get(contadorFilhosArtigosPublicados).getChildren();
  

            //Para cada um dos filhos do elemento de "ARTIGO-PUBLICADO"
            for(int contadorFilhosArtigoPublicado = 0; contadorFilhosArtigoPublicado< filhosArtigoPublicado.size(); contadorFilhosArtigoPublicado++)
                //Procura os que tem nome igual a "DADOS-BASICOS-DO-ARTIGO"
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

        //Para cada um determina o nome da revista que foi publicado, seta esse nome como no regex do Artigo
        //Adiciona esse artigo a lista de ArtigosEvento do professor
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
        
        //Para cada um dos filhos do elemento de "ORIENTACOES-CONCLUIDAS"
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            //Procura os que tem nome igual a  "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO"
            if(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getName().equals("ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")) 
                    contabilizaOrientacaoMestradoConcluidas(professor, filhosOrientacoesConcluidas, anoInicio, anoFim);
                    
            //Procura os que tem nome igual a  "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO"
            if(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getName().equals("ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO"))
                    contabilizaOrientacaoDoutoradoConcluidas(professor, filhosOrientacoesConcluidas, anoInicio, anoFim);
                    
            //Procura os que tem nome igual a "OUTRAS-ORIENTACOES-CONCLUIDAS"
            if(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getName().equals("OUTRAS-ORIENTACOES-CONCLUIDAS"))
                contabilizaOrientacaoGraduacaoConcluidas(professor, filhosOrientacoesConcluidas, anoInicio, anoFim);   
       }
    }
    
    /*
        Método para contabilizar quantas orientações de mestrado concluidas serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoMestradoConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, int anoInicio, int anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
       
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            //Cria lista de elementos filhos de "ORIENTACOES-CONCLUIDAS-PARA-MESTRADO"
            List<Element> filhosOrientacoesMestrado = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();

            //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
            for(int contadorFilhosMestrado = 0; contadorFilhosMestrado < filhosOrientacoesMestrado.size(); contadorFilhosMestrado++)
                if(filhosOrientacoesMestrado.get(contadorFilhosMestrado).getName().equals("DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-MESTRADO")) {
                    String ano = filhosOrientacoesMestrado.get(contadorFilhosMestrado).getAttributeValue("ANO");
                    int anoOrientacoesMestrado = Integer.parseInt(ano);

                    if((anoOrientacoesMestrado >= anoInicio) && (anoOrientacoesMestrado <= anoFim))
                        filhosUsados.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                }
        }

        //Seta o numero de orientações como o tamanho da lista de filhos usados
        professor.setNumeroOrientacaoMestradoConcluidas(filhosUsados.size());
    
    }
    
    /*
        Método para contabilizar quantas orientações de doutorado concluidas serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoDoutoradoConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, int anoInicio, int anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            //Cria lista de elementos filhos de "ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO"
            List<Element> filhosOrientacoesDoutorado = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();
                  
            //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
            for(int contadorFilhosDoutorado = 0; contadorFilhosDoutorado < filhosOrientacoesDoutorado.size(); contadorFilhosDoutorado++) {
                if(filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getName().equals("DADOS-BASICOS-DE-ORIENTACOES-CONCLUIDAS-PARA-DOUTORADO")) {
                    String ano = filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getAttributeValue("ANO");
                    int anoOrientacoesDoutorado = Integer.parseInt(ano);
        
                    if((anoOrientacoesDoutorado >= anoInicio) && (anoOrientacoesDoutorado <= anoFim))
                        filhosUsados.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                }
            }
        }
                    
        //Seta o numero de orientações como o tamanho da lista de filhos usados
        professor.setNumeroOrientacaoDoutoradoConcluidas(filhosUsados.size());
    }
    
    /*
        Método para contabilizar quantas orientações de graduação concluidas serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoGraduacaoConcluidas(Professor professor, List<Element> filhosOrientacoesConcluidas, int anoInicio, int anoFim) {
    
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesConcluidas = 0; contadorFilhosOrientacoesConcluidas < filhosOrientacoesConcluidas.size(); contadorFilhosOrientacoesConcluidas++) {
            //Cria lista de elementos filhos de "OUTRAS-ORIENTACOES-CONCLUIDAS"
            List<Element> filhosOrientacoesGraduacao = filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas).getChildren();
                    
            //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
            for(int contadorFilhosGraduacao = 0; contadorFilhosGraduacao < filhosOrientacoesGraduacao.size(); contadorFilhosGraduacao++) {
                if(filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getName().equals("DADOS-BASICOS-DE-OUTRAS-ORIENTACOES-CONCLUIDAS")) {
                    String ano = filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getAttributeValue("ANO");
                    int anoOrientacoesGraduacao = Integer.parseInt(ano);
        
                    if((anoOrientacoesGraduacao >= anoInicio) && (anoOrientacoesGraduacao <= anoFim))
                        filhosUsados.add(filhosOrientacoesConcluidas.get(contadorFilhosOrientacoesConcluidas));
                        
                }
            }
        }

        //Seta o numero de orientações como o tamanho da lista de filhos usados
        professor.setNumeroOrientacaoGraduacaoConcluidas(filhosUsados.size());
    }
    
    /*
        Método para ler as orientações em andamento de cada professor
    
    */
    private void lerOrientacoesAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, int  anoInicio, int anoFim) {
        
        //Para cada um dos filhos do elemento de "ORIENTACOES-EM-ANDAMENTO"
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            //Procura os que tem nome igual a  "ORIENTACOES-EM-ANDAMENTO-PARA-MESTRADO"
            if(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO")) 
                contabilizaOrientacaoMestradoAndamento(professor, filhosOrientacoesAndamento, anoInicio, anoFim);
                    
            //Procura os que tem nome igual a  "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO"
            if(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO"))
                contabilizaOrientacaoDoutoradoAndamento(professor, filhosOrientacoesAndamento, anoInicio, anoFim);
                    
            //Procura os que tem nome igual a "OUTRAS-ORIENTACOES-CONCLUIDAS"
            if(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getName().equals("ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO"))
                contabilizaOrientacaoGraduacaoAndamento(professor, filhosOrientacoesAndamento, anoInicio, anoFim);   
        }
    }
    
    /*
        Método para contabilizar quantas orientações de mestrado em andamento serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoMestradoAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, int anoInicio, int anoFim) {
         
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            //Cria lista de elementos filhos de "ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO"
            List<Element> filhosOrientacoesMestrado = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
            //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
            for(int contadorFilhosMestrado = 0; contadorFilhosMestrado < filhosOrientacoesMestrado.size(); contadorFilhosMestrado++) {
                if(filhosOrientacoesMestrado.get(contadorFilhosMestrado).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-MESTRADO")) {
                    String ano = filhosOrientacoesMestrado.get(contadorFilhosMestrado).getAttributeValue("ANO");
                    int anoOrientacoesMestrado = Integer.parseInt(ano);
        
                    if((anoOrientacoesMestrado >= anoInicio) && (anoOrientacoesMestrado <= anoFim))
                        filhosUsados.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                }
            }
        }
                    
        //Seta o numero de orientações como o tamanho da lista de filhos usados
        professor.setNumeroOrientacaoMestradoAndamento(filhosUsados.size());
    }
    
    /*
        Método para contabilizar quantas orientações de doutorado em andamento serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoDoutoradoAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, int anoInicio, int anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            //Cria lista de elementos filhos de "ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO"
            List<Element> filhosOrientacoesDoutorado = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
            //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
            for(int contadorFilhosDoutorado = 0; contadorFilhosDoutorado < filhosOrientacoesDoutorado.size(); contadorFilhosDoutorado++) {
                if(filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-DOUTORADO")) {
                    String ano = filhosOrientacoesDoutorado.get(contadorFilhosDoutorado).getAttributeValue("ANO");
                    int anoOrientacoesDoutorado = Integer.parseInt(ano);
                
                    if((anoOrientacoesDoutorado >= anoInicio) && (anoOrientacoesDoutorado <= anoFim))
                        filhosUsados.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                }
            }
        }

        //Seta o numero de orientações como o tamanho da lista de filhos usados
        professor.setNumeroOrientacaoDoutoradoAndamento(filhosUsados.size());
    }
       
    /*
        Método para contabilizar quantas orientações de graduação em andamento serão considerados dados os anos definidos
    */
    private void contabilizaOrientacaoGraduacaoAndamento(Professor professor, List<Element> filhosOrientacoesAndamento, int anoInicio, int anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosOrientacoesAndamento = 0; contadorFilhosOrientacoesAndamento < filhosOrientacoesAndamento.size(); contadorFilhosOrientacoesAndamento++) {
            //Cria lista de elementos filhos de "ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO"
            List<Element> filhosOrientacoesGraduacao = filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento).getChildren();
                    
            //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
            for(int contadorFilhosGraduacao = 0; contadorFilhosGraduacao < filhosOrientacoesGraduacao.size(); contadorFilhosGraduacao++) {
                if(filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getName().equals("DADOS-BASICOS-DA-ORIENTACAO-EM-ANDAMENTO-DE-GRADUACAO")) {
                    String ano = filhosOrientacoesGraduacao.get(contadorFilhosGraduacao).getAttributeValue("ANO");
                    int anoOrientacoesGraduacao = Integer.parseInt(ano);
                
                    if((anoOrientacoesGraduacao >= anoInicio) && ( anoOrientacoesGraduacao <= anoFim))
                        filhosUsados.add(filhosOrientacoesAndamento.get(contadorFilhosOrientacoesAndamento));
                }
            }
        }

        //Seta o numero de orientações como o tamanho da lista de filhos usados
        professor.setNumeroOrientacaoGraduacaoAndamento(filhosUsados.size());
    }
    
    /*
        Método para ler as participações em banca de cada professor
    
    */
    private void lerParticipacoesBanca(Professor professor, List<Element> filhosParticipacaoBanca, int  anoInicio, int anoFim) {
        
        //Para cada um dos filhos do elemento de "PARTICIPACAO-EM-BANCA"
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            //Procura os que tem nome igual a  "PARTICIPACAO-EM-BANCA-DE-MESTRADO"
            if(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getName().equals("PARTICIPACAO-EM-BANCA-DE-MESTRADO")) 
                contabilizaParticipacaoMestrado(professor, filhosParticipacaoBanca, anoInicio, anoFim);
                    
            //Procura os que tem nome igual a  "PARTICIPACAO-EM-BANCA-DE-DOUTORADO"
            if(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getName().equals("PARTICIPACAO-EM-BANCA-DE-DOUTORADO"))
                contabilizaParticipacaoDoutorado(professor, filhosParticipacaoBanca, anoInicio, anoFim);
                    
            //Procura os que tem nome igual a "PARTICIPACAO-EM-BANCA-DE-GRADUACAO"
            if(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getName().equals("PARTICIPACAO-EM-BANCA-DE-GRADUACAO"))
                contabilizaParticipacaoGraducao(professor, filhosParticipacaoBanca, anoInicio, anoFim);   
        }
    }
    
    /*
        Método para contabilizar quantas participações em banca de mestrados serão considerados dados os anos definidos
    */
    private void contabilizaParticipacaoMestrado(Professor professor, List<Element> filhosParticipacaoBanca, int anoInicio, int anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            //Cria lista de elementos filhos de "PARTICIPACAO-EM-BANCA-DE-MESTRADO"
            List<Element> filhosBancaMestrado = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
            //Para cada um determina o ano da participação e adiciona os filhos usados, se válido
            for(int contadorBancaMestrado = 0; contadorBancaMestrado < filhosBancaMestrado.size(); contadorBancaMestrado++) {
                if(filhosBancaMestrado.get(contadorBancaMestrado).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-MESTRADO")) {
                    String ano = filhosBancaMestrado.get(contadorBancaMestrado).getAttributeValue("ANO");
                    int anoBancaMestrado = Integer.parseInt(ano);
                
                    if((anoBancaMestrado >= anoInicio) && (anoBancaMestrado <= anoFim))
                        filhosUsados.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                }
            }
        }

        //Seta o numero de bancas como o tamanho da lista de filhos usados
        professor.setNumeroBancasMestrado(filhosUsados.size());
    }
    
    /*
        Método para contabilizar quantas participações em banca de doutorado serão considerados dados os anos definidos
    */
    private void contabilizaParticipacaoDoutorado(Professor professor, List<Element> filhosParticipacaoBanca, int anoInicio, int anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            //Cria lista de elementos filhos de "PARTICIPACAO-EM-BANCA-DE-DOUTORADO"
            List<Element> filhosBancaDoutorado = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
        
            //Para cada um determina o ano da orientação e adiciona os filhos usados, se válido
            for(int contadorBancaDoutorado = 0; contadorBancaDoutorado < filhosBancaDoutorado.size(); contadorBancaDoutorado++) {
                if(filhosBancaDoutorado.get(contadorBancaDoutorado).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-DOUTORADO")) {
                    String ano = filhosBancaDoutorado.get(contadorBancaDoutorado).getAttributeValue("ANO");
                    int anoBancaDoutorado = Integer.parseInt(ano);
        
                    if((anoBancaDoutorado >= anoInicio) && (anoBancaDoutorado <= anoFim))
                        filhosUsados.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                }
            }
        }
                    
        //Seta o numero de bancas como o tamanho da lista de filhos usados
        professor.setNumeroBancasDoutorado(filhosUsados.size());
    }
    
    /*
        Método para contabilizar quantas participações em banca de graduação serão considerados dados os anos definidos
    */
    private void contabilizaParticipacaoGraducao(Professor professor, List<Element> filhosParticipacaoBanca, int anoInicio, int anoFim) {
        
        //Listas com elementos que seram usados de acordo com os anos passados como parâmetro
        List<Element> filhosUsados = new ArrayList<Element>();
        
        for(int contadorFilhosParticipacaoBanca = 0; contadorFilhosParticipacaoBanca < filhosParticipacaoBanca.size(); contadorFilhosParticipacaoBanca++) {
            //Cria lista de elementos filhos de "PARTICIPACAO-EM-BANCA-DE-GRADUACAO"
            List<Element> filhosBancaGraduacao = filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca).getChildren();
                    
            //Para cada um determina o ano da banca e adiciona os filhos usados, se válido
            for(int contadorBancaGraduacao = 0; contadorBancaGraduacao < filhosBancaGraduacao.size(); contadorBancaGraduacao++) {
                if(filhosBancaGraduacao.get(contadorBancaGraduacao).getName().equals("DADOS-BASICOS-DA-PARTICIPACAO-EM-BANCA-DE-GRADUACAO")) {
                    String ano = filhosBancaGraduacao.get(contadorBancaGraduacao).getAttributeValue("ANO");
                    int anoBancaGraduacao = Integer.parseInt(ano);
                
                    if((anoBancaGraduacao >= anoInicio) && (anoBancaGraduacao <= anoFim))
                        filhosUsados.add(filhosParticipacaoBanca.get(contadorFilhosParticipacaoBanca));
                }
            }
        }

        //Seta o numero de orientações como o tamanho da lista de filhos usados
        professor.setNumeroBancasGraduacao(filhosUsados.size());
    }

}
