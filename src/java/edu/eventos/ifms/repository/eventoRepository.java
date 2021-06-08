/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.eventoModel;
import edu.eventos.ifms.util.hibernateConector;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author delci
 */
public class eventoRepository {
    private Session session;
    private Transaction transaction;
    
    public void salvar(eventoModel evento){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.save(evento);
        
        this.transaction.commit();
        this.session.close();
    }
}
