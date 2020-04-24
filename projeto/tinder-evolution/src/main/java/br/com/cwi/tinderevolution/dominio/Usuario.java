package br.com.cwi.tinderevolution.dominio;

import org.springframework.web.bind.annotation.PutMapping;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario{

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String bio;
    private Double latitude;
    private Double longitude;
    private String foto;

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

    public final List<Integer> musicasCurtidas = new ArrayList<>();
    public final List<Integer> filmesCurtidos = new ArrayList<>();
    public final List<Integer> seriesCurtidas = new ArrayList<>();
    public final List<Integer> jogosCurtidos = new ArrayList<>();
    public final List<Integer> esportesCurtidos = new ArrayList<>();
    public final List<Curiosidade> curiosidades = new ArrayList<>();
    public final List<Integer> usuariosCurtidos = new ArrayList<>();
    public final List<Integer> matches = new ArrayList<>();


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
                ", foto='" + foto + '\'' +
                ", musicasCurtidas=" + musicasCurtidas +
                ", filmesCurtidos=" + filmesCurtidos +
                ", seriesCurtidas=" + seriesCurtidas +
                ", jogosCurtidos=" + jogosCurtidos +
                ", esportesCurtidos=" + esportesCurtidos +
                ", curiosidades=" + curiosidades +
                ", usuariosCurtidos=" + usuariosCurtidos +
                ", matches=" + matches +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
