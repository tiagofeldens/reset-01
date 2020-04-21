package br.com.cwi.tinderevolution.Rest;

import br.com.cwi.tinderevolution.Banco.FilmeBanco;
import br.com.cwi.tinderevolution.dominio.Filme;
import br.com.cwi.tinderevolution.gerenciador.FilmeGerenciador;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")

public class FilmeRest {

    public FilmeGerenciador filmeGerenciador = new FilmeGerenciador();
    public FilmeBanco banco = new FilmeBanco();

    @GetMapping
    public List<Filme> listarTodos() {
        return filmeGerenciador.listar();
    }

    @GetMapping("{id}")
    public Filme listarUm(@PathVariable("id") int id) {
        return filmeGerenciador.procurar(id);
    }


    @PutMapping("{id}")
    public Filme editar(@PathVariable("id") int id, @RequestBody Filme filme) {
        return filmeGerenciador.editar(id, filme);
    }

    @PostMapping
    public Filme criar(@Validated @RequestBody Filme novoFilme) {
        return filmeGerenciador.salvar(novoFilme);
    }

    @DeleteMapping("{id}")
    public boolean deletar(@PathVariable("id") int id) {
        return filmeGerenciador.deletar(id);
    }
}

