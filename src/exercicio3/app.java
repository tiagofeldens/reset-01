package exercicio3;

import java.sql.SQLOutput;

public class app {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("tiago",8.5);
        boolean aprovado = aluno.aprovado();
        System.out.println("tiago");
        System.out.println(8.5);
        System.out.println(aprovado);
        Aluno aluno1 = new Aluno ("mateus", 6.1);
                 aprovado = aluno.aprovado();
        System.out.println("mateus");
        System.out.println(6.1);
        System.out.println(aprovado);

    }
}






