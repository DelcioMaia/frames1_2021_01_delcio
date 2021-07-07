/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author delci
 */
@Entity
@Table(name = "externo")
@PrimaryKeyJoinColumn(name = "idPessoa")

public class externoModel extends pessoaModel implements Serializable {
    
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCidade", insertable = true, updatable = true)
    private cidadeModel cidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idEstado", insertable = true, updatable = true)
    private estadoModel estado;

    @Column(nullable = false)
    private Long numero;

    @Column(nullable = false, length = 100)
    private String instituicao;

    @Column(nullable = false, length = 100)
    private String logradouro;

    public externoModel(){
        this.cidade = new cidadeModel();
        this.estado = new estadoModel();
    }

    /**
     * @return the cidade
     */
    public cidadeModel getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(cidadeModel cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public estadoModel getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(estadoModel estado) {
        this.estado = estado;
    }

    /**
     * @return the numero
     */
    public Long getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Long numero) {
        this.numero = numero;
    }

    /**
     * @return the instituicao
     */
    public String getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

}
