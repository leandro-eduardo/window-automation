package com.eduardo.leandro.windowautomation.model;


//POJO
public class Historico {

    private int id;
    private String datetime;
    private String  status;

    public Historico() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
