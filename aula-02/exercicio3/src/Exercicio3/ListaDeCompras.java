package Exercicio3;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {
    Item item = new Item("Pão", Segmento.ALIMENTACAO, 7.80, 2);
    Item item1 = new Item("Sabonete", Segmento.HIGIENE, 2.50, 5);
    Item item2 = new Item("Vassoura", Segmento.LIMPEZA, 13, 1);

    List<ListaDeCompras> itens = new ArrayList<>();
    itens.add(item);
    itens.add(item1);
    itens.add(item2);






}
