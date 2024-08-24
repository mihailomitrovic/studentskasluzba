/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesija;

import domen.Sluzbenik;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihailomitrovic
 */
public class Sesija {
    
    private static Sesija instance;
    private Socket socket;
    private Sluzbenik ulogovani;

    public Sesija() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            Logger.getLogger(Sesija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }
    
    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(Sluzbenik s) {
        this.ulogovani = s;
    }

    public Sluzbenik getUlogovani() {
        return ulogovani;
    }
    
}
