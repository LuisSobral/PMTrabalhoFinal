package ClassesObjetos;

import java.util.ArrayList;
import java.util.List;

/*
    Classe que contém as regex do arquivo qualis separadas em eventos e reveistas
*/
public class Qualis {
    
    private List<EntradaQualis> ArtigosEvento;
    private List<EntradaQualis> ArtigosRevista;

    public Qualis() {
        this.ArtigosEvento = new ArrayList<EntradaQualis>();
        this.ArtigosRevista = new ArrayList<EntradaQualis>();
    }

    /*
        Método que retorna a lista de regex de eventos
    */
    public List<EntradaQualis> getArtigosEvento() {
        return ArtigosEvento;
    }

    /*
        Método que retorna a lista de regex de revista
    */
    public List<EntradaQualis> getArtigosRevista() {
        return ArtigosRevista;
    }

    /*
        Método que adiciona a lista de regex de eventos
    */
    public void adicionaArtigoEvento(EntradaQualis entrada) {
        ArtigosEvento.add(entrada);
    } 
    
    /*
        Método que adiciona a lista de regex de revistas
    */
    public void adicionaArtigoRevista(EntradaQualis entrada) {
        ArtigosRevista.add(entrada);
    } 
    
    /*
        Método que retorna uma regex de evento
    */
    public String pegaRegexEvento(int index) {
        return ArtigosEvento.get(index).getRegex();
    }
    
    /*
        Método que retorna uma regex de revista
    */
    public String pegaRegexRevista(int index) {
        return ArtigosRevista.get(index).getRegex();
    }
    
    /*
        Método que retorna uma classe de evento
    */
    public String pegaClasseEvento(int index) {
        return ArtigosEvento.get(index).getClasse();
    }
    
    /*
        Método que retorna uma classe de revista
    */
    public String pegaClasseRevista(int index) {
        return ArtigosRevista.get(index).getClasse();
    }
}
