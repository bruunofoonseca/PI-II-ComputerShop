/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.utils;

/**
 *
 * @author BruunoFoonseca
 */
public enum Sexo {
    
    masculino('M', "Masculino"),
    feminino('F', "Feminino"),
    indefinido('I', "Indefinido");
    
    private char id;
    private String descricao;
        
    Sexo(char id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
    }
    
    public char getId()
    {
        return this.id;
    }
    
    public String getDescricao()
    {
        return this.descricao;
    }
    
    public static Sexo getById(char id)
    {
        switch (id) {
            case 'M':
                return Sexo.masculino;
            case 'F':
                return Sexo.feminino;
            case 'I':
                return Sexo.indefinido;
            default:
                throw new AssertionError("Sexo inválido.");
        }
    }
}