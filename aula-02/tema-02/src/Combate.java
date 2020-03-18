import java.util.ArrayList;
import java.util.List;

public class Combate {

    public static void main(String[] args) {
        Criacao criacao = new Criacao();

        //lista de personagens
        List<Personagem> personagens = new ArrayList<>();
        while (personagens.size() < 6) {
            personagens.add(criacao.novoPersonagem());
        }

        //personagens criados para teste
        Personagem personagem1 = personagens.get(0);
        Personagem personagem2 = personagens.get(1);
        Personagem personagem3 = personagens.get(2);


        //lista de registros de ataque
        List<String> registros = new ArrayList<>();



    }

}
