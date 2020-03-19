import java.util.List;

public class Arcano extends Personagem {
    int mana;

    protected Arcano(String nome, double vida, double ataque, double defesa, int mana) {
        super(nome, vida, ataque, defesa);
        this.mana = mana;
    }

    private void atacar(Personagem atacado, Magia magiaUtilizada, List<String> registros) {
        if (this.vida > 0 && this.mana > magiaUtilizada.custoDeMana) {
            double dano = calcularDano(magiaUtilizada.poder, atacado.defesa);
            atacado.vida = atacado.vida - dano;
            this.mana = mana - magiaUtilizada.custoDeMana;
            String registro = dataHora() + this.nome + " atacou " + atacado.nome + " com o " + magiaUtilizada.nome + " causando dano de " + dano;
            registros.add(registro);

            if (atacado.vida == 0) {
                registro = dataHora() + atacado.nome + " morreu!";
                registros.add(registro);
            }
        }
    }
    
    void atacar (Personagem atacado, MagiaIndividual magiaIndividual, List<String> registros){
        this.atacar(atacado, magiaIndividual, registros);
    }

    void atacar (List<Personagem> personagensAtacados, MagiaEmArea magiaEmArea, List<String> registros){
        for (Personagem atacado : personagensAtacados){
            this.atacar(atacado, magiaEmArea, registros);
        }
    }

    void imprimir() {
        System.out.println("Nome: " + this.nome + " Vida: " + this.vida + " Ataque: " + this.ataque + " Defesa: " + this.defesa + " Mana: " + this.mana);
    }

    @Override
    void imprimirStatus() {
        System.out.println(this.nome + " ficou com " + this.vida + " de vida e com " + this.mana + " de mana");
    }
}

