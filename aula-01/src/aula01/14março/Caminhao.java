package aula01;

public class Caminhao extends Veiculos {
    String combustivel;
    int quantidadeDeRodas;

    public Caminhao(String nome, Double velocidadeMaxima, String terreno, Double lotacaoMaxima, String combustivel, int quantidadeDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.quantidadeDeRodas = quantidadeDeRodas;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "combustivel='" + combustivel + '\'' +
                ", quantidadeDeRodas=" + quantidadeDeRodas +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
