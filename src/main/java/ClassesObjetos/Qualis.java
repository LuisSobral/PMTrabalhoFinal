package ClassesObjetos;

import java.util.ArrayList;
import java.util.List;

public class Qualis {
    
    private List<EntradaQualis> ArtigosEvento;
    private List<EntradaQualis> ArtigosRevista;

    public Qualis() {
        this.ArtigosEvento = new ArrayList<EntradaQualis>();
        this.ArtigosRevista = new ArrayList<EntradaQualis>();
    }

    public List<EntradaQualis> getArtigosEvento() {
        return ArtigosEvento;
    }

    public List<EntradaQualis> getArtigosRevista() {
        return ArtigosRevista;
    }

    public void adicionaArtigoEvento(EntradaQualis entrada) {
        ArtigosEvento.add(entrada);
    } 
    
    public void adicionaArtigoRevista(EntradaQualis entrada) {
        ArtigosRevista.add(entrada);
    } 
    
    public String pegaRegexEvento(int index) {
        return ArtigosEvento.get(index).getRegex();
    }
    
    public String pegaRegexRevista(int index) {
        return ArtigosRevista.get(index).getRegex();
    }
    
    public String pegaClasseEvento(int index) {
        return ArtigosEvento.get(index).getClasse();
    }
    
    public String pegaClasseRevista(int index) {
        return ArtigosRevista.get(index).getClasse();
    }
}
