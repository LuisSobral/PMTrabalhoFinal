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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumeroBancasDoutorado() {
        return numeroBancasDoutorado;
    }

    public void setNumeroBancasDoutorado(int numeroBancasDoutorado) {
        this.numeroBancasDoutorado = numeroBancasDoutorado;
    }

    public int getNumeroBancasMestrado() {
        return numeroBancasMestrado;
    }

    public void setNumeroBancasMestrado(int numeroBancasMestrado) {
        this.numeroBancasMestrado = numeroBancasMestrado;
    }

    public int getNumeroBancasGraduacao() {
        return numeroBancasGraduacao;
    }

    public void setNumeroBancasGraduacao(int numeroBancasGraduacao) {
        this.numeroBancasGraduacao = numeroBancasGraduacao;
    }

    public int getNumeroOrientacaoDoutoradoConcluidas() {
        return numeroOrientacaoDoutoradoConcluidas;
    }

    public void setNumeroOrientacaoDoutoradoConcluidas(int numeroOrientacaoDoutoradoConcluidas) {
        this.numeroOrientacaoDoutoradoConcluidas = numeroOrientacaoDoutoradoConcluidas;
    }

    public int getNumeroOrientacaoMestradoConcluidas() {
        return numeroOrientacaoMestradoConcluidas;
    }

    public void setNumeroOrientacaoMestradoConcluidas(int numeroOrientacaoMestradoConcluidas) {
        this.numeroOrientacaoMestradoConcluidas = numeroOrientacaoMestradoConcluidas;
    }

    public int getNumeroOrientacaoGraduacaoConcluidas() {
        return numeroOrientacaoGraduacaoConcluidas;
    }

    public void setNumeroOrientacaoGraduacaoConcluidas(int numeroOrientacaoGraduacaoConcluidas) {
        this.numeroOrientacaoGraduacaoConcluidas = numeroOrientacaoGraduacaoConcluidas;
    }

    public int getNumeroOrientacaoDoutoradoAndamento() {
        return numeroOrientacaoDoutoradoAndamento;
    }

    public void setNumeroOrientacaoDoutoradoAndamento(int numeroOrientacaoDoutoradoAndamento) {
        this.numeroOrientacaoDoutoradoAndamento = numeroOrientacaoDoutoradoAndamento;
    }

    public int getNumeroOrientacaoMestradoAndamento() {
        return numeroOrientacaoMestradoAndamento;
    }

    public void setNumeroOrientacaoMestradoAndamento(int numeroOrientacaoMestradoAndamento) {
        this.numeroOrientacaoMestradoAndamento = numeroOrientacaoMestradoAndamento;
    }

    public int getNumeroOrientacaoGraduacaoAndamento() {
        return numeroOrientacaoGraduacaoAndamento;
    }

    public void setNumeroOrientacaoGraduacaoAndamento(int numeroOrientacaoGraduacaoAndamento) {
        this.numeroOrientacaoGraduacaoAndamento = numeroOrientacaoGraduacaoAndamento;
    }
    
    public void adicionaArtigoEvento(Artigo artigo) {
        artigosEvento.add(artigo);
    }
    
    public Iterable<Artigo> getArtigosEventos() {
        return artigosEvento;
    }
    
    public Artigo pegaArtigoEventoIndice(int indice) {
        return artigosEvento.get(indice);
    }
    
    public List<Artigo> pegaArtigoEvento() {
        return artigosEvento;
    }
    
    public void adicionaArtigoRevista(Artigo artigo) {
        artigosRevista.add(artigo);
    }
    
    public Iterable<Artigo> getArtigosRevista() {
        return artigosRevista;
    }
    
    public Artigo pegaArtigoRevistaIndice(int indice) {
        return artigosRevista.get(indice);
    }
    
    public List<Artigo> pegaArtigoRevista() {
        return artigosRevista;
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
    
}    