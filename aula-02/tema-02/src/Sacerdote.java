import java.util.List;

public class Sacerdote extends Personagem {
    int fe;

    protected Sacerdote(String nome, double vida, double ataque, double defesa, int fe) {
        super(nome, vida, ataque, defesa, TipoDePersonagem.SACERDOTE);
        this.fe = fe;
    }

    private void atacarPrivado(Personagem atacado, PoderDivino poderDivinoUtilizado, List<String> registros, boolean ataqueEmArea) {
        if (this.getVida()> 0 && this.fe > poderDivinoUtilizado.custo) {
            double dano = calcularDano(poderDivinoUtilizado.forca, atacado.defesa);
            atacado.setVida(atacado.getVida() - dano);
            this.fe= fe - poderDivinoUtilizado.custo;
            String registro = dataHora() + " " + this.nome + " atacou " + atacado.nome + " com o " + poderDivinoUtilizado.nome + " causando dano de " + dano + ". ";
            if (ataqueEmArea) {
                registro = registro + "O ataque foi em área.";
            }
            registros.add(registro);

            if (atacado.getVida() == 0) {
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
        System.out.println("Nome: " + this.nome + " Vida: " + this.getVida() + " Ataque: " + this.ataque + " Defesa: " + this.defesa + " Fé: " + this.fe);
    }

    @Override
    void imprimirStatus() {
        System.out.println(this.nome + " ficou com " + this.getVida() + " de vida e com " + this.fe + " de Fé");
    }
}
