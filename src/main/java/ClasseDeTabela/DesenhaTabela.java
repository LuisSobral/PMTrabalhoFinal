package ClasseDeTabela;

import ClasseDeRotinas.Somatorio;
import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DesenhaTabela extends JFrame {
    
    public void criaJanela(Programa programa){
        
        JPanel painelFundo;
        JTable tabela;
        JScrollPane barraRolagem;
        DefaultTableModel modelo = new DefaultTableModel();
    
        modelo.addColumn("Nome");
        modelo.addColumn("RA1");
        modelo.addColumn("RA2");
        modelo.addColumn("RB1");
        modelo.addColumn("RB2");
        modelo.addColumn("RB3");
        modelo.addColumn("RB4");
        modelo.addColumn("RC");
        modelo.addColumn("RN/C");
        modelo.addColumn("EA1");
        modelo.addColumn("EA2");
        modelo.addColumn("EB1");
        modelo.addColumn("EB2");
        modelo.addColumn("EB3");
        modelo.addColumn("EB4");
        modelo.addColumn("EC");
        modelo.addColumn("EN/C");
        modelo.addColumn("BD");
        modelo.addColumn("BM");
        modelo.addColumn("BG");
        modelo.addColumn("ODC");
        modelo.addColumn("OMC");
        modelo.addColumn("OGC");
        modelo.addColumn("ODA");
        modelo.addColumn("OMA");
        modelo.addColumn("OGA");
        
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        tabela = new JTable(modelo);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(BorderLayout.CENTER,barraRolagem); 
        
        getContentPane().add(painelFundo);
        setSize(1000,300);
        setVisible(true);
        
        preencherTabela(modelo,programa);
    }
    
    public void preencherTabela(DefaultTableModel modelo, Programa programa) {
		modelo.setNumRows(0);
                
                for(LinhaDePesquisa linha : programa.getLinhas()) {
                    for(Professor professor : linha.getProfessores())
                        adicionarProfessor(modelo, professor);
                    
                    adicionarLinhaDePesquisa(modelo, linha);
                }
                        
		adicionaPrograma(modelo, programa);
	}
    
    public void adicionarProfessor(DefaultTableModel modelo, Professor professor) {
       
        modelo.addRow(new Object[]{professor.getNome(),0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   professor.getNumeroBancasDoutorado(),professor.getNumeroBancasMestrado(),professor.getNumeroBancasGraduacao(),
                                                   professor.getNumeroOrientacaoDoutoradoConcluidas(),professor.getNumeroOrientacaoMestradoConcluidas(),professor.getNumeroOrientacaoGraduacaoConcluidas(),
                                                   professor.getNumeroOrientacaoDoutoradoAndamento(),professor.getNumeroOrientacaoMestradoAndamento(),professor.getNumeroOrientacaoGraduacaoAndamento()});
    }
    
    public void adicionarLinhaDePesquisa (DefaultTableModel modelo, LinhaDePesquisa linha) {
        
        Somatorio soma = new Somatorio();
        
        modelo.addRow(new Object[] {"Total da linha ".concat(linha.getNome()),0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   soma.somarBancaDoutoradoLinhas(linha),soma.somarBancaMestradoLinhas(linha),soma.somarBancaGraduacaoLinhas(linha),
                                                   soma.somarOrientacoesDoutoradoConcluidasLinhas(linha),soma.somarOrientacoesMestradoConcluidasLinhas(linha),soma.somarOrientacoesGraduacaoConcluidasLinhas(linha),
                                                   soma.somarOrientacoesDoutoradoAndamentoLinhas(linha),soma.somarOrientacoesMestradoAndamentoLinhas(linha),soma.somarOrientacoesGraduacaoAndamentoLinhas(linha)});
        
    }
    
    public void adicionaPrograma(DefaultTableModel modelo, Programa programa) {
        
        Somatorio soma = new Somatorio();
        
        modelo.addRow(new Object[] {"Total do programa ".concat(programa.getNome()),0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   0,0,0,
                                                   soma.somarBancaDoutoradoPrograma(programa),soma.somarBancaMestradoPrograma(programa),soma.somarBancaGraduacaoPrograma(programa),
                                                   soma.somarOrientacoesDoutoradoConcluidasPrograma(programa),soma.somarOrientacoesMestradoConcluidasPrograma(programa),soma.somarOrientacoesGraduacaoConcluidasPrograma(programa),
                                                   soma.somarOrientacoesDoutoradoAndamentoPrograma(programa),soma.somarOrientacoesMestradoAndamentoPrograma(programa),soma.somarOrientacoesGraduacaoAndamentoPrograma(programa)});
    }
    
}
