package ClasseDeEscritaDeArquivo;

import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
    Classe para criar o relatório de resultado, mostrando os dados necessários de cada professor, linha e programa
*/
public class EscreverArquivo {
    
    /*
        Método que cria o relatório
    */
    public void criaArquivo(Programa programa, int anoInicio, int anoFim) throws IOException{
                           
        FileWriter arq = new FileWriter(programa.getNome()+" "+anoInicio+" - "+anoFim+".txt");
        PrintWriter ArqG = new PrintWriter(arq);
        
        preencherTabela(ArqG,programa);
 
        arq.close();
    }
    
    /*
        Método que preenche cada uma das colunas da tabela
    */
    public void preencherTabela(PrintWriter ArqG, Programa programa) {
        
                for(LinhaDePesquisa linha : programa.getLinhas()) {
                    for(Professor professor : linha.getProfessores())
                            adicionarProfessor(ArqG, professor);
                    
                    adicionarLinhaDePesquisa(ArqG, linha);
                }
                        
		adicionaPrograma(ArqG, programa);
	}
    
    /*
        Método que adiciona cada linha dos professores com seus atributos necessários
    */
    public void adicionarProfessor(PrintWriter ArqG, Professor professor) {
        
        String quebraLinha = System.getProperty("line.separator");
        ArqG.printf("Nome professor: "+professor.getNome()+"\tRA1: "+(int)professor.somarArtigosA1RevistaProfessor()+"\tRA2: "+
                                                   (int)professor.somarArtigosA2RevistaProfessor()+"\tRB1: "+(int)professor.somarArtigosB1RevistaProfessor()+"\tRB2: "+(int)professor.somarArtigosB2RevistaProfessor()+"\tRB3: "+
                                                   (int)professor.somarArtigosB3RevistaProfessor()+"\tRB4: "+(int)professor.somarArtigosB4RevistaProfessor()+"\tRC: "+(int)professor.somarArtigosCRevistaProfessor()+"\tRNC: "+
                                                   (int)professor.somarArtigosNCRevistaProfessor()+"\tEA1: "+(int)professor.somarArtigosA1EventoProfessor()+"\tEA2: "+(int)professor.somarArtigosA2EventoProfessor()+"\tEB1: "+
                                                   (int)professor.somarArtigosB1EventoProfessor()+"\tEB2: "+(int)professor.somarArtigosB2EventoProfessor()+"\tEB3: "+(int)professor.somarArtigosB3EventoProfessor()+"\tEB4: "+
                                                   (int)professor.somarArtigosB4EventoProfessor()+"\tEC: "+(int)professor.somarArtigosCEventoProfessor()+"\tENC: "+(int)professor.somarArtigosNCEventoProfessor()+"\tBD: "+
                                                   professor.getNumeroBancasDoutorado()+"\tBM: "+professor.getNumeroBancasMestrado()+"\tBG: "+professor.getNumeroBancasGraduacao()+"\tODC: "+
                                                   professor.getNumeroOrientacaoDoutoradoConcluidas()+"\tOMC: "+professor.getNumeroOrientacaoMestradoConcluidas()+"\tOGC: "+professor.getNumeroOrientacaoGraduacaoConcluidas()+"\tODA: "+
                                                   professor.getNumeroOrientacaoDoutoradoAndamento()+"\tOMA: "+professor.getNumeroOrientacaoMestradoAndamento()+"\tOGA: "+professor.getNumeroOrientacaoGraduacaoAndamento()+quebraLinha);
    }
    
