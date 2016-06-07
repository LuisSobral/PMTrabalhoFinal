/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseDeRotinas;

import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author labccet
 */
public class SomatorioTest {
    
    /**
     * Test of somarOrientacoesMestradoConcluidasLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesMestradoConcluidasLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesMestradoConcluidasLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesDoutoradoConcluidasLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesDoutoradoConcluidasLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesDoutoradoConcluidasLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesGraduacaoConcluidasLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesGraduacaoConcluidasLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesGraduacaoConcluidasLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesMestradoAndamentoLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesMestradoAndamentoLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesMestradoAndamentoLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesDoutoradoAndamentoLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesDoutoradoAndamentoLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesDoutoradoAndamentoLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesGraduacaoAndamentoLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesGraduacaoAndamentoLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesGraduacaoAndamentoLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarBancaDoutoradoLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarBancaDoutoradoLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarBancaDoutoradoLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarBancaMestradoLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarBancaMestradoLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarBancaMestradoLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarBancaGraduacaoLinhas method, of class Somatorio.
     */
    @Test
    public void testSomarBancaGraduacaoLinhas() {
        
        LinhaDePesquisa linha = criarLinha();
        Somatorio instance = new Somatorio();
        String result = instance.somarBancaGraduacaoLinhas(linha);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesMestradoConcluidasPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesMestradoConcluidasPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesMestradoConcluidasPrograma(programa);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesDoutoradoConcluidasPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesDoutoradoConcluidasPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesDoutoradoConcluidasPrograma(programa);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesGraduacaoConcluidasPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesGraduacaoConcluidasPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesGraduacaoConcluidasPrograma(programa);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesMestradoAndamentoPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesMestradoAndamentoPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesMestradoAndamentoPrograma(programa);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesDoutoradoAndamentoPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesDoutoradoAndamentoPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesDoutoradoAndamentoPrograma(programa);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarOrientacoesGraduacaoAndamentoPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarOrientacoesGraduacaoAndamentoPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarOrientacoesGraduacaoAndamentoPrograma(programa);
        assertEquals("2,0", result);
        
    }

    /**
     * Test of somarBancaDoutoradoPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarBancaDoutoradoPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarBancaDoutoradoPrograma(programa);
        assertEquals("2,0", result);
    }

    /**
     * Test of somarBancaMestradoPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarBancaMestradoPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarBancaMestradoPrograma(programa);
        assertEquals("2,0", result);
        
    }

    /**
     * Test of somarBancaGraduacaoPrograma method, of class Somatorio.
     */
    @Test
    public void testSomarBancaGraduacaoPrograma() {
        
        Programa programa = criarPrograma();
        Somatorio instance = new Somatorio();
        String result = instance.somarBancaGraduacaoPrograma(programa);
        assertEquals("2,0", result);
        
    }
    
    public LinhaDePesquisa criarLinha() {
        
        LinhaDePesquisa linha = new LinhaDePesquisa();
        
        Professor professor1 = new Professor("","",1,1,1,1,1,1,1,1,1);
        linha.adicionaProfessor(professor1);
        
        Professor professor2 = new Professor("","",2,2,2,2,2,2,2,2,2);
        linha.adicionaProfessor(professor2);
        
        Professor professor3 = new Professor("","",3,3,3,3,3,3,3,3,3);
        linha.adicionaProfessor(professor3);
        
        return linha;
    }
    
    public Programa criarPrograma() {
        
        LinhaDePesquisa linha = new LinhaDePesquisa();
        Programa programa = new Programa();
        
        Professor professor1 = new Professor("","",1,1,1,1,1,1,1,1,1);
        linha.adicionaProfessor(professor1);
        
        Professor professor2 = new Professor("","",2,2,2,2,2,2,2,2,2);
        linha.adicionaProfessor(professor2);
        
        Professor professor3 = new Professor("","",3,3,3,3,3,3,3,3,3);
        linha.adicionaProfessor(professor3);
        
        programa.adicionaLinha(linha);
        
        return programa;
    }
    
}
