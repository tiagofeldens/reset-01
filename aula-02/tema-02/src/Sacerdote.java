import java.util.List;

public class Sacerdote extends Personagem {
    int fe;

    protected Sacerdote(String nome, double vida, double ataque, double defesa, int fe) {
        super(nome, vida, ataque, defesa);
        this.fe = fe;
    }

    private void atacar(Personagem atacado, PoderDivino poderDivinoUtilizado, List<String> registros) {
        if (this.vida > 0 && this.fe > poderDivinoUtilizado.custoDeFe) {
            double dano = calcularDano(poderDivinoUtilizado.intensidade, atacado.defesa);
            atacado.vida = atacado.vida - dano;
            this.fe= fe - poderDivinoUtilizado.custoDeFe;
            String registro = this.nome + " atacou " + atacado.nome + " com o " + poderDivinoUtilizado.nome + " causando dano de " + dano;
            registros.add(registro);

            if (atacado.vida == 0) {
                registro = atacado.nome + " morreu!";
                registros.add(registro);
            }
        }
    }
    void atacar (Personagem atacado, PoderDivinoIndividual poderIndividual, List<String> registros){
        this.atacar(atacado, poderIndividual, registros);
    }

    void atacar (List<Personagem> personagensAtacados, PoderDivinoEmArea poderEmArea, List<String> registros){
        for (Personagem atacado : personagensAtacados){
            this.atacar(atacado, poderEmArea, registros);
        }
    }
    void imprimir() {
        System.out.println("Nome: " + this.nome + " Vida: " + this.vida + " Ataque: " + this.ataque + " Defesa: " + this.defesa + " Fé: " + this.fe);
    }
}
