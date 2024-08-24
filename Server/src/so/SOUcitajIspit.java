/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.Ispit;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SOUcitajIspit extends ApstraktnaSO {
    private Ispit ispit;
    
    public Ispit getIspit() {
        return ispit;
    }
    
    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Ispit)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        ArrayList<Ispit> listaIspita = (ArrayList<Ispit>) (ArrayList<?>) lista;
        
        Ispit i = (Ispit) ado;
        
        for (Ispit ispit : listaIspita) {
            if (ispit.getIspitID()== i.getIspitID()) {
                this.ispit = ispit;
                break;
            }
        }
        
    }
}
