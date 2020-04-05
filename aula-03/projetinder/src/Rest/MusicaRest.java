package Rest;

import gerenciador.MusicaGerenciador;

import javax.xml.ws.RequestWrapper;

@RestController
@RequestMapping("musicas")

public class MusicaRest {
    MusicaGerenciador musicaGerenciador = new MusicaGerenciador();

    @GetMapping
    public musicaGerenciador.listar;

    @GetMapping("{id}")
    public musicaGerenciador.procurar;

    @PostMapping
    public musicaGerenciador.salvar;

    @DeleteMapping
    public musicaGerenciador.deletar;

    @PutMapping
    public musicaGerenciador.editar;

}
