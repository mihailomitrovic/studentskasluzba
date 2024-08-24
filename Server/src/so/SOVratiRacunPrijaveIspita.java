/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.RacunPrijaveIspita;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SOVratiRacunPrijaveIspita extends ApstraktnaSO {

    private RacunPrijaveIspita racun;

    public RacunPrijaveIspita getRacun() {
        return racun;
    }
    
    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof RacunPrijaveIspita)) {
            throw new Exception("Nevalidan objekat!");
        }    
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        RacunPrijaveIspita rpi = (RacunPrijaveIspita) ado;
        
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        ArrayList<RacunPrijaveIspita> listaRacuna = (ArrayList<RacunPrijaveIspita>) (ArrayList<?>) lista;
        
        for (RacunPrijaveIspita r : listaRacuna) {
            if (r.getPrijavaIspita().getPrijavaID() == rpi.getPrijavaIspita().getPrijavaID()) {
                racun = r;
                break;
            }
        }
    }
    
}
