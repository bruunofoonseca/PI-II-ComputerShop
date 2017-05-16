/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.models;

import java.util.Calendar;
import java.util.List;
import com.ComputerShop.utils.Sexo;
import com.ComputerShop.utils.EstadoCivil;

/**
 *
 * @author BruunoFoonseca
 */

public class ClienteModel {
    
    private int idCliente;    
    
    private String nome;
    private String cpf;
//    private String rg;
    private String telefone;
    private String celular;
    
    private String sexo;        
    private String estadoCivil;
    private String nascimento;
    private EnderecoModel endereco;
    private String email;
    
    private Boolean ativo;

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the id to set
     */
//    public void setIdCLiente(int id) {
//        this.idCliente = id;
//    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

//    /**
//     * @return the rg
//     */
//    public String getRg() {
//        return rg;
//    }
//
//    /**
//     * @param rg the rg to set
//     */
//    public void setRg(String rg) {
//        this.rg = rg;
//    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }
    
//    public String getIdade(){
//        
//        int anoNascimento = nascimento.get(Calendar.YEAR);        
//        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
//        
//        return String.format("%s anos", anoAtual - anoNascimento);
//    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the endereco
     */
    public EnderecoModel getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefones
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefone(String telefones) {
        this.telefone = telefones;
    }
    
    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}