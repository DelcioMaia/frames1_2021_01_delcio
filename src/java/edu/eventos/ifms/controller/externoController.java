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
import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.model.externoModel;
import edu.eventos.ifms.repository.cidadeRepository;
import edu.eventos.ifms.repository.estadoRepository;
import edu.eventos.ifms.repository.externoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class externoController {

    private externoModel externoModel;
    private externoRepository externoRepository;
    private estadoRepository estadoRepository;
    private cidadeRepository cidadeRepository;
    private List<SelectItem> listaDeCidades;
    private List<externoModel> listaDeExterno;

    public externoController() {
        this.externoModel = new externoModel();
        this.externoRepository = new externoRepository();
        this.estadoRepository = new estadoRepository();
        this.cidadeRepository = new cidadeRepository();
        this.listaDeCidades = this.getCidades(1);
        this.listaDeExterno = new ArrayList<>();
    }

    public void salvar() {
        this.getExternoRepository().salvar(this.getExternoModel());
    }

    public String salvarEdicao() {
        this.getExternoRepository().salvar(this.getExternoModel());
        return "buscarExterno.xhtml?faces-redirect=true";
    }

    public void remover(long idExterno) {
        this.getExternoRepository().remover(idExterno);
    }

    public String editar(long idExterno) {
        return "editarExterno.xhtml?faces-redirect=true&idExterno=" + idExterno;
    }

    public void buscarExterno() {
        this.setExternoModel(this.getExternoRepository().buscarPorId(this.getExternoModel().getIdPessoa()));
    }

    public void getExterno() {
        this.setExternoModel(this.getExternoRepository().buscarPorId(this.getExternoModel().getIdPessoa()));
        this.setListaDeCidades(this.getCidades(this.getExternoModel().getEstado().getIdEstado()));
    }

    /**
     *
     * @return
     */
    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<estadoModel> listaDeEstados = this.getEstadoRepository().buscar();
        for (estadoModel estado : listaDeEstados) {
            itens.add(new SelectItem(estado.getIdEstado(), estado.getEstadoNome()));
        }
        return itens;
    }

    public void onChangeEstado() {
        this.listaDeCidades = this.getCidades(this.externoModel.getEstado().getIdEstado());
    }

    public List<SelectItem> getCidades(long idEstado) {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<cidadeModel> listaDeCidades = this.getCidadeRepository().buscar(idEstado);
        for (cidadeModel cidade : listaDeCidades) {
            itens.add(new SelectItem(cidade.getIdCidade(), cidade.getCidadeNome()));
        }
        return itens;
    }

    public void buscarTodosExternos() {
        this.listaDeExterno = this.getExternoRepository().buscarTodos();
    }

    /**
     * @return the externoModel
     */
    public externoModel getExternoModel() {
        return externoModel;
    }

    /**
     * @param externoModel the externoModel to set
     */
    public void setExternoModel(externoModel externoModel) {
        this.externoModel = externoModel;
    }

    /**
     * @return the externoRepository
     */
    public externoRepository getExternoRepository() {
        return externoRepository;
    }

    /**
     * @param externoRepository the externoRepository to set
     */
    public void setExternoRepository(externoRepository externoRepository) {
        this.externoRepository = externoRepository;
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
     * @return the listaDeExterno
     */
    public List<externoModel> getListaDeExterno() {
        return listaDeExterno;
    }

    /**
     * @param listaDeExterno the listaDeExterno to set
     */
    public void setListaDeExterno(List<externoModel> listaDeExterno) {
        this.listaDeExterno = listaDeExterno;
    }

}
