/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author delci
 */
public class cursoRepository {
    private Session session;
    private Transaction transaction;
    
    public List<cursoModel> bucar(){
        this.setSession(hibernateConector.getSessionFactory().openSession());
        this.setTransaction(getSession().beginTransaction());
        
        List<cursoModel>listaDeCursos = this.getSession().createQuery("from cursoModel").list();
        
        this.getTransaction().commit();
        this.getSession().close();
        return listaDeCursos;
    }
    
    public void salvar(cursoModel curso){
        this.setSession(hibernateConector.getSessionFactory().openSession());
        this.setTransaction(getSession().beginTransaction());
        
        this.getSession().saveOrUpdate(curso);
        
        this.getTransaction().commit();
        this.getSession().close();
    }
    //inicio das alterações 27-06
    public List<cursoModel> buscarTodos(){
        this.setSession(hibernateConector.getSessionFactory().openSession());
        this.setTransaction(getSession().beginTransaction());
        
        List<cursoModel>listaDeCursos = this.getSession().createQuery("from cursoModel").list();
        
        this.getTransaction().commit();
        this.getSession().close();
        return listaDeCursos;
    }

    /**
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * @return the transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    
}
