package ClassesObjetos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe com os dados da linha de pesquisa
 */
public class LinhaDePesquisa {
    
    private String nome;
    private List<Professor> professores;

    public LinhaDePesquisa(String nome) {
        this.nome = nome;
        this.professores = new ArrayList<Professor>();
    }
    
    public LinhaDePesquisa() {
        this("");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void adicionaProfessor(Professor professor) {
        professores.add(professor);
    }
    
    public Iterable<Professor> getProfessores() {
        return professores;
    }
    
    public Professor pegaProfessorIndice(int indice) {
        return professores.get(indice);
    }
    
    public List<Professor> pegaProfessores() {
        return professores;
    }
    
    /*
        Soma as orientações de mestrado concluidas para cada linha
    */
    public String somarOrientacoesMestradoConcluidasLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoMestradoConcluidas();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma as orientações de doutorado concluidas para cada linha
    */
    public String somarOrientacoesDoutoradoConcluidasLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoDoutoradoConcluidas();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma as orientações de graduacao concluidas para cada linha
    */
    public String somarOrientacoesGraduacaoConcluidasLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoGraduacaoConcluidas();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma as orientações de mestrado em andamento para cada linha
    */
    public String somarOrientacoesMestradoAndamentoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoMestradoAndamento();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma as orientações de doutorado em andamento para cada linha
    */
    public String somarOrientacoesDoutoradoAndamentoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoDoutoradoAndamento();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma as orientações de graduacao em andamento para cada linha
    */
    public String somarOrientacoesGraduacaoAndamentoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoGraduacaoAndamento();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma as bancas de doutorado para cada linha
    */
    public String somarBancaDoutoradoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroBancasDoutorado();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma as bancas de mestrado para cada linha
    */
    public String somarBancaMestradoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroBancasMestrado();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma as bancas de graduacao para cada linha
    */
    public String somarBancaGraduacaoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroBancasGraduacao();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos A1 de revistas de cada linha
    */
    public String somarArtigosA1RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosA1RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos A2 de revistas de cada linha
    */
    public String somarArtigosA2RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosA2RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B1 de revistas de cada linha
    */
    public String somarArtigosB1RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosB1RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B2 de revistas de cada linha
    */
    public String somarArtigosB2RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosB2RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B3 de revistas de cada linha
    */
    public String somarArtigosB3RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosB3RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B4 de revistas de cada linha
    */
    public String somarArtigosB4RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosB4RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos C de revistas de cada linha
    */
    public String somarArtigosCRevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosCRevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos NC de revistas de cada linha
    */
    public String somarArtigosNCRevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosNCRevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos A1 de evento de cada linha
    */
    public String somarArtigosA1EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosA1EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos A2 de evento de cada linha
    */
    public String somarArtigosA2EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosA2EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos b1 de evento de cada linha
    */
    public String somarArtigosB1EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosB1EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public String somarArtigosB2EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosB2EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B3 de evento de cada linha
    */
    public String somarArtigosB3EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosB3EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B4 de evento de cada linha
    */
    public String somarArtigosB4EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosB4EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public String somarArtigosCEventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosCEventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public String somarArtigosNCEventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.somarArtigosNCEventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
}