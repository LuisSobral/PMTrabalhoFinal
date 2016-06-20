package ClassesDeXML;

import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.PosGraduacao;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;

public class LerLinhasTest {
   
    @Test
    public void testLeituraDeLinhas() throws Exception {
         
        PosGraduacao pos = new PosGraduacao();
        LerProgramas xmlProgramas = new LerProgramas();
        LerLinhas xmlLinhas = new LerLinhas();
        
        //Faz a leitura do xml com os programas de pós graduação
        xmlProgramas.leituraDeProgramas(pos);
        
        for(Programa programa : pos.getProgramas()) {
            if(programa.getNome().equals("PPGI-UNIRIO")) {
                xmlLinhas.leituraDeLinhas(programa);
                
                LinhaDePesquisa linhaTest = new LinhaDePesquisa("Representação de Conhecimento e Raciocínio");
                assertEquals(linhaTest.getNome(), programa.pegaLinhaDePesquisaIndice(0).getNome());

                linhaTest.setNome("Distribuição e Redes");
                assertEquals(linhaTest.getNome(), programa.pegaLinhaDePesquisaIndice(1).getNome());

                linhaTest.setNome("Sistemas de Apoio a Negócios");
                assertEquals(linhaTest.getNome(), programa.pegaLinhaDePesquisaIndice(2).getNome());    
            }
        }
    }
    
    @Test
    public void testLeituraProfessores() throws ParserConfigurationException, SAXException, IOException {
        
        PosGraduacao pos = new PosGraduacao();
        LerProgramas xmlProgramas = new LerProgramas();
        LerLinhas xmlLinhas = new LerLinhas();
        
        //Faz a leitura do xml com os programas de pós graduação
        xmlProgramas.leituraDeProgramas(pos);
        
        for(Programa programa : pos.getProgramas()) {
            if(programa.getNome().equals("PPGI-UNIRIO")) {
                xmlLinhas.leituraDeLinhas(programa);
                
                Professor professorTest = new Professor("Adriana Cesário de Faria Alvim","",0,0,0,0,0,0,0,0,0);
                assertEquals(professorTest.getNome(),programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(0).getNome());

                professorTest.setNome("Bernardo Pereira Nunes");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(1).getNome());

                professorTest.setNome("Leila Cristina Vasconcelos de Andrade");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(2).getNome());

                professorTest.setNome("Kate Cerqueira Revoredo");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(3).getNome());

                professorTest.setNome("Sean Wolfgand Matsui Siqueira");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(0).pegaProfessorIndice(4).getNome());

                professorTest.setNome("Astério Kiyoshi Tanaka");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(0).getNome());

                professorTest.setNome("Carlos Alberto Vieira Campos");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(1).getNome());

                professorTest.setNome("Fernanda Araújo Baião Amorim");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(2).getNome());

                professorTest.setNome("Leonardo Guerreiro Azevedo");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(3).getNome());

                professorTest.setNome("Morganna Carmem Diniz");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(4).getNome());

                professorTest.setNome("Sidney Cunha de Lucena");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(1).pegaProfessorIndice(5).getNome());

                professorTest.setNome("Claudia Cappelli");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(0).getNome());

                professorTest.setNome("Flávia Maria Santoro");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(1).getNome());

                professorTest.setNome("Gleison dos Santos Santos");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(2).getNome());

                professorTest.setNome("Márcio de Oliveira Barros");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(3).getNome());

                professorTest.setNome("Mariano Pimentel");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(4).getNome());

                professorTest.setNome("Renata Mendes de Araujo");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(5).getNome());

                professorTest.setNome("Simone Bacellar Leal Ferreira");
                assertEquals(professorTest.getNome(), programa.pegaLinhaDePesquisaIndice(2).pegaProfessorIndice(6).getNome());
            }
        }
    }
}
