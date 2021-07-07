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
import edu.eventos.ifms.model.alunoModel;
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.repository.alunoRepository;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.cursoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class alunoController {

    private alunoModel alunoModel;
    private alunoRepository alunoRepository;
    private campusRepository campusRepository;
    private cursoRepository cursoRepository;
    private List<alunoModel> listaDeAlunos;

    public alunoController() {
        this.alunoModel = new alunoModel();
        this.campusRepository = new campusRepository();
        this.cursoRepository = new cursoRepository();
        this.alunoRepository = new alunoRepository();
        this.listaDeAlunos = new ArrayList<>();
    }

    public void salvar() {
        this.getAlunoRepository().salvar(this.getAlunoModel());
    }

    public String salvarEdicao() {
        this.getAlunoRepository().salvar(this.getAlunoModel());
        return "buscarAluno.xhtml?faces-redirect=true";
    }

    public void remover(long idAluno) {
        this.getAlunoRepository().remover(idAluno);
    }

    public String editar(long idAluno) {
        return "editarAluno.xhtml?faces-redirect=true&idAluno=" + idAluno;
    }

    public void buscarAluno() {
        this.alunoModel = this.alunoRepository.buscarPorId(this.getAlunoModel().getIdPessoa());
    }

    public List<SelectItem> getCampus() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<campusModel> listaDeCampus = this.getCampusRepository().buscar();
        for (campusModel campus : listaDeCampus) {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        }
        return itens;
    }

    public List<SelectItem> getCurso() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<cursoModel> listaDeCursos = this.getCursoRepository().bucar();
        for (cursoModel curso : listaDeCursos) {
            itens.add(new SelectItem(curso.getIdCurso(), curso.getCursoNome()));
        }
        return itens;
    }

    public List<SelectItem> getAlunos() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<alunoModel> listaDeAlunos = this.getAlunoRepository().buscarTodos();
        for (alunoModel aluno : listaDeAlunos) {
            itens.add(new SelectItem(aluno.getIdPessoa(), aluno.getPessoaNome()));
        }
        return itens;
    }

    public void buscarTodosAlunos() {
        this.setListaDeAlunos(this.getAlunoRepository().buscarTodos());
    }

    /**
     * @return the alunoModel
     */
    public alunoModel getAlunoModel() {
        return alunoModel;
    }

    /**
     * @param alunoModel the alunoModel to set
     */
    public void setAlunoModel(alunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    /**
     * @return the alunoRepository
     */
    public alunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    /**
     * @param alunoRepository the alunoRepository to set
     */
    public void setAlunoRepository(alunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
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
     * @return the cursoRepository
     */
    public cursoRepository getCursoRepository() {
        return cursoRepository;
    }

    /**
     * @param cursoRepository the cursoRepository to set
     */
    public void setCursoRepository(cursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    /**
     * @return the listaDeAlunos
     */
    public List<alunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    /**
     * @param listaDeAlunos the listaDeAlunos to set
     */
    public void setListaDeAlunos(List<alunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

}
