package Models;

public class Pokemon {
    
    private String nome;
    private int vida;
    private int cura;
    private int ataque;

    public Pokemon(String nome, int vida, int cura, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.cura = cura;
        this.ataque = ataque;
    }
    
    public Pokemon(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    @Override
    public String toString() {
        String string = "";
        string += "Nome: " + nome;
        string += "\nVida: " + vida;
        string += "\nCura: " + cura;
        string += "\nAtaque: " + ataque;
        return string;
    }
    
}
