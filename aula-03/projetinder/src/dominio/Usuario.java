package dominio;

import java.time.LocalDate;

public class Usuario{

    public int id;
    public String nome;
    public String email;
    public String telefone;
    public LocalDate dataNascimento;
    public String bio;
    public Localizacao localizacao;

    public Usuario(String nome, String email, String telefone, LocalDate dataNascimento, String bio, Localizacao localizacao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.bio = bio;
        this.localizacao = localizacao;
    }


    @Override
    public String toString(){
        return "Usuário[" +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", Email: '" + email + '\'' +
                ", Telefone: " + telefone +
                ", Data de Nascimento: " + dataNascimento +
                ", Bio: " + bio +
                ']';
    }

}
