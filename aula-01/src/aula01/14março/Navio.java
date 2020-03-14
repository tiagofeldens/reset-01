package aula01;

public class Navio extends Veiculos {
    String combustivel;

    public Navio(String nome, Double velocidadeMaxima, String terreno, Double lotacaoMaxima, String combustivel) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return "Navio{" +
                "combustivel='" + combustivel + '\'' +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}


