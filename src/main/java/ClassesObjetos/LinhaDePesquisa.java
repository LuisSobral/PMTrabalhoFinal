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
}