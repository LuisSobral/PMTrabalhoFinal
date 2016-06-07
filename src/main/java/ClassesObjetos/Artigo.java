package ClassesObjetos;

/**
 * Classe com dados de um artigo
 */
public class Artigo {
    
    private String classe;
    private String regex;

    public Artigo(String classe, String regex) {
        this.classe = classe;
        this.regex = regex;
    }
    
    public Artigo() {
        this("","");
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
    
    
    
}
