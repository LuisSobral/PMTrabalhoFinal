package ClassesDeXML;

import ClassesObjetos.Artigo;
import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.PosGraduacao;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;

public class LerQualisTest {
    
    @Test
    public void testClassificarArtigo() throws ParserConfigurationException, SAXException, IOException {
        
        PosGraduacao pos = new PosGraduacao();
        LerProgramas xmlProgramas = new LerProgramas();
        xmlProgramas.leituraDeProgramas(pos);
               
        for(Programa programa : pos.getProgramas())
            if(programa.getNome().equals("PPGI-UNIRIO")) {      
                criarLinhas(programa);
                
                LerQualis xmlQualis = new LerQualis();
                xmlQualis.classificarArtigos(programa);
                
                assertEquals("NC",programa.pegaLinha(0).pegaProfessorIndice(0).pegaArtigoEvento(0).getClasse());
                assertEquals("A1",programa.pegaLinha(0).pegaProfessorIndice(0).pegaArtigoEvento(1).getClasse());
                assertEquals("B2",programa.pegaLinha(0).pegaProfessorIndice(0).pegaArtigoEvento(2).getClasse());
                assertEquals("B4",programa.pegaLinha(0).pegaProfessorIndice(0).pegaArtigoEvento(3).getClasse());
                assertEquals("B1",programa.pegaLinha(0).pegaProfessorIndice(0).pegaArtigoEvento(4).getClasse());
                assertEquals("",programa.pegaLinha(0).pegaProfessorIndice(0).pegaArtigoEvento(5).getClasse());
            }
    }
    
    private void criarLinhas(Programa programa) {
        
        LinhaDePesquisa linha = new LinhaDePesquisa();
        
        criarProfessores(linha);
        
        programa.adicionaLinha(linha);
    }

    private void criarProfessores(LinhaDePesquisa linha) {
        
        Professor professor = new Professor();
        
        criarArtigosEvento(professor);  
        
        linha.adicionaProfessor(professor);
    
    }

    private void criarArtigosEvento(Professor professor) {
    
        Artigo artigo1 = new Artigo("", "Otimização em Engenharia de Software");
        Artigo artigo2 = new Artigo("", "CONFERENCE ON ARTIFICIAL INTELLIGENCE");
        Artigo artigo3 = new Artigo("", "WORKSHOP ON FAULT DIAGNOSIS AND TOLERANCE IN CRYPTOGRAPHY");
        Artigo artigo4 = new Artigo("", "LINZ SEMINAR ON FUZZY SET THEORY");
        Artigo artigo5 = new Artigo("", "INTERNATIONAL SYMPOSIUM ON APPLICATIONS AND THE INTERNET");
        Artigo artigo6 = new Artigo("", "Faculdade");
        
        professor.adicionaArtigoEvento(artigo1);
        professor.adicionaArtigoEvento(artigo2);
        professor.adicionaArtigoEvento(artigo3);
        professor.adicionaArtigoEvento(artigo4);
        professor.adicionaArtigoEvento(artigo5);
        professor.adicionaArtigoEvento(artigo6);
    }
    
    
}
