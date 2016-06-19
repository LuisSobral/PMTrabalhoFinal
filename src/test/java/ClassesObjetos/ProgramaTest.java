package ClassesObjetos;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProgramaTest {
    Professor professor1 = new Professor();
    Professor professor2 = new Professor();
    Professor professor3 = new Professor();
    Professor professor4 = new Professor();
    Professor professor5 = new Professor();
    
    Artigo artigo1 = new Artigo();
    Artigo artigo2 = new Artigo();
    Artigo artigo3 = new Artigo();
    Artigo artigo4 = new Artigo();
    Artigo artigo5 = new Artigo();

    LinhaDePesquisa linha1 = new LinhaDePesquisa();
    LinhaDePesquisa linha2 = new LinhaDePesquisa();
    LinhaDePesquisa linha3 = new LinhaDePesquisa();
    
    Programa programa = new Programa();
    
    double soma = 0;
    int numProfessores = 0;
    double media = 0;
    /**
     * Teste do metodo 'somarOrientacoesMestradoConcluidasPrograma' da classe Programa.
     */
    @Test
    public void testSomarOrientacoesMestradoConcluidasPrograma() {
        professor1.setNumeroOrientacaoMestradoConcluidas(3);
        professor2.setNumeroOrientacaoMestradoConcluidas(8);
        professor3.setNumeroOrientacaoMestradoConcluidas(6);
        professor4.setNumeroOrientacaoMestradoConcluidas(5);
        professor5.setNumeroOrientacaoMestradoConcluidas(10);
        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = (3+8+6)+(5+10)+(10+8+6+3) = 59!
        soma = 59.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarOrientacoesMestradoConcluidasPrograma(), 0.001);
    }

    @Test
    public void testSomarOrientacoesMestradoConcluidasProgramaNulas() {        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = 0!
        soma = 0.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarOrientacoesMestradoConcluidasPrograma(), 0.001);
    }
    /**
     * Teste do metodo 'somarOrientacoesMestradoAndamentoPrograma' da classe Programa.
     */
    @Test
    public void testSomarOrientacoesMestradoAndamentoPrograma() {
        professor1.setNumeroOrientacaoMestradoAndamento(13);
        professor2.setNumeroOrientacaoMestradoAndamento(0);
        professor3.setNumeroOrientacaoMestradoAndamento(9);
        professor4.setNumeroOrientacaoMestradoAndamento(4);
        professor5.setNumeroOrientacaoMestradoAndamento(20);
        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = (13+0+9)+(4+20)+(20+0+9+13) = 88!
        soma = 88.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarOrientacoesMestradoAndamentoPrograma(), 0.001);
    }

    @Test
    public void testSomarOrientacoesMestradoAndamentoProgramaNulas() {        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = 0!
        soma = 0.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarOrientacoesMestradoAndamentoPrograma(), 0.001);
    }

    /**
     * Teste do metodo 'somarBancaDoutoradoPrograma' da classe Programa.
     */
    @Test
    public void testSomarBancaDoutoradoPrograma() {
        professor1.setNumeroBancasDoutorado(3);
        professor2.setNumeroBancasDoutorado(9);
        professor3.setNumeroBancasDoutorado(15);
        professor4.setNumeroBancasDoutorado(4);
        professor5.setNumeroBancasDoutorado(2);
        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = (3+9+15)+(4+2)+(2+9+15+3) = 62!
        soma = 62.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarBancaDoutoradoPrograma(), 0.001);
    }

    @Test
    public void testSomarBancaDoutoradoProgramaNulas() {
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = 0!
        soma = 0.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarBancaDoutoradoPrograma(), 0.001);
    }
    /**
     * Teste do metodo 'somarArtigosA1RevistaPrograma' da classe Programa.
     */
    @Test
    public void testSomarArtigosA1RevistaPrograma() {
        artigo1.setClasse("A1");
        artigo2.setClasse("A1");
        artigo3.setClasse("A1");
        artigo4.setClasse("A1");
        artigo5.setClasse("A1");
        
        professor1.adicionaArtigoRevista(artigo1);
        professor1.adicionaArtigoRevista(artigo2);
        professor1.adicionaArtigoRevista(artigo3);
        professor2.adicionaArtigoRevista(artigo1);
        professor3.adicionaArtigoRevista(artigo4);
        professor3.adicionaArtigoRevista(artigo5);
        professor4.adicionaArtigoRevista(artigo1);
        professor4.adicionaArtigoRevista(artigo2);
        professor4.adicionaArtigoRevista(artigo3);
        professor4.adicionaArtigoRevista(artigo4);
        professor4.adicionaArtigoRevista(artigo5);
        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = (3+1+2)+(5+0)+(0+1+2+3) = 17!
        soma = 17.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarArtigosA1RevistaPrograma(), 0.001);
    }
    
    @Test
    public void testSomarArtigosA1RevistaProgramaClassesDiferentes() {
        artigo1.setClasse("C");
        artigo2.setClasse("NC");
        artigo3.setClasse("A1");
        artigo4.setClasse("NC");
        artigo5.setClasse("A1");
        
        professor1.adicionaArtigoRevista(artigo1);
        professor1.adicionaArtigoRevista(artigo2);
        professor1.adicionaArtigoRevista(artigo3);
        professor2.adicionaArtigoRevista(artigo1);
        professor3.adicionaArtigoRevista(artigo4);
        professor3.adicionaArtigoRevista(artigo5);
        professor4.adicionaArtigoRevista(artigo1);
        professor4.adicionaArtigoRevista(artigo2);
        professor4.adicionaArtigoRevista(artigo3);
        professor4.adicionaArtigoRevista(artigo4);
        professor4.adicionaArtigoRevista(artigo5);
        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = (1+0+1)+(2+0)+(0+0+1+1) = 6!
        soma = 6.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarArtigosA1RevistaPrograma(), 0.001);
    }
    
    @Test
    public void testSomarArtigosA1RevistaProgramaSemClasse() {
        professor1.adicionaArtigoRevista(artigo1);
        professor1.adicionaArtigoRevista(artigo2);
        professor1.adicionaArtigoRevista(artigo3);
        professor2.adicionaArtigoRevista(artigo1);
        professor3.adicionaArtigoRevista(artigo4);
        professor3.adicionaArtigoRevista(artigo5);
        professor4.adicionaArtigoRevista(artigo1);
        professor4.adicionaArtigoRevista(artigo2);
        professor4.adicionaArtigoRevista(artigo3);
        professor4.adicionaArtigoRevista(artigo4);
        professor4.adicionaArtigoRevista(artigo5);
        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = 0!
        soma = 0.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarArtigosA1RevistaPrograma(), 0.001);
    }
    
    @Test
    public void testSomarArtigosA1RevistaProgramaClassesInvalidas() {
        artigo1.setClasse("DU");
        artigo2.setClasse("DA");
        artigo3.setClasse("DE");
        artigo4.setClasse("DO");
        artigo5.setClasse("DI");
        
        professor1.adicionaArtigoRevista(artigo1);
        professor1.adicionaArtigoRevista(artigo2);
        professor1.adicionaArtigoRevista(artigo3);
        professor2.adicionaArtigoRevista(artigo1);
        professor3.adicionaArtigoRevista(artigo4);
        professor3.adicionaArtigoRevista(artigo5);
        professor4.adicionaArtigoRevista(artigo1);
        professor4.adicionaArtigoRevista(artigo2);
        professor4.adicionaArtigoRevista(artigo3);
        professor4.adicionaArtigoRevista(artigo4);
        professor4.adicionaArtigoRevista(artigo5);
        
        linha1.adicionaProfessor(professor1);
        linha1.adicionaProfessor(professor2);
        linha1.adicionaProfessor(professor3);
        linha2.adicionaProfessor(professor4);
        linha2.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor5);
        linha3.adicionaProfessor(professor2);
        linha3.adicionaProfessor(professor3);
        linha3.adicionaProfessor(professor1);
        
        programa.adicionaLinha(linha1);
        programa.adicionaLinha(linha2);
        programa.adicionaLinha(linha3);
        
        //soma = 0!
        soma = 0.0;
        //numProfessores = 3+2+4 = 9!
        numProfessores = 9;
        media = soma/numProfessores;
        
        assertEquals(Math.round(media*1e1)/1e1, programa.somarArtigosA1RevistaPrograma(), 0.001);
    }

}
