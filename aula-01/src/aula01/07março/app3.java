public class app {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Outra Coisa");
        System.out.println("teste 1");
        System.out.println("teste 2");
        System.out.println("teste 3");

        Calculadora calculadoraDeIdades = new Calculadora();
        int somaDasIdades = calculadoraDeIdades.soma(33, 54);
        System.out.println(somaDasIdades);

        int subtraiIdades = calculadoraDeIdades.subtrai(54, 33);
        System.out.println(subtraiIdades);

        int multiplicaIdades = calculadoraDeIdades.multiplica(10, 10);
        System.out.println(multiplicaIdades);

        double divideIdades = calculadoraDeIdades.divide(51,25);
        System.out.println(divideIdades);

        Comparador comparadorDeNumeros = new Comparador();
        boolean comparacao = comparadorDeNumeros.menorQue(55, 44);
        System.out.println(comparacao);
        comparacao = comparadorDeNumeros.menorQue(44,55);
        System.out.println(comparacao);

        boolean comparacao2 = comparadorDeNumeros.maoirQue(23,43);
        System.out.println(comparacao2);
    }
}
