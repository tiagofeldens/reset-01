import java.time.Duration;
import java.time.LocalDateTime;
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
        Personagem personagem4 = personagens.get(3);
        Personagem personagem5 = personagens.get(4);
        Personagem personagem6 = personagens.get(5);

        //lista de registros de ataque
        List<String> registros = new ArrayList<>();

        System.out.println(LocalDateTime.now());

        //combate
        LocalDateTime horaInicial = LocalDateTime.now();

        personagem1.atacar, personagem2;
        personagem3.atacar, personagem4;
        personagem1.atacar, personagem2;
        personagem3.atacar, personagem4;
        personagem1.atacar, personagem2;
        personagem3.atacar, personagem4;
        personagem1.atacar, personagem2;
        personagem3.atacar, personagem4;
        personagem1.atacar, personagem2;
        personagem3.atacar, personagem4;

        for (String item : registros) {
            System.out.println(item);
        }

        for (Personagem estado : personagens) {
            estado.imprimirStatus();

        }
        Duration tempoDeCombate = Duration.between(horaInicial, LocalDateTime.now());
        System.out.println("Duração total do combate: " + tempoDeCombate);

    }

}
