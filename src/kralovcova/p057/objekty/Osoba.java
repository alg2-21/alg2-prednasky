/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p057.objekty;

import java.io.Serializable;

/**
 *
 * @author Jirina
 */
public class Osoba implements Serializable{
    String jmeno;
    String prijmeni;

    public Osoba(String jmeno, String prijmeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    @Override
    public String toString() {
        return "Osoba{" + "jmeno=" + jmeno + ", prijmeni=" + prijmeni + '}';
    }
    
    
}
