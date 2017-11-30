package GerenciadorCartas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mlaker and the people
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean sair = true;
        while (sair) {
            System.out.println("♦♣BLACKJACK♠♥");
            System.out.println("*******************");
            System.out.println("(1)INICIAR JOGO");
            System.out.println("(2)SAIR");
            System.out.println("*******************");
            System.out.print("(?): ");
            int resp = 0;
            try {
                resp = entradaInt();
            } catch (InputMismatchException ex) {
                System.out.println("Opção inválida!");
                System.out.println("\n");
            }
            switch (resp) {
                case 1:
                    boolean sair2 = true;
                    while (sair2) {
                        //iniciar jogo
                        System.out.println("");
                        System.out.println("*******************");
                        System.out.println("Quantos jogadores:");
                        System.out.println("(1)2 Jogadores");
                        System.out.println("(2)3 Jogadores");
                        System.out.println("(3)4 Jogadores");
                        System.out.println("(4)SAIR");
                        System.out.println("*******************");
                        System.out.print("(?): ");
                        int resp2 = 0;
                        try {
                            resp2 = entradaInt();
                        } catch (InputMismatchException ex) {
                            System.out.println("Opção inválida!");
                            System.out.println("\n");
                        }

                        switch (resp2) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                String raking = "";
                                int vezes = 2;
                                boolean primeiraVez = true;
                                for (int i = 0; i < vezes; i++) {

                                    GerenciarJogo gere = new GerenciarJogo();
                                    Baralho baralhoPrin = new Baralho();
                                    baralhoPrin.CriarBaralho();
                                    baralhoPrin.Embaralhar();
                                    // cria os jogadores
                                    int numjog = resp2 + 1;
                                    for (int m = 0; m < numjog; m++) {//VARIALVEL
                                        gere.adicionarJogardor(new Jogador(new Baralho()));
                                    }
                                    if (primeiraVez) {
                                        Raking.setJogadores(gere.getJogadores());
                                        primeiraVez = false;
                                    }
                                    //inicia com duas cartas para todos os jogadores
                                    for (int carta = 0; carta < gere.getJogadores().size(); carta++) {
                                        gere.getJogadores().get(carta).getBaralhoJogador().tirarCartaBaralho(baralhoPrin);
                                        gere.getJogadores().get(carta).getBaralhoJogador().tirarCartaBaralho(baralhoPrin);
                                    }

                                    //validação
                                    boolean validacao = true;

                                    while (validacao) {

                                        for (int v = 0; v < gere.getJogadores().size(); v++) {

                                            for (int s = 0; s < 20; s++) {
                                                System.out.println("*");
                                            }
                                            char cont1 = 0;
                                            //espera o jogador 1 iniciar
                                            while (cont1 == 0) {
                                                int num = v + 1;
                                                System.out.println("Vez do Jogador " + num + "");
                                                System.out.println("Digite qualquer letra para continuar...");
                                                try {
                                                    cont1 = entradaString().charAt(0);
                                                } catch (StringIndexOutOfBoundsException ex) {
                                                    cont1 = 's';
                                                }
                                            }
                                            //imprimi as cartas do jogador
                                            System.out.println("Suas Cartas:");
                                            for (int j = 0; j < gere.getJogadores().get(v).getBaralhoJogador().getCartas().size(); j++) {
                                                System.out.println("[" + gere.getJogadores().get(v).getBaralhoJogador().getCartas().get(j).imprimirCarta() + "]");
                                            }
                                            System.out.println("Valor atual das suas cartas: " + gere.getJogadores().get(v).getBaralhoJogador().ValordasCartas());
                                            System.out.println("O que deseja fazer? ");

                                            boolean f = true;
                                            int fazer = 0;
                                            System.out.println("(1)NOVA CARTA");
                                            System.out.println("(2)MANTER");

                                            while (f) {
                                                System.out.print("(?):");
                                                try {
                                                    fazer = entradaInt();
                                                } catch (InputMismatchException ex) {

                                                }

                                                switch (fazer) {
                                                    case 1:
                                                        //nova carta
                                                        gere.getJogadores().get(v).getBaralhoJogador().tirarCartaBaralho(baralhoPrin);
                                                        f = false;
                                                        cont1 = 0;
                                                        break;
                                                    case 2:
                                                        gere.getJogadores().get(v).setContJoga(false);
                                                        f = false;
                                                        cont1 = 0;
                                                        break;
                                                    default:
                                                        System.out.println("Opção Errada");
                                                }
                                            }
                                        }
                                        //validação
                                        for (int l = 0; l < gere.getJogadores().size(); l++) {
                                            if (l == 0) {
                                                validacao = gere.getJogadores().get(l).isContJoga();
                                            } else {
                                                validacao = validacao || gere.getJogadores().get(l).isContJoga();
                                            }

                                        }
                                    }
                                    //vencedor rodada
                                    String vencedor = "";
                                    if (gere.vencedorRodada()) {
                                        for (int j = 0; j < gere.getJogadores().size(); j++) {
                                            int num = j + 1;
                                            if (gere.getJogadores().get(j).isVenceu()) {
                                                gere.getJogadores().get(j).setVenceu(false);
                                                Raking.getJogadores().get(j).setPontos(3);
                                                vencedor += "Jogador " + num + " Venceu a rodada!" + "\n"
                                                        + "Valores da cartas: " + gere.getJogadores().get(j).getBaralhoJogador().ValordasCartas();

                                            }
                                        }

                                    } else if (gere.empateRodada()) {
                                        vencedor = "Empate entre:" + "\n";
                                        for (int j = 0; j < gere.getJogadores().size(); j++) {
                                            int num = j + 1;
                                            if (gere.getJogadores().get(j).isVenceu()) {
                                                gere.getJogadores().get(j).setVenceu(false);
                                                Raking.getJogadores().get(j).setPontos(1);
                                                vencedor += "Jogador " + num + "\n"
                                                        + "Valores das cartas: " + gere.getJogadores().get(j).getBaralhoJogador().ValordasCartas()
                                                        + "\n" + "------------------------"
                                                        + "\n";
                                            }
                                        }

                                    } else {
                                        switch (gere.proximOVinteUm()) {
                                            case 'V':
                                                for (int j = 0; j < gere.getJogadores().size(); j++) {
                                                    int num = j + 1;
                                                    if (gere.getJogadores().get(j).isVenceu()) {
                                                        gere.getJogadores().get(j).setVenceu(false);
                                                        Raking.getJogadores().get(j).setPontos(3);
                                                        vencedor += "Jogador " + num + " Venceu a rodada! " + "\n"
                                                                + "Valores das cartas: " + gere.getJogadores().get(j).getBaralhoJogador().ValordasCartas();

                                                    }
                                                }
                                                break;
                                            case 'E':
                                                //empate
                                                vencedor = "Empate entre:" + "\n";
                                                for (int j = 0; j < gere.getJogadores().size(); j++) {
                                                    int num = j + 1;
                                                    if (gere.getJogadores().get(j).isVenceu()) {
                                                        gere.getJogadores().get(j).setVenceu(false);
                                                        Raking.getJogadores().get(j).setPontos(1);
                                                        vencedor += "Jogador " + num + "\n"
                                                                + "Valores das cartas: " + gere.getJogadores().get(j).getBaralhoJogador().ValordasCartas()
                                                                + "\n" + "------------------------"
                                                                + "\n";
                                                    }
                                                }
                                                break;
                                            case 'D':
                                                vencedor += "Ninguem venceu a rodada";
                                                //todos perderam
                                                break;
                                        }

                                    }
                                    for (int s = 0; s < 20; s++) {
                                        System.out.println("*");
                                    }
                                    System.out.println("***♦♣VENCEDORES DA RODADA♠♥***");
                                    System.out.println(vencedor);
                                    int cont2 = 0;

                                    while (cont2 == 0) {
                                        System.out.println("Digite qualquer letra para iniciar nova rodada...");
                                        try {
                                            cont2 = entradaString().charAt(0);
                                        } catch (StringIndexOutOfBoundsException ex) {
                                            cont2 = 's';
                                        }
                                    }

                                }
                                System.out.println("---------------------RAKING-----------------");
                                System.out.println(Raking.raking());
                                char cont3 = 0;
                                while (cont3 == 0) {
                                    System.out.println("Digite qualquer letra para ir para tela de inicio...");
                                    try {
                                        cont3 = entradaString().charAt(0);
                                    } catch (StringIndexOutOfBoundsException ex) {
                                        cont3 = 's';
                                    }
                                }
                                break;

                            case 4:
                                sair2 = false;
                            default:
                                System.out.println("Opção inválida!");
                                System.out.println("\n");
                                break;
                        }

                    }
                    break;
                case 2:
                    sair = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static String entradaString() {
        Scanner e = new Scanner(System.in);
        return e.nextLine();
    }

    public static int entradaInt() {
        Scanner e = new Scanner(System.in);
        return e.nextInt();
    }

}
