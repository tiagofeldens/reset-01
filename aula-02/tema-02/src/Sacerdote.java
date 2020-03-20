import java.util.List;

public class Sacerdote extends Personagem {
    int fe;

    protected Sacerdote(String nome, double vida, double ataque, double defesa, int fe) {
        super(nome, vida, ataque, defesa);
        this.fe = fe;
    }

    private void atacarPrivado(Personagem atacado, PoderDivino poderDivinoUtilizado, List<String> registros, boolean ataqueEmArea) {
        if (this.vida > 0 && this.fe > poderDivinoUtilizado.custoDeFe) {
            double dano = calcularDano(poderDivinoUtilizado.intensidade, atacado.defesa);
            atacado.vida = atacado.vida - dano;
            this.fe= fe - poderDivinoUtilizado.custoDeFe;
            String registro = dataHora() + " " + this.nome + " atacou " + atacado.nome + " com o " + poderDivinoUtilizado.nome + " causando dano de " + dano;
            if (ataqueEmArea) {
                registro = registro + "O ataque foi em área.";
            }
            registros.add(registro);

            if (atacado.vida == 0) {
                registro = dataHora() + atacado.nome + " morreu!";
                registros.add(registro);
            }
        }
    }
    void atacar (Personagem atacado, PoderDivinoIndividual poderIndividual, List<String> registros){
        this.atacarPrivado(atacado, poderIndividual, registros, false);
    }

    void atacar (List<Personagem> personagensAtacados, PoderDivinoEmArea poderEmArea, List<String> registros){
        for (Personagem atacado : personagensAtacados){
            this.atacarPrivado(atacado, poderEmArea, registros, true);
        }
    }
    void imprimir() {
        System.out.println("Nome: " + this.nome + " Vida: " + this.vida + " Ataque: " + this.ataque + " Defesa: " + this.defesa + " Fé: " + this.fe);
    }

    @Override
    void imprimirStatus() {
        System.out.println(this.nome + " ficou com " + this.vida + " de vida e com " + this.fe + " de Fé");
    }
}
