/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

/**
 *
 * @author delci
 */
import edu.eventos.ifms.model.eventoModel;
import edu.eventos.ifms.repository.eventoRepository;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class eventoController {
    private eventoModel eventoModel;
    private eventoRepository eventoRepository;
 
    public eventoController(){
        this.eventoModel = new eventoModel();
        this.eventoRepository = new eventoRepository();
    }
    
    public void salvar(){
        this.getEventoRepository().salvar(this.getEventoModel());
    }

    /**
     * @return the eventoModel
     */
    public eventoModel getEventoModel() {
        return eventoModel;
    }

    /**
     * @param eventoModel the eventoModel to set
     */
    public void setEventoModel(eventoModel eventoModel) {
        this.eventoModel = eventoModel;
    }

    /**
     * @return the eventoRepository
     */
    public eventoRepository getEventoRepository() {
        return eventoRepository;
    }

    /**
     * @param eventoRepository the eventoRepository to set
     */
    public void setEventoRepository(eventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }
    
}
