/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.RacunPrijaveIspita;
import java.sql.SQLException;

/**
 *
 * @author mihailomitrovic
 */
public class SOZapamtiRacunPrijaveIspita extends ApstraktnaSO{

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof RacunPrijaveIspita)) {
            throw new Exception("Nevalidan objekat!");
        }    
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }
    
}
