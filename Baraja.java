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
public class Baraja {

    /**
     * An array of 52 or 54 cards. A 54-card deck contains two Jokers, in
     * addition to the 52 cards of a regular poker deck.
     */
    private Carta[] baraja;

    /**
     * Keeps track of the number of cards that have been dealt from the deck so
     * far.
     */
    private int cartasJugador;

    /**
     * Constructs a regular 52-card poker deck. Initially, the cards are in a
     * sorted order. The shuffle() method can be called to randomize the order.
     * (Note that "new Deck()" is equivalent to "new Deck(false)".)
     */
    public Baraja() {
        this(false);  // Just call the other constructor in this class.
    }

   
    public Baraja(boolean incluirJokers) {
        if (incluirJokers) {
            baraja = new Carta[54];
        } else {
            baraja = new Carta[52];
        }
        int cardCt = 0; // How many cards have been created so far.
        for (int cojunto = 0; cojunto <= 3;cojunto++) {
            for (int valor = 1;valor <= 13; valor++) {
                baraja[cardCt] = new Carta(valor, cojunto);
                cardCt++;
            }
        }
        if (incluirJokers) {
            baraja[52] = new Carta(1, Carta.MONA);
            baraja[53] = new Carta(2, Carta.MONA);
        }
        cartasJugador = 0;
    }

    
    public void barajar() {
        for (int i = baraja.length - 1; i > 0; i--) {
            int rand = (int) (Math.random() * (i + 1));
            Carta temp = baraja[i];
            baraja[i] = baraja[rand];
            baraja[rand] = temp;
        }
        cartasJugador = 0;
    }

   
    public int cartasIzquierda() {
        return baraja.length - cartasJugador;
    }

    
    public Carta cartaIntercambio() {
        if (cartasJugador == baraja.length) {
            throw new IllegalStateException("No quedan cartas en la baraja.");
        }
        cartasJugador++;
        return baraja[cartasJugador - 1];
        
    }

   
    public boolean tieneMona() {
        return (baraja.length == 54);
    }

}
