package ClasseDeRotinas;

import ClassesObjetos.Artigo;
import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;

import java.text.DecimalFormat;

/*
    Classe de apoio para as funções de soma de artigos, orientações e bancas
*/
public class Somatorio {
    
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
        Soma de aritgos A1 evento de cada professor
    */
    public double somarArtigosA1EventoProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosEventos())
            if(artigo.getClasse().equals("A1"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos A2 evento de cada professor
    */
    public double somarArtigosA2EventoProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosEventos())
            if(artigo.getClasse().equals("A2"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B1 evento de cada professor
    */
    public double somarArtigosB1EventoProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosEventos())
            if(artigo.getClasse().equals("B1"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B2 evento de cada professor
    */
    public double somarArtigosB2EventoProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosEventos())
            if(artigo.getClasse().equals("B2"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B3 evento de cada professor
    */
    public double somarArtigosB3EventoProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosEventos())
            if(artigo.getClasse().equals("B3"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B4 evento de cada professor
    */
    public double somarArtigosB4EventoProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosEventos())
            if(artigo.getClasse().equals("B4"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos C de eventos de cada professor
    */
    public double somarArtigosCEventoProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosEventos())
            if(artigo.getClasse().equals("C"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos NC evento de cada professor
    */
    public double somarArtigosNCEventoProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosEventos())
            if(artigo.getClasse().equals("NC"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos A1 de revistas de cada professor
    */
    public double somarArtigosA1RevistaProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosRevista())
            if(artigo.getClasse().equals("A1"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos A2 de revistas de cada professor
    */
    public double somarArtigosA2RevistaProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosRevista())
            if(artigo.getClasse().equals("A2"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B1 de revistas de cada professor
    */
    public double somarArtigosB1RevistaProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosRevista())
            if(artigo.getClasse().equals("B1"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B2 de revistas de cada professor
    */
    public double somarArtigosB2RevistaProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosRevista())
            if(artigo.getClasse().equals("B2"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B3 de revistas de cada professor
    */
    public double somarArtigosB3RevistaProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosRevista())
            if(artigo.getClasse().equals("B3"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B4 de revistas de cada professor
    */
    public double somarArtigosB4RevistaProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosRevista())
            if(artigo.getClasse().equals("B4"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos C de revistas de cada professor
    */
    public double somarArtigosCRevistaProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosRevista())
            if(artigo.getClasse().equals("C"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos NC de revistas de cada professor
    */
    public double somarArtigosNCRevistaProfessor(Professor professor) {
        
        double soma = 0;
        
        for(Artigo artigo : professor.getArtigosRevista())
            if(artigo.getClasse().equals("NC"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos A1 de revistas de cada linha
    */
    public String somarArtigosA1RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosA1RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos A2 de revistas de cada linha
    */
    public String somarArtigosA2RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosA2RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B1 de revistas de cada linha
    */
    public String somarArtigosB1RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosB1RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B2 de revistas de cada linha
    */
    public String somarArtigosB2RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosB2RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B3 de revistas de cada linha
    */
    public String somarArtigosB3RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosB3RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B4 de revistas de cada linha
    */
    public String somarArtigosB4RevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosB4RevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos C de revistas de cada linha
    */
    public String somarArtigosCRevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosCRevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos NC de revistas de cada linha
    */
    public String somarArtigosNCRevistaLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosNCRevistaProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos A1 de evento de cada linha
    */
    public String somarArtigosA1EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosA1EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos A2 de evento de cada linha
    */
    public String somarArtigosA2EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosA2EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos b1 de evento de cada linha
    */
    public String somarArtigosB1EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosB1EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public String somarArtigosB2EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosB2EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B3 de evento de cada linha
    */
    public String somarArtigosB3EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosB3EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B4 de evento de cada linha
    */
    public String somarArtigosB4EventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosB4EventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public String somarArtigosCEventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosCEventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public String somarArtigosNCEventoLinha(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + somarArtigosNCEventoProfessor(professor);
        
        return df2.format(soma/linha.pegaProfessores().size());
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
                soma = soma + somarArtigosA1RevistaProfessor(professor);
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
                soma = soma + somarArtigosA2RevistaProfessor(professor);
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
                soma = soma + somarArtigosB1RevistaProfessor(professor);
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
                soma = soma + somarArtigosB2RevistaProfessor(professor);
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
                soma = soma + somarArtigosB3RevistaProfessor(professor);
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
                soma = soma + somarArtigosB4RevistaProfessor(professor);
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
                soma = soma + somarArtigosCRevistaProfessor(professor);
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
                soma = soma + somarArtigosNCRevistaProfessor(professor);
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
                soma = soma + somarArtigosA1EventoProfessor(professor);
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
                soma = soma + somarArtigosA2EventoProfessor(professor);
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
                soma = soma + somarArtigosB1EventoProfessor(professor);
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
                soma = soma + somarArtigosB2EventoProfessor(professor);
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
                soma = soma + somarArtigosB3EventoProfessor(professor);
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
                soma = soma + somarArtigosB4EventoProfessor(professor);
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
                soma = soma + somarArtigosCEventoProfessor(professor);
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
                soma = soma + somarArtigosNCEventoProfessor(professor);
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores++);
    }
}
