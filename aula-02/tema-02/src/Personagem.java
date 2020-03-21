import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Personagem {

    final String nome;

    private double vida;

    final double ataque;

    final double defesa;

    final TipoDePersonagem tipo;

    public Personagem(String nome, double vida, double ataque, double defesa, TipoDePersonagem tipo) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.tipo = tipo;
    }

    public double getVida() {return vida;

    }

    public void setVida(double vida) {this.vida = vida;


    }

    void equipar(Arma armaUtilizada) {
    }



    double calcularDano(double poder, double defesa) {
        return poder * this.ataque - defesa;

    }

    void atacar(Personagem atacado, List<String> registros, Poder poder){

    }

    String dataHora (){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSSS"));
    }

    void imprimirStatus(){
    }

}
