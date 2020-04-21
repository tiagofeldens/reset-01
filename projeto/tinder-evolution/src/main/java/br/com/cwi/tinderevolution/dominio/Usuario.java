package br.com.cwi.tinderevolution.dominio;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario{

    public int id;
    public String nome;
    public String email;
    public String telefone;
    public LocalDate dataNascimento;
    public String bio;
    public Double latitude;
    public Double longitude;
    public String foto;

    public Usuario(String nome, String email, String telefone, LocalDate dataNascimento, String bio, Double latitude, Double longitude, String foto) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.bio = bio;
        this.latitude = latitude;
        this.longitude = longitude;
        this.foto = foto;
    }

    public final List<Musica> musicasCurtidas = new ArrayList<>();
    public final List<Filme> filmesCurtidos = new ArrayList<>();
    public final List<Serie> seriesCurtidas = new ArrayList<>();
    public final List<Jogo> jogosCurtidos = new ArrayList<>();
    public final List<Esporte> esportesCurtidos = new ArrayList<>();
    public final List<Curiosidade> curiosidades = new ArrayList<>();



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", bio='" + bio + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
