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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class areaController {
    private areaModel areaModel;
    private areaRepository areaRepository;
    private List listaDeAreas;
    
    public areaController(){
        this.areaModel = new areaModel();
        this.areaRepository = new areaRepository();
    }
            
    public void salvar(){
        this.areaRepository.salvar(this.areaModel);
    }
    
    //inicio modificações 27/06
    public void buscarTodosArea(){
        this.setListaDeAreas(this.areaRepository.buscarTodos());
    }
    
    public void remover(long idArea){
        this.areaRepository.remover(idArea);
    }
    
    public String editar(long idArea){
        return "editarArea.xhtml?faces-redirect=true&idArea=" + idArea;
    }
    
    public void getArea(){
        this.areaModel = this.areaRepository.buscarPorId(this.areaModel.getIdArea());
    }
    
    public String salvarEdicao(){
        this.areaRepository.salvar(this.areaModel);
        return "buscarArea.xhtml?faces-redirect=true";
    }
    
    public List getListaDeAreas(){
        return listaDeAreas;
    }
    
    /**
     *
     * @param listaDeAreas
     */
    public void setListaDeAreas(List listaDeAreas){
        this.listaDeAreas = listaDeAreas;
    }
    
    //final da mofificcação 27/06

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
