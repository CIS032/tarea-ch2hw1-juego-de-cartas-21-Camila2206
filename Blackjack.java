/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

import java.util.Scanner;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Blackjack {

    static Calendar calendario = Calendar.getInstance();
    static String cad = calendario.get(Calendar.YEAR) + "/" + (calendario.get(Calendar.MONTH) + 1)
            + "/" + calendario.get(Calendar.DAY_OF_MONTH) + "\n";
    static String salida = "";

    static boolean playBlackjack() {
        Scanner scan = new Scanner(System.in);

        Baraja baraja;                  // A deck of cards.  A new deck for each game.
        BlackjackMano manoRepartidor;   // The dealer's hand.
        BlackjackMano manoJugador;     // The user's hand.

        baraja = new Baraja();
        manoRepartidor = new BlackjackMano();
        manoJugador = new BlackjackMano();

        
        baraja.barajar();
        manoRepartidor.añadirCarta(baraja.cartaIntercambio());
        manoRepartidor.añadirCarta(baraja.cartaIntercambio());
        manoJugador.añadirCarta(baraja.cartaIntercambio());
        manoJugador.añadirCarta(baraja.cartaIntercambio());

        Blackjack.cad += "\n";
        Blackjack.cad += "\n";

        System.out.println();
        System.out.println();

        /* Check if one of the players has Blackjack (two cards totaling to 21).
         The player with Blackjack wins the game.  Dealer wins ties.
         */
        if (manoRepartidor.getBlackjackValor() == 21) {
//            JOptionPane.showMessageDialog(null, "El repartidor tiene el:" + manoRepartidor.getCarta(0) + "  y el" + manoRepartidor.getCarta(1) + ".");
            System.out.println("El repartidor tiene el: " + manoRepartidor.getCarta(0) + " y el: " + manoRepartidor.getCarta(1) + ".");
//            JOptionPane.showMessageDialog(null, "El juga tiene:" + manoJugador.getCarta(0) + "  y el:" + manoJugador.getCarta(1));
            System.out.println("El juga tiene: " + manoJugador.getCarta(0)
                    + " y el" + manoJugador.getCarta(1) + ".");

//            JOptionPane.showMessageDialog(null, "El repartidor tiene Blackjack \nEl repartidor gana");
            System.out.println();
            System.out.println("El repartidor tiene Blackjack. El repartidor gana");
            Blackjack.cad += ("El repartidor tiene el: " + manoRepartidor.getCarta(0) + " y el: " + manoRepartidor.getCarta(1) + ".");
            Blackjack.cad += ("El juga tiene: " + manoJugador.getCarta(0)
                    + " y el" + manoJugador.getCarta(1) + ".");
            Blackjack.cad += "\n";
            Blackjack.cad += ("El repartidor tiene Blackjack. El repartidor gana");
            return false;
        }

        if (manoJugador.getBlackjackValor() == 21) {
//            JOptionPane.showMessageDialog(null, "El repartidor tiene el:" + manoRepartidor.getCarta(0) + "  y el:" + manoRepartidor.getCarta(1) + ".");
            System.out.println("El repartidor tiene el: " + manoRepartidor.getCarta(0)
                    + " y el: " + manoRepartidor.getCarta(1) + ".");

//            JOptionPane.showMessageDialog(null, "El jugador tiene:" + manoJugador.getCarta(0) + "  y el: " + manoJugador.getCarta(1) + ".");
            System.out.println("\"El jugador tiene: " + manoJugador.getCarta(0)
                    + " y el:" + manoJugador.getCarta(1) + ".");
            System.out.println();

//            JOptionPane.showMessageDialog(null, "Tu tienes Blackjack\n Tú ganaste");
            System.out.println("Tu tienes Blackjack. Tú ganaste");
            Blackjack.cad += ("El repartidor tiene el: " + manoRepartidor.getCarta(0)
                    + " y el: " + manoRepartidor.getCarta(1) + ".");
            Blackjack.cad += ("\"El jugador tiene: " + manoJugador.getCarta(0)
                    + " y el:" + manoJugador.getCarta(1) + ".");
            Blackjack.cad += "\n";
            Blackjack.cad += ("Tu tienes Blackjack. Tú ganaste");
            return true;
        }

        /*  If neither player has Blackjack, play the game.  First the user 
          gets a chance to draw cards (i.e., to "Hit").  The while loop ends 
          when the user chooses to "Stand".  If the user goes over 21,
          the user loses immediately.
         */
        while (true) {

            /* Display user's cards, and let user decide to Hit or Stand. */
            System.out.println();
            System.out.println();
            Blackjack.cad += "\n";
            Blackjack.cad += "\n";
//            JOptionPane.showMessageDialog(null, "Tu cartas son:");
            System.out.println("Tu cartas son:");
            Blackjack.cad += "Tu cartas son:";

            for (int i = 0; i < manoJugador.getConteoCarta(); i++) {
//              JOptionPane.showMessageDialog(null, "   " + manoJugador.getCarta(i));
                System.out.println("    " + manoJugador.getCarta(i));
                Blackjack.cad += "    " + manoJugador.getCarta(i) + "\n";

            }
//            JOptionPane.showMessageDialog(null, "Tu total es:" + manoJugador.getBlackjackValor());
            System.out.println("Tu total es: " + manoJugador.getBlackjackValor());
            Blackjack.cad += ("Tu total es: " + manoJugador.getBlackjackValor());
            System.out.println();
            Blackjack.cad += "\n";

//            JOptionPane.showMessageDialog(null, "El repartidor muestra el: " + manoRepartidor.getCarta(0));
            System.out.println("El repartidor muestra el: " + manoRepartidor.getCarta(0));
            Blackjack.cad += ("El repartidor muestra el: " + manoRepartidor.getCarta(0));
            System.out.println();
            Blackjack.cad += "\n";
//            JOptionPane.showInputDialog(null, "¿Lanzar (L) o Permanecer (P)?");
            System.out.print("¿Lanzar (L) o Permanecer (P)? ");
            Blackjack.cad += ("¿Lanzar (L) o Permanecer (P)? ");
            char userAction;  // User's response, 'H' or 'S'.
            do {
                String ent = scan.next();
                userAction = Character.toUpperCase(scan.next().charAt(0));
                Blackjack.cad += ent + "\n";
                if (userAction != 'L' && userAction != 'P') {
//                    JOptionPane.showInputDialog(null, "Por favor respone L o P:");
                    System.out.print("Por favor respone L o P:  ");
                    Blackjack.cad += ("Por favor respone L o P:  ");
                }
            } while (userAction != 'L' && userAction != 'P');

            /* If the user Hits, the user gets a card.  If the user Stands,
              the loop ends (and it's the dealer's turn to draw cards).
             */
            if (userAction == 'P') {
                // Loop ends; user is done taking cards.
                break;
            } else {  // userAction is 'H'.  Give the user a card.  
                // If the user goes over 21, the user loses.
                Carta newCard = baraja.cartaIntercambio();
                manoJugador.añadirCarta(newCard);
                System.out.println();
//                JOptionPane.showMessageDialog(null, "Lanzamientos de usuario.\nTu carta es" + newCard);
                System.out.println("Lanzamientos de usuario.");
                System.out.println("Tu carta es " + newCard);
//                JOptionPane.showMessageDialog(null, "Tu total  ahora es:" + manoJugador.getBlackjackValor());
                System.out.println("Tu total  ahora es: " + manoJugador.getBlackjackValor());
                Blackjack.cad += "\n";
                Blackjack.cad += ("Lanzamientos de usuario.");
                Blackjack.cad += ("Tu carta es " + newCard);
                Blackjack.cad += ("Tu total  ahora es: " + manoJugador.getBlackjackValor());

                if (manoJugador.getBlackjackValor() > 21) {
                    System.out.println();

                    System.out.println("Fracasaste por sobrepasar los 21.  Tu perdiste.");

                    System.out.println("La otra carta del repartidor era:"
                            + manoRepartidor.getCarta(1));
                    Blackjack.cad += "\n";
                    Blackjack.cad += ("Fracasaste por sobrepasar los 21.  Tu perdiste.\n");
                    Blackjack.cad += ("La otra carta del repartidor era:"
                            + manoRepartidor.getCarta(1) + "\n");

                    return false;
                }
            }

        } 

        
        System.out.println();
        Blackjack.cad += "\n";


        System.out.println("Jugador permanece");
        Blackjack.cad += ("Jugador permanece");


        System.out.println("Las cartas del repartidor son:");
        System.out.println("    " + manoRepartidor.getCarta(0));
        System.out.println("    " + manoRepartidor.getCarta(1));

        Blackjack.cad += ("Las cartas del repartidor son:\n");
        Blackjack.cad += ("    " + manoRepartidor.getCarta(0) + "\n");
        Blackjack.cad += ("    " + manoRepartidor.getCarta(1) + "\n");

        while (manoRepartidor.getBlackjackValor() <= 16) {
            Carta newCard = baraja.cartaIntercambio();
//            JOptionPane.showMessageDialog(null, "El repartidor lanza y obtiene: " + newCard);
            System.out.println("El repartidor lanza y obtiene: " + newCard);
            manoRepartidor.añadirCarta(newCard);
            Blackjack.cad += ("El repartidor lanza y obtiene: " + newCard + "\n");
            manoRepartidor.añadirCarta(newCard);
            if (manoRepartidor.getBlackjackValor() > 21) {
                System.out.println();
                Blackjack.cad += "\n";
//                JOptionPane.showMessageDialog(null, "El repartidor sobrepaso los 21.\nTu ganas");
                System.out.println("El repartidor sobrepaso los 21.  Tu ganas");
                Blackjack.cad += ("El repartidor sobrepaso los 21.  Tu ganas");
                return true;
            }
        }
//        JOptionPane.showMessageDialog(null, "El total del repartidor es:" + manoRepartidor.getBlackjackValor());
        System.out.println("El total del repartidor es: " + manoRepartidor.getBlackjackValor());
        Blackjack.cad += ("El total del repartidor es: " + manoRepartidor.getBlackjackValor());

        /* If we get to this point, both players have 21 or less.  We
         can determine the winner by comparing the values of their hands. */
        System.out.println();
        Blackjack.cad += "\n";

        if (manoRepartidor.getBlackjackValor() == manoJugador.getBlackjackValor()) {
//            JOptionPane.showMessageDialog(null, "El repartidor gana con empate\nTu pierdes");
            System.out.println("El repartidor gana con empate.  Tu pierdes");
            Blackjack.cad += ("El repartidor gana con empate.  Tu pierdes");
            return false;
        } else if (manoRepartidor.getBlackjackValor() > manoJugador.getBlackjackValor()) {
//            JOptionPane.showMessageDialog(null, "El repartidor gana" + manoRepartidor.getBlackjackValor() + " frente a:" + manoJugador.getBlackjackValor() + ".");
            System.out.println("El repartidor gana" + manoRepartidor.getBlackjackValor() + " frente a:" + manoJugador.getBlackjackValor() + ".");
            Blackjack.cad += ("El repartidor gana" + manoRepartidor.getBlackjackValor() + " frente a:" + manoJugador.getBlackjackValor() + ".");
            return false;
        } else {
//            JOptionPane.showMessageDialog(null, "Tu ganas" + manoJugador.getBlackjackValor() + " frente a:" + manoRepartidor.getBlackjackValor() + ".");
            System.out.println("Tu ganas" + manoJugador.getBlackjackValor() + " frente a:" + manoRepartidor.getBlackjackValor() + ".");
            Blackjack.cad += ("Tu ganas" + manoJugador.getBlackjackValor() + " frente a:" + manoRepartidor.getBlackjackValor() + ".");
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dinero;          // Amount of money the user has.
        int apuesta;            // Amount user bets on a game.
        boolean resultadoJuego;   // Did the user win the game?

//        JOptionPane.showMessageDialog(null, "Bienvenido al juego de Blackjack");
        System.out.println("Bienvenido al juego de Blackjack");
        System.out.println();
        Blackjack.cad += "Bienvenido al juego";
        Blackjack.cad += "\n";
        dinero = 100;  // User starts with $100.

        while (true) {
//            JOptionPane.showMessageDialog(null, "Tu tienes:" + dinero + " dolares");
            System.out.println("Usted tiene " + dinero + " dolares.");
            Blackjack.cad += ("Usted tiene " + dinero + " dolares.");
            do {
//                JOptionPane.showInputDialog(null, "¿Cuanto diner quieres apostar?\n (Ingresa  0 para finalizar)");
                System.out.println("¿Cuanto diner quieres apostar??  (Ingresa  0 para finalizar.\n)");
                System.out.print("? ");
                apuesta = scan.nextInt();
                Blackjack.cad += "¿Cuanto diner quieres apostar?? (Ingresa 0 para finalizar)\n";
                Blackjack.cad += apuesta + "\n";
                if (apuesta < 0 || apuesta > dinero) {
//                    JOptionPane.showMessageDialog(null, "Su respuesta debe ser entre 0 y " + dinero + ".");
                    System.out.println("Su respuesta debe ser entre 0 y " + dinero + '.');
                    Blackjack.cad += "Su respuesta debe ser entre 0 y " + dinero + ".";
                }
            } while (apuesta < 0 || apuesta > dinero);
            if (apuesta == 0) {
                break;
            }
            resultadoJuego = playBlackjack();
            if (resultadoJuego) {
                dinero = dinero + apuesta;
            } else {
                dinero = dinero - apuesta;
            }
            System.out.println();
            Blackjack.cad += "\n";
            if (dinero == 0) {
//                JOptionPane.showMessageDialog(null, "\nParece que te has quedado sin dinero!!");
                System.out.println("Parece que te has quedado sin dinero!!");
                Blackjack.cad += "Parece que te has quedado sin dinero!!";
                break;
            }
        }

        System.out.println();
//        JOptionPane.showMessageDialog(null, " Te vas con: $" + dinero + ".");
        System.out.println("Te vas con: $" + dinero + ".");
        Blackjack.cad += "Te vas con: $" + dinero + ".";
        Blackjack.cad += "\n";
        BlackjackLogs blackjackLogs = new BlackjackLogs(cad);

    }

}
