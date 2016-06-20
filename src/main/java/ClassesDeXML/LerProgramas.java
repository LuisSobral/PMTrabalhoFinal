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
        Método de leitura do arquivo XML que contém os nomes dos programas
    */
    public void leituraDeProgramas(PosGraduacao pos) throws ParserConfigurationException, SAXException, IOException {
        
        Programa programa = new Programa();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        org.w3c.dom.Document docProgramas = (org.w3c.dom.Document) dombuilder.parse("https://s3.amazonaws.com/posgraduacao/programas.xml");
        DOMBuilder jdomBuilder = new DOMBuilder();
        
        Document jdomDocument = jdomBuilder.build(docProgramas);
        
        Element root = jdomDocument.getRootElement();
        
        List<Element> filhosRoot = root.getChildren();
       
        for(int i=0; i < filhosRoot.size(); i++) {
            programa.setNome(filhosRoot.get(i).getAttributeValue("nome"));
            pos.adicionaPrograma(programa);
        }
    }
}
