package br.com.cwi.tinderevolution.Rest;

import br.com.cwi.tinderevolution.Banco.JogoBanco;
import br.com.cwi.tinderevolution.dominio.Jogo;
import br.com.cwi.tinderevolution.gerenciador.JogoGerenciador;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")

public class JogoRest {

    public JogoGerenciador jogoGerenciador = new JogoGerenciador();
    public JogoBanco banco = new JogoBanco();

    @GetMapping
    public List<Jogo> listarTodos() {
        return jogoGerenciador.listar();
    }

    @GetMapping("{id}")
    public Jogo listarUm(@PathVariable("id") int id) {
        return jogoGerenciador.procurar(id);
    }


    @PutMapping("{id}")
    public Jogo editar(@PathVariable("id") int id, @RequestBody Jogo jogo) {
        return jogoGerenciador.editar(id, jogo);
    }

    @PostMapping
    public Jogo criar(@Validated @RequestBody Jogo novoJogo) {
        return jogoGerenciador.salvar(novoJogo);
    }

    @DeleteMapping("{id}")
    public boolean deletar(@PathVariable("id") int id) {
        return jogoGerenciador.deletar(id);
    }
}

