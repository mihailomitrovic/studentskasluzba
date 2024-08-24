/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import forma.KlijentskaForma;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihailomitrovic
 */
public class VremeNit extends Thread {
    
    private KlijentskaForma forma;

    public VremeNit(KlijentskaForma forma) {
        this.forma = forma;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");
        
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
                forma.getLblVreme().setText(sdf.format(new Date()));
            } catch (InterruptedException ex) {
                Logger.getLogger(KlijentskaForma.class.getName()).log(Level.SEVERE, null, ex);
            }

        }    
    }
    
}
