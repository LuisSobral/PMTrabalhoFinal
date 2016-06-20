package ClassesDeXML;

import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
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

public class LerLinhas {
    
    /*
        Método de leitura do arquivo XML que contém o nome das linhas e dos professores
    */
    public void leituraDeLinhas(Programa programa) throws ParserConfigurationException, SAXException, IOException {
        
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
            linha.setNome(filhosRoot.get(i).getAttributeValue("nome"));
            
            programa.adicionaLinha(linha);
            
            List<Element> filhosLinha = filhosRoot.get(i).getChildren();
            
            leituraDeProfessores(linha, filhosLinha);
        }
    
    }

    /*
        Método de leitura de professores dentro de uma linha
    */
    private void leituraDeProfessores(LinhaDePesquisa linha, List<Element> filhosLinha) {
        
        for(int j=0; j<filhosLinha.size(); j++) {
           
            Professor professor = new Professor();
            professor.setCodigo(filhosLinha.get(j).getAttributeValue("codigo"));

            professor.setNome(filhosLinha.get(j).getAttributeValue("nome"));

            linha.adicionaProfessor(professor);
        }
    }
    
}
