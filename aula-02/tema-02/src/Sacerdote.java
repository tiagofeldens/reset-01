public class Sacerdote extends Personagem {
    int fe;

    public Sacerdote(String nome, double vida, double ataque, double defesa, int fe) {
        super(nome, vida, ataque, defesa);
        this.fe = fe;
    }

    void atacar(Personagem atacado, PoderDivino poderDivinoUtilizado) {
        if (this.vida > 0 && this.fe > poderDivinoUtilizado.custoDeFe) {
            double dano = calcularDano(poderDivinoUtilizado.intensidade, atacado.defesa);
            atacado.vida = atacado.vida - dano;
            this.fe= fe - poderDivinoUtilizado.custoDeFe;

            if (atacado.vida == 0) {
                System.out.println(atacado.nome + " morreu!");
            }
        }
    }
    void imprimir() {
        System.out.println("Nome: " + this.nome + " Vida: " + this.vida + " Ataque: " + this.ataque + " Defesa: " + this.defesa + " Fé: " + this.fe);
    }
}
