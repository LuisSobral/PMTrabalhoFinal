package TrabalhoFinalPM;

import ClasseDeTabela.DesenhaTabela;
import ClassesDeXML.LeituraXML;
import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;


public class TrabalhoFinal {

    public static void main(String[] args) throws JDOMException, IOException, ParserConfigurationException, SAXException {
    
        Programa programa = new Programa();
        LeituraXML xml = new LeituraXML();
        
        //Faz a leitura do xml com os programas de pós graduação
        xml.leituraDeProgramas(programa);
        
        //Faz a leitura do xml com as linhas de pesqueisa e cada um de seus professores
        xml.leituraDeLinhasEProfessores(programa);
        
        //Faz a leitura dos curriculos de cada professor
        xml.leituraDeCurriculos(programa,"2013","2015");
        
        //Para cada professor faz a classificação dos seus artigos
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores())
                    xml.classificarArtigos(professor);
        
        //Mostra a tabela com os dados analisados
        DesenhaTabela tabela = new DesenhaTabela();
        tabela.criaJanela(programa);
        
    }
    
}
