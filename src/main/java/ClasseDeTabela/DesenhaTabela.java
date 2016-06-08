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

/*
    Classe para criar a tabela e mostrar os dados necessários de cada professor, linha e programa
*/
public class DesenhaTabela extends JFrame {
    
    /*
        Cria a tabela com suas colunas 
    */
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
    
    /*
        Preenche cada uma das colunas da tabela
    */
    public void preencherTabela(DefaultTableModel modelo, Programa programa) {
		modelo.setNumRows(0);
                
                for(LinhaDePesquisa linha : programa.getLinhas()) {
                    for(Professor professor : linha.getProfessores())
                        adicionarProfessor(modelo, professor);
                    
                    adicionarLinhaDePesquisa(modelo, linha);
                }
                        
		adicionaPrograma(modelo, programa);
	}
    
    /*
        adiciona cada linha dos professores com seus atributos necessários
    */
    public void adicionarProfessor(DefaultTableModel modelo, Professor professor) {
       
        Somatorio soma = new Somatorio();
        
        modelo.addRow(new Object[]{professor.getNome(),(int)soma.somarArtigosA1RevistaProfessor(professor),
                                                   (int)soma.somarArtigosA2RevistaProfessor(professor),(int)soma.somarArtigosB1RevistaProfessor(professor),(int)soma.somarArtigosB2RevistaProfessor(professor),
                                                   (int)soma.somarArtigosB3RevistaProfessor(professor),(int)soma.somarArtigosB4RevistaProfessor(professor),(int)soma.somarArtigosCRevistaProfessor(professor),
                                                   (int)soma.somarArtigosNCRevistaProfessor(professor),(int)soma.somarArtigosA1EventoProfessor(professor),(int)soma.somarArtigosA2EventoProfessor(professor),
                                                   (int)soma.somarArtigosB1EventoProfessor(professor),(int)soma.somarArtigosB2EventoProfessor(professor),(int)soma.somarArtigosB3EventoProfessor(professor),
                                                   (int)soma.somarArtigosB4EventoProfessor(professor),(int)soma.somarArtigosCEventoProfessor(professor),(int)soma.somarArtigosNCEventoProfessor(professor),
                                                   professor.getNumeroBancasDoutorado(),professor.getNumeroBancasMestrado(),professor.getNumeroBancasGraduacao(),
                                                   professor.getNumeroOrientacaoDoutoradoConcluidas(),professor.getNumeroOrientacaoMestradoConcluidas(),professor.getNumeroOrientacaoGraduacaoConcluidas(),
                                                   professor.getNumeroOrientacaoDoutoradoAndamento(),professor.getNumeroOrientacaoMestradoAndamento(),professor.getNumeroOrientacaoGraduacaoAndamento()});
    }
    
    /*
        adiciona cada linha de linha de pesquisa com seus atributos necessários
    */
    public void adicionarLinhaDePesquisa (DefaultTableModel modelo, LinhaDePesquisa linha) {
        
        Somatorio soma = new Somatorio();
        
        modelo.addRow(new Object[] {"Total da linha ".concat(linha.getNome()),soma.somarArtigosA1RevistaLinha(linha),
                                                   soma.somarArtigosA2RevistaLinha(linha),soma.somarArtigosB1RevistaLinha(linha),soma.somarArtigosB2RevistaLinha(linha),
                                                   soma.somarArtigosB3RevistaLinha(linha),soma.somarArtigosB4RevistaLinha(linha),soma.somarArtigosCRevistaLinha(linha),
                                                   soma.somarArtigosNCRevistaLinha(linha),soma.somarArtigosA1EventoLinha(linha),soma.somarArtigosA2EventoLinha(linha),
                                                   soma.somarArtigosB1EventoLinha(linha),soma.somarArtigosB2EventoLinha(linha),soma.somarArtigosB3EventoLinha(linha),
                                                   soma.somarArtigosB4EventoLinha(linha),soma.somarArtigosCEventoLinha(linha),soma.somarArtigosNCEventoLinha(linha),
                                                   soma.somarBancaDoutoradoLinhas(linha),soma.somarBancaMestradoLinhas(linha),soma.somarBancaGraduacaoLinhas(linha),
                                                   soma.somarOrientacoesDoutoradoConcluidasLinhas(linha),soma.somarOrientacoesMestradoConcluidasLinhas(linha),soma.somarOrientacoesGraduacaoConcluidasLinhas(linha),
                                                   soma.somarOrientacoesDoutoradoAndamentoLinhas(linha),soma.somarOrientacoesMestradoAndamentoLinhas(linha),soma.somarOrientacoesGraduacaoAndamentoLinhas(linha)});
        
    }
    
    /*
        adiciona a linha de programa com seus atributos necessários
    */
    public void adicionaPrograma(DefaultTableModel modelo, Programa programa) {
        
        Somatorio soma = new Somatorio();
        
        modelo.addRow(new Object[] {"Total do programa ".concat(programa.getNome()),soma.somarArtigosA1RevistaPrograma(programa),
                                                   soma.somarArtigosA2RevistaPrograma(programa),soma.somarArtigosB1RevistaPrograma(programa),soma.somarArtigosB2RevistaPrograma(programa),
                                                   soma.somarArtigosB3RevistaPrograma(programa),soma.somarArtigosB4RevistaPrograma(programa),soma.somarArtigosCRevistaPrograma(programa),
                                                   soma.somarArtigosNCRevistaPrograma(programa),soma.somarArtigosA1EventoPrograma(programa),soma.somarArtigosA2EventoPrograma(programa),
                                                   soma.somarArtigosB1EventoPrograma(programa),soma.somarArtigosB2EventoPrograma(programa),soma.somarArtigosB3EventoPrograma(programa),
                                                   soma.somarArtigosB4EventoPrograma(programa),soma.somarArtigosCEventoPrograma(programa),soma.somarArtigosNCEventoPrograma(programa),
                                                   soma.somarBancaDoutoradoPrograma(programa),soma.somarBancaMestradoPrograma(programa),soma.somarBancaGraduacaoPrograma(programa),
                                                   soma.somarOrientacoesDoutoradoConcluidasPrograma(programa),soma.somarOrientacoesMestradoConcluidasPrograma(programa),soma.somarOrientacoesGraduacaoConcluidasPrograma(programa),
                                                   soma.somarOrientacoesDoutoradoAndamentoPrograma(programa),soma.somarOrientacoesMestradoAndamentoPrograma(programa),soma.somarOrientacoesGraduacaoAndamentoPrograma(programa)});
    }
    
}
