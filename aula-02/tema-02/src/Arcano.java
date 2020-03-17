public class Arcano extends Personagem {
    int mana;

    public Arcano(String nome, double vida, double ataque, double defesa, int mana) {
        super(nome, vida, ataque, defesa);
        this.mana = mana;
    }

    void atacar(Personagem atacado, Magia magiaUtilizada) {
        if (this.vida > 0 && this.mana > magiaUtilizada.custoDeMana) {
            double dano = calcularDano(magiaUtilizada.poder, atacado.defesa);
            atacado.vida = atacado.vida - dano;
            this.mana = mana - magiaUtilizada.custoDeMana;

            if (atacado.vida == 0) {
                System.out.println(atacado.nome + " morreu!");
            }
        }
    }

    void imprimir() {
        System.out.println("Nome: " + this.nome + " Vida: " + this.vida + " Ataque: " + this.ataque + " Defesa: " + this.defesa + " Mana: " + this.mana);
    }
}

