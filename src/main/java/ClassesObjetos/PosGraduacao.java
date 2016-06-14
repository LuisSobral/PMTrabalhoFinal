package ClassesObjetos;

import java.util.ArrayList;
import java.util.List;


public class PosGraduacao {
    
    private List<Programa> programas;

    public PosGraduacao() {
        this.programas = new ArrayList<Programa>();
    }

    public List<Programa> pegaProgramas() {
        return programas;
    }
    
    public void adicionaPrograma(Programa programa) {
        programas.add(programa);
    }
    
     public Iterable<Programa> getProgramas() {
        return programas;
    }
}
