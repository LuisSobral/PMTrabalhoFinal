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

    /*
        Método que retorna a classe de um artigo
    */
    public String getClasse() {
        return classe;
    }

    /*
        Método que seta o nome do evento ou revista do artigo
    */
    public void setClasse(String classe) {
        this.classe = classe;
    }

    /*
        Método que retorna o nome do evento ou revista do artigo
    */
    public String getRegex() {
        return regex;
    }

    /*
        Método que seta o nome do evento ou revista do artigo
    */
    public void setRegex(String regex) {
        this.regex = regex;
    }
    
    
    
}
