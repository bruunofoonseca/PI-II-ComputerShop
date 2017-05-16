/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.models;

/**
 *
 * @author BruunoFoonseca
 */
public class ProdutoModel {
    
    // Atributos
    private String nome;
    private String fabricante;
    private String tipoProduto;
    private int qtdProduto;
    private float valorProduto;

    
    // Get e Setter
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public String getNome (){
        return this.nome;
    }
    
    public void setFabricante (String fabricante){
        this.fabricante = fabricante;
    }
    
    public String getFabricante (){
        return this.fabricante;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
     
    public void setValorProduto(float valorProd){
        this.valorProduto = valorProd;
    }
    
    public float getValorProduto (){
        return valorProduto;
    }
    
    
}
