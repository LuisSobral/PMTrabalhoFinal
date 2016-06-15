package ClassesObjetos;

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
    public double somarOrientacoesMestradoConcluidasPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroOrientacaoMestradoConcluidas();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma as orientações de doutorado concluidas para cada linha
    */
    public double somarOrientacoesDoutoradoConcluidasPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
                
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroOrientacaoDoutoradoConcluidas();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;   
    }
    
    /*
        Soma as orientações de graduacao concluidas para cada programa
    */
    public double somarOrientacoesGraduacaoConcluidasPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroOrientacaoGraduacaoConcluidas();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma as orientações de mestrado em andamento para cada programa
    */
    public double somarOrientacoesMestradoAndamentoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroOrientacaoMestradoAndamento();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma as orientações de doutorado em andamento para cada programa
    */
    public double somarOrientacoesDoutoradoAndamentoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroOrientacaoDoutoradoAndamento();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma as orientações de graduacao em andamento para cada programa
    */
    public double somarOrientacoesGraduacaoAndamentoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroOrientacaoGraduacaoAndamento();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma as bancas de doutorado em andamento para cada programa
    */
    public double somarBancaDoutoradoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroBancasDoutorado();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma as bancas de mestrado para cada programa
    */
    public double somarBancaMestradoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroBancasMestrado();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma as bancas de graduacao para cada programa
    */
    public double somarBancaGraduacaoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).getNumeroBancasGraduacao();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos A1 de revistas do programa
    */
    public double somarArtigosA1RevistaPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosA1RevistaProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos A2 de revistas do programa
    */
    public double somarArtigosA2RevistaPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosA2RevistaProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B1 de revistas do programa
    */
    public double somarArtigosB1RevistaPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosB1RevistaProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B2 de revistas do programa
    */
    public double somarArtigosB2RevistaPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosB2RevistaProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B3 de revistas do programa
    */
    public double somarArtigosB3RevistaPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosB3RevistaProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B4 de revistas do programa
    */
    public double somarArtigosB4RevistaPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosB4RevistaProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos C de revistas do programa
    */
    public double somarArtigosCRevistaPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosCRevistaProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos NC de revistas do programa
    */
    public double somarArtigosNCRevistaPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosNCRevistaProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos A1 de eventos do programa
    */
    public double somarArtigosA1EventoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosA1EventoProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos A2 de eventos do programa
    */
    public double somarArtigosA2EventoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosA2EventoProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B1 de eventos do programa
    */
    public double somarArtigosB1EventoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosB1EventoProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B2 de eventos do programa
    */
    public double somarArtigosB2EventoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosB2EventoProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B3 de eventos do programa
    */
    public double somarArtigosB3EventoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosB3EventoProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B4 de eventos do programa
    */
    public double somarArtigosB4EventoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosB4EventoProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos C de eventos do programa
    */
    public double somarArtigosCEventoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosCEventoProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
    
    /*
        Soma de aritgos NC de eventos do programa
    */
    public double somarArtigosNCEventoPrograma() {
        
        double soma = 0;
        int numeroProfessores = 0;
        
        for(int i=0; i<linhas.size(); i++) {
            for(int j=0;j<linhas.get(i).pegaProfessores().size();j++) 
                soma = soma + linhas.get(i).pegaProfessores().get(j).somarArtigosNCEventoProfessor();
            
            numeroProfessores = numeroProfessores + linhas.get(i).contaProfessores();
        }
        
        return Math.round((soma/numeroProfessores)*1e1)/1e1;
    }
}
