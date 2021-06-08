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
import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.repository.areaRepository;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class areaController {
    private areaModel areaModel;
    private areaRepository areaRepository;
    
    public areaController(){
        this.areaModel = new areaModel();
        this.areaRepository = new areaRepository();
    }
            
    public void salvar(){
        this.areaRepository.salvar(this.areaModel);
    }

    /**
     * @return the areaModel
     */
    public areaModel getAreaModel() {
        return areaModel;
    }

    /**
     * @param areaModel the areaModel to set
     */
    public void setAreaModel(areaModel areaModel) {
        this.areaModel = areaModel;
    }

    /**
     * @return the areaRepository
     */
    public areaRepository getAreaRepository() {
        return areaRepository;
    }

    /**
     * @param areaRepository the areaRepository to set
     */
    public void setAreaRepository(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
    
}
