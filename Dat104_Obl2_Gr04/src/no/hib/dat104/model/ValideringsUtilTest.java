package no.hib.dat104.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValideringsUtilTest {
    private ValideringsUtil v = new ValideringsUtil();

    @Before
    public void Setup() {
        v.setFname("");
        v.setLname("");
        v.setMob("");
    }


    @Test
    public void erFnameUgyldig() {
        v.setFname("Pe");
        assertTrue(v.erFnameUgyldig());
    }
    @Test
    public void erFnameGyldig() {
        v.setFname("Per");
        assertFalse(v.erFnameUgyldig());
    }
    @Test
    public void erLnameUgyldig() {
        v.setLname("Pa");
        assertTrue(v.erLnameUgyldig());
    }
    @Test
    public void erLnameGyldig() {
        v.setLname("Pålsen");
        assertFalse(v.erLnameUgyldig());
    }
    @Test
    public void erMobUgyldig() {
        v.setMob("1234567");
        assertTrue(v.erMobUgyldig());
    }
    @Test
    public void erMobGyldig() {
        v.setMob("12345678");
        assertFalse(v.erMobUgyldig());
    }
    @Test
    public void erAlleGyldig() {
        v.setMob("12345678");
        v.setFname("Petter");
        v.setLname("Pettersensenpetter");
        assertFalse(v.erMobUgyldig());
    }
    @Test
    public void erAlleUgyldig() {
        v.setMob("1234");
        v.setFname("Pr");
        v.setLname("");
        assertTrue(v.erMobUgyldig());
    }
}