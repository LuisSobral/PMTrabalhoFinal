package ClassesDeXML;

import ClassesObjetos.PosGraduacao;
import ClassesObjetos.Programa;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

public class LerProgramas {
    
    /*
        Método de leitura do arquivo XML que contém o nome dos programas
    */
    public void leituraDeProgramas(PosGraduacao pos) throws ParserConfigurationException, SAXException, IOException {
        
        Programa programa = new Programa();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        
        //Recebe o arquivo xml
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("https://s3.amazonaws.com/posgraduacao/programas.xml");
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        //Pega o elemento do root do xml
        Element root = jdomDocument.getRootElement();
        
        
        //Pega o filho do root com nome de programa
        List<Element> filhosRoot = root.getChildren();
       
        //Pega o valor do atributo de nome: "nome"
        //Seta o nome do programa como o valor do atributo
        //Adiciona programa a lista de programas da pos-graduação
        for(int i=0; i < filhosRoot.size(); i++) {
            programa.setNome(filhosRoot.get(i).getAttributeValue("nome"));
            pos.adicionaPrograma(programa);
        }
    }
}
