public class Personagem {

    final String nome;

    double vida;

    final double ataque;

    final double defesa;

    public Personagem(String nome, double vida, double ataque, double defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }


    double calcularDano(double poder, double defesa) {
        return poder * this.ataque - defesa;

    }


}
