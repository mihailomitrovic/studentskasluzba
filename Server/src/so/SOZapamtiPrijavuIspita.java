/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.PrijavaIspita;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SOZapamtiPrijavuIspita extends ApstraktnaSO {

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof PrijavaIspita)) {
            throw new Exception("Nevalidan objekat!");
        }
        
        PrijavaIspita prijava = (PrijavaIspita) ado;
        
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        ArrayList<PrijavaIspita> listaPrijava = (ArrayList<PrijavaIspita>) (ArrayList<?>) lista;
        
        for (PrijavaIspita p : listaPrijava) {
            if (p.getIspitniRok().getIspitniRokID() == prijava.getIspitniRok().getIspitniRokID() && p.getIspit().getIspitID() == prijava.getIspit().getIspitID() && p.getStudent().getStudentID() == prijava.getStudent().getStudentID()) {
                throw new Exception("Sistem ne može da zapamti prijavu. Student " + prijava.getStudent().toString() + " je već prijavio ispit " + prijava.getIspit().toString() + " za " + prijava.getIspitniRok().getPridevIspitnogRoka() + " rok!");
            }
        }
        
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }
    
}
