/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author delci
 */
public class areaRepository {
    private Session session;
    private Transaction transaction;
    
    public void salvar(areaModel area){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        this.session.saveOrUpdate(area);
        
        this.transaction.commit();
        this.session.close();
    }
    //inicio das alterações 27-06
    public List<areaModel> buscarTodos(){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<areaModel>listaDeAreas = this.session.createQuery("from areaModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeAreas;
    }
    
    public void remover(long idArea){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        areaModel area = (areaModel)this.session.get(areaModel.class, idArea);
        this.session.delete(area);
        
        this.transaction.commit();
        this.session.close();
    }
    
    public areaModel buscarPorId(long idArea){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        areaModel area = (areaModel) this.session.get(areaModel.class, idArea);
        
        this.transaction.commit();
        this.session.close();
        return area;
    }
    //final da modificação 27-06
}
