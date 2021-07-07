/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.externoModel;
import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author delci
 */
public class externoRepository {
    private Session session;
    private Transaction transaction;
    
    public void salvar(externoModel externo){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(externo);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public List<externoModel> buscarTodos(){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<externoModel> listaDeExternos = this.session.createQuery("from externoModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeExternos;
    }
    
    public List<externoModel> buscar(){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<externoModel> listaDeExternos = this.session.createQuery("from externoModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeExternos;
    }
    
    public void remover(long idExterno){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        externoModel externo = (externoModel) this.session.get(externoModel.class, idExterno);
        this.session.delete(externo);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public externoModel buscarPorId(long idExterno){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        externoModel externo = (externoModel) this.session.get(externoModel.class, idExterno);
        
        this.transaction.commit();
        this.session.close();
        return externo;
    }
}