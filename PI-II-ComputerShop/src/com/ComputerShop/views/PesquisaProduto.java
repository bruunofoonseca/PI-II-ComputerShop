/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.views;


import com.ComputerShop.models.ProdutoModel;
import com.ComputerShop.exceptions.ProdutoException;
import com.ComputerShop.services.ServicoProduto;
import java.awt.Dimension; // verificar
import javax.swing.JInternalFrame; // verificar
import javax.swing.JOptionPane; // verificar
import javax.swing.table.DefaultTableModel; // verificar
import java.util.List;

/**
 *
 * @author alef.nsousa
 * edit diogo.sfelix
 */
public class PesquisaProduto extends javax.swing.JInternalFrame {
    
    // instânci da tela de editar o produto
    TelaEditarProduto formEditarProduto = new TelaEditarProduto();

    // pega o ultimo resultado
    String ultimaPesq = null;
    List<ProdutoModel> resultado;

    /**
     * Creates new form PesquisaProduto
     */
    public PesquisaProduto() {
        initComponents();
        
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCampoPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pesquisar Produto");

        jLabel1.setText("Nome do produto");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Fabricante", "Tipo produto", "Quant", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblProdutos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblProdutos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblProdutos.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        btnExcluir.setText("Excluir Selecionado");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar Selecionado");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCampoPesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnExcluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEditar)))
                                .addGap(0, 321, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // codigo abaixo ira excluir o produto selecionado
        
        if(tblProdutos.getSelectedRow() >= 0){
            
            // obtem a linha do produto selecionado
            final int row = tblProdutos.getSelectedRow();
            
            //obtem o nome do produto, para pedir a confirmaçaõ exclusão
            String nome = (String) tblProdutos.getValueAt(row, 1);
            
            // exibindo caixa de dialogo
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Confirmar Exclusão", "Excluir Produto", JOptionPane.YES_NO_OPTION);
            
            // verifica a resposta do usuario
            if(resposta == JOptionPane.YES_OPTION){
                try {
                    // obtém o id do produto
                    int id = resultado.get(row).getId();
                    
                    // chama a classe serviço para excluir o item
                    ServicoProduto.excluirProduto(id);
                    this.refreshList();
                    
                } catch (Exception e) {
                    // se ocorre erro, mostra no console o erro,
                    // esconde do usuario
                    e.printStackTrace();
                    // exibi mensagem de erro ao usuario
                    JOptionPane.showConfirmDialog(rootPane, e.getMessage(), "Falha na exclusão", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
        try {
            // obtem a linha selecionada na tabela
            final int row = tblProdutos.getSelectedRow();
            
            // verifica se ha linha selecionada
            if (row >= 0){
                // obtem a linha selecionada na tabela
                int id = resultado.get(row).getId();
                
                // solicita ao services obter o produto
                ProdutoModel produto = ServicoProduto.obterProduto(id);

                formEditarProduto.dispose();
                formEditarProduto = new TelaEditarProduto();
                formEditarProduto.setProduto(produto);
                formEditarProduto.setTitle(produto.getNome());
                this.getParent().add(formEditarProduto);
                this.openFrameInCenter(formEditarProduto);
                formEditarProduto.toFront();
            }
            
        } catch (Exception e) {
            // se ocorrer algum erro tecnico mostra no console
            e.printStackTrace();
            // exibe mensagem de erro generica para usuario
            JOptionPane.showMessageDialog(rootPane, "Não é possivel" 
                    + " exibir os dados do produto", 
                    "Erro ao abrir detalhes",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // codigo abaixo realiza a pesquisa do produto
        
        // inicializa a pesquisa com resultado padrao
        boolean resultadoPesquisa = false;
        
        // Pegando o que foi digitado no campo de pesquisa
        ultimaPesq = txtCampoPesquisa.getText();
        
        try {
            
            resultadoPesquisa = refreshList();
            
        } catch (Exception e) {
            
            // se a lista não devolver nada, caira no catch exibindo mensagem
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),"Falhou ao obter a classe memoria", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        
        
        if(!resultadoPesquisa){
            JOptionPane.showMessageDialog(rootPane, "A pesquisa nao retornou resultado","",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    // ira atualiza a lista de produtos
    public boolean refreshList() throws ProdutoException, Exception{
        
        resultado = ServicoProduto.localizarProduto(ultimaPesq);
        
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        
        // isso vai limpar a lista, mesmo se nao encontrar resultado
        modelo.setRowCount(0);
        
        if(resultado == null || resultado.size() <= 0){
            return false;
        }
        
        for (int i = 0; i < resultado.size(); i++) {
            ProdutoModel prod = resultado.get(i);
            if (prod != null){
                Object[] row = new Object[6];
                row[0] = prod.getId();
                row[1] = prod.getNome();
                row[2] = prod.getFabricante();
                row[3] = prod.getTipoProduto();
                row[4] = prod.getQtdProduto();
                row[5] = prod.getValorProduto();
                modelo.addRow(row);
            } 
        }
        
        return true;
    }
    
    
    // aqui trata a questão do clique na tela de pesquisa de produto
    private void tabelaResultadoMouseClicked(java.awt.event.MouseEvent evt){
        // verificando se houve duplo clique
        
        if (evt.getClickCount() == 2){
            try {
                // ira obter a linha selecionada pelo usuario na tabela
                final int row = tblProdutos.getSelectedRow();
                
                // obtem o valor do ID da coluna ID
                Integer id = (Integer) tblProdutos.getValueAt(row, 0);
                
                // tendo o id da coluna, chama a classe memoria
                ProdutoModel prod = ServicoProduto.obterProduto(id);
                
                
            } catch (Exception e) {
            }
            
            
        }
    }
    
    // abre um internal frame centralizdo na tela
    public void openFrameInCenter(JInternalFrame jif){
        Dimension desktopSize = this.getParent().getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCampoPesquisa;
    // End of variables declaration//GEN-END:variables
}
