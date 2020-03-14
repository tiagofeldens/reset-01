package aula01;

public class Submarino extends Veiculos {
    String combustivel;
    Double profundidadeMaxima;


    public Submarino(String nome, Double velocidadeMaxima, String terreno, Double lotacaoMaxima, String combustivel, Double profundidadeMaxima) {
        super(nome, velocidadeMaxima, terreno, lotacaoMaxima);
        this.combustivel = combustivel;
        this.profundidadeMaxima = profundidadeMaxima;
    }

}

    @Override
    public String toString() {
        return "Submarino{" +
                "combustivel='" + combustivel + '\'' +
                ", profundidadeMaxima=" + profundidadeMaxima +
                ", nome='" + nome + '\'' +
                ", velocidadeMaxima=" + velocidadeMaxima +
                ", terreno='" + terreno + '\'' +
                ", lotacaoMaxima=" + lotacaoMaxima +
                '}';
    }
}
