package telas;

import BancoDados.Conexao;
import classes.Equipamento;
import java.util.ArrayList;
import classes.Peca;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaListaPecas extends javax.swing.JInternalFrame
{
    private final TelaPrincipal telaPrincipal;
    private ArrayList<Peca> listaPecas;
    private ArrayList<Equipamento> listaEquipamentos;
    private long ultimoIdPeca;
    
    public TelaListaPecas(TelaPrincipal tela)
    {
        initComponents();
        this.ultimoIdPeca = 0;
        telaPrincipal = tela;
        
        carregarPecas();
        atualizarListaPecas();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPeca = new javax.swing.JTable();
        botaoEditar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Peças");

        tabelaPeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Modelo", "Fabricante", "Equipamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaPeca.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaPeca);

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoRemover)
                .addGap(18, 18, 18)
                .addComponent(botaoEditar)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditar)
                    .addComponent(botaoRemover))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        Peca pecaSelecionada;
        int indiceLista = 0;
        
        if(tabelaPeca.getSelectedRow() != -1)
        {
            if(telaPrincipal.abrirJanela(telaPrincipal.getTelaEditarPeca()))
            {
                pecaSelecionada = listaPecas.get(tabelaPeca.getSelectedRow());
                telaPrincipal.getTelaEditarPeca().getLabelId().setText(String.valueOf(pecaSelecionada.getId()));
                telaPrincipal.getTelaEditarPeca().getCampoNome().setText(pecaSelecionada.getNome());
                telaPrincipal.getTelaEditarPeca().getCampoModelo().setText(pecaSelecionada.getModelo());
                telaPrincipal.getTelaEditarPeca().getCampoFabricante().setText(pecaSelecionada.getFabricante());
                
                telaPrincipal.getTelaEditarPeca().getCampoEquipamento().removeAllItems();

                for(Equipamento item : telaPrincipal.getTelaListaEquipamentos().getListaEquipamentos())
                {
                    telaPrincipal.getTelaEditarPeca().getCampoEquipamento().addItem(item.getNome());

                    if(item == pecaSelecionada.getEquipamento())
                        {
                            telaPrincipal.getTelaEditarPeca().getCampoEquipamento().setSelectedIndex(indiceLista);
                        }

                    indiceLista++;
                }
            }
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if(tabelaPeca.getSelectedRow() != -1)
            removerPeca((listaPecas.get(tabelaPeca.getSelectedRow())));
    }//GEN-LAST:event_botaoRemoverActionPerformed
    
    public ArrayList<Peca> carregarPecas()
    {
        ArrayList<Peca> lista = new ArrayList<Peca>();
        listaEquipamentos = telaPrincipal.getTelaListaEquipamentos().getListaEquipamentos();
        
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "SELECT * FROM peca ORDER BY id_peca";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            ResultSet resultado = declaracao.getResultSet();
            
            while(resultado.next())
            {
                Peca peca = new Peca(resultado.getString("nome"), resultado.getString("modelo"), resultado.getString("fabricante"));
                
                for(Equipamento equipamento : listaEquipamentos)
                {
                if((equipamento.getId() + 1) == resultado.getInt("id_equip"))
                    peca.setEquipamento(equipamento);
                }
                
                peca.setId(resultado.getInt("id_peca") - 1);
                lista.add(peca);
            }
            
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listaPecas = lista;
        return lista;
    }
    
    public void adicionarPeca(Peca peca)
    {
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "SELECT last_value FROM peca_id_peca_seq;";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            ResultSet resultado = declaracao.getResultSet();
            resultado.next();
            ultimoIdPeca = resultado.getInt("last_value");
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        peca.setId(ultimoIdPeca);
        ultimoIdPeca++;
        listaPecas.add(peca);
        atualizarListaPecas();
        
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "INSERT INTO peca (nome, modelo, fabricante, id_equip) VALUES ('" + peca.getNome() + "', '" + peca.getModelo() + "', '" + peca.getFabricante() + "', '" + (peca.getEquipamento().getId() + 1) + "');";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaPecas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarPeca(Peca peca)
    {
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "UPDATE peca SET nome = '" + peca.getNome() + "', modelo = '" + peca.getModelo() + "', fabricante = '" + peca.getFabricante() + "', id_equip = '" + (peca.getEquipamento().getId() + 1) + "' WHERE id_peca = " + (peca.getId() + 1) + ";";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        carregarPecas();
        atualizarListaPecas();
    }
    
    public void removerPeca(Peca peca)
    {
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "DELETE FROM peca WHERE id_peca = " + (peca.getId() + 1) + ";";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            conexao.close();
            carregarPecas();
            atualizarListaPecas();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarListaPecas()
    {
        ((DefaultTableModel) tabelaPeca.getModel()).setNumRows(0);
        
        for(Peca item : listaPecas)
            ((DefaultTableModel) tabelaPeca.getModel()).addRow(new Object[]{ item.getId(), item.getNome(), item.getModelo(), item.getFabricante(), item.getEquipamento().getNome() });
    }
    
    public ArrayList<Peca> getListaPecas()
    {
        return listaPecas;
    }

    public JTable getTabelaPeca()
    {
        return tabelaPeca;
    }

    public long getUltimoIdPeca()
    {
        return ultimoIdPeca;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPeca;
    // End of variables declaration//GEN-END:variables
}