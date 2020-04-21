package br.com.cwi.tinderevolution.gerenciador;



import br.com.cwi.tinderevolution.Banco.CuriosidadeBanco;
import br.com.cwi.tinderevolution.dominio.Curiosidade;

import java.util.List;

public class CuriosidadeGerenciador {


    public CuriosidadeBanco banco = new CuriosidadeBanco();


    public Curiosidade salvar(Curiosidade curiosidade) {
        List<Curiosidade> curiosidades = banco.listar();

        if (curiosidade.descricao.isEmpty() || curiosidade.categoria == null) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        }

        for (Curiosidade curiosidadeExistente : curiosidades) {
            if (curiosidade.descricao.equals(curiosidadeExistente.descricao)) {
                return curiosidadeExistente;
            }
        }
        return banco.salvar(curiosidade);
    }

    public List<Curiosidade> listar() {
        return banco.listar();
    }

    public Curiosidade procurar(int id) {
        if (id > 0) {
            return banco.procurar(id);
        }
        return null;
    }

    public Curiosidade editar(int id, Curiosidade curiosidadeAtualizada) {
        List<Curiosidade> curiosidades = banco.listar();
        Curiosidade curiosidadeExistente = procurar(id);
        if (curiosidadeExistente == null) {
            return null;
        }

        if (curiosidadeAtualizada.descricao.isEmpty() || curiosidadeAtualizada.categoria == null) {
            System.out.println("Campos obrigatórios não foram preenchidos.");
            return null;
        } else {
            for (Curiosidade curiosidade : curiosidades) {
                if (curiosidadeAtualizada.descricao.equals(curiosidade.descricao) && curiosidadeAtualizada.id != curiosidade.id) {
                    return curiosidadeAtualizada;
                }
            }
            return banco.editar(curiosidadeExistente, curiosidadeAtualizada);

        }
    }

    public boolean deletar(int id) {
        if (id > 0) {
            return banco.deletar(id);
        }
        return false;
    }

}
