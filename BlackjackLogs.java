/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

/**
 *
 * @author USER
 */
public class BlackjackLogs {
    
    ArrayList<String> logs;
    public BlackjackLogs(String contenido ){
        this.logs = new ArrayList<>(); 
        if(new File("BlackjackLogs.txt").exists()){
            this.logs = cargarArchivos(); 
        }
        archivos(contenido);
        
        
    }
    private void archivos(String contenido) {
        try {
            logs.add(contenido);
             BufferedWriter salida = new BufferedWriter(new FileWriter("BlackjackLogs.txt")) ; 
                for (int i = logs.size() - 1; i >= 0; i--) {
                    salida.write(logs.get(i) + "\n%\n");
                }
            
        } catch (IOException ex) {
            Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private ArrayList<String> cargarArchivos() {
        ArrayList<String> cargar = new ArrayList<>();
        String contenido = "";
        try {
            String aux;
            String linea[];
            BufferedReader lector = new BufferedReader(new FileReader("BlackjackLogs.txt"));
            while ((aux = lector.readLine()) != null) {
                contenido += aux + "\n";
            }

            for (int i = contenido.split("%").length - 1; i >= 0; i--) {
                cargar.add(contenido.split("%")[i]);
            }

            lector.close();
        } catch (IOException ex) {
            Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargar;
    }
  

}
