/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.ApstraktniObjekat;
import domen.Student;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author mihailomitrovic
 */
public class SOIzmeniStudenta extends ApstraktnaSO {

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        if (!(ado instanceof Student)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws SQLException {
        DBBroker.getInstance().update(ado);
    }
    
}
