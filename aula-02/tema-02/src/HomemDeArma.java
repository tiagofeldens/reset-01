import java.util.List;

public class HomemDeArma extends Personagem {
    Arma arma;

    protected HomemDeArma(String nome, double vida, double ataque, double defesa) {
        super(nome, vida, ataque, defesa);
    }

    void atacar(Personagem atacado, List<String> registros) {
        if (this.vida > 0) {
            double dano = calcularDano(arma.poderDeAtaque, atacado.defesa);
            atacado.vida = atacado.vida - dano;
            String registro = this.nome + " atacou " + atacado.nome + " com o " + arma.nome + " causando dano de " + dano;
            registros.add(registro);

            if (atacado.vida == 0) {
               registro = atacado.nome + " morreu!";
                registros.add(registro);
            }
        }
    }

    void equipar(Arma armaUtilizada) {
        this.arma = armaUtilizada;
    }
    void imprimir() {
        System.out.println("Nome: " + this.nome + " Vida: " + this.vida + " Ataque: " + this.ataque + " Defesa: " + this.defesa);
}}
