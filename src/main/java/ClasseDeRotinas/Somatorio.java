package ClasseDeRotinas;

import ClassesObjetos.LinhaDePesquisa;
import ClassesObjetos.Professor;
import ClassesObjetos.Programa;


import java.text.DecimalFormat;

public class Somatorio {
    
    public String somarOrientacoesMestradoConcluidasLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoMestradoConcluidas();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    public String somarOrientacoesDoutoradoConcluidasLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoDoutoradoConcluidas();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    public String somarOrientacoesGraduacaoConcluidasLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoGraduacaoConcluidas();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    public String somarOrientacoesMestradoAndamentoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoMestradoAndamento();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    public String somarOrientacoesDoutoradoAndamentoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoDoutoradoAndamento();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    public String somarOrientacoesGraduacaoAndamentoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroOrientacaoGraduacaoAndamento();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    public String somarBancaDoutoradoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroBancasDoutorado();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    public String somarBancaMestradoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroBancasMestrado();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    public String somarBancaGraduacaoLinhas(LinhaDePesquisa linha) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        
        for(Professor professor : linha.getProfessores())
            soma = soma + professor.getNumeroBancasGraduacao();
        
        return df2.format(soma/linha.pegaProfessores().size());
    }
    
    
    public String somarOrientacoesMestradoConcluidasPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoMestradoConcluidas();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    public String somarOrientacoesDoutoradoConcluidasPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoDoutoradoConcluidas();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    public String somarOrientacoesGraduacaoConcluidasPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoGraduacaoConcluidas();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    public String somarOrientacoesMestradoAndamentoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoMestradoAndamento();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    public String somarOrientacoesDoutoradoAndamentoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoDoutoradoAndamento();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    public String somarOrientacoesGraduacaoAndamentoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroOrientacaoGraduacaoAndamento();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    public String somarBancaDoutoradoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroBancasDoutorado();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    public String somarBancaMestradoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroBancasMestrado();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
    public String somarBancaGraduacaoPrograma(Programa programa) {
        
        DecimalFormat df2 = new DecimalFormat(".#");
        double soma = 0;
        int numeroProfessores = 0;
        
        for(LinhaDePesquisa linha : programa.getLinhas())
            for(Professor professor : linha.getProfessores()) {
                soma = soma + professor.getNumeroBancasGraduacao();
                numeroProfessores++;
            }
        
        return df2.format(soma/numeroProfessores);
    }
    
}
