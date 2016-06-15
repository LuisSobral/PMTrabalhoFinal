package ClasseDeTabela;

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
        
        modelo.addRow(new Object[]{professor.getNome(),(int)professor.somarArtigosA1RevistaProfessor(professor),
                                                   (int)professor.somarArtigosA2RevistaProfessor(professor),(int)professor.somarArtigosB1RevistaProfessor(professor),(int)professor.somarArtigosB2RevistaProfessor(professor),
                                                   (int)professor.somarArtigosB3RevistaProfessor(professor),(int)professor.somarArtigosB4RevistaProfessor(professor),(int)professor.somarArtigosCRevistaProfessor(professor),
                                                   (int)professor.somarArtigosNCRevistaProfessor(professor),(int)professor.somarArtigosA1EventoProfessor(professor),(int)professor.somarArtigosA2EventoProfessor(professor),
                                                   (int)professor.somarArtigosB1EventoProfessor(professor),(int)professor.somarArtigosB2EventoProfessor(professor),(int)professor.somarArtigosB3EventoProfessor(professor),
                                                   (int)professor.somarArtigosB4EventoProfessor(professor),(int)professor.somarArtigosCEventoProfessor(professor),(int)professor.somarArtigosNCEventoProfessor(professor),
                                                   professor.getNumeroBancasDoutorado(),professor.getNumeroBancasMestrado(),professor.getNumeroBancasGraduacao(),
                                                   professor.getNumeroOrientacaoDoutoradoConcluidas(),professor.getNumeroOrientacaoMestradoConcluidas(),professor.getNumeroOrientacaoGraduacaoConcluidas(),
                                                   professor.getNumeroOrientacaoDoutoradoAndamento(),professor.getNumeroOrientacaoMestradoAndamento(),professor.getNumeroOrientacaoGraduacaoAndamento()});
    }
    
    /*
        adiciona cada linha de linha de pesquisa com seus atributos necessários
    */
    public void adicionarLinhaDePesquisa (DefaultTableModel modelo, LinhaDePesquisa linha) {
        
        modelo.addRow(new Object[] {"Total da linha ".concat(linha.getNome()),linha.somarArtigosA1RevistaLinha(linha),
                                                   linha.somarArtigosA2RevistaLinha(linha),linha.somarArtigosB1RevistaLinha(linha),linha.somarArtigosB2RevistaLinha(linha),
                                                   linha.somarArtigosB3RevistaLinha(linha),linha.somarArtigosB4RevistaLinha(linha),linha.somarArtigosCRevistaLinha(linha),
                                                   linha.somarArtigosNCRevistaLinha(linha),linha.somarArtigosA1EventoLinha(linha),linha.somarArtigosA2EventoLinha(linha),
                                                   linha.somarArtigosB1EventoLinha(linha),linha.somarArtigosB2EventoLinha(linha),linha.somarArtigosB3EventoLinha(linha),
                                                   linha.somarArtigosB4EventoLinha(linha),linha.somarArtigosCEventoLinha(linha),linha.somarArtigosNCEventoLinha(linha),
                                                   linha.somarBancaDoutoradoLinhas(linha),linha.somarBancaMestradoLinhas(linha),linha.somarBancaGraduacaoLinhas(linha),
                                                   linha.somarOrientacoesDoutoradoConcluidasLinhas(linha),linha.somarOrientacoesMestradoConcluidasLinhas(linha),linha.somarOrientacoesGraduacaoConcluidasLinhas(linha),
                                                   linha.somarOrientacoesDoutoradoAndamentoLinhas(linha),linha.somarOrientacoesMestradoAndamentoLinhas(linha),linha.somarOrientacoesGraduacaoAndamentoLinhas(linha)});
        
    }
    
    /*
        adiciona a linha de programa com seus atributos necessários
    */
    public void adicionaPrograma(DefaultTableModel modelo, Programa programa) {
        
        modelo.addRow(new Object[] {"Total do programa ".concat(programa.getNome()),programa.somarArtigosA1RevistaPrograma(programa),
                                                   programa.somarArtigosA2RevistaPrograma(programa),programa.somarArtigosB1RevistaPrograma(programa),programa.somarArtigosB2RevistaPrograma(programa),
                                                   programa.somarArtigosB3RevistaPrograma(programa),programa.somarArtigosB4RevistaPrograma(programa),programa.somarArtigosCRevistaPrograma(programa),
                                                   programa.somarArtigosNCRevistaPrograma(programa),programa.somarArtigosA1EventoPrograma(programa),programa.somarArtigosA2EventoPrograma(programa),
                                                   programa.somarArtigosB1EventoPrograma(programa),programa.somarArtigosB2EventoPrograma(programa),programa.somarArtigosB3EventoPrograma(programa),
                                                   programa.somarArtigosB4EventoPrograma(programa),programa.somarArtigosCEventoPrograma(programa),programa.somarArtigosNCEventoPrograma(programa),
                                                   programa.somarBancaDoutoradoPrograma(programa),programa.somarBancaMestradoPrograma(programa),programa.somarBancaGraduacaoPrograma(programa),
                                                   programa.somarOrientacoesDoutoradoConcluidasPrograma(programa),programa.somarOrientacoesMestradoConcluidasPrograma(programa),programa.somarOrientacoesGraduacaoConcluidasPrograma(programa),
                                                   programa.somarOrientacoesDoutoradoAndamentoPrograma(programa),programa.somarOrientacoesMestradoAndamentoPrograma(programa),programa.somarOrientacoesGraduacaoAndamentoPrograma(programa)});
    }
    
}
