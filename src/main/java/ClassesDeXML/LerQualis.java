package ClassesDeXML;

import ClassesObjetos.Artigo;
import ClassesObjetos.EntradaQualis;
import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;
import ClassesObjetos.Qualis;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

public class LerQualis {
    
    public void classificarArtigos(Programa programa) throws SAXException, ParserConfigurationException, IOException {
        
        Qualis qualis = new Qualis();
        int achou = 0;
        criarEntradas(qualis);
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                for(Artigo artigo : professor.getArtigosEventos()) {
                    for(int i=0; i<qualis.getArtigosEvento().size(); i++) {
                        if(artigo.getRegex().matches("(?i)"+qualis.pegaRegexEvento(i))) {
                            achou = 1;
                            artigo.setClasse(qualis.pegaClasseEvento(i));
                        }
                    }
                    
                    if(achou == 0)
                        System.out.println("Não existe regex para: "+artigo.getRegex());
                    else
                        achou = 0;
                }
                                
                for(Artigo artigo : professor.getArtigosRevista()) {
                    for(int i=0; i<qualis.getArtigosRevista().size(); i++) {
                        if(artigo.getRegex().matches("(?i)"+qualis.pegaRegexRevista(i))) {
                            achou = 1;
                            artigo.setClasse(qualis.pegaClasseRevista(i));
                        }
                    }
                
                    if(achou == 0)
                        System.out.println("Não existe regex para: "+artigo.getRegex());
                    else
                        achou = 0;
                }
            }
        
    }
    
    private void criarEntradas(Qualis qualis) throws ParserConfigurationException, SAXException, IOException {
        
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
        
        //Para cada entrada do xml qualis procura se se é conferência ou periódico
        for(int contadorEntry = 0; contadorEntry < filhosRoot.size(); contadorEntry++) {
            EntradaQualis entrada = new EntradaQualis();
            
            //Se periódico coloca na lista de regex para revistas
            if(filhosRoot.get(contadorEntry).getAttributeValue("type").equals("Periódico")) {
                entrada.setClasse(filhosRoot.get(contadorEntry).getAttributeValue("class"));
                entrada.setRegex(filhosRoot.get(contadorEntry).getAttributeValue("regex"));
                qualis.adicionaArtigoRevista(entrada);
            }
            
            //Se conferência coloca na lista de regex para eventos
            if(filhosRoot.get(contadorEntry).getAttributeValue("type").equals("Conferência")) {
                entrada.setClasse(filhosRoot.get(contadorEntry).getAttributeValue("class"));
                entrada.setRegex(filhosRoot.get(contadorEntry).getAttributeValue("regex"));
                qualis.adicionaArtigoEvento(entrada);
            }
        }
    }    
}
