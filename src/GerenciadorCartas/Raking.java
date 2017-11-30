package GerenciadorCartas;

import java.util.ArrayList;

/**
 *
 * @author Mlaker and the people
 */
public class Raking {

    private static ArrayList<Jogador> jogadores;

    public Raking() {
        Raking.jogadores = new ArrayList<>();
    }

    public  Raking(ArrayList<Jogador> jogadores) {
        Raking.jogadores = jogadores;
    }

    public static void setJogadores(ArrayList<Jogador> jogadores) {
        Raking.jogadores = jogadores;
    }

    public static ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public static String raking() {
        String retorno = "Pontos dos Jogadores: " + "\n";
        for (int i = 0; i < Raking.jogadores.size(); i++) {
            int num = i + 1;
            retorno += "Jogador " + num + "\n"
                    + "PONTUACAO: " + Raking.jogadores.get(i).getPontos() + "\n"
                    + "---------------------------------------------" + "\n";
        }
        return retorno;
    }
}
