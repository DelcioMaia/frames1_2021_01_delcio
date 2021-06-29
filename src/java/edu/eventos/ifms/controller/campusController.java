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
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.cidadeRepository;
import edu.eventos.ifms.repository.estadoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class campusController {
    private campusModel campusModel;
    private campusRepository campusRepository;
    private estadoRepository estadoRepository;
    private cidadeRepository cidadeRepository;
    private List<SelectItem> listaDeCidades;
    private List listaDeCampus;
    
    public campusController(){
        this.campusModel = new campusModel();
        this.campusRepository = new campusRepository();
        this.estadoRepository = new estadoRepository();
        this.cidadeRepository = new cidadeRepository();
        this.listaDeCidades = this.getCidades(1);
    }
    
    public void salvar(){
        this.campusRepository.salvar(this.campusModel);
    }
    
    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<estadoModel> listaDeEstados = this.estadoRepository.buscar();
            for(estadoModel estado : listaDeEstados){
                itens.add(new SelectItem(estado.getIdEstado(), estado.getEstadoNome()));
            }
        return itens;
    }
    
    public void onChangeEstado(){
        this.listaDeCidades = this.getCidades(this.campusModel.getEstado().getIdEstado());
    }
 
    public List<SelectItem> getCidades(long idEstado) {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<cidadeModel> listaDeCidades = this.cidadeRepository.buscar(idEstado);
            for(cidadeModel cidade : listaDeCidades){
                itens.add(new SelectItem(cidade.getIdCidade(), cidade.getCidadeNome()));
            }
        return itens;
    }
    
    public void buscarTodosCampus(){
        this.setListaDeCampus(this.campusRepository.buscarTodos());
    }
    
    public void remover(long idCampus){
        this.campusRepository.remover(idCampus);
    }
    
    public String editar(long idCampus){
        return "editarCampus.xhtml?faces-redirect=true&idCampus=" + idCampus;
    }
    
    public void getCampus(){
        this.campusModel = this.campusRepository.buscarPorId(this.campusModel.getIdCampus());
        this.listaDeCidades = this.getCidades(this.campusModel.getEstado().getIdEstado());
    }
    
    public String salvarEdicao(){
        this.campusRepository.salvar(this.campusModel);
        return "buscarCampus.xhtml?faces-redirect=true";
    }

    /**
     * @return the campusModel
     */
    public campusModel getCampusModel() {
        return campusModel;
    }

    /**
     * @param campusModel the campusModel to set
     */
    public void setCampusModel(campusModel campusModel) {
        this.campusModel = campusModel;
    }

    /**
     * @return the campusRepository
     */
    public campusRepository getCampusRepository() {
        return campusRepository;
    }

    /**
     * @param campusRepository the campusRepository to set
     */
    public void setCampusRepository(campusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    /**
     * @return the estadoRepository
     */
    public estadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    /**
     * @param estadoRepository the estadoRepository to set
     */
    public void setEstadoRepository(estadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    /**
     * @return the cidadeRepository
     */
    public cidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    /**
     * @param cidadeRepository the cidadeRepository to set
     */
    public void setCidadeRepository(cidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    /**
     * @return the listaDeCidades
     */
    public List<SelectItem> getListaDeCidades() {
        return listaDeCidades;
    }

    /**
     * @param listaDeCidades the listaDeCidades to set
     */
    public void setListaDeCidades(List<SelectItem> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }

    /**
     * @return the listaDeCampus
     */
    public List getListaDeCampus() {
        return listaDeCampus;
    }

    /**
     * @param listaDeCampus the listaDeCampus to set
     */
    public void setListaDeCampus(List listaDeCampus) {
        this.listaDeCampus = listaDeCampus;
    }
   
}
