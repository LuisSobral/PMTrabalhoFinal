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
}
