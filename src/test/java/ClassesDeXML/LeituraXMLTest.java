package ClassesDeXML;

import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;


public class LeituraXMLTest {
    
    @Test
    public void testLeituraDeProgramas() throws ParserConfigurationException, SAXException, IOException {
        
        Programa programaTest = new Programa("PPGI-UNIRIO");
        Programa programa = new Programa();
        LeituraXML xml = new LeituraXML();
        xml.leituraDeProgramas(programa);
        
        assertEquals(programa.getNome(),programaTest.getNome());        
    }
    
    @Test
    public void testLeituraDeLinhas() throws ParserConfigurationException, SAXException, IOException {
        
        Programa programa = new Programa();
        LeituraXML xml = new LeituraXML();
        xml.leituraDeProgramas(programa);
        xml.leituraDeLinhasEProfessores(programa);
        
        LinhaDePesquisa linhaTest = new LinhaDePesquisa("Representação de Conhecimento e Raciocínio");
        assertEquals(programa.pegaLinhaDePesquisaIndice(0).getNome(),linhaTest.getNome());
        
        linhaTest.setNome("Distribuição e Redes");
        assertEquals(programa.pegaLinhaDePesquisaIndice(1).getNome(),linhaTest.getNome());
        
        linhaTest.setNome("Sistemas de Apoio a Negócios");
        assertEquals(programa.pegaLinhaDePesquisaIndice(2).getNome(),linhaTest.getNome());       
    }
    
    @Test
    public void testLeituraDeProfessores() throws ParserConfigurationException, SAXException, IOException {
        
        Programa programa = new Programa();
        LeituraXML xml = new LeituraXML();
        xml.leituraDeProgramas(programa);
        xml.leituraDeLinhasEProfessores(programa);
        
        Professor professorTest = new Professor("Adriana Cesário de Faria Alvim","",0,0,0,0,0,0,0,0,0);
        assertEquals(programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(0).getNome(),professorTest.getNome());
        
        professorTest.setNome("Bernardo Pereira Nunes");
        assertEquals(programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(1).getNome(),professorTest.getNome());
        
        professorTest.setNome("Leila Cristina Vasconcelos de Andrade");
        assertEquals(programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(2).getNome(),professorTest.getNome());
        
        professorTest.setNome("Kate Cerqueira Revoredo");
        assertEquals(programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(3).getNome(),professorTest.getNome());
        
        professorTest.setNome("Sean Wolfgand Matsui Siqueira");
        assertEquals(programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(4).getNome(),professorTest.getNome());
        
        professorTest.setNome("Astério Kiyoshi Tanaka");
        assertEquals(programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(0).getNome(),professorTest.getNome());
        
        professorTest.setNome("Carlos Alberto Vieira Campos");
        assertEquals(programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(1).getNome(),professorTest.getNome());
        
        professorTest.setNome("Fernanda Araújo Baião Amorim");
        assertEquals(programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(2).getNome(),professorTest.getNome());
        
        professorTest.setNome("Leonardo Guerreiro Azevedo");
        assertEquals(programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(3).getNome(),professorTest.getNome());
        
        professorTest.setNome("Morganna Carmem Diniz");
        assertEquals(programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(4).getNome(),professorTest.getNome());
        
        professorTest.setNome("Sidney Cunha de Lucena");
        assertEquals(programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(5).getNome(),professorTest.getNome());
        
        professorTest.setNome("Claudia Cappelli");
        assertEquals(programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(0).getNome(),professorTest.getNome());
        
        professorTest.setNome("Flávia Maria Santoro");
        assertEquals(programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(1).getNome(),professorTest.getNome());
        
        professorTest.setNome("Gleison dos Santos Santos");
        assertEquals(programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(2).getNome(),professorTest.getNome());
        
        professorTest.setNome("Márcio de Oliveira Barros");
        assertEquals(programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(3).getNome(),professorTest.getNome());
        
        professorTest.setNome("Mariano Pimentel");
        assertEquals(programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(4).getNome(),professorTest.getNome());
        
        professorTest.setNome("Renata Mendes de Araujo");
        assertEquals(programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(5).getNome(),professorTest.getNome());
    
        professorTest.setNome("Simone Bacellar Leal Ferreira");
        assertEquals(programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(6).getNome(),professorTest.getNome());
    }
    
}
