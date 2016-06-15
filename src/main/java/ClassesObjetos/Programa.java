package ClassesObjetos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe com dados dos programas de pós-graduação
 */
public class Programa {
    
    //Nome do programa de pós-graduação
    private String nome;
    private List<LinhaDePesquisa> linhas;

    public Programa(String nome) {
        this.nome = nome;
        this.linhas = new ArrayList<LinhaDePesquisa>();
    }
    
    public Programa() {
        this("");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void adicionaLinha(LinhaDePesquisa linha) {
        linhas.add(linha);
    }
    
    public Iterable<LinhaDePesquisa> getLinhas() {
        return linhas;
    }
    
    public LinhaDePesquisa pegaLinhaDePesquisaIndice(int indice) {
        return linhas.get(indice);
    }
    
    /*
        Soma as orientações de mestrado concluidas para cada programa
    */
    public String somarOrientacoesMestradoConcluidasPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoMestradoConcluidas();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma as orientações de doutorado concluidas para cada linha
    */
    public String somarOrientacoesDoutoradoConcluidasPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoDoutoradoConcluidas();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma as orientações de graduacao concluidas para cada programa
    */
    public String somarOrientacoesGraduacaoConcluidasPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoGraduacaoConcluidas();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma as orientações de mestrado em andamento para cada programa
    */
    public String somarOrientacoesMestradoAndamentoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoMestradoAndamento();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma as orientações de doutorado em andamento para cada programa
    */
    public String somarOrientacoesDoutoradoAndamentoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoDoutoradoAndamento();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma as orientações de graduacao em andamento para cada programa
    */
    public String somarOrientacoesGraduacaoAndamentoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoGraduacaoAndamento();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma as bancas de doutorado em andamento para cada programa
    */
    public String somarBancaDoutoradoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroBancasDoutorado();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma as bancas de mestrado para cada programa
    */
    public String somarBancaMestradoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroBancasMestrado();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma as bancas de graduacao para cada programa
    */
    public String somarBancaGraduacaoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroBancasGraduacao();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    /*
        Soma de aritgos A1 de revistas do programa
    */
    public String somarArtigosA1RevistaPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosA1RevistaProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos A2 de revistas do programa
    */
    public String somarArtigosA2RevistaPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosA2RevistaProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos B1 de revistas do programa
    */
    public String somarArtigosB1RevistaPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosB1RevistaProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos B2 de revistas do programa
    */
    public String somarArtigosB2RevistaPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosB2RevistaProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos B3 de revistas do programa
    */
    public String somarArtigosB3RevistaPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosB3RevistaProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }/*
        Soma de aritgos B4 de revistas do programa
    */
    public String somarArtigosB4RevistaPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosB4RevistaProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos C de revistas do programa
    */
    public String somarArtigosCRevistaPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosCRevistaProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos NC de revistas do programa
    */
    public String somarArtigosNCRevistaPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosNCRevistaProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos A1 de eventos do programa
    */
    public String somarArtigosA1EventoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosA1EventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos A2 de eventos do programa
    */
    public String somarArtigosA2EventoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosA2EventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos B1 de eventos do programa
    */
    public String somarArtigosB1EventoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosB1EventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos B2 de eventos do programa
    */
    public String somarArtigosB2EventoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosB2EventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos B3 de eventos do programa
    */
    public String somarArtigosB3EventoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosB3EventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos B4 de eventos do programa
    */
    public String somarArtigosB4EventoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosB4EventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos C de eventos do programa
    */
    public String somarArtigosCEventoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosCEventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
    
    /*
        Soma de aritgos NC de eventos do programa
    */
    public String somarArtigosNCEventoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.somarArtigosNCEventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
}
