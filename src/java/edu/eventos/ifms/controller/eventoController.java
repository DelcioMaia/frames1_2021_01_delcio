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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class eventoController {
    private eventoModel eventoModel;
    private eventoRepository eventoRepository;
    private List listaDeEventos;
 
    public eventoController(){
        this.eventoModel = new eventoModel();
        this.eventoRepository = new eventoRepository();
    }
    
    public void salvar(){
        this.eventoRepository.salvar(this.eventoModel);
    }
    
    public void buscarTodosEvento(){
        this.setListaDeEventos(this.eventoRepository.buscarTodos());
    }
    
    public void remover(long idEvento){
        this.eventoRepository.remover(idEvento);
    }
    
    public String editar(long idEvento){
        return "editarEvento.xhtml?faces-redirect=true&idEvento=" + idEvento;
    }
    
    public void getEvento(){
        this.eventoModel = this.eventoRepository.buscarPorId(this.eventoModel.getIdEvento());
    }
    
    public String salvarEdicao(){
        this.eventoRepository.salvar(this.eventoModel);
        return "buscarEvento.xhtml?faces-redirect=true";
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

    /**
     * @return the listaDeEventos
     */
    public List getListaDeEventos() {
        return listaDeEventos;
    }

    /**
     * @param listaDeEventos the listaDeEventos to set
     */
    public void setListaDeEventos(List listaDeEventos) {
        this.listaDeEventos = listaDeEventos;
    } 
}
