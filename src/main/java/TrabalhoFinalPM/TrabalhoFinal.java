package TrabalhoFinalPM;

import ClasseDeEscritaDeArquivo.EscreverArquivo;
import ClassesDeXML.LerCurriculo;
import ClassesDeXML.LerLinhas;
import ClassesDeXML.LerProgramas;
import ClassesDeXML.LerQualis;
import ClassesObjetos.PosGraduacao;
import ClassesObjetos.Programa;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;


public class TrabalhoFinal {

    public static void main(String[] args) throws JDOMException, IOException, ParserConfigurationException, SAXException {
    
        PosGraduacao pos = new PosGraduacao();
        LerProgramas xmlProgramas = new LerProgramas();
        LerLinhas xmlLinhas = new LerLinhas();
        LerCurriculo xmlCurriculos = new LerCurriculo();
        LerQualis xmlQualis = new LerQualis();
        
        //Faz a leitura do xml com os programas de pós graduação
        xmlProgramas.leituraDeProgramas(pos);
                
        int anoInicio = Integer.parseInt("2013");
        int anoFim = Integer.parseInt("2015");
        
        //Faz a leitura do xml com as linhas de pesqueisa e cada um de seus professores
        //Faz a leitura dos curriculos de cada professor
        for(Programa programa : pos.getProgramas())
            if(programa.getNome().equals("PPGI-UNIRIO")) {
                xmlLinhas.leituraDeLinhas(programa);
                xmlCurriculos.leituraDeCurriculos(programa,anoInicio,anoFim);
                xmlQualis.classificarArtigos(programa);
                
                //Mostra a tabela com os dados analisados
                EscreverArquivo tabela = new EscreverArquivo();
                tabela.criaArquivo(programa, anoInicio, anoFim);
            }
        
        System.out.println("Análise concluída!");
    }
    
}
