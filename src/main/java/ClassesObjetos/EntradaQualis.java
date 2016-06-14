package ClassesObjetos;

import java.util.HashMap;
import java.util.Map;

public class EntradaQualis {
    
    private String regex;
    private String classe;
    
    public EntradaQualis(String regex, String classe, String type) {
        this.regex = regex;
        this.classe = classe;
    }

    public EntradaQualis() {
        this("","","");
    }
    
    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }    
}
