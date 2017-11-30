package GerenciadorCartas;

/**
 *
 * @author Mlaker and the people
 */
public class Jogador {

    private int pontos;
    private boolean contJoga;
    private boolean venceu;
    private Baralho baralhoJogador;

    public Jogador() {
        pontos = 0;
        this.baralhoJogador = new Baralho();
        contJoga = true;
        venceu = false;
    }

    public Jogador(Baralho baralhoJogador) {
        this.pontos = 0;
        this.baralhoJogador = baralhoJogador;
        contJoga = true;
        venceu = false;
    }

    public boolean isContJoga() {
        return contJoga;
    }

    public void setContJoga(boolean contJoga) {
        this.contJoga = contJoga;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos += pontos;
    }

    public Baralho getBaralhoJogador() {
        return baralhoJogador;
    }

    public void setBaralhoJogador(Baralho baralhoJogador) {
        this.baralhoJogador = baralhoJogador;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
    }

}
