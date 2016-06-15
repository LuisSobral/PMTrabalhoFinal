package ClasseDeEscritaDeArquivo;

import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
    Classe para criar a tabela e mostrar os dados necessários de cada professor, linha e programa
*/
public class EscreverArquivo {
    
    /*
        Cria a tabela com suas colunas 
    */
    public void criaArquivo(Programa programa) throws IOException{
                           
        FileWriter arq = new FileWriter("Relatório.txt");
        PrintWriter ArqG = new PrintWriter(arq);
        
        preencherTabela(ArqG,programa);
 
        arq.close();
    }
    
    /*
        Preenche cada uma das colunas da tabela
    */
    public void preencherTabela(PrintWriter ArqG, Programa programa) {
        
        String quebraLinha = System.getProperty("line.separator");
        ArqG.printf("Nome\tRA1\tRA2\tRB1\tRB2\tRB3\tRB4\tRC\tRNC\tEA1\tEA2\tEB1\tEB2\tEB3\tEB4\tEC\tENC"
                + "\tBD\tBM\tBG\tODC\tOMC\tOGC\tODA\tOMA\tOGA"+quebraLinha);
        
                for(LinhaDePesquisa linha : programa.getLinhas()) {
                    for(Professor professor : linha.getProfessores())
                            adicionarProfessor(ArqG, professor);
                    
                    adicionarLinhaDePesquisa(ArqG, linha);
                }
                        
		adicionaPrograma(ArqG, programa);
	}
    
    /*
        adiciona cada linha dos professores com seus atributos necessários
    */
    public void adicionarProfessor(PrintWriter ArqG, Professor professor) {
        
        String quebraLinha = System.getProperty("line.separator");
        ArqG.printf(professor.getNome()+"\t"+(int)professor.somarArtigosA1RevistaProfessor()+"\t"+
                                                   (int)professor.somarArtigosA2RevistaProfessor()+"\t"+(int)professor.somarArtigosB1RevistaProfessor()+"\t"+(int)professor.somarArtigosB2RevistaProfessor()+"\t"+
                                                   (int)professor.somarArtigosB3RevistaProfessor()+"\t"+(int)professor.somarArtigosB4RevistaProfessor()+"\t"+(int)professor.somarArtigosCRevistaProfessor()+"\t"+
                                                   (int)professor.somarArtigosNCRevistaProfessor()+"\t"+(int)professor.somarArtigosA1EventoProfessor()+"\t"+(int)professor.somarArtigosA2EventoProfessor()+"\t"+
                                                   (int)professor.somarArtigosB1EventoProfessor()+"\t"+(int)professor.somarArtigosB2EventoProfessor()+"\t"+(int)professor.somarArtigosB3EventoProfessor()+"\t"+
                                                   (int)professor.somarArtigosB4EventoProfessor()+"\t"+(int)professor.somarArtigosCEventoProfessor()+"\t"+(int)professor.somarArtigosNCEventoProfessor()+"\t"+
                                                   professor.getNumeroBancasDoutorado()+"\t"+professor.getNumeroBancasMestrado()+"\t"+professor.getNumeroBancasGraduacao()+"\t"+
                                                   professor.getNumeroOrientacaoDoutoradoConcluidas()+"\t"+professor.getNumeroOrientacaoMestradoConcluidas()+"\t"+professor.getNumeroOrientacaoGraduacaoConcluidas()+"\t"+
                                                   professor.getNumeroOrientacaoDoutoradoAndamento()+"\t"+professor.getNumeroOrientacaoMestradoAndamento()+"\t"+professor.getNumeroOrientacaoGraduacaoAndamento()+quebraLinha);
    }
    
