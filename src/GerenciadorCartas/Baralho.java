package GerenciadorCartas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mlaker and people
 */
public class Baralho {

    private ArrayList<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
    }

    //Gera um baralho de 52 cartas
    public void CriarBaralho() {

        //"Paus"
        for (int i = 0; i < 13; i++) {
            //adiciona a carta com naipe, o valor dela 
            this.cartas.add(new Carta(Valor.retornoV(i), Naipe.PAUS));
        }
        //"Ouros
        for (int i = 0; i < 13; i++) {
            //adiciona a carta com naipe, o valor dela 
            this.cartas.add(new Carta(Valor.retornoV(i), Naipe.OUROS));
        }
        //"Copas"
        for (int i = 0; i < 13; i++) {
            //adiciona a carta com naipe, o valor dela 
            this.cartas.add(new Carta(Valor.retornoV(i), Naipe.COPAS));
        }
        // "Espadas"
        for (int i = 0; i < 13; i++) {
            //adiciona a carta com naipe, o valor dela 
            this.cartas.add(new Carta(Valor.retornoV(i), Naipe.ESPADAS));
        }
    }

    public void Embaralhar() {
        //cria um baralho de cartas temporario
        ArrayList<Carta> temp = new ArrayList<>();
        Random r = new Random();
        int randomCarIndice;
        int tamanhoOriginal = this.cartas.size();
        for (int i = 0; i < tamanhoOriginal; i++) {
            randomCarIndice = r.nextInt(this.cartas.size());
            //adiciona a carta ao temporário com uma carta aleatoria do baralho atual
            temp.add(this.cartas.get(randomCarIndice));
            this.cartas.remove(randomCarIndice);
        }
        this.cartas = temp;
    }

    public Carta pegarCarta(int i) {
        return this.cartas.get(i);
    }

    public void adicionarCarta(Carta carta) {
        this.cartas.add(carta);
    }

    public void removerCarta(int i) {
        this.cartas.remove(i);
    }

    public void tirarCartaBaralho(Baralho origem) {
        this.cartas.add(origem.pegarCarta(0));
        origem.removerCarta(0);
    }

    public int ValordasCartas() {
        int totalValorCartas = 0;
        int ases = 0;

        for (Carta carta : cartas) {
            switch (carta.getValordaCarta()) {
                case DOIS:
                    totalValorCartas += 2;
                    break;
                case TRES:
                    totalValorCartas += 3;
                    break;
                case QUATRO:
                    totalValorCartas += 4;
                    break;
                case CINCO:
                    totalValorCartas += 5;
                    break;
                case SEIS:
                    totalValorCartas += 6;
                    break;
                case SETE:
                    totalValorCartas += 7;
                    break;
                case OITO:
                    totalValorCartas += 8;
                    break;
                case NOVE:
                    totalValorCartas += 9;
                    break;
                case DEZ:
                    totalValorCartas += 10;
                    break;
                case VALETE:
                    totalValorCartas += 10;
                    break;
                case RAINHA:
                    totalValorCartas += 10;
                    break;
                case REI:
                    totalValorCartas += 10;
                    break;
                case AS:
                    ases += 1;
                    break;
            }
        }
        for (int i = 0; i < ases; i++) {
            if (totalValorCartas > 10) {
                totalValorCartas += 1;
            } else {
                totalValorCartas += 11;
            }
        }
        return totalValorCartas;
    }

    public String imprimirCartas() {
        String retorno = "";
        for (int i = 0; i < this.cartas.size(); i++) {
            retorno += i + " - " + this.cartas.get(i).getValordaCarta() + " de " + this.cartas.get(i).getNaipe() + "\n";
        }
        return retorno;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

}
