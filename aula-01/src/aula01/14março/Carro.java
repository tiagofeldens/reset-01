package aula01;

public class Carro extends Veiculos {
    String combustivel;
    int quantidadeDeRodas;

    public Carro(String nome, Double velocidadeMaxima, String terreno, Double lotacaoMaxima, int quantidadeDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.quantidadeDeRodas = quantidadeDeRodas;
        this.combustivel = combustivel;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "combustivel='" + combustivel + '\'' +
                ", quantidadeDeRodas=" + quantidadeDeRodas +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
