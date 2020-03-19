import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Personagem {

    final String nome;

    double vida;

    final double ataque;

    final double defesa;

    public Personagem(String nome, double vida, double ataque, double defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }


    double calcularDano(double poder, double defesa) {
        return poder * this.ataque - defesa;

    }

    void atacar(Personagem atacado, List<String> registros, Poder poder){

    }

    String dataHora (){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:ssss"));
    }

    void imprimirStatus(){
    }

}
