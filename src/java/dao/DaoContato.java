/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Contato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author User
 */
public class DaoContato {
  public static boolean persist(Contato ct) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("webApiAgendaJPAPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ct);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }
    
    public static Contato getOne(Long pId){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("webApiAgendaJPAPU");  
      EntityManager em = emf.createEntityManager();
      return em.find(Contato.class, pId);    
    }   
    
    public static boolean excluir(Long pId){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("webApiAgendaJPAPU");  
      EntityManager em = emf.createEntityManager();
      em.remove(pId); 
      return true;
    }
    public static List<Contato> getAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("webApiAgendaJPAPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Contato> tq = em.createQuery("select c  from Contato c", Contato.class);
        return tq.getResultList();
    }
    
    public static boolean editar(Contato ct){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("webApiAgendaJPAPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ct);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }
  
}
