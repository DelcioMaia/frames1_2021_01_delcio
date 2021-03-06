/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

/**
 *
 * @author delci 2w
 */
import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.repository.areaRepository;
import edu.eventos.ifms.repository.servidorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class servidorController {
    
    private servidorModel servidorModel;
    private servidorRepository servidorRepository;
    private areaRepository areaRepository;
    private List<servidorModel> listaDeServidor;
    
    public servidorController(){
        this.servidorModel = new servidorModel();
        this.areaRepository = new areaRepository();
        this.servidorRepository = new servidorRepository();
        this.listaDeServidor = new ArrayList<>();
    }
    
    public void salvar(){
        this.servidorRepository.salvar(this.servidorModel);
    }
    
    public String salvarEdicao(){
        this.servidorRepository.salvar(this.servidorModel);
        return "buscarServidor.xhtml?faces-redirect=true";
    }

    public void remover(long idServidor){
        this.servidorRepository.remover(idServidor);
    }
    
    public String editar(long idServidor){
        return "editarServidor.xhtml?faces-redirect=true&idServidor=" +idServidor;
    }
   
    public void buscarServidor(){
        this.servidorModel = this.servidorRepository.buscarPorId(this.servidorModel.getIdPessoa());
    }
    
    public List<SelectItem> getAreas(){
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<areaModel> listaDeAreas = this.areaRepository.buscar();
        for(areaModel area : listaDeAreas){
            itens.add(new SelectItem(area.getIdArea(), area.getAreaNome()));
        }
        return itens;
    }
    
    public List<SelectItem> getServidores() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<servidorModel> listaDeServidores = this.servidorRepository.buscarTodos();
        for (servidorModel servidor : listaDeServidores) {
            itens.add(new SelectItem(servidor.getIdPessoa(), servidor.getPessoaNome()));
        }
        return itens;
    }
    
    public void buscarTodosServidores(){
        this.listaDeServidor = this.servidorRepository.buscarTodos();
    }

    /**
     * @return the servidorModel
     */
    public servidorModel getServidorModel() {
        return servidorModel;
    }

    /**
     * @param servidorModel the servidorModel to set
     */
    public void setServidorModel(servidorModel servidorModel) {
        this.servidorModel = servidorModel;
    }

    /**
     * @return the servidorRepository
     */
    public servidorRepository getServidorRepository() {
        return servidorRepository;
    }

    /**
     * @param servidorRepository the servidorRepository to set
     */
    public void setServidorRepository(servidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
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

    /**
     * @return the listaDeServidor
     */
    public List<servidorModel> getListaDeServidor() {
        return listaDeServidor;
    }

    /**
     * @param listaDeServidor the listaDeServidor to set
     */
    public void setListaDeServidor(List<servidorModel> listaDeServidor) {
        this.listaDeServidor = listaDeServidor;
    }
        
}
