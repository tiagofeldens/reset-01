public class HomemDeArma extends Personagem {
    Arma arma;

    public HomemDeArma(String nome, double vida, double ataque, double defesa) {
        super(nome, vida, ataque, defesa);
    }

    void atacar(Personagem atacado) {
        if (this.vida > 0) {
            double dano = calcularDano(arma.poderDeAtaque, atacado.defesa);
            atacado.vida = atacado.vida - dano;

            if (atacado.vida == 0) {
                System.out.println(atacado.nome + " morreu!");
            }
        }
    }

    void equipar(Arma armaUtilizada) {
        this.arma = armaUtilizada;
    }
    void imprimir() {
        System.out.println("Nome: " + this.nome + " Vida: " + this.vida + " Ataque: " + this.ataque + " Defesa: " + this.defesa);
}}
