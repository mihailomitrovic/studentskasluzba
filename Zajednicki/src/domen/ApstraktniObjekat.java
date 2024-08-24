/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author mihailomitrovic
 */
public abstract class ApstraktniObjekat implements Serializable {
    public abstract String tabela();
    public abstract String alijas();
    public abstract String spajanje();
    public abstract String primarniKljuc();
    public abstract String koloneZaInsert();
    public abstract String vrednostiZaInsert();
    public abstract String vrednostiZaUpdate();
    public abstract String id();
    public abstract ArrayList<ApstraktniObjekat> lista(ResultSet rs) throws SQLException;
}
