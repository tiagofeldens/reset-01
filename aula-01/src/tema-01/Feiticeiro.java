public class Feiticeiro {

    String nome;
    int vida;
    int ataque;
    int defesa;
    int mana;

    public Feiticeiro(String nome, int vida, int ataque, int defesa, int mana) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.mana = mana;
    }

    int atacar(Clerigo atacado, Magia magiaUtilizada) {
        int dano = magiaUtilizada.poder * ataque - atacado.defesa;
        if (this.mana < magiaUtilizada.custoDeMana) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.mana > magiaUtilizada.custoDeMana) {
            this.mana = mana - magiaUtilizada.custoDeMana;
        }
        ;

        return dano;
    }

    int atacar(Druida atacado, Magia magiaUtilizada) {
        int dano = magiaUtilizada.poder * ataque - atacado.defesa;
        if (this.mana < magiaUtilizada.custoDeMana) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.mana > magiaUtilizada.custoDeMana) {
            this.mana = mana - magiaUtilizada.custoDeMana;
        }
        ;

        return dano;
    }

    int atacar(Guerreiro atacado, Magia magiaUtilizada) {
        int dano = magiaUtilizada.poder * ataque - atacado.defesa;
        if (this.mana < magiaUtilizada.custoDeMana) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.mana > magiaUtilizada.custoDeMana) {
            this.mana = mana - magiaUtilizada.custoDeMana;
        }
        ;

        return dano;
    }

    int atacar(Barbaro atacado, Magia magiaUtilizada) {
        int dano = magiaUtilizada.poder * ataque - atacado.defesa;
        if (this.mana < magiaUtilizada.custoDeMana) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.mana > magiaUtilizada.custoDeMana) {
            this.mana = mana - magiaUtilizada.custoDeMana;
        }
        ;

        return dano;
    }

    int atacar(Mago atacado, Magia magiaUtilizada) {
        int dano = magiaUtilizada.poder * ataque - atacado.defesa;
        if (this.mana < magiaUtilizada.custoDeMana) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }

        if (this.mana > magiaUtilizada.custoDeMana) {
            this.mana = mana - magiaUtilizada.custoDeMana;
        }
        ;

        return dano;
    }

    int atacar(Feiticeiro atacado, Magia magiaUtilizada) {
        int dano = magiaUtilizada.poder * ataque - atacado.defesa;
        if (this.mana < magiaUtilizada.custoDeMana) {
            dano = 0;
        }

        if (atacado.vida < dano) {
            atacado.vida = 0;
        } else {
            atacado.vida = atacado.vida - dano;
        }
        if (this.mana > magiaUtilizada.custoDeMana) {
            this.mana = mana - magiaUtilizada.custoDeMana;
        }
        ;

        return dano;
    }


}