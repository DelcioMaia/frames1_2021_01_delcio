/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author delci
 */
public class cidadeRepository {
    private Session session;
    private Transaction transaction;
    
    public List<cidadeModel> buscar(long IdEstado){
        this.setSession(hibernateConector.getSessionFactory().openSession());
        this.setTransaction(getSession().beginTransaction());
        
        List<cidadeModel> listaDeCidades = this.getSession().createQuery("from cidadeModel where idEstado = "+IdEstado).list();
        
        this.getTransaction().commit();
        this.getSession().close();
        return listaDeCidades;
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
