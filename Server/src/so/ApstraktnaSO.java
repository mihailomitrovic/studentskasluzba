/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihailomitrovic
 */
public abstract class ApstraktnaSO {
    
    public void template(ApstraktniObjekat ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
        
    }
    
    protected abstract void validate(ApstraktniObjekat ado) throws Exception;

    protected abstract void execute(ApstraktniObjekat ado) throws SQLException;

    private void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    private void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
