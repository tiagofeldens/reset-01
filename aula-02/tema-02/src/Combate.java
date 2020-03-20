import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combate {

    public static void main(String[] args) {
        Arma machado = new Arma("machado", 3);
        Arma espada = new Arma("espada", 4);
        MagiaIndividual bolaDeFogo = new MagiaIndividual("bola de fogo", 2, 4);
        MagiaEmArea cogumeloSonifero = new MagiaEmArea("cogumelo sonifero", 2, 4);
        PoderDivinoIndividual armaEspiritual = new PoderDivinoIndividual("arma espiritual", 2, 2);
        PoderDivinoEmArea rajadaDeFe = new PoderDivinoEmArea("rajada De fé", 3, 5);

        Criacao criacao = new Criacao();

        //lista de personagens
        List<HomemDeArma> homensDeArma = new ArrayList<>();
        List<Arcano> arcanos = new ArrayList<>();
        List<Sacerdote> sacerdotes = new ArrayList<>();

        int contadorDePersonagens = 0;
        while (contadorDePersonagens < 6) {
            criacao.novoPersonagem(homensDeArma, arcanos, sacerdotes);
            contadorDePersonagens++;
        }

        //personagens criados para teste
        HomemDeArma personagem1 = homensDeArma.get(0);
        HomemDeArma personagem2 = homensDeArma.get(1);
        Arcano personagem3 = arcanos.get(0);
        Arcano personagem4 = arcanos.get(1);
        Sacerdote personagem5 = sacerdotes.get(0);
        Sacerdote personagem6 = sacerdotes.get(1);

        //lista de alvos
        List<Personagem> alvosGuerreiros = new ArrayList<>();
        alvosGuerreiros.add(personagem1);
        alvosGuerreiros.add(personagem2);

        List<Personagem>alvosArcanos = new ArrayList<>();
        alvosArcanos.add(personagem3);
        alvosArcanos.add(personagem4);

        List<Personagem> alvosSacerdotes = new ArrayList<>();
        alvosSacerdotes.add(personagem5);
        alvosSacerdotes.add(personagem6);

        //lista de registros de ataque
        List<String> registros = new ArrayList<>();

        System.out.println(LocalDateTime.now());

        //combate
        LocalDateTime horaInicial = LocalDateTime.now();

        personagem1.equipar(machado);
        personagem1.atacar(personagem2, registros, null);
        personagem3.atacar(personagem5, bolaDeFogo, registros);
        personagem1.equipar(espada);
        personagem1.atacar(personagem3, registros, null);
        personagem4.atacar(alvosArcanos, cogumeloSonifero, registros);
        personagem2.equipar(machado);
        personagem2.atacar(personagem6, registros, null);
        personagem6.atacar(personagem2, armaEspiritual, registros);
        personagem3.atacar(personagem4, bolaDeFogo, registros);
        personagem6.atacar(alvosSacerdotes, rajadaDeFe, registros);
        personagem5.atacar(personagem1, armaEspiritual, registros);
        personagem2.equipar(machado);
        personagem2.atacar(personagem4, registros, null);

        for (String item : registros) {
            System.out.println(item);
        }

        for (Personagem estado : arcanos) {
            estado.imprimirStatus();
        }

        for (Personagem estado : sacerdotes) {
            estado.imprimirStatus();
        }
        for (Personagem estado : homensDeArma) {
            estado.imprimirStatus();
        }
        Duration tempoDeCombate = Duration.between(horaInicial, LocalDateTime.now());
        long tempo = tempoDeCombate.toMillis();
        System.out.println("Duração total do combate: " + tempo + " milissegundos.");

    }

}
