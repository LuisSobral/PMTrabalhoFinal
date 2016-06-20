package ClassesObjetos;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que tem os dados de um professor
 */
public class Professor {
    
    private String nome;
    private String codigo;
    private List<Artigo> artigosRevista;
    private List<Artigo> artigosEvento;
    private int numeroBancasDoutorado;
    private int numeroBancasMestrado;
    private int numeroBancasGraduacao;
    private int numeroOrientacaoDoutoradoConcluidas;
    private int numeroOrientacaoMestradoConcluidas;
    private int numeroOrientacaoGraduacaoConcluidas;
    private int numeroOrientacaoDoutoradoAndamento;
    private int numeroOrientacaoMestradoAndamento;
    private int numeroOrientacaoGraduacaoAndamento;

    public Professor(String nome, String codigo, int numeroBancasDoutorado, int numeroBancasMestrado, int numeroBancasGraduacao, int numeroOrientacaoDoutoradoConcluidas, int numeroOrientacaMestradoConcluidas, int numeroOrientacaGraduacaoConcluidas, int numeroOrientacaoDoutoradoAndamento, int numeroRevistasOrientacaMestradoAndamento, int numeroRevistasOrientacaGraduacaoAndamento) {
        this.nome = nome;
        this.codigo = codigo;
        this.artigosRevista = new ArrayList<Artigo>();
        this.artigosEvento = new ArrayList<Artigo>();
        this.numeroBancasDoutorado = numeroBancasDoutorado;
        this.numeroBancasMestrado = numeroBancasMestrado;
        this.numeroBancasGraduacao = numeroBancasGraduacao;
        this.numeroOrientacaoDoutoradoConcluidas = numeroOrientacaoDoutoradoConcluidas;
        this.numeroOrientacaoMestradoConcluidas = numeroOrientacaMestradoConcluidas;
        this.numeroOrientacaoGraduacaoConcluidas = numeroOrientacaGraduacaoConcluidas;
        this.numeroOrientacaoDoutoradoAndamento = numeroOrientacaoDoutoradoAndamento;
        this.numeroOrientacaoMestradoAndamento = numeroRevistasOrientacaMestradoAndamento;
        this.numeroOrientacaoGraduacaoAndamento = numeroRevistasOrientacaGraduacaoAndamento;
    }
    
    public Professor() {
        this("","",0,0,0,0,0,0,0,0,0);
    }

    /*
        Método que retorna o nome do professor
    */
    public String getNome() {
        return nome;
    }

    /*
        Método que seta o nome do professor
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /*
        Método que retorna o codigo do professor
    */
    public String getCodigo() {
        return codigo;
    }

    /*
        Método que seta o codigo do professor
    */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /*
        Método que retorna o numero de bancas de doutorado do professor
    */
    public int getNumeroBancasDoutorado() {
        return numeroBancasDoutorado;
    }

    /*
        Método que seta o numero de bancas de doutorado do professor
    */
    public void setNumeroBancasDoutorado(int numeroBancasDoutorado) {
        this.numeroBancasDoutorado = numeroBancasDoutorado;
    }

    /*
        Método que retorna o numero de bancas de mestrado do professor
    */
    public int getNumeroBancasMestrado() {
        return numeroBancasMestrado;
    }

    /*
        Método que seta o numero de bancas de mestrado do professor
    */
    public void setNumeroBancasMestrado(int numeroBancasMestrado) {
        this.numeroBancasMestrado = numeroBancasMestrado;
    }

    /*
        Método que retorna o numero de bancas de graduacao do professor
    */
    public int getNumeroBancasGraduacao() {
        return numeroBancasGraduacao;
    }

    /*
        Método que seta o numero de bancas de graduacao do professor
    */
    public void setNumeroBancasGraduacao(int numeroBancasGraduacao) {
        this.numeroBancasGraduacao = numeroBancasGraduacao;
    }

    /*
        Método que retorna o numero de orientacoes de doutorado concluidas do professor
    */
    public int getNumeroOrientacaoDoutoradoConcluidas() {
        return numeroOrientacaoDoutoradoConcluidas;
    }

