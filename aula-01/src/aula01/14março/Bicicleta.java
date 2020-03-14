package aula01;

public class Bicicleta extends Veiculos {
    String quantidadeDeRodas;

    public Bicicleta(String nome, Double velocidadeMaxima, String terreno, Double lotacaoMaxima, String quantidadeDeRodas) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.quantidadeDeRodas = quantidadeDeRodas;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "quantidadeDeRodas='" + quantidadeDeRodas + '\'' +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
