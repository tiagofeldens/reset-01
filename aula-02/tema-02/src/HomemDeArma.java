import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.List;

public class HomemDeArma extends Personagem {
    Arma arma;

    protected HomemDeArma(String nome, double vida, double ataque, double defesa) {
        super(nome, vida, ataque, defesa, TipoDePersonagem.HOMEM_DE_ARMA);
    }

    @Override
    void atacar(Personagem atacado, List<String> registros, Poder poder) {
        if (this.getVida()> 0) {
            double dano = calcularDano(arma.poderDeAtaque, atacado.defesa);
            atacado.setVida(atacado.getVida()- dano);
            String registro = dataHora() + " " + this.nome + " atacou " + atacado.nome + " com o " + arma.nome + " causando dano de " + dano;
            registros.add(registro);

            if (atacado.getVida() == 0) {
               registro = dataHora() + atacado.nome + " morreu!";
                registros.add(registro);
            }
        }
    }

    @Override
    void equipar(Arma armaUtilizada) {
        this.arma = armaUtilizada;
    }

    void imprimir() {
        System.out.println("Nome: " + this.nome + " Vida: " + this.getVida() + " Ataque: " + this.ataque + " Defesa: " + this.defesa);
    }

    @Override
    void imprimirStatus() {
        System.out.println(this.nome + " ficou com " + this.getVida() + " de vida ");
    }
}
