/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author User
 */
public class Compromisso {
    private int id;
    private Contato contato;
    private String local;

    public int getId() {
        return id;
    }

    public Compromisso(int id, Contato contato, String local) {
        this.id = id;
        this.contato = contato;
        this.local = local;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
