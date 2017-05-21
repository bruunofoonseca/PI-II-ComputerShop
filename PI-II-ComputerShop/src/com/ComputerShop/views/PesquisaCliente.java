package com.ComputerShop.views;

import com.ComputerShop.models.CadastraCliente;
import com.ComputerShop.exceptions.ClienteException;
import com.ComputerShop.services.ServiceCliente;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//Pesquisa cliente
public class PesquisaCliente extends javax.swing.JFrame {
    //Instância do form de edição de clientes
    EditarCliente formEditarCliente = new EditarCliente();
    // Armazena a última pesquisa
    String ultimaPesquisa = null;
    
    //Contrutor e inicializaçãode componetes
    public PesquisaCliente() {
        initComponents();
        //Fazer não mostrar o ID na tela
        tabelaResultados.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaResultados.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaResultados.getColumnModel().getColumn(0).setWidth(0);
    }
    //Código gerado do GUI Builder
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesquisaNome = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        excluir = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesquisa de Cliente");

        jLabel1.setText("Nome:");

        pesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaNomeActionPerformed(evt);
            }
        });

        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        tabelaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Endereço", "Número", "CEP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(tabelaResultados);
        if (tabelaResultados.getColumnModel().getColumnCount() > 0) {
            tabelaResultados.getColumnModel().getColumn(0).setMinWidth(100);
            tabelaResultados.getColumnModel().getColumn(2).setMinWidth(200);
            tabelaResultados.getColumnModel().getColumn(3).setMinWidth(50);
            tabelaResultados.getColumnModel().getColumn(4).setMinWidth(50);
        }

        jLabel2.setText("CPF");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        editar.setText("Editar");

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(excluir)
                    .addComponent(editar))
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

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        //Trata o botão excluir
        //Verifica se há itens selecionados para exclusão.
        //Caso negativo, ignora o comando
        if (tabelaResultados.getSelectedRow() >= 0) {
            
            //Obtém a linha do item selecionado
            final int row = tabelaResultados.getSelectedRow();
            //Obtém o nome do cliente da linha indicada para exibição
            //de mensagem de confirmação de exclusão utilizando seu nome
            String nome = (String) tabelaResultados.getValueAt(row, 1);
            //Mostra o diálogo de confirmação de exclusão
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                "Excluir o cliente \"" + nome + "\"?",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            //Se o valor de resposta for "Sim" para a exclusão
            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    //Obtém o ID do cliente
                    Integer id = (Integer) tabelaResultados.getValueAt(row, 0);
                    //Solicita ao serviço a inativação do cliente com o ID
                    ServiceCliente.excluirCliente(id);
                    //Atualiza a lista após a "exclusão"
                    this.refreshList();
                } catch (Exception e) {
                    //Se ocorrer algum erro técnico, mostra-o no console,
                    //mas esconde-o do usuário
                    e.printStackTrace();
                    //Exibe uma mensagem de erro genérica ao usuário
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(),
                            "Falha na Exclusão", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        /* Inicializa o sucesso da pesquisa com valor negativo, indicando que
        a pesquisa de clientes não obteve resultados (situação padrão)*/
        boolean resultSearch = false;
        
        /*Grava o campo de pesquisa como a última pesquisa válida. O valor
        de última pesquisa válida é utilizado na atualização da lista*/
        ultimaPesquisa = pesquisaNome.getText();
        
        try{
            //Solicita atualização da lista
            resultSearch = refreshList();
        }catch (Exception e){
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
    }//GEN-LAST:event_pesquisarActionPerformed

    private void pesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisaNomeActionPerformed
    //Abre um internal frame centralizado na tela
    public void opemFrameInCenter(JInternalFrame jif){
        Dimension desktopSize = this.getParent().getSize();
        Dimension jInternelFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternelFrameSize.width);
        int height = (desktopSize.height - jInternelFrameSize.height);
        jif.setLocation(width, height);
        jif.setVisible(true);
    }
    
    
    //Atualizar lista de clientes.  Pode ser chamado por outras telas
    public boolean refreshList() throws ClienteException, Exception {
        /*Realiza a pesquisa de clientes com o último valor de pesquisa
        para atualizar a lista*/
        List<CadastraCliente> resultado = ServiceCliente.procurarCliente(ultimaPesquisa);
        
        //Obtém elemento representante do conteúdo da tabela na tela
        DefaultTableModel model = (DefaultTableModel) tabelaResultados.getModel();
        /*Indica que a tabela deve excluir todos seus elementos.
        Deve limpar a lista, mesmo que não tenha sucesso da pesquisa
        */
        model.setRowCount(0);
        
        /*Verifica se não existiram resultados. Caso afirmativo, encerra a
        atualização e indica ao elemento acionador o não sucesso da pesquisa*/
       if(resultado == null || resultado.size() <= 0){
           return false;
       }
    
       //Percorre a lista de resultados e os adiciona na tabela
        for (int i = 0; i < resultado.size(); i++) {
            CadastraCliente cli = resultado.get(i);
            if(cli != null){
                Object[] row = new Object[5];
                row[0] = cli.getNome();
                row[1] = cli.getCpf();
                row[2] = cli.getLogradouro();
                SimpleDateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
                row[3] = cli.getNumero();
                row[4] = cli.getCep();
                model.addRow(row);
            }
        }
       /*Se chegamos até aqui, a pesquisa teve sucesso, então
        retornamos "true" para o elemento acionante, indicando
        que não devem ser exibidas mensagens de erro*/
       return true;
    }
    
    //Trata cliques na tabela de resultados
    private void tabelaResultadosMouseClicked(java.awt.event.MouseEvent evt){
        //Verifica se o clique é um clique duplo
        if(evt.getClickCount() == 2){
            try{
            //Obtém a linha selecionado da tabela de resultados
            final int row = tabelaResultados.getSelectedRow();
            //Obtém o valor do ID da coluna
            Integer id = (Integer) tabelaResultados.getValueAt(row, 0);
            
            CadastraCliente cliente = ServiceCliente.obterCliente(id);
            
            /*Cria uma nova instância da tela de edição,
            configura o cliente selecionado como elemento a
            ser editado e mostra a tela de edição.
            Para exibir a tela, é necessário adicioná-la ao
            componente de desktop, o "pai" da janela corrente*/
            formEditarCliente.dispose();
            formEditarCliente = new EditarCliente();
            formEditarCliente.setCliente(cliente);
            formEditarCliente.setTitle(cliente.getNome());
            this.getParent().add(formEditarCliente);
            this.opemFrameInCenter(formEditarCliente);
            formEditarCliente.toFront();
        }catch(Exception e){
            //Exibe uma mensagem de erro genérica ao usuário
                JOptionPane.showMessageDialog(rootPane, "Não é possível "
                    + "exibir os detalhes deste cliente.",
                    "Erro ao abrir detalhe", JOptionPane.ERROR_MESSAGE);
        } 
    }
 }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editar;
    private javax.swing.JButton excluir;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField pesquisaNome;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTable tabelaResultados;
    // End of variables declaration//GEN-END:variables

    private void opemFrameInCenter(EditarCliente formEditarCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
