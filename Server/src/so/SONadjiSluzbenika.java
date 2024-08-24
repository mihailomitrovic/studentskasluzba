/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.Sluzbenik;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mihailomitrovic
 */
public class SONadjiSluzbenika extends ApstraktnaSO {

    private Sluzbenik sluzbenik;
    
    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }
    
    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Sluzbenik)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = DBBroker.getInstance().select(ado);
        ArrayList<Sluzbenik> listaSluzbenika = (ArrayList<Sluzbenik>) (ArrayList<?>) lista;
        
        Sluzbenik s = (Sluzbenik) ado;
        
        for (Sluzbenik sluzbenik : listaSluzbenika) {
            if (sluzbenik.getKorisnickoIme().equals(s.getKorisnickoIme()) && sluzbenik.getLozinka().equals(s.getLozinka())) {
                this.sluzbenik = sluzbenik;
                break;
            }
        }
        
    }
    
}
