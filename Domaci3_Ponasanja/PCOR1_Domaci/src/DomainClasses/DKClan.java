/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nikola
 */
public class DKClan implements Serializable,GeneralDObject{
    private String imeClana;
    private int sifraClana;

    public DKClan() {
    }

    public DKClan(int sifraClana, String imeClana) {
        this.imeClana = imeClana;
        this.sifraClana = sifraClana;
    }

    /**
     * @return the imeClana
     */
    public String getImeClana() {
        return imeClana;
    }

    /**
     * @param imeClana the imeClana to set
     */
    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    /**
     * @return the sifraClana
     */
    public int getSifraClana() {
        return sifraClana;
    }

    /**
     * @param sifraClana the sifraClana to set
     */
    public void setSifraClana(int sifraClana) {
        this.sifraClana = sifraClana;
    }

    @Override
    public String getAtrValue() {
        return sifraClana + ", " + (imeClana == null ? null : "'" + imeClana + "'");
    }

    @Override
    public String setAtrValue() {
        return "sifraClana=" + sifraClana + ", " + "imeClana=" + (imeClana == null ? null : "'" + imeClana + "'");
    }

    @Override
    public String getClassName() {
        return "DKClan";
    }

    @Override
    public String getWhereCondition() {
        return "sifraClana = " + sifraClana;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"sifraClana","imeClana"}; 
          return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new DKClan(rs.getInt("sifraClana"),rs.getString("imeClana"));
    }
    
}
