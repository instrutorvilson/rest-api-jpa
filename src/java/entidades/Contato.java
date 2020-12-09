/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vilson
 */
@Entity
public class Contato implements Serializable{
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
   
   private String nome;
   private String fone;   

    public Contato(Long id, String nome, String fone) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
    }

    public Contato(String nome, String fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public Contato() {
       
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
   
    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + ", fone=" + fone + '}';
    }
        
    
}
