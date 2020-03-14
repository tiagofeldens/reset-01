public class Druida {

    String nome;
    int vida;
    int ataque;
    int defesa;
    int fe;

    public Druida(String nome, int vida, int ataque, int defesa, int fe) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.fe = fe;
    }


    int atacar(Guerreiro atacado, PoderDivino poderDivinoUtilizado) {
        int dano = poderDivinoUtilizado.intensidade * ataque - atacado.defesa;
        if (this.fe < poderDivinoUtilizado.custoDeFe) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.fe > poderDivinoUtilizado.custoDeFe) {
            this.fe = fe - poderDivinoUtilizado.custoDeFe;
        }
        ;

        return dano;
    }

    int atacar(Barbaro atacado, PoderDivino poderDivinoUtilizado) {
        int dano = poderDivinoUtilizado.intensidade * ataque - atacado.defesa;
        if (this.fe < poderDivinoUtilizado.custoDeFe) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.fe > poderDivinoUtilizado.custoDeFe) {
            this.fe = fe - poderDivinoUtilizado.custoDeFe;
        }
        ;

        return dano;
    }

    int atacar(Mago atacado, PoderDivino poderDivinoUtilizado) {
        int dano = poderDivinoUtilizado.intensidade * ataque - atacado.defesa;
        if (this.fe < poderDivinoUtilizado.custoDeFe) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.fe > poderDivinoUtilizado.custoDeFe) {
            this.fe = fe - poderDivinoUtilizado.custoDeFe;
        }
        ;

        return dano;
    }

    int atacar(Feiticeiro atacado, PoderDivino poderDivinoUtilizado) {
        int dano = poderDivinoUtilizado.intensidade * ataque - atacado.defesa;
        if (this.fe < poderDivinoUtilizado.custoDeFe) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.fe > poderDivinoUtilizado.custoDeFe) {
            this.fe = fe - poderDivinoUtilizado.custoDeFe;
        }
        ;

        return dano;
    }

    int atacar(Clerigo atacado, PoderDivino poderDivinoUtilizado) {
        int dano = poderDivinoUtilizado.intensidade * ataque - atacado.defesa;
        if (this.fe < poderDivinoUtilizado.custoDeFe) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.fe > poderDivinoUtilizado.custoDeFe) {
            this.fe = fe - poderDivinoUtilizado.custoDeFe;
        }
        ;

        return dano;
    }

    int atacar(Druida atacado, PoderDivino poderDivinoUtilizado) {
        int dano = poderDivinoUtilizado.intensidade * ataque - atacado.defesa;
        if (this.fe < poderDivinoUtilizado.custoDeFe) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.fe > poderDivinoUtilizado.custoDeFe) {
            this.fe = fe - poderDivinoUtilizado.custoDeFe;
        }
        ;

        return dano;
    }
}