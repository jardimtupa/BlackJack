package GerenciadorCartas;

/**
 *
 * @author Mlaker and the people
 */
public class Carta {

    private Valor valordaCarta; //2..10 OU 1/11
    private Naipe naipe;

    public Carta() {
    }

    public Carta(Valor valordaCarta, Naipe naipe) {
        this.valordaCarta = valordaCarta;
        this.naipe = naipe;

    }

    public Valor getValordaCarta() {
        return valordaCarta;
    }

    public void setValordaCarta(Valor valordaCarta) {
        this.valordaCarta = valordaCarta;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    }

    public String imprimirCarta() {
        String retorno = "";
        switch (this.getNaipe()) {
            case PAUS:
                retorno += this.valordaCarta + " DE " + this.naipe + " ♣";
                break;
            case OUROS:
                retorno += this.valordaCarta + " DE " + this.naipe + " ♦";
                break;
            case COPAS:
                retorno += this.valordaCarta + " DE " + this.naipe + " ♥";
                break;
            case ESPADAS:
                retorno += this.valordaCarta + " DE " + this.naipe + " ♠";
                break;
        }
        return retorno;
    }

}
