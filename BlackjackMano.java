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
public class BlackjackMano extends Mano {

    /**
     * Computes and returns the value of this hand in the game of Blackjack.
     */
    public int getBlackjackValor() {

        int valor;
        boolean as;
        int cartas;
        valor = 0;
        as = false;
        cartas = getConteoCarta();

        for (int i = 0; i < cartas; i++) {
            // Add the value of the i-th card in the hand.
            Carta carta;    // The i-th card; 
            int cardValor;  // The blackjack value of the i-th card.
            carta = getCarta(i);
            cardValor = carta.getValor();  // The normal value, 1 to 13.
            if (cardValor > 10) {
                cardValor = 10;   // For a Jack, Queen, or King.
            }
            if (cardValor == 1) {
                as = true;     // There is at least one ace.
            }
            valor = valor + cardValor;
        }

        if (as == true && valor + 10 <= 21) {
            valor = valor + 10;
        }

        return valor;

    } 

}
