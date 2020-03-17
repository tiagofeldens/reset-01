public class App {

    public static void main(String[] args) {
        Livro livro = new Livro("Biblia", "J. Cristo", Categorias.FANTASIA, Status.DISPONIVEL);
        Livro livro1 = new Livro("Dicionário", "Aurélio", Categorias.SUSPENSE, Status.EM_USO);
        Livro livro2 = new Livro("As veias abertas da America Latina", "E. Galeano", Categorias.TERROR, Status.EMPRESTADO);
        Livro livro3 = new Livro("Harry Potter", "Tolkien", Categorias.ROMANCE, Status.DISPONIVEL);


        System.out.println(livro);
        System.out.println(livro1);
        System.out.println(livro2);
        System.out.println(livro3);
    }


}