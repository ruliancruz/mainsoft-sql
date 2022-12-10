package telas;

import BancoDados.Conexao;
import java.util.ArrayList;
import classes.Equipamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaListaEquipamentos extends javax.swing.JInternalFrame
{
    private final TelaPrincipal telaPrincipal;
    private ArrayList<Equipamento> listaEquipamentos;
    private long ultimoIdEquipamento;
    
    public TelaListaEquipamentos(TelaPrincipal tela)
    {
        initComponents();
        this.ultimoIdEquipamento = 0;
        telaPrincipal = tela;
        
        carregarEquipamentos();
        atualizarListaEquipamentos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEquipamento = new javax.swing.JTable();
        botaoEditar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Equipamentos");

        tabelaEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Modelo", "Fabricante", "Data de Aquisição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEquipamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaEquipamento);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoRemover)
                    .addComponent(botaoEditar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public ArrayList<Equipamento> carregarEquipamentos()
    {
        ArrayList<Equipamento> lista = new ArrayList<Equipamento>();
        
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "SELECT * FROM equipamento ORDER BY id_equip";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            ResultSet resultado = declaracao.getResultSet();
            
            while(resultado.next())
            {
                Equipamento equipamento = new Equipamento(resultado.getString("nome"), resultado.getString("modelo"), resultado.getString("fabricante"));
                equipamento.setDataAquisicaoSQL(resultado.getString("data_aquisicao"));
                equipamento.setId(resultado.getInt("id_equip") - 1);
                lista.add(equipamento);
            }
            
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listaEquipamentos = lista;
        return lista;
    }
    
    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        Equipamento equipamentoSelecionado;
        
        if(tabelaEquipamento.getSelectedRow() != -1)
        {
            if(telaPrincipal.abrirJanela(telaPrincipal.getTelaEditarEquipamento()))
            {
                equipamentoSelecionado = listaEquipamentos.get(tabelaEquipamento.getSelectedRow());
                telaPrincipal.getTelaEditarEquipamento().getLabelId().setText(String.valueOf(equipamentoSelecionado.getId()));
                telaPrincipal.getTelaEditarEquipamento().getCampoNome().setText(equipamentoSelecionado.getNome());
                telaPrincipal.getTelaEditarEquipamento().getCampoModelo().setText(equipamentoSelecionado.getModelo());
                telaPrincipal.getTelaEditarEquipamento().getCampoFabricante().setText(equipamentoSelecionado.getFabricante());
                telaPrincipal.getTelaEditarEquipamento().getCampoDataAquisicao().setText(equipamentoSelecionado.getDataAquisicaoString());
            }
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if(tabelaEquipamento.getSelectedRow() != -1)
            removerEquipamento((listaEquipamentos.get(tabelaEquipamento.getSelectedRow())));
    }//GEN-LAST:event_botaoRemoverActionPerformed
    
    public void adicionarEquipamento(Equipamento equipamento)
    {
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "SELECT last_value FROM equipamento_id_equip_seq;";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            ResultSet resultado = declaracao.getResultSet();
            resultado.next();
            ultimoIdEquipamento = resultado.getInt("last_value");
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        equipamento.setId(ultimoIdEquipamento);
        ultimoIdEquipamento++;
        listaEquipamentos.add(equipamento);
        atualizarListaEquipamentos();
        
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "INSERT INTO equipamento (nome, modelo, fabricante, data_aquisicao) VALUES ('" + equipamento.getNome() + "', '" + equipamento.getModelo() + "', '" + equipamento.getFabricante() + "', '" + equipamento.getDataAquisicaoStringSQL() + "');";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaEquipamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarEquipamento(Equipamento equipamento)
    {
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "UPDATE equipamento SET nome = '" + equipamento.getNome() + "', modelo = '" + equipamento.getModelo() + "', fabricante = '" + equipamento.getFabricante() + "', data_aquisicao = '" + equipamento.getDataAquisicaoStringSQL() + "' WHERE id_equip = " + (equipamento.getId() + 1) + ";";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        carregarEquipamentos();
        atualizarListaEquipamentos();
    }
    
    public void removerEquipamento(Equipamento equipamento)
    {
        try
        {
            int quantidadeDependencias = 0;
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "SELECT peca.id_equip FROM peca FULL JOIN manutencao ON peca.id_equip = manutencao.id_equip WHERE peca.id_equip = " + (equipamento.getId() + 1) + " OR manutencao.id_equip = " + (equipamento.getId() + 1) + ";";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            ResultSet resultado = declaracao.getResultSet();
            
            while(resultado.next())
                quantidadeDependencias++;
            
            if(quantidadeDependencias > 0 && JOptionPane.showConfirmDialog(this, "Foram encontrados " + quantidadeDependencias + " registros que utilizam este equipamento, deseja removê-los?", "Confirmar Remoção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0)
            {
                sqlScript = "DELETE FROM peca WHERE id_equip = " + (equipamento.getId() + 1) + ";";
                declaracao = conexao.prepareStatement(sqlScript);
                declaracao.execute();
                sqlScript = "DELETE FROM manutencao_corretiva WHERE id_manu IN (SELECT id_manu FROM manutencao WHERE id_equip = " + (equipamento.getId() + 1) + ");";
                declaracao = conexao.prepareStatement(sqlScript);
                declaracao.execute();
                sqlScript = "DELETE FROM manutencao_preventiva WHERE id_manu IN (SELECT id_manu FROM manutencao WHERE id_equip = " + (equipamento.getId() + 1) + ");";
                declaracao = conexao.prepareStatement(sqlScript);
                declaracao.execute();
                sqlScript = "DELETE FROM manutencao WHERE id_equip = " + (equipamento.getId() + 1) + ";";
                declaracao = conexao.prepareStatement(sqlScript);
                declaracao.execute();
                
                telaPrincipal.carregarManutencoes();
                telaPrincipal.atualizarListaManutencoes();
                telaPrincipal.getTelaListaPecas().carregarPecas();
                telaPrincipal.getTelaListaPecas().atualizarListaPecas();
            }
            
            sqlScript = "DELETE FROM equipamento WHERE id_equip = " + (equipamento.getId() + 1) + ";";
            declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            conexao.close();
            carregarEquipamentos();
            atualizarListaEquipamentos();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarListaEquipamentos()
    {
        ((DefaultTableModel) tabelaEquipamento.getModel()).setNumRows(0);
        
        for(Equipamento item : listaEquipamentos)
            ((DefaultTableModel) tabelaEquipamento.getModel()).addRow(new Object[]{ item.getId(), item.getNome(), item.getModelo(), item.getFabricante(), item.getDataAquisicaoString() });
    }
    
    public ArrayList<Equipamento> getListaEquipamentos()
    {
        return listaEquipamentos;
    }

    public JTable getTabelaEquipamento()
    {
        return tabelaEquipamento;
    }

    public long getUltimoIdEquipamento()
    {
        return ultimoIdEquipamento;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEquipamento;
    // End of variables declaration//GEN-END:variables
}