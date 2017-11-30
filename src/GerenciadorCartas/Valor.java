package GerenciadorCartas;

/**
 *
 * @author Mlaker and the people
 */
public enum Valor {
    
    DOIS, TRES, QUATRO, CINCO, SEIS, SETE, OITO, NOVE,
    DEZ, VALETE, RAINHA, REI, AS;

    public static Valor retornoV(int carta) {
        Valor retorno = null;
        switch (carta) {
            case 0:
                retorno = AS;
                break;
            case 1:
                retorno = DOIS;
                break;
            case 2:
                retorno = TRES;
                break;
            case 3:
                retorno = QUATRO;
                break;
            case 4:
                retorno = CINCO;
                break;
            case 5:
                retorno = SEIS;
                break;
            case 6:
                retorno = SETE;
                break;
            case 7:
                retorno = OITO;
                break;
            case 8:
                retorno = NOVE;
                break;
            case 9:
                retorno = DEZ;
                break;
            case 10:
                retorno = VALETE;
                break;
            case 11:
                retorno = REI;
                break;
            case 12:
                retorno = RAINHA;
                break;
        }
        return retorno;
    }

}
