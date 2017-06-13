/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.views;
import com.ComputerShop.exceptions.ClienteException;
import com.ComputerShop.exceptions.DataSourceException;
import com.ComputerShop.exceptions.ProdutoException;
import com.ComputerShop.exceptions.VendaException;
import com.ComputerShop.models.ClienteModel;
import com.ComputerShop.models.PedidoModel;
import com.ComputerShop.models.ProdutoModel;
import com.ComputerShop.models.VendaModel;
import com.ComputerShop.services.ServiceCliente;
import com.ComputerShop.services.ServiceVenda;
import com.ComputerShop.services.ServicoProduto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alef.nsousa
 */
public class CadastrarVenda extends javax.swing.JInternalFrame {
    
    String ultimaPesquisaCli = null;
    String ultimaPesquisaProd = null;
    List<ClienteModel> resultadoCli = null;
    List<ProdutoModel> resultadoProd = null;
    ClienteModel cliente;
    List<PedidoModel> pedidos = new ArrayList<>();
    float valorTotal = 0;
    VendaModel venda = new VendaModel();

    /**
     * Creates new form CadastrarVenda
     */
    public CadastrarVenda() {
        initComponents();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        lblDataVenda.setText(format.format(new Date()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnPesquisarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        lblClienteSelecionado = new javax.swing.JLabel();
        btnAdicionarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNomeProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnPesquisarProduto = new javax.swing.JButton();
        btnAdicionarProduto = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblDataVenda = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Realizar Venda");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("* Nome do Cliente:");

        btnPesquisarCliente.setText("Pesquisar");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Data de Nascimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        lblClienteSelecionado.setText("Nome do cliente escolhido");

        btnAdicionarCliente.setText("Adicionar");
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClienteSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdicionarCliente))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarCliente)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCliente))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnAdicionarCliente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClienteSelecionado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeProdutoActionPerformed(evt);
            }
        });

        jLabel5.setText("* Produto:");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProdutos);

        btnPesquisarProduto.setText("Pesquisar");
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });

        btnAdicionarProduto.setText("Adicionar");
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesquisarProduto)
                            .addComponent(btnAdicionarProduto)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionarProduto)
                        .addGap(25, 25, 25))))
        );

        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Produto", "Valor Unitário", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblVenda);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(8, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel2.setText("Valor Total: R$ ");

        lblValorTotal.setText("0");

        btnFinalizar.setText("Finalizar Compra");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel3.setText("Data: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFinalizar)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorTotal))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(btnRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblValorTotal)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        /* Inicializa o sucesso da pesquisa com valor negativo, indicando que
        a pesquisa de clientes não obteve resultados (situação padrão)*/
        boolean resultSearch = false;
        
        /*Grava o campo de pesquisa como a última pesquisa válida. O valor
        de última pesquisa válida é utilizado na atualização da lista*/
        ultimaPesquisaCli = txtNomeCliente.getText();
        
        try {
            //Solicita atualização da lista
            resultSearch = refreshListCli();
        } catch (Exception e){
            //Exibir mensagens de erro na fonte de dados
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Exibir mensagem de erro quando a pequisa não tenha resultado
        if(!resultSearch){
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados",
                    "Sem resultados",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    public boolean refreshListCli() throws ClienteException, Exception {
        resultadoCli = ServiceCliente.procurarCliente(ultimaPesquisaCli);
        
        DefaultTableModel model = (DefaultTableModel) tblCliente.getModel();
        model.setRowCount(0);
        
        if(resultadoCli == null || resultadoCli.size() <= 0) {
           return false;
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < resultadoCli.size(); i++) {
            ClienteModel cli = resultadoCli.get(i);
            if(cli != null){
                Object[] row = new Object[3];
                row[0] = cli.getNome();
                row[1] = cli.getCpf();
                row[2] = format.format(cli.getDataNasc());
                model.addRow(row);
            }
        }

       return true;
    }
    
    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
        boolean resultSearch = false;
        
        ultimaPesquisaProd = txtNomeProduto.getText();
        
        try{
            resultSearch = refreshListProd();
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!resultSearch){
            JOptionPane.showMessageDialog(rootPane, "A pesquisa não retornou resultados",
                    "Sem resultados",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    public boolean refreshListProd() throws ClienteException, Exception {
        resultadoProd = ServicoProduto.localizarProduto(ultimaPesquisaProd);
        
        DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
        model.setRowCount(0);
        
        if(resultadoProd == null || resultadoProd.size() <= 0){
           return false;
        }
    
        for (int i = 0; i < resultadoProd.size(); i++) {
            ProdutoModel prod = resultadoProd.get(i);
            if(prod != null){
                Object[] row = new Object[3];
                row[0] = prod.getNome();
                row[1] = prod.getValorProduto();
                row[2] = prod.getQtdProduto();
                model.addRow(row);
            }
        }

       return true;
    }
    
    private void txtNomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeProdutoActionPerformed

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        int index = tblCliente.getSelectedRow();
        
        cliente = resultadoCli.get(index);
        
        lblClienteSelecionado.setText(cliente.getNome());
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        int index = tblProdutos.getSelectedRow();
        boolean resultAdd = false;
        int quantidade = (int)txtQuantidade.getValue();
        ProdutoModel produto;
        PedidoModel pedido = new PedidoModel();
        
        if(quantidade > 0 && resultadoProd.get(index).getQtdProduto() < quantidade) {
            JOptionPane.showMessageDialog(rootPane, "Nâo possuimos está quantidade em estoque!", 
                    "Erro ao Adicionar!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        produto = resultadoProd.get(index);
        
        if(!validar(produto)) {
            JOptionPane.showMessageDialog(rootPane, 
                    "Produto já adicionado ao carrinho!", "Erro ao Adicionar!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        pedido.setProduto(produto);
        pedido.setQtd(quantidade);
        
        float valorParcial = produto.getValorProduto() * quantidade;
        pedido.setValorParcial(valorParcial);
        
        valorTotal += valorParcial;
        
        lblValorTotal.setText(Float.toString(valorTotal));
        
        pedidos.add(pedido);
        
        try{
            resultAdd = refreshListVenda();
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                    "Falha ao obter lista", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!resultAdd){
            JOptionPane.showMessageDialog(rootPane, "Erro na inserção!",
                    "Sem resultados",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    public boolean validar (ProdutoModel produto) {
        for(int i = 0; i < pedidos.size(); i++) {
            if(pedidos.get(i).getProduto().getId().equals(produto.getId())) {
                return false;
            }
        }
        
        return true;
    }
    
    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        venda.setCliente(cliente);
        venda.setPedidos(pedidos);
        venda.setValorTotal(valorTotal);
        venda.setDataVenda(new Date());
        
        try {
            ServiceVenda.cadastraPedido(venda);
        } catch (VendaException | DataSourceException ex) {
            Logger.getLogger(CadastrarVenda.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        int aux = JOptionPane.showOptionDialog(rootPane, "Venda Realizada!!", "Sucesso!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        
        if (aux == JOptionPane.OK_OPTION) {
            //                super.setClosed(true);
            for(int i = 0; i < pedidos.size(); i++) {
                ProdutoModel prod = pedidos.get(i).getProduto();
                prod.setQtdProduto(prod.getQtdProduto() - pedidos.get(i).getQtd());
                try {
                    ServicoProduto.atualizarProduto(prod);
                } catch (ProdutoException | DataSourceException ex) {
                    Logger.getLogger(CadastrarVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            limpar();
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void limpar() {
        DefaultTableModel modelVenda = (DefaultTableModel) tblVenda.getModel();
        for(int i = 0; i < modelVenda.getRowCount(); i++) {
            modelVenda.removeRow(i);
        }
        
        DefaultTableModel modelProd = (DefaultTableModel) tblProdutos.getModel();
        for(int i = 0; i < modelProd.getRowCount(); i++) {
            modelProd.removeRow(i);
        }
        
        DefaultTableModel modelCli = (DefaultTableModel) tblCliente.getModel();
        for(int i = 0; i < modelCli.getRowCount(); i++) {
            modelCli.removeRow(i);
        }
        
        txtNomeCliente.setText("");
        txtNomeProduto.setText("");
        txtQuantidade.setValue(new Integer(0));
        lblClienteSelecionado.setText("");
        lblValorTotal.setText("");
        
        ultimaPesquisaCli = null;
        ultimaPesquisaProd = null;
        resultadoCli = null;
        resultadoProd = null;
        cliente = null;
        pedidos.clear();
        pedidos = new ArrayList<>();
        valorTotal = 0;
        venda = new VendaModel();
    }
    
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblVenda.getModel();
        model.removeRow(tblVenda.getSelectedRow());
    }//GEN-LAST:event_btnRemoverActionPerformed

    public boolean refreshListVenda() throws ClienteException, Exception {        
        DefaultTableModel model = (DefaultTableModel) tblVenda.getModel();
        model.setRowCount(0);
        
        if(pedidos == null){
           return false;
        }
    
        for (int i = 0; i < pedidos.size(); i++) {
            ProdutoModel prod = pedidos.get(i).getProduto();
            ClienteModel cli = cliente;
            if(prod != null){
                Object[] row = new Object[4];
                row[0] = cli.getNome();
                row[1] = prod.getNome();
                row[2] = prod.getValorProduto();
                row[3] = pedidos.get(i).getQtd();
                model.addRow(row);
            }
        }

       return true;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblClienteSelecionado;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTable tblVenda;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JSpinner txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
