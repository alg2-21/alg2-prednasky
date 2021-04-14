/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *
 */
package kralovcova.p026.predekobject;

import java.util.Objects;

/**
 *
 * @author Jirina
 */
public class Osoba {
    String jmeno;
    String prijmeni;
    long cislo;

    public Osoba(String jmeno, String prijmeni, long cislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.cislo = cislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public long getCislo() {
        return cislo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.jmeno);
        hash = 23 * hash + Objects.hashCode(this.prijmeni);
        hash = 23 * hash + (int) (this.cislo ^ (this.cislo >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Osoba other = (Osoba) obj;
        if (this.cislo != other.cislo) {
            return false;
        }
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        if (!Objects.equals(this.prijmeni, other.prijmeni)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "Osoba{" + "jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", cislo=" + cislo + '}';
        return String.format("%s %s %d", jmeno, prijmeni, cislo);
    }
    
    
    
    
}
