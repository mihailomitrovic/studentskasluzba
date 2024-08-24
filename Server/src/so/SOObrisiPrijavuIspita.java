/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.PrijavaIspita;
import domen.RacunPrijaveIspita;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author mihailomitrovic
 */
public class SOObrisiPrijavuIspita extends ApstraktnaSO {
    
    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof PrijavaIspita)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        PrijavaIspita prijava = (PrijavaIspita) ado;
        RacunPrijaveIspita racun = new RacunPrijaveIspita(-1, new Date(), prijava);
        DBBroker.getInstance().delete(racun);
        DBBroker.getInstance().delete(prijava);
    }
    
}