    /*
        Método que adiciona cada linha de linha de pesquisa com seus atributos necessários
    */
    public void adicionarLinhaDePesquisa (PrintWriter ArqG, LinhaDePesquisa linha) {
        
        String quebraLinha = System.getProperty("line.separator");
        ArqG.printf("Total da linha ".concat(linha.getNome())+"\tRA1: "+linha.somarArtigosA1RevistaLinha()+"\tRA2: "+
                                                   linha.somarArtigosA2RevistaLinha()+"\tRB1: "+linha.somarArtigosB1RevistaLinha()+"\tRB2: "+linha.somarArtigosB2RevistaLinha()+"\tRB3: "+
                                                   linha.somarArtigosB3RevistaLinha()+"\tRB4: "+linha.somarArtigosB4RevistaLinha()+"\tRC: "+linha.somarArtigosCRevistaLinha()+"\tRNC: "+
                                                   linha.somarArtigosNCRevistaLinha()+"\tEA1: "+linha.somarArtigosA1EventoLinha()+"\tEA2: "+linha.somarArtigosA2EventoLinha()+"\tEB1: "+
                                                   linha.somarArtigosB1EventoLinha()+"\tEB2: "+linha.somarArtigosB2EventoLinha()+"\tEB3: "+linha.somarArtigosB3EventoLinha()+"\tEB4: "+
                                                   linha.somarArtigosB4EventoLinha()+"\tEC: "+linha.somarArtigosCEventoLinha()+"\tENC: "+linha.somarArtigosNCEventoLinha()+"\tBD: "+
                                                   linha.somarBancaDoutoradoLinhas()+"\tBM: "+linha.somarBancaMestradoLinhas()+"\tBG: "+linha.somarBancaGraduacaoLinhas()+"\tODC: "+
                                                   linha.somarOrientacoesDoutoradoConcluidasLinhas()+"\tOMC: "+linha.somarOrientacoesMestradoConcluidasLinhas()+"\tOGC: "+linha.somarOrientacoesGraduacaoConcluidasLinhas()+"\tODA: "+
                                                   linha.somarOrientacoesDoutoradoAndamentoLinhas()+"\tOMA: "+linha.somarOrientacoesMestradoAndamentoLinhas()+"\tOGA: "+linha.somarOrientacoesGraduacaoAndamentoLinhas()+quebraLinha);
        
    }
    
    /*
        Método que adiciona a linha de programa com seus atributos necessários
    */
    public void adicionaPrograma(PrintWriter ArqG, Programa programa) {
        
        ArqG.printf("Total do programa ".concat(programa.getNome())+"\tRA1: "+programa.somarArtigosA1RevistaPrograma()+"\t"+
                                                   programa.somarArtigosA2RevistaPrograma()+"\tRB1: "+programa.somarArtigosB1RevistaPrograma()+"\tRB2: "+programa.somarArtigosB2RevistaPrograma()+"\tRB3: "+
                                                   programa.somarArtigosB3RevistaPrograma()+"\tRB4: "+programa.somarArtigosB4RevistaPrograma()+"\tRC: "+programa.somarArtigosCRevistaPrograma()+"\tRNC: "+
                                                   programa.somarArtigosNCRevistaPrograma()+"\tEA1: "+programa.somarArtigosA1EventoPrograma()+"\tEA2: "+programa.somarArtigosA2EventoPrograma()+"\tEB1: "+
                                                   programa.somarArtigosB1EventoPrograma()+"\tEB2: "+programa.somarArtigosB2EventoPrograma()+"\tEB3: "+programa.somarArtigosB3EventoPrograma()+"\tEB4: "+
                                                   programa.somarArtigosB4EventoPrograma()+"\tEC: "+programa.somarArtigosCEventoPrograma()+"\tENC: "+programa.somarArtigosNCEventoPrograma()+"\tBD: "+
                                                   programa.somarBancaDoutoradoPrograma()+"\tBM: "+programa.somarBancaMestradoPrograma()+"\tBG: "+programa.somarBancaGraduacaoPrograma()+"\tODC: "+
                                                   programa.somarOrientacoesDoutoradoConcluidasPrograma()+"\tOMC: "+programa.somarOrientacoesMestradoConcluidasPrograma()+"\tOGC: "+programa.somarOrientacoesGraduacaoConcluidasPrograma()+"\tODA: "+
                                                   programa.somarOrientacoesDoutoradoAndamentoPrograma()+"\tOMA: "+programa.somarOrientacoesMestradoAndamentoPrograma()+"\tOGA: "+programa.somarOrientacoesGraduacaoAndamentoPrograma());
    }
    
}
