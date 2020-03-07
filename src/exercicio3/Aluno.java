package exercicio3;

public class Aluno {

    String nome;
    Double nota;

    public Aluno(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    boolean aprovado() {
        return nota >= 7;
    }

}