    /*
        adiciona cada linha de linha de pesquisa com seus atributos necessários
    */
    public void adicionarLinhaDePesquisa (PrintWriter ArqG, LinhaDePesquisa linha) {
        
        String quebraLinha = System.getProperty("line.separator");
        ArqG.printf("Total da linha ".concat(linha.getNome())+"\t"+linha.somarArtigosA1RevistaLinha()+"\t"+
                                                   linha.somarArtigosA2RevistaLinha()+"\t"+linha.somarArtigosB1RevistaLinha()+"\t"+linha.somarArtigosB2RevistaLinha()+"\t"+
                                                   linha.somarArtigosB3RevistaLinha()+"\t"+linha.somarArtigosB4RevistaLinha()+"\t"+linha.somarArtigosCRevistaLinha()+"\t"+
                                                   linha.somarArtigosNCRevistaLinha()+"\t"+linha.somarArtigosA1EventoLinha()+"\t"+linha.somarArtigosA2EventoLinha()+"\t"+
                                                   linha.somarArtigosB1EventoLinha()+"\t"+linha.somarArtigosB2EventoLinha()+"\t"+linha.somarArtigosB3EventoLinha()+"\t"+
                                                   linha.somarArtigosB4EventoLinha()+"\t"+linha.somarArtigosCEventoLinha()+"\t"+linha.somarArtigosNCEventoLinha()+"\t"+
                                                   linha.somarBancaDoutoradoLinhas()+"\t"+linha.somarBancaMestradoLinhas()+"\t"+linha.somarBancaGraduacaoLinhas()+"\t"+
                                                   linha.somarOrientacoesDoutoradoConcluidasLinhas()+"\t"+linha.somarOrientacoesMestradoConcluidasLinhas()+"\t"+linha.somarOrientacoesGraduacaoConcluidasLinhas()+"\t"+
                                                   linha.somarOrientacoesDoutoradoAndamentoLinhas()+"\t"+linha.somarOrientacoesMestradoAndamentoLinhas()+"\t"+linha.somarOrientacoesGraduacaoAndamentoLinhas()+quebraLinha);
        
    }
    
    /*
        adiciona a linha de programa com seus atributos necessários
    */
    public void adicionaPrograma(PrintWriter ArqG, Programa programa) {
        
        ArqG.printf("Total do programa ".concat(programa.getNome())+"\t"+programa.somarArtigosA1RevistaPrograma()+"\t"+
                                                   programa.somarArtigosA2RevistaPrograma()+"\t"+programa.somarArtigosB1RevistaPrograma()+"\t"+programa.somarArtigosB2RevistaPrograma()+"\t"+
                                                   programa.somarArtigosB3RevistaPrograma()+"\t"+programa.somarArtigosB4RevistaPrograma()+"\t"+programa.somarArtigosCRevistaPrograma()+"\t"+
                                                   programa.somarArtigosNCRevistaPrograma()+"\t"+programa.somarArtigosA1EventoPrograma()+"\t"+programa.somarArtigosA2EventoPrograma()+"\t"+
                                                   programa.somarArtigosB1EventoPrograma()+"\t"+programa.somarArtigosB2EventoPrograma()+"\t"+programa.somarArtigosB3EventoPrograma()+"\t"+
                                                   programa.somarArtigosB4EventoPrograma()+"\t"+programa.somarArtigosCEventoPrograma()+"\t"+programa.somarArtigosNCEventoPrograma()+"\t"+
                                                   programa.somarBancaDoutoradoPrograma()+"\t"+programa.somarBancaMestradoPrograma()+"\t"+programa.somarBancaGraduacaoPrograma()+"\t"+
                                                   programa.somarOrientacoesDoutoradoConcluidasPrograma()+"\t"+programa.somarOrientacoesMestradoConcluidasPrograma()+"\t"+programa.somarOrientacoesGraduacaoConcluidasPrograma()+"\t"+
                                                   programa.somarOrientacoesDoutoradoAndamentoPrograma()+"\t"+programa.somarOrientacoesMestradoAndamentoPrograma()+"\t"+programa.somarOrientacoesGraduacaoAndamentoPrograma());
    }
    
}
