/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

import java.util.Calendar;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class BlackjackGUI {

    static Calendar calen = Calendar.getInstance();
    static String logstr = calen.get(Calendar.YEAR) + "/" + (calen.get(Calendar.MONTH) + 1) + "/" + calen.get(Calendar.DAY_OF_MONTH) + "\n";
    static String mensaje = "";

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
        if (manoRepartidor.getBlackjackValor() == 21) {
            Blackjack.cad += ("El repartidor tiene el: " + manoRepartidor.getCarta(0)
                    + " y el: " + manoRepartidor.getCarta(1) + ".\n");
            Blackjack.cad += ("El juga tiene: " + manoJugador.getCarta(0)
                    + " y el" + manoJugador.getCarta(1) + ".\n");
            Blackjack.cad += "\n";
            Blackjack.cad += ("El repartidor tiene Blackjack. El repartidor gana");

            mensaje = ("El repartidor tiene el: " + manoRepartidor.getCarta(0) + " y el: " + manoRepartidor.getCarta(1) + ".");
            mensaje = ("El juga tiene: " + manoJugador.getCarta(0)
                    + " y el" + manoJugador.getCarta(1) + ".");
            mensaje = "\n";
            mensaje = ("El repartidor tiene Blackjack. El repartidor gana");
            JOptionPane.showMessageDialog(null, mensaje);
            return false;

        }

        if (manoJugador.getBlackjackValor() == 21) {
            Blackjack.cad += ("El repartidor tiene el: " + manoRepartidor.getCarta(0)
                    + " y el: " + manoRepartidor.getCarta(1) + ".");
            Blackjack.cad += ("\"El jugador tiene: " + manoJugador.getCarta(0)
                    + " y el:" + manoJugador.getCarta(1) + ".");
            Blackjack.cad += "\n";
            Blackjack.cad += ("Tu tienes Blackjack. Tú ganaste");

            mensaje = ("El repartidor tiene el: " + manoRepartidor.getCarta(0)
                    + " y el: " + manoRepartidor.getCarta(1) + ".");
            mensaje = ("\"El jugador tiene: " + manoJugador.getCarta(0)
                    + " y el:" + manoJugador.getCarta(1) + ".");
            mensaje = "\n";
            mensaje = ("Tu tienes Blackjack. Tú ganaste");
            JOptionPane.showMessageDialog(null, mensaje);
            return true;
        }
        mensaje = "";

        while (true) {
            Blackjack.cad += "\n";
            Blackjack.cad += "\n";
            Blackjack.cad += "Tu cartas son:";

            mensaje = "\n";
            mensaje = "\n";
            mensaje = "Tu cartas son:";
            for (int i = 0; i < manoJugador.getConteoCarta(); i++) {
                Blackjack.cad += "    " + manoJugador.getCarta(i) + "\n";
                mensaje = "    " + manoJugador.getCarta(i) + "\n";

            }

            Blackjack.cad += ("Tu total es: " + manoJugador.getBlackjackValor());
            Blackjack.cad += "\n";
            Blackjack.cad += ("El repartidor muestra el: " + manoRepartidor.getCarta(0));
            Blackjack.cad += "\n";

            mensaje = ("Tu total es: " + manoJugador.getBlackjackValor());
            mensaje = "\n";
            mensaje = ("El repartidor muestra el: " + manoRepartidor.getCarta(0));
            mensaje = "\n";
            JOptionPane.showMessageDialog(null, mensaje);

            Blackjack.cad += ("¿Lanzar (L) o Permanecer (P)? ");
            mensaje = ("¿Lanzar (L) o Permanecer (P)? ");
            char userAction;

            do {
                String ent = JOptionPane.showInputDialog(null, mensaje);
                userAction = Character.toUpperCase(scan.next().charAt(0));
                Blackjack.cad += ent + "\n";

                mensaje = ent + "\n";
                if (userAction != 'L' && userAction != 'P') {

                    Blackjack.cad += ("Por favor respone L o P:  ");
                    mensaje = ("Por favor respone L o P:  ");

                }
            } while (userAction != 'L' && userAction != 'P');

            if (userAction == 'P') {
                // Loop ends; user is done taking cards.
                break;
            } else {
                Carta newCard = baraja.cartaIntercambio();
                manoJugador.añadirCarta(newCard);
                Blackjack.cad += "\n";
                Blackjack.cad += ("Lanzamientos de usuario.");
                Blackjack.cad += ("Tu carta es " + newCard);
                Blackjack.cad += ("Tu total  ahora es: " + manoJugador.getBlackjackValor());

                mensaje = "\n";
                mensaje = ("Lanzamientos de usuario.");
                mensaje = ("Tu carta es " + newCard);
                mensaje = ("Tu total  ahora es: " + manoJugador.getBlackjackValor());
                if (manoJugador.getBlackjackValor() > 21) {
                    Blackjack.cad += "\n";
                    Blackjack.cad += ("Fracasaste por sobrepasar los 21.  Tu perdiste.\n");
                    Blackjack.cad += ("La otra carta del repartidor era:"
                            + manoRepartidor.getCarta(1) + "\n");

                    mensaje = "\n";
                    mensaje = ("Fracasaste por sobrepasar los 21.  Tu perdiste.\n");
                    mensaje = ("La otra carta del repartidor era:"
                            + manoRepartidor.getCarta(1) + "\n");

                    return false;

                }
                JOptionPane.showMessageDialog(null, mensaje);

            }
        }

        Blackjack.cad += "\n";
        Blackjack.cad += ("Jugador permanece");
        Blackjack.cad += ("Las cartas del repartidor son:\n");
        Blackjack.cad += ("    " + manoRepartidor.getCarta(0) + "\n");
        Blackjack.cad += ("    " + manoRepartidor.getCarta(1) + "\n");

        mensaje = "\n";
        mensaje = ("Jugador permanece");
        mensaje = ("Las cartas del repartidor son:\n");
        mensaje = ("    " + manoRepartidor.getCarta(0) + "\n");
        mensaje = ("    " + manoRepartidor.getCarta(1) + "\n");

        while (manoRepartidor.getBlackjackValor() <= 16) {
            Carta newCard = baraja.cartaIntercambio();
            manoRepartidor.añadirCarta(newCard);
            Blackjack.cad += ("El repartidor lanza y obtiene: " + newCard + "\n");
            manoRepartidor.añadirCarta(newCard);
            mensaje = ("El repartidor lanza y obtiene: " + newCard + "\n");

            if (manoRepartidor.getBlackjackValor() > 21) {

                Blackjack.cad += "\n";
                Blackjack.cad += ("El repartidor sobrepaso los 21.  Tu ganas");

                mensaje = "\n";
                mensaje = ("El repartidor sobrepaso los 21.  Tu ganas");

                return true;
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }

        Blackjack.cad += ("El total del repartidor es: " + manoRepartidor.getBlackjackValor());

        mensaje = ("El total del repartidor es: " + manoRepartidor.getBlackjackValor());
        JOptionPane.showMessageDialog(null, mensaje);

        Blackjack.cad += "\n";
        mensaje = "\n";

        if (manoRepartidor.getBlackjackValor() == manoJugador.getBlackjackValor()) {

            Blackjack.cad += ("El repartidor gana con empate.  Tu pierdes");
            mensaje = ("El repartidor gana con empate.  Tu pierdes");
            JOptionPane.showMessageDialog(null, mensaje);
            return false;
        } else if (manoRepartidor.getBlackjackValor() > manoJugador.getBlackjackValor()) {

            Blackjack.cad += ("El repartidor gana" + manoRepartidor.getBlackjackValor() + " frente a:" + manoJugador.getBlackjackValor() + ".");
            mensaje = ("El repartidor gana" + manoRepartidor.getBlackjackValor() + " frente a:" + manoJugador.getBlackjackValor() + ".");
            JOptionPane.showMessageDialog(null, mensaje);
            return false;
        } else {
//            
            Blackjack.cad += ("Tu ganas" + manoJugador.getBlackjackValor() + " frente a:" + manoRepartidor.getBlackjackValor() + ".");
            mensaje = ("Tu ganas" + manoJugador.getBlackjackValor() + " frente a:" + manoRepartidor.getBlackjackValor() + ".");
            JOptionPane.showMessageDialog(null, mensaje);
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dinero;          // Amount of money the user has.
        int apuesta;            // Amount user bets on a game.
        boolean resultadoJuego;   // Did the user win the game?

        Blackjack.cad += "Bienvenido al juego";
        Blackjack.cad += "\n";
        dinero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto total de su dinero"));   // User starts with $100.

        while (true) {

            System.out.println("Usted tiene " + dinero + " dolares.");
            mensaje = ("Usted tiene " + dinero + " dolares.");
            do {

                Blackjack.cad += ("¿Cuanto diner quieres apostar??  (Ingresa 0 para finalizar)\n");

                mensaje = ("¿Cuanto diner quieres apostar??  (Ingresa 0 para finalizar)\n");
                Blackjack.cad = ("?");
                apuesta = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                Blackjack.cad += apuesta + "\n";
                if (apuesta < 0 || apuesta > dinero) {
//                    
                    Blackjack.cad += "Su respuesta debe ser entre 0 y " + dinero + ".";
                    mensaje = "Su respuesta debe ser entre 0 y " + dinero + ".";

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

            mensaje = "\n";
            if (dinero == 0) {

                Blackjack.cad += "Parece que te has quedado sin dinero!!";
                mensaje = Blackjack.cad += "Parece que te has quedado sin dinero!!";
                JOptionPane.showMessageDialog(null, mensaje);
                break;
            }
        }

        Blackjack.cad += "Te vas con: $" + dinero + ".";
        Blackjack.cad += "\n";

        mensaje = "Te vas con: $" + dinero + ".";
        mensaje = "\n";
        JOptionPane.showMessageDialog(null, mensaje);

        BlackjackLogs blackjackLogs = new BlackjackLogs(logstr);

    }

}
