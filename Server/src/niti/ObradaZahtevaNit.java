/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konst.Operacije;
import konst.StatusOdgovora;
import logika.ServerKontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author mihailomitrovic
 */
public class ObradaZahtevaNit extends Thread {
    private Socket soket;

    public ObradaZahtevaNit(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
                KlijentskiZahtev kz = (KlijentskiZahtev) ois.readObject();
                
                ServerskiOdgovor so = obradiZahtev(kz);
                ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
                oos.writeObject(so);
            }
        } catch (Exception e) {
            System.out.println("Klijent je prekinuo sa radom");
        }
    }

    public ServerskiOdgovor obradiZahtev(KlijentskiZahtev kz) {
        ServerskiOdgovor so = new ServerskiOdgovor(null, null, StatusOdgovora.Success);
            
        try {
            switch (kz.getOperacija()) {
                case Operacije.NADJI_SLUZBENIKA:
                  Sluzbenik sluzbenik = ServerKontroler.getInstance().nadjiSluzbenika((Sluzbenik) kz.getParametar());
                  so.setOdgovor(sluzbenik);
                  
                  if (so.getOdgovor() == null) {
                    throw new Exception("Pogrešni kredencijali za prijavu!");
                  } else {
                    break;
                  }
                case Operacije.UCITAJ_LISTU_MESTA:
                    ArrayList<Mesto> listaMesta = (ArrayList<Mesto>) ServerKontroler.getInstance().ucitajListuMesta();
                    so.setOdgovor(listaMesta);
                    break;
                case Operacije.ZAPAMTI_STUDENTA:
                    ServerKontroler.getInstance().zapamtiStudenta((Student) kz.getParametar());
                    break;
                case Operacije.NADJI_STUDENTE:
                    ArrayList<Student> listaPronadjenihStudenata = (ArrayList<Student>) ServerKontroler.getInstance().nadjiStudente((Student) kz.getParametar());
                    so.setOdgovor(listaPronadjenihStudenata);
                    break;
                case Operacije.VRATI_STUDENTE:
                    ArrayList<Student> listaStudenata = (ArrayList<Student>) ServerKontroler.getInstance().vratiStudente();
                    so.setOdgovor(listaStudenata);
                    break;
                case Operacije.UCITAJ_STUDENTA:
                    Student student = (Student) ServerKontroler.getInstance().ucitajStudenta((Student) kz.getParametar());
                    so.setOdgovor(student);
                    break; 
                case Operacije.IZMENI_STUDENTA:
                    ServerKontroler.getInstance().izmeniStudenta((Student) kz.getParametar());
                    break;
                case Operacije.UCITAJ_LISTU_ISPITA:
                    ArrayList<Ispit> listaIspita = (ArrayList<Ispit>) ServerKontroler.getInstance().ucitajListuIspita();
                    so.setOdgovor(listaIspita);
                    break;
                case Operacije.UCITAJ_LISTU_ISPITNIH_ROKOVA:
                    ArrayList<IspitniRok> listaRokova = (ArrayList<IspitniRok>) ServerKontroler.getInstance().ucitajListuIspitnihRokova();
                    so.setOdgovor(listaRokova);
                    break;
                case Operacije.ZAPAMTI_PRIJAVU_ISPITA:
                    ServerKontroler.getInstance().zapamtiPrijavuIspita((PrijavaIspita) kz.getParametar());
                    break;
                case Operacije.NADJI_PRIJAVE_ISPITA:
                    ArrayList<PrijavaIspita> listaPronadjenihPrijava = (ArrayList<PrijavaIspita>) ServerKontroler.getInstance().nadjiPrijaveIspita((PrijavaIspita) kz.getParametar());
                    so.setOdgovor(listaPronadjenihPrijava);
                    break; 
                case Operacije.VRATI_PRIJAVE_ISPITA:
                    ArrayList<PrijavaIspita> listaPrijava = (ArrayList<PrijavaIspita>) ServerKontroler.getInstance().vratiPrijaveIspita();
                    so.setOdgovor(listaPrijava);
                    break; 
                case Operacije.UCITAJ_PRIJAVU_ISPITA:
                    PrijavaIspita prijava = (PrijavaIspita) ServerKontroler.getInstance().ucitajPrijavuIspita((PrijavaIspita) kz.getParametar());
                    so.setOdgovor(prijava);
                    break;
                case Operacije.NADJI_ISPITE:
                    ArrayList<Ispit> listaPronadjenihIspita = (ArrayList<Ispit>) ServerKontroler.getInstance().nadjiIspite((Ispit) kz.getParametar());
                    so.setOdgovor(listaPronadjenihIspita);
                    break;    
                case Operacije.UCITAJ_ISPIT:
                    Ispit ispit = (Ispit) ServerKontroler.getInstance().ucitajIspit((Ispit) kz.getParametar());
                    so.setOdgovor(ispit);
                    break;
                case Operacije.OBRISI_PRIJAVU_ISPITA:
                    ServerKontroler.getInstance().obrisiPrijavuIspita((PrijavaIspita) kz.getParametar());
                    break;
                case Operacije.VRATI_RACUN_PRIJAVE_ISPITA:
                    RacunPrijaveIspita racun = ServerKontroler.getInstance().vratiRacunPrijaveIspita((PrijavaIspita) kz.getParametar());
                    so.setOdgovor(racun);
                    break; 
                case Operacije.ZAPAMTI_RACUN_PRIJAVE_ISPITA:
                    ServerKontroler.getInstance().zapamtiRacunPrijaveIspita((PrijavaIspita) kz.getParametar());
                    break;
                default:
                    System.out.println("Greška!");;
            }
        } catch (Exception e) {
            so.setGreska(e);
            so.setStatus(StatusOdgovora.Error);
        }
            
        return so;
    }
    
}
