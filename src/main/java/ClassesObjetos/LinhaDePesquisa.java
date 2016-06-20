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

    /*
        Método que retorna o nome de uma linha
    */
    public String getNome() {
        return nome;
    }

    /*
        Método que seta o nome de uma linha
    */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /*
        Método que adiciona professor a uma linha
    */
    public void adicionaProfessor(Professor professor) {
        professores.add(professor);
    }
    
    /*
        Método que retorna lista de professores
    */
    public Iterable<Professor> getProfessores() {
        return professores;
    }
    
    /*
        Método que retorna um determinado professor
    */
    public Professor pegaProfessorIndice(int indice) {
        return professores.get(indice);
    }
    
    /*
        Método que retorna a lista de professores
    */
    public List<Professor> pegaProfessores() {
        return professores;
    }
    
    /*
        Soma as orientações de mestrado concluidas para cada linha
    */
    public double somarOrientacoesMestradoConcluidasLinhas() {
        
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroOrientacaoMestradoConcluidas();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma as orientações de doutorado concluidas para cada linha
    */
    public double somarOrientacoesDoutoradoConcluidasLinhas() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroOrientacaoDoutoradoConcluidas();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma as orientações de graduacao concluidas para cada linha
    */
    public double somarOrientacoesGraduacaoConcluidasLinhas() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroOrientacaoGraduacaoConcluidas();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma as orientações de mestrado em andamento para cada linha
    */
    public double somarOrientacoesMestradoAndamentoLinhas() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroOrientacaoMestradoAndamento();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma as orientações de doutorado em andamento para cada linha
    */
    public double somarOrientacoesDoutoradoAndamentoLinhas() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
                
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroOrientacaoDoutoradoAndamento();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma as orientações de graduacao em andamento para cada linha
    */
    public double somarOrientacoesGraduacaoAndamentoLinhas() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroOrientacaoGraduacaoAndamento();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma as bancas de doutorado para cada linha
    */
    public double somarBancaDoutoradoLinhas() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroBancasDoutorado();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma as bancas de mestrado para cada linha
    */
    public double somarBancaMestradoLinhas() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
                
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroBancasMestrado();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma as bancas de graduacao para cada linha
    */
    public double somarBancaGraduacaoLinhas() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
                
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).getNumeroBancasGraduacao();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos A1 de revistas de cada linha
    */
    public double somarArtigosA1RevistaLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosA1RevistaProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos A2 de revistas de cada linha
    */
    public double somarArtigosA2RevistaLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosA2RevistaProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B1 de revistas de cada linha
    */
    public double somarArtigosB1RevistaLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosB1RevistaProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B2 de revistas de cada linha
    */
    public double somarArtigosB2RevistaLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosB2RevistaProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B3 de revistas de cada linha
    */
    public double somarArtigosB3RevistaLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosB3RevistaProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B4 de revistas de cada linha
    */
    public double somarArtigosB4RevistaLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosB4RevistaProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos C de revistas de cada linha
    */
    public double somarArtigosCRevistaLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosCRevistaProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos NC de revistas de cada linha
    */
    public double somarArtigosNCRevistaLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosNCRevistaProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos A1 de evento de cada linha
    */
    public double somarArtigosA1EventoLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosA1EventoProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos A2 de evento de cada linha
    */
    public double somarArtigosA2EventoLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosA2EventoProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos b1 de evento de cada linha
    */
    public double somarArtigosB1EventoLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosB1EventoProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public double somarArtigosB2EventoLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosB2EventoProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B3 de evento de cada linha
    */
    public double somarArtigosB3EventoLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosB3EventoProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;      
    }
    
    /*
        Soma de aritgos B4 de evento de cada linha
    */
    public double somarArtigosB4EventoLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosB4EventoProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public double somarArtigosCEventoLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0;
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosCEventoProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Soma de aritgos B2 de evento de cada linha
    */
    public double somarArtigosNCEventoLinha() {
        
        DecimalFormat df2 = new DecimalFormat("#.#");
        double soma = 0; 
        
        for(int i=0; i<professores.size(); i++)
            soma = soma + professores.get(i).somarArtigosNCEventoProfessor();
        
        if(soma == 0)
            return 0.0;
        else
            return Math.round((soma/professores.size())*1e1)/1e1;
    }
    
    /*
        Método que retorna a quantidade de professores
    */
    public int contaProfessores() {
        return professores.size();
    }
}