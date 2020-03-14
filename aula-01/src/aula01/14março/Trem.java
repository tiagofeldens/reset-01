package aula01;

public class Trem extends Veiculos {
    String combustivel;
    int numeroDeRodas;

    public Trem(String nome, Double velocidadeMaxima, String terreno, Double lotacaoMaxima, String combustivel, int numeroDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.numeroDeRodas = numeroDeRodas;
    }

    @Override
    public String toString() {
        return "Trem{" +
                "combustivel='" + combustivel + '\'' +
                ", numeroDeRodas=" + numeroDeRodas +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
