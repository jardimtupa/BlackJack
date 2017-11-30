package GerenciadorCartas;

import java.util.ArrayList;

/**
 *
 * @author Mlaker and the people
 */
public class GerenciarJogo {

    private final ArrayList<Jogador> jogadores;

    public GerenciarJogo() {
        this.jogadores = new ArrayList<>();
    }

    public void adicionarJogardor(Jogador novoJogador) {
        this.jogadores.add(novoJogador);
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public boolean vencedorRodada() {
        boolean retorno = false;
        int vecedores = 0;
        for (int i = 0; i < this.jogadores.size(); i++) {
            if (this.jogadores.get(i).getBaralhoJogador().ValordasCartas() == 21) {
                this.jogadores.get(i).setVenceu(true);
                vecedores++;
            }
        }

        if (vecedores == 1) {
            System.out.println("aki " + vecedores);
            retorno = true;
        }
        return retorno;

    }

    public boolean empateRodada() {
        boolean retorno = false;
        int vecedores = 0;
        for (int i = 0; i < this.jogadores.size(); i++) {
            if (this.jogadores.get(i).getBaralhoJogador().ValordasCartas() == 21) {
                this.jogadores.get(i).setVenceu(true);
                vecedores++;

            }

        }
        if (vecedores > 1) {
            retorno = true;
        }
        return retorno;

    }
//jogador 1 19
    //jogador 2 20
    //jogadore 3 20

    public char proximOVinteUm() {
        int menordiferenca = 20;
        int iguais = 0;
        char retorno = 0;
        for (int i = 0; i < this.jogadores.size(); i++) {

            if (this.jogadores.get(i).getBaralhoJogador().ValordasCartas() < 21) {
                int dif = 21 - this.jogadores.get(i).getBaralhoJogador().ValordasCartas();
                if (dif < menordiferenca) {
                    menordiferenca = dif;
                } else if (menordiferenca == dif) {
                    iguais++;
                }
            }
        }
        for (int i = 0; i < this.jogadores.size(); i++) {
            if (21 - this.jogadores.get(i).getBaralhoJogador().ValordasCartas() == menordiferenca) {
                this.jogadores.get(i).setVenceu(true);
            }
        }
        if (menordiferenca == 20) {
            retorno = 'D';
        } else if (iguais > 0) {
            retorno = 'E';
        } else if (iguais == 0 && menordiferenca != 20) {
            retorno = 'V';
        }
        return retorno;
    }

}
