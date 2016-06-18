package ClassesObjetos;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProfessorTest {
    Professor professor = new Professor();

    Artigo artigo1 = new Artigo();
    Artigo artigo2 = new Artigo();
    Artigo artigo3 = new Artigo();
    Artigo artigo4 = new Artigo();
    Artigo artigo5 = new Artigo();
    /**
     * Teste do metodo 'somarArtigosA1RevistaProfessor' da classe Professor.
     */
    @Test
    public void testSomarArtigosA1RevistaProfessor() {        
        artigo1.setClasse("A1");
        artigo2.setClasse("A1");
        artigo3.setClasse("A1");
        artigo4.setClasse("A1");
        artigo5.setClasse("A1");
        
        professor.adicionaArtigoRevista(artigo1);
        professor.adicionaArtigoRevista(artigo2);
        professor.adicionaArtigoRevista(artigo3);
        professor.adicionaArtigoRevista(artigo4);
        professor.adicionaArtigoRevista(artigo5);
        
        //somaTotal = 5!
        double soma = 5.0;
        
        assertEquals(soma, professor.somarArtigosA1RevistaProfessor(), 0.001);
    }
    
    @Test
    public void testSomarArtigosA1RevistaProfessorClassesDiferentes() {
        artigo1.setClasse("A1");
        artigo2.setClasse("C");
        artigo3.setClasse("A1");
        artigo4.setClasse("NC");
        artigo5.setClasse("A1");
        
        professor.adicionaArtigoRevista(artigo1);
        professor.adicionaArtigoRevista(artigo2);
        professor.adicionaArtigoRevista(artigo3);
        professor.adicionaArtigoRevista(artigo4);
        professor.adicionaArtigoRevista(artigo5);
        
        //somaTotal = 3!
        double soma = 3.0;
        
        assertEquals(soma, professor.somarArtigosA1RevistaProfessor(), 0.001);
    }
    
    @Test
    public void testSomarArtigosA1RevistaProfessorSemClasse() {
        professor.adicionaArtigoRevista(artigo1);
        professor.adicionaArtigoRevista(artigo2);
        professor.adicionaArtigoRevista(artigo3);
        professor.adicionaArtigoRevista(artigo4);
        professor.adicionaArtigoRevista(artigo5);
        
        //somaTotal = 0!
        double soma = 0.0;
        
        assertEquals(soma, professor.somarArtigosA1RevistaProfessor(), 0.001);
    }
    
    @Test
    public void testSomarArtigosA1RevistaProfessorClassesInvalidas() {
        artigo1.setClasse("BA");
        artigo2.setClasse("BO");
        artigo3.setClasse("BE");
        artigo4.setClasse("BU");
        artigo5.setClasse("BI");
        
        professor.adicionaArtigoRevista(artigo1);
        professor.adicionaArtigoRevista(artigo2);
        professor.adicionaArtigoRevista(artigo3);
        professor.adicionaArtigoRevista(artigo4);
        professor.adicionaArtigoRevista(artigo5);
        
        //somaTotal = 0!
        double soma = 0.0;
        
        assertEquals(soma, professor.somarArtigosA1RevistaProfessor(), 0.001);
    }
}