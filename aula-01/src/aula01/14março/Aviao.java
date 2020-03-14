package aula01;

public class Aviao extends Veiculos {
    String combustivel;
    int altitudeMaxima;

    public Aviao(String nome, Double velocidadeMaxima, String terreno, Double lotacaoMaxima, String combustivel, int altitudeMaxima) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.altitudeMaxima = altitudeMaxima;
    }

    @Override
    public String toString() {
        return "Aviao{" +
                "combustivel='" + combustivel + '\'' +
                ", altitudeMaxima=" + altitudeMaxima +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
