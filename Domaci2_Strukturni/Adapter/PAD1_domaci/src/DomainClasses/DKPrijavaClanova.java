/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nikola
 */
public class DKPrijavaClanova implements Serializable, GeneralDObject{
    
    private int sifraPrijave;
    private String ime;
    private String prezime;
    private String pozicija;
    private java.util.Date datum;

    public DKPrijavaClanova() {
        sifraPrijave = 0;
        ime = "";
        prezime = "";
        pozicija= "";
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datum = java.sql.Date.valueOf(sm.format(dDatum));
        
    }

    public DKPrijavaClanova(int sifraPrijave, String ime, String prezime, String pozicija, Date datum) {
        this.sifraPrijave = sifraPrijave;
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.datum = datum;
    }
    
    public DKPrijavaClanova(int sifraPrijave){
        this.sifraPrijave = sifraPrijave;
    }
    
     public int getSifraPrijave() {
        return sifraPrijave;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getPozicija() {
        return pozicija;
    }

    public java.util.Date getDatum() {
        return datum;
    }

    public void setSifraPrijave(int sifraPrijave) {
        this.sifraPrijave = sifraPrijave;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public void setDatum(java.util.Date datum) {
        this.datum = datum;
    }
    
    
    
    
    @Override
    public String getAtrValue() {
        
        return sifraPrijave + ", '" + ime + "', '" + prezime + "', '"+pozicija +"', '" + datum + "'";
        
//        return sifraPrijave + ", " 
//                +   "'"+ ime  + "'"
//                + ", " +"'"+ prezime +"'"+ ", " + "'"
//                + pozicija +"'" +", " + "'"
//                + datum + "'";
    }

    @Override
    public String setAtrValue() {
        return "sifraPrijave=" + sifraPrijave + ", " + "ime="+"'"+ime+"'"+", "+"prezime="+"'"+prezime+"'"+", "
                +"pozicija="+"'"+pozicija+"'"+", "+"Datum="+"'"+datum+"'";
                
        
//        return "sifraPrijave=" +sifraPrijave+ ", " +"ime="
//                +   "'"+ ime  + "'"
//                + ", "+"prezime=" +"'"+ prezime +"'"+ ", "+"pozicija=" + "'"
//                + pozicija +"'" +", "+"Datum=" + "'"
//                + datum + "'";
    }

    @Override
    public String getClassName() {
        return "DKPrijavaClanova";
    }

    @Override
    public String getWhereCondition() {
        return "SifraPrijave = " + sifraPrijave;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"sifraPrijave","ime","prezime","pozicija","datum"}; 
          return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new DKPrijavaClanova(
                rs.getInt("sifraPrijave"),
                rs.getString("ime"),
                rs.getString("prezime"),
                rs.getString("pozicija"),
                rs.getDate("Datum"));
        } 
    }

   
    

