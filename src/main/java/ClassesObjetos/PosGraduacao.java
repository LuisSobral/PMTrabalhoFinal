package ClassesObjetos;

import java.util.ArrayList;
import java.util.List;

/*
    Classe que contém a lista de programas
*/
public class PosGraduacao {
    
    private List<Programa> programas;

    public PosGraduacao() {
        this.programas = new ArrayList<Programa>();
    }

    /*
        Método que retorna a lista de programas
    */
    public List<Programa> pegaProgramas() {
        return programas;
    }
    
    /*
        Método que adiciona programa
    */
    public void adicionaPrograma(Programa programa) {
        programas.add(programa);
    }
    
    /*
        Método que retorna a lista de programas
    */
     public Iterable<Programa> getProgramas() {
        return programas;
    }
     
     /*
        Método que retorna um programa
    */
     public Programa pegaProgramas(int index) {
        return programas.get(index);
    }
}
