/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

/**
 *
 * @author USER
 */
public class Carta {

    public final static int ESPADAS = 0;   // Codes for the 4 suits, plus Joker.
    public final static int CORAZONES = 1;
    public final static int DIAMANTES = 2;
    public final static int TREBOLES = 3;
    public final static int MONA = 4;

    public final static int AS = 1;      // Codes for the non-numeric cards.
    public final static int JACK = 11;    //   Cards 2 through 10 have their 
    public final static int REINA = 12;   //   numerical values for their codes.
    public final static int REY = 13;

   
    private final int conjunto;

    
    private final int valor;

   
    public Carta() {
        conjunto = MONA;
        valor = 1;
    }

    
    public Carta(int elValor, int elConjunto) {
        if (elConjunto != ESPADAS && elConjunto!= CORAZONES && elConjunto != DIAMANTES
                && elConjunto != TREBOLES && elConjunto != MONA) {
            throw new IllegalArgumentException("El conjunto de cartas es ilegal");
        }
        if (elConjunto != MONA && (elValor < 1 || elValor > 13)) {
            throw new IllegalArgumentException("Valor ilegal de cartas");
        }
        valor = elValor;
        conjunto = elConjunto;
    }

    
    public int getConjunto() {
        return conjunto;
    }

    
    public int getValor() {
        return valor;
    }

    
    public String getConjuntotComoString() {
        switch (conjunto) {
            case ESPADAS:
                return "Espadas";
            case CORAZONES:
                return "Corazones";
            case DIAMANTES:
                return "Diamantes";
            case TREBOLES:
                return "Treboles";
            default:
                return "Joker";
        }
    }

    
    public String getValorComoString() {
        if (conjunto == MONA) {
            return "" + valor;
        } else {
            switch (valor) {
                case 1:
                    return "As";
                case 2:
                    return "2";
                case 3:
                    return "3";
                case 4:
                    return "4";
                case 5:
                    return "5";
                case 6:
                    return "6";
                case 7:
                    return "7";
                case 8:
                    return "8";
                case 9:
                    return "9";
                case 10:
                    return "10";
                case 11:
                    return "Jack";
                case 12:
                    return "Reina";
                default:
                    return "Rey";
            }
        }
    }

  
    public String toString() {
        if (conjunto == MONA) {
            if (valor == 1) {
                return "Joker";
            } else {
                return "Joker #" + valor;
            }
        } else {
            return getValorComoString() + " de" + getConjuntotComoString();
        }
    }

}
