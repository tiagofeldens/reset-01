import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class App {
    public static void main(String[] args) {

        Arma machado = new Arma("machado", 3);
        Arma espada = new Arma("espada", 4);
        Magia bolaDeFogo = new Magia("bola de fogo", 2, 4);
        Magia cogumeloSonifero = new Magia("cogumelo sonifero", 2, 4);
        PoderDivino armaEspiritual = new PoderDivino("arma espiritual", 2, 2);
        PoderDivino rajadaDeFe = new PoderDivino("rajada De fé", 3, 5);
        Guerreiro ramza = new Guerreiro("Ramza", 100, 17, 4);
        Barbaro ragnar = new Barbaro("Ragnar", 100, 18, 3);
        Mago floki = new Mago("Floki", 100, 15, 2, 50);
        Feiticeiro bjorn = new Feiticeiro("Bjorn", 100, 16, 2, 45);
        Druida rollo = new Druida("Rollo", 100, 13, 1, 40);
        Clerigo athelstein = new Clerigo("Athelstein", 100, 13, 1, 35);

        //primeiro ataque
        if (ramza.vida > 0) {
            int dano = ramza.atacar(ragnar, machado);
            System.out.println(ramza.nome + " atacou " + ragnar.nome + " com o " + machado.nome + " causando dano de " + dano);
            if (ragnar.vida == 0) {
                System.out.println(ragnar.nome + " morreu!");
            }
        } else {
            System.out.println(ramza.nome + " tentou atacar " + ragnar.nome + " mas está morto.");
            if (floki.vida > 0) {
                int dano = floki.atacar(rollo, cogumeloSonifero);
                System.out.println(floki.nome + " atacou " + rollo.nome + " com o " + cogumeloSonifero.nome + " causando dano de " + dano);
                if (rollo.vida == 0) {
                    System.out.println(rollo.nome + " morreu!");
                }
            } else {
                System.out.println(floki.nome + " tentou atacar " + rollo.nome + " mas está morto.");
            }
        }

        //segundo ataque
        if (rollo.vida > 0) {
            int dano = rollo.atacar(athelstein, armaEspiritual);
            System.out.println(rollo.nome + " atacou " + athelstein.nome + " com o " + armaEspiritual.nome + " causando dano de " + dano);
            if (athelstein.vida == 0) {
                System.out.println(athelstein.nome + " morreu!");
            }
        }
        else {
            System.out.println(rollo.nome + " tentou atacar " + athelstein.nome + " mas está morto.");
        }

        //terceiro ataque
        if (ragnar.vida > 0) {
            int dano = ragnar.atacar(floki, machado);
            System.out.println(ragnar.nome + " atacou " + floki.nome + " com o " + machado.nome + " causando dano de " + dano);
            if (floki.vida == 0) {
                System.out.println(floki.nome + " morreu!");
            }
        } else {
            System.out.println(ragnar.nome + " tentou atacar " + floki.nome + " mas está morto.");
        }

        //quarto ataque
        if (ragnar.vida > 0) {
            int dano = ragnar.atacar(bjorn, espada);
            System.out.println(ragnar.nome + " atacou " + bjorn.nome + " com o " + espada.nome + " causando dano de " + dano);
            if (bjorn.vida == 0) {
                System.out.println(bjorn.nome + " morreu!");
            }
        } else {
            System.out.println(ragnar.nome + " tentou atacar " + bjorn.nome + " mas está morto.");
        }

        //quinto ataque

        //sexto ataque
        if (floki.vida > 0) {
            int dano = floki.atacar(bjorn, bolaDeFogo);
            System.out.println(floki.nome + " atacou " + bjorn.nome + " com o " + bolaDeFogo.nome + " causando dano de " + dano);
            if (bjorn.vida == 0) {
                System.out.println(bjorn.nome + " morreu!");
            }
        }
        else {
            System.out.println(floki.nome + " tentou atacar " + bjorn.nome + " mas está morto.");
        }

        //sétimo ataque
        if (bjorn.vida > 0) {
            int dano = bjorn.atacar(rollo, cogumeloSonifero);
            System.out.println(bjorn.nome + " atacou " + rollo.nome + " com o " + cogumeloSonifero.nome + " causando dano de " + dano);
            if (rollo.vida == 0) {
                System.out.println(rollo.nome + " morreu!");
            }
        }
        else {
            System.out.println(bjorn.nome + " tentou atacar " + rollo.nome + " mas está morto.");
        }

        //oitavo ataque
        if (bjorn.vida > 0) {
            int dano = bjorn.atacar(athelstein, bolaDeFogo);
            System.out.println(bjorn.nome + " atacou " + athelstein.nome + " com o " + bolaDeFogo.nome + " causando dano de " + dano);
            if (athelstein.vida == 0) {
                System.out.println(athelstein.nome + " morreu!");
            }
        }
        else {
            System.out.println(bjorn.nome + " tentou atacar " + athelstein.nome + " mas está morto.");
        }

        //nono ataque
        if (ramza.vida > 0) {
            int dano = ramza.atacar(floki, espada);
            System.out.println(ramza.nome + " atacou " + floki.nome + " com o " + espada.nome + " causando dano de " + dano);
            if (floki.vida == 0) {
                System.out.println(floki.nome + " morreu!");
            }
        } else {
            System.out.println(ramza.nome + " tentou atacar " + floki.nome + " mas está morto.");
        }

        //decimo ataque
        if (rollo.vida > 0) {
            int dano = rollo.atacar(ramza, rajadaDeFe);
            System.out.println(rollo.nome + " atacou " + ramza.nome + " com o " + rajadaDeFe.nome + " causando dano de " + dano);
            if (ramza.vida == 0) {
                System.out.println(ragnar.nome + " morreu!");
            }
        }
        else {
            System.out.println(rollo.nome + " tentou atacar " + ramza.nome + " mas está morto.");
        }

        //decimo primeiro ataque
        if (athelstein.vida > 0) {
            int dano = athelstein.atacar(ragnar, armaEspiritual);
            System.out.println(athelstein.nome + " atacou " + ragnar.nome + " com o " + armaEspiritual.nome + " causando dano de " + dano);
            if (ragnar.vida == 0) {
                System.out.println(ragnar.nome + " morreu!");
            }
        }
        else {
            System.out.println(athelstein.nome + " tentou atacar " + ragnar.nome + " mas está morto.");
        }

        //decimo segundo ataque
        if (athelstein.vida > 0) {
            int dano = athelstein.atacar(ramza, rajadaDeFe);
            System.out.println(athelstein.nome + " atacou " + ramza.nome + " com o " + ramza.nome + " causando dano de " + dano);
            if (ramza.vida == 0) {
                System.out.println(ramza.nome + " morreu!");
            }
        }
        else {
            System.out.println(athelstein.nome + " tentou atacar " + ramza.nome + " mas está morto.");
        }

        //decimo terceiro ataque (simulando ataque em vítima já morta)
        if (ramza.vida > 0) {
            if (floki.vida > 0){
            int dano = ramza.atacar(floki, espada);
            System.out.println(ramza.nome + " atacou " + floki.nome + " com o " + espada.nome + " causando dano de " + dano);
            if (floki.vida == 0) {
                System.out.println(floki.nome + " morreu!");
            }}
            else {
                System.out.println(ramza.nome + " tentou atacar " + floki.nome + " mas " + floki.nome + " já está morto.");
            }
        } else {
            System.out.println(ramza.nome + " tentou atacar " + floki.nome + " mas está morto.");
        }

        //decimo quarto ataque (simulando ataque com atacante já morto)
        if (floki.vida > 0) {
            int dano = floki.atacar(ragnar, cogumeloSonifero);
            System.out.println(floki.nome + " atacou " + ragnar.nome + " com o " + cogumeloSonifero.nome + " causando dano de " + dano);
            if (ragnar.vida == 0) {
                System.out.println(ragnar.nome + " morreu!");
            }
        } else {
            System.out.println(floki.nome + " tentou atacar " + ragnar.nome + " mas está morto.");
        }


        System.out.println("Final de combate:");
        System.out.println(ramza.nome + " ficou com " + ramza.vida + " de vida ");
        System.out.println(ragnar.nome + " ficou com " + ragnar.vida + " de vida ");
        System.out.println(floki.nome + " ficou com " + floki.vida + " de vida e com " + floki.mana + " de mana");
        System.out.println(bjorn.nome + " ficou com " + bjorn.vida + " de vida e com " + bjorn.mana + " de mana");
        System.out.println(rollo.nome + " ficou com " + rollo.vida + " de vida e com " + rollo.fe + " de fé");
        System.out.println(athelstein.nome + " ficou com " + athelstein.vida + " de vida e com " + athelstein.fe + " de fé");

    }
}
