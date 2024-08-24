/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.ApstraktniObjekat;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihailomitrovic
 */
public class DBBroker {
    private static DBBroker instance;
    private static Connection konekcija;

    public DBBroker() {
        Properties properties = new Properties();
        
        try {
            properties.load(new FileInputStream("dbconfig.properties"));
            konekcija = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("pass"));
            konekcija.setAutoCommit(false);
        } catch (Exception ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();        }
        return instance;
    }
    
    public Connection getConnection() {
        return konekcija;
    }

    public ArrayList<ApstraktniObjekat> select(ApstraktniObjekat ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.tabela() + " " + ado.alijas() + " " + ado.spajanje();
        System.out.println("Upit: " + upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.lista(rs);
    }
    
    public PreparedStatement insert(ApstraktniObjekat ado) throws SQLException {
        String upit = "INSERT INTO " + ado.tabela() + " " + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println("Upit: " + upit);
        PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(ApstraktniObjekat ado) throws SQLException {
        String upit = "UPDATE " + ado.tabela() + " SET " + ado.vrednostiZaUpdate() + " WHERE " + ado.id();
        System.out.println("Upit: " + upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(ApstraktniObjekat ado) throws SQLException {
        String upit = "DELETE FROM " + ado.tabela() + " WHERE " + ado.id();
        System.out.println("Upit: " + upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }
}
