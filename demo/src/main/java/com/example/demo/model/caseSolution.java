package com.example.demo.model;


import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;

public class caseSolution implements CaseComponent {

    String id ;
    int p;
    int u;
    int b;
    int skt;
    int autr;
    int pas;
    int conf;


    public String toString()
    {
        return "("+id+";"+p+";"+u+";"+b+";"+skt+";"+autr+";"+pas+";"+conf+")";
    }


    public Attribute getIdAttribute() {

        return new Attribute("id", this.getClass());
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }








    public int getP() {
        return p;
    }
    public void setP(int p) {
        this.p = p;
    }



    public int getU() {
        return u;
    }
    public void setU(int u) {
        this.u = u;
    }



    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }



    public int getSkt() {
        return skt;
    }
    public void setSkt(int skt) {
        this.skt = skt;
    }






    public int getAutr() {
        return autr;
    }
    public void setAutr(int autr) {
        this.autr = autr;
    }






    public int getPas() {
        return pas;
    }
    public void setPas(int pas) {
        this.pas = pas;
    }






    public int getConf() {
        return conf;
    }
    public void setConf(int conf) {
        this.conf = conf;
    }








}