    /*
        Método que seta o numero de orientacoes de doutorado concluidas do professor
    */
    public void setNumeroOrientacaoDoutoradoConcluidas(int numeroOrientacaoDoutoradoConcluidas) {
        this.numeroOrientacaoDoutoradoConcluidas = numeroOrientacaoDoutoradoConcluidas;
    }

    /*
        Método que retorna o numero de orientacoes de mestrado concluidas do professor
    */
    public int getNumeroOrientacaoMestradoConcluidas() {
        return numeroOrientacaoMestradoConcluidas;
    }

    /*
        Método que seta o numero de orientacoes de mestrado concluidas do professor
    */
    public void setNumeroOrientacaoMestradoConcluidas(int numeroOrientacaoMestradoConcluidas) {
        this.numeroOrientacaoMestradoConcluidas = numeroOrientacaoMestradoConcluidas;
    }

    /*
        Método que retorna o numero de orientacoes de graduacao concluidas do professor
    */
    public int getNumeroOrientacaoGraduacaoConcluidas() {
        return numeroOrientacaoGraduacaoConcluidas;
    }

    /*
        Método que seta o numero de orientacoes de graduacao concluidas do professor
    */
    public void setNumeroOrientacaoGraduacaoConcluidas(int numeroOrientacaoGraduacaoConcluidas) {
        this.numeroOrientacaoGraduacaoConcluidas = numeroOrientacaoGraduacaoConcluidas;
    }

    /*
        Método que retorna o numero de orientacoes de doutorado em andamento do professor
    */
    public int getNumeroOrientacaoDoutoradoAndamento() {
        return numeroOrientacaoDoutoradoAndamento;
    }

    /*
        Método que seta o numero de orientacoes de doutorado em andamento do professor
    */
    public void setNumeroOrientacaoDoutoradoAndamento(int numeroOrientacaoDoutoradoAndamento) {
        this.numeroOrientacaoDoutoradoAndamento = numeroOrientacaoDoutoradoAndamento;
    }

    /*
        Método que retorna o numero de orientacoes de mestrado em andamento do professor
    */
    public int getNumeroOrientacaoMestradoAndamento() {
        return numeroOrientacaoMestradoAndamento;
    }

    /*
        Método que seta o numero de orientacoes de mestrado em andamento do professor
    */
    public void setNumeroOrientacaoMestradoAndamento(int numeroOrientacaoMestradoAndamento) {
        this.numeroOrientacaoMestradoAndamento = numeroOrientacaoMestradoAndamento;
    }

    /*
        Método que retorna o numero de orientacoes de graduacao em andamento do professor
    */
    public int getNumeroOrientacaoGraduacaoAndamento() {
        return numeroOrientacaoGraduacaoAndamento;
    }

    /*
        Método que seta o numero de orientacoes de graduacao em andamento do professor
    */
    public void setNumeroOrientacaoGraduacaoAndamento(int numeroOrientacaoGraduacaoAndamento) {
        this.numeroOrientacaoGraduacaoAndamento = numeroOrientacaoGraduacaoAndamento;
    }
    
    /*
        Método que adiciona um artigo a lista de artigos de evento
    */
    public void adicionaArtigoEvento(Artigo artigo) {
        artigosEvento.add(artigo);
    }
    
    /*
        Método que retorna a lista de artigos de evento
    */
    public Iterable<Artigo> getArtigosEventos() {
        return artigosEvento;
    }
    
    /*
        Método que retorna um artigo da lista de artigos de evento
    */
    public Artigo pegaArtigoEventoIndice(int indice) {
        return artigosEvento.get(indice);
    }
    
    /*
        Método que retorna a lista de artigos de evento
    */
    public List<Artigo> pegaArtigoEvento() {
        return artigosEvento;
    }
    
    /*
        Método que adiciona um artigo a lista de artigos de revista
    */
    public void adicionaArtigoRevista(Artigo artigo) {
        artigosRevista.add(artigo);
    }
    
    /*
        Método que retorna a lista de artigos de revista
    */
    public Iterable<Artigo> getArtigosRevista() {
        return artigosRevista;
    }
    
    /*
        Método que retorna um aritog da lista de artigos de revista
    */
    public Artigo pegaArtigoRevistaIndice(int indice) {
        return artigosRevista.get(indice);
    }
    
    /*
        Método que retorna a lista de artigos de revista
    */
    public List<Artigo> pegaArtigoRevista() {
        return artigosRevista;
    }
    
    /*
        Soma de aritgos A1 evento de cada professor
    */
    public double somarArtigosA1EventoProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosEvento.size(); i++)
            if(artigosEvento.get(i).getClasse().equals("A1"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos A2 evento de cada professor
    */
    public double somarArtigosA2EventoProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosEvento.size(); i++)
            if(artigosEvento.get(i).getClasse().equals("A2"))
                soma++;
        
        return soma;
        
    }
    
    /*
        Soma de aritgos B1 evento de cada professor
    */
    public double somarArtigosB1EventoProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosEvento.size(); i++)
            if(artigosEvento.get(i).getClasse().equals("B1"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B2 evento de cada professor
    */
    public double somarArtigosB2EventoProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosEvento.size(); i++)
            if(artigosEvento.get(i).getClasse().equals("B2"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B3 evento de cada professor
    */
    public double somarArtigosB3EventoProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosEvento.size(); i++)
            if(artigosEvento.get(i).getClasse().equals("B3"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B4 evento de cada professor
    */
    public double somarArtigosB4EventoProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosEvento.size(); i++)
            if(artigosEvento.get(i).getClasse().equals("B4"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos C de eventos de cada professor
    */
    public double somarArtigosCEventoProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosEvento.size(); i++)
            if(artigosEvento.get(i).getClasse().equals("C"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos NC evento de cada professor
    */
    public double somarArtigosNCEventoProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosEvento.size(); i++)
            if(artigosEvento.get(i).getClasse().equals("NC"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos A1 de revistas de cada professor
    */
    public double somarArtigosA1RevistaProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosRevista.size(); i++)
            if(artigosRevista.get(i).getClasse().equals("A1"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos A2 de revistas de cada professor
    */
    public double somarArtigosA2RevistaProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosRevista.size(); i++)
            if(artigosRevista.get(i).getClasse().equals("A2"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B1 de revistas de cada professor
    */
    public double somarArtigosB1RevistaProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosRevista.size(); i++)
            if(artigosRevista.get(i).getClasse().equals("B1"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B2 de revistas de cada professor
    */
    public double somarArtigosB2RevistaProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosRevista.size(); i++)
            if(artigosRevista.get(i).getClasse().equals("B2"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B3 de revistas de cada professor
    */
    public double somarArtigosB3RevistaProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosRevista.size(); i++)
            if(artigosRevista.get(i).getClasse().equals("B3"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos B4 de revistas de cada professor
    */
    public double somarArtigosB4RevistaProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosRevista.size(); i++)
            if(artigosRevista.get(i).getClasse().equals("B4"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos C de revistas de cada professor
    */
    public double somarArtigosCRevistaProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosRevista.size(); i++)
            if(artigosRevista.get(i).getClasse().equals("C"))
                soma++;
        
        return soma;
    }
    
    /*
        Soma de aritgos NC de revistas de cada professor
    */
    public double somarArtigosNCRevistaProfessor() {
        
        double soma = 0;
        
        for(int i=0; i<artigosRevista.size(); i++)
            if(artigosRevista.get(i).getClasse().equals("NC"))
                soma++;
        
        return soma;
    }
    
    /*
        Método que retorna um artigo evento
    */
    public Artigo pegaArtigoEvento(int index) {
        return artigosEvento.get(index);
    }
    
    /*
        Método que retorna um artigo revista
    */
    public Artigo pegaArtigoRevista(int index) {
        return artigosRevista.get(index);
    }
    
}    