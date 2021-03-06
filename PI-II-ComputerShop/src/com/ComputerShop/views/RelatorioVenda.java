/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ComputerShop.views;

import com.ComputerShop.exceptions.DataSourceException;
import com.ComputerShop.exceptions.VendaException;
import com.ComputerShop.models.ClienteModel;
import com.ComputerShop.models.ItemPedidoModel;
import com.ComputerShop.models.ProdutoModel;
import com.ComputerShop.models.PedidoModel;
import com.ComputerShop.services.ServiceVenda;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alef
 */
public class RelatorioVenda extends javax.swing.JInternalFrame {
    
    int flagIndex = -1;
    
    /**
     * Creates new form RelatorioVenda
     */
    public RelatorioVenda() {
        initComponents();
        
        DefaultTableModel model = (DefaultTableModel) tblRelatorio.getModel();
        model.setRowCount(0);
        
        DefaultTableModel modelItens = (DefaultTableModel) tblItens.getModel();
        modelItens.setRowCount(0);
        
        inicializarDatas();
    }
    
    //Inicializa as datas padrão do relatório (hoje + 30 dias)
    private void inicializarDatas() {
        //Define um formatador de datas
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
              
        Date hoje = new Date();
        String hojeFormatado = formatador.format(hoje);
        txtDataInicio.setText(hojeFormatado);

        Date dataFinal = new Date();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dataFinal);
        calendario.add(Calendar.DAY_OF_MONTH, 30);
        dataFinal = calendario.getTime();

        String dataFinalFormatada = formatador.format(dataFinal);
        txtDataFinal.setText(dataFinalFormatada);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRelatorio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDataFinal = new javax.swing.JFormattedTextField();
        txtDataInicio = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatorio de Vendas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatorios"));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Total R$ ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("* campos obrigatorios");

        lblTotal.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(204, 0, 0));

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Produto", "Tipo do Produto", "Valor Unitário", "Quantidade", "Sub-Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblItens);

        jLabel4.setText("Pedidos:");

        jLabel5.setText("Itens:");

        tblRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Cliente", "Data da Compra", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
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
        jScrollPane1.setViewportView(tblRelatorio);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        jLabel1.setText("* Data inicial:");

        btnPesquisar.setText("Gerar Relatório");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setText("* Data final:");

        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDataInicio))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataInicioActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (!(txtDataInicio.getText().equals("  /  /    ")) && !(txtDataFinal.getText().equals("  /  /   "))){
             try {
                refreshListRelatorio();
            } catch (VendaException | DataSourceException | ParseException ex) {
                Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showOptionDialog(rootPane, "É obrigatório o preenchimento da Data Inicial e Data Final!", 
                    "Atenção!", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    public boolean refreshListRelatorio() throws VendaException, DataSourceException, ParseException {
        List<PedidoModel> vendas = ServiceVenda.listarPedidos();
        float totalVendas = 0;
        
        DefaultTableModel model = (DefaultTableModel) tblRelatorio.getModel();
        model.setRowCount(0);
        
        if(vendas == null || vendas.size() <= 0){
           return false;
        }
        
        List<PedidoModel> vendasNoPeriodo = new ArrayList<>();
        SimpleDateFormat format = null;
        Date dataInicio = null;
        Date dataFim = null;
        
        try {
            format = new SimpleDateFormat("dd/MM/yyyy");
            dataInicio = format.parse(txtDataInicio.getText());
            dataFim = format.parse(txtDataFinal.getText());
        } catch (ParseException ex) {
            JOptionPane.showOptionDialog(rootPane, "Preencha as datas corretamente!", 
                    "Atenção!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
        }
        
        for (PedidoModel venda : vendas) {
            String aux = new SimpleDateFormat("dd/MM/yyy").format(venda.getDataVenda());
            Date dataVenda = format.parse(aux);
            if(dataVenda.after(dataInicio) && dataVenda.before(dataFim) 
                    || dataVenda.equals(dataInicio) || dataVenda.equals(dataFim)) {
                vendasNoPeriodo.add(venda);
                totalVendas += venda.getValorTotal();
            }
        }

        lblTotal.setText(Float.toString(totalVendas));

        for (int i = 0; i < vendasNoPeriodo.size(); i++) {
            ClienteModel cli = vendasNoPeriodo.get(i).getCliente();
            if(cli != null){
                Object[] row = new Object[4];
                row[0] = vendasNoPeriodo.get(i).getId();
                row[1] = cli.getNome();
                row[2] = format.format(vendasNoPeriodo.get(i).getDataVenda());
                row[3] = vendasNoPeriodo.get(i).getValorTotal();
                model.addRow(row);
            }
        }
        
        tblRelatorio.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            // do some actions here, for example
            // print first column value from selected row

            if(flagIndex != tblRelatorio.getSelectedRow()) {
                flagIndex = tblRelatorio.getSelectedRow();
                try {
                    refreshListRelatorioItens(vendasNoPeriodo.get(tblRelatorio.getSelectedRow()));
                } catch (VendaException | DataSourceException | ParseException ex) {
                    Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

       return true;
    }
    
    public boolean refreshListRelatorioItens(PedidoModel pedido) throws VendaException, DataSourceException, ParseException {
        List<ItemPedidoModel> itens = pedido.getItens();
        
        DefaultTableModel model = (DefaultTableModel) tblItens.getModel();
        model.setRowCount(0);
        
        if(itens == null || itens.size() <= 0){
           return false;
        }
        
        for(ItemPedidoModel itemPedido : itens) {
            ProdutoModel produto = itemPedido.getProduto();
            if(produto != null){
                Object[] row = new Object[5];
                row[0] = produto.getNome();
                row[1] = produto.getTipoProduto();
                row[2] = produto.getValorProduto();
                row[3] = itemPedido.getQtd();
                row[4] = itemPedido.getValorParcial();
                model.addRow(row);
            }
        }

       return true;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblItens;
    private javax.swing.JTable tblRelatorio;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicio;
    // End of variables declaration//GEN-END:variables
}