package ClassesObjetos;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinhaDePesquisaTest {
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

    LinhaDePesquisa linha = new LinhaDePesquisa();
    
    double soma = 0;
    double media = 0;
    /**
     * Teste do metodo 'somarOrientacoesMestradoConcluidasLinhas' da classe LinhaDePesquisa.
     */
    @Test
    public void testSomarOrientacoesMestradoConcluidasLinhas() {
        professor1.setNumeroOrientacaoMestradoConcluidas(3);
        professor2.setNumeroOrientacaoMestradoConcluidas(8);
        professor3.setNumeroOrientacaoMestradoConcluidas(6);
        professor4.setNumeroOrientacaoMestradoConcluidas(5);
        professor5.setNumeroOrientacaoMestradoConcluidas(10);
        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);
        
        //soma = 3+8+6+5+10 = 32!
        soma = 32.0;
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarOrientacoesMestradoConcluidasLinhas(), 0.001);
    }
    
    @Test
    public void testSomarOrientacoesMestradoConcluidasLinhasNulas() {        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);
        
        //soma = 0!
        soma = 0.0;
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarOrientacoesMestradoConcluidasLinhas(), 0.001);
    }
    
    /**
     * Teste do metodo 'somarOrientacoesMestradoAndamentoLinhas' da classe LinhaDePesquisa.
     */
    @Test
    public void testSomarOrientacoesMestradoAndamentoLinhas() {        
        professor1.setNumeroOrientacaoMestradoAndamento(7);
        professor2.setNumeroOrientacaoMestradoAndamento(13);
        professor3.setNumeroOrientacaoMestradoAndamento(0);
        professor4.setNumeroOrientacaoMestradoAndamento(2);
        professor5.setNumeroOrientacaoMestradoAndamento(1);
        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);
        
        //soma = 7+13+0+2+1 = 23!
        soma = 23.0;
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarOrientacoesMestradoAndamentoLinhas(), 0.001);
    }

    @Test
    public void testSomarOrientacoesMestradoAndamentoLinhasNulas() {     
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);
        
        //soma = 0!
        soma = 0.0;
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarOrientacoesMestradoAndamentoLinhas(), 0.001);
    }
    
    /**
     * Teste do metodo 'somarBancaDoutoradoLinhas' da classe LinhaDePesquisa.
     */
    @Test
    public void testSomarBancaDoutoradoLinhas() {        
        professor1.setNumeroBancasDoutorado(3);
        professor2.setNumeroBancasDoutorado(9);
        professor3.setNumeroBancasDoutorado(15);
        professor4.setNumeroBancasDoutorado(4);
        professor5.setNumeroBancasDoutorado(2);
        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);
        
        //soma = 3+9+15+4+2 = 33!
        soma = 33.0;
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarBancaDoutoradoLinhas(), 0.001);
    }
    
    @Test
    public void testSomarBancaDoutoradoLinhasNulas() {        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);
        
        //soma = 0!
        soma = 0.0;
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarBancaDoutoradoLinhas(), 0.001);
    }
    
    /**
     * Teste dos metodos de somarArtigosRevistaLinha da classe LinhaDePesquisa.
     */
    @Test
    public void testSomarArtigosA1RevistaLinha() {       
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
        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);        

        //somaTotal = 3+1+2+5+0 = 11!
        soma = professor1.somarArtigosA1RevistaProfessor()+professor2.somarArtigosA1RevistaProfessor()
                +professor3.somarArtigosA1RevistaProfessor()+professor4.somarArtigosA1RevistaProfessor()
                +professor5.somarArtigosA1RevistaProfessor();
        
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarArtigosA1RevistaLinha(), 0.001);
    }
    
    @Test
    public void testSomarArtigosA1RevistaLinhaClassesDiferentes() {        
        artigo1.setClasse("A1");
        artigo2.setClasse("A2");
        artigo3.setClasse("A1");
        artigo4.setClasse("A1");
        artigo5.setClasse("B1");
        
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
        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);        

        //somaTotal = 2+1+1+3+0 = 7!
        soma = professor1.somarArtigosA1RevistaProfessor()+professor2.somarArtigosA1RevistaProfessor()
                +professor3.somarArtigosA1RevistaProfessor()+professor4.somarArtigosA1RevistaProfessor()
                +professor5.somarArtigosA1RevistaProfessor();
        
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarArtigosA1RevistaLinha(), 0.001);
    }
    
    @Test
    public void testSomarArtigosA1RevistaLinhaSemClasse() {        
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
        professor5.adicionaArtigoRevista(artigo3);
        professor5.adicionaArtigoRevista(artigo2);
        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);        

        //somaTotal = 0!
        soma = professor1.somarArtigosA1RevistaProfessor()+professor2.somarArtigosA1RevistaProfessor()
                +professor3.somarArtigosA1RevistaProfessor()+professor4.somarArtigosA1RevistaProfessor()
                +professor5.somarArtigosA1RevistaProfessor();
        
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarArtigosA1RevistaLinha(), 0.001);
    }
    
    @Test
    public void testSomarArtigosRevistaLinhaClassesInvalidas() {        
        artigo1.setClasse("LA");
        artigo2.setClasse("LO");
        artigo3.setClasse("LI");
        artigo4.setClasse("LU");
        artigo5.setClasse("LE");
        
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
        professor5.adicionaArtigoRevista(artigo3);
        professor5.adicionaArtigoRevista(artigo5);
        professor5.adicionaArtigoRevista(artigo1);
        
        linha.adicionaProfessor(professor1);
        linha.adicionaProfessor(professor2);
        linha.adicionaProfessor(professor3);
        linha.adicionaProfessor(professor4);
        linha.adicionaProfessor(professor5);        

        //somaTotal = 0!
        soma = professor1.somarArtigosA1RevistaProfessor()+professor2.somarArtigosA2RevistaProfessor()
                +professor3.somarArtigosB1RevistaProfessor()+professor4.somarArtigosB2RevistaProfessor()
                +professor5.somarArtigosB3RevistaProfessor()+professor4.somarArtigosB4RevistaProfessor()
                +professor3.somarArtigosCRevistaProfessor()+professor2.somarArtigosNCRevistaProfessor();
        
        media = soma/5;
        
        assertEquals(Math.round(media*1e1)/1e1, linha.somarArtigosA1RevistaLinha(), 0.001);
    }
    
}
