/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;
import konst.StatusOdgovora;

/**
 *
 * @author mihailomitrovic
 */

public class ServerskiOdgovor implements Serializable {
    private Object odgovor;
    private Exception greska;
    private StatusOdgovora status;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, Exception greska, StatusOdgovora status) {
        this.odgovor = odgovor;
        this.greska = greska;
        this.status = status;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public Exception getGreska() {
        return greska;
    }

    public void setGreska(Exception greska) {
        this.greska = greska;
    }

    public StatusOdgovora getStatus() {
        return status;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }
    
}
