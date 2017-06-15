/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.memoria;

import com.ComputerShop.models.PedidoModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BruunoFoonseca
 */

public class MemoriaVenda {
    
    private static int totalPedidos = 0;  
    private static List<PedidoModel> listaPedidos = new ArrayList<PedidoModel>();
    
    public static void inserir(PedidoModel pedido) throws Exception {
        pedido.setId(totalPedidos++);
        listaPedidos.add(pedido);
    }

    public static void atualizar (PedidoModel pedidoProcura) throws Exception {
        if (pedidoProcura != null && pedidoProcura.getId() != null && !listaPedidos.isEmpty()) {
            for (PedidoModel listPedidos : listaPedidos) {
                if(listPedidos != null && listPedidos.getId() == pedidoProcura.getId()){
                    listPedidos.setCliente(pedidoProcura.getCliente());
                    listPedidos.setItens(pedidoProcura.getItens());
                    listPedidos.setValorTotal(pedidoProcura.getValorTotal());
                    break;
                }
            }
        }
    }
    
    public static void excluir(Integer id) throws Exception {
        if(id != null && !listaPedidos.isEmpty()){
            for(int i = 0; i<listaPedidos.size(); i++){
                PedidoModel pedido = listaPedidos.get(i);
                if(pedido != null && pedido.getId() == id){
                    listaPedidos.remove(i);
                    break;
                }
            }
        }
    }
    
    public static List<PedidoModel> listar() throws Exception {
        return listaPedidos;
    }

//    public static List<PedidoModel> procurar (String nome) throws Exception {
//        List<PedidoModel> listaResultado = new ArrayList<PedidoModel>();
//        
//        if(nome != null && !listaPedidos.isEmpty()){
//            for(PedidoModel clienteList : listaPedidos){
//                if(clienteList != null && clienteList.getNome() != null){
//                    if(clienteList.getNome().toUpperCase().contains(nome.toUpperCase())){
//                        listaResultado.add(clienteList);
//                    }
//                }
//            }
//        }
//
//        return listaResultado;
//    }

    public static PedidoModel obter(Integer id) throws Exception {
        if(id != null && !listaPedidos.isEmpty()){
            for (int i = 0; i < listaPedidos.size(); i++) {
                if(listaPedidos.get(i) != null && listaPedidos.get(i).getId() == id){
                    return listaPedidos.get(i);
                }
            }
        }
        
        return  null;
    }
}