package ClassesObjetos;

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
    
    /*
        Método que retorna a regex
    */
    public String getRegex() {
        return regex;
    }

    /*
        Método que seta a regex
    */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /*
        Método que retorna a classe
    */
    public String getClasse() {
        return classe;
    }

    /*
        Método que seta a classe
    */
    public void setClasse(String classe) {
        this.classe = classe;
    }    
}
