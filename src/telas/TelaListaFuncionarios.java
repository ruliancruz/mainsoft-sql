package telas;

import BancoDados.Conexao;
import java.util.ArrayList;
import classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class TelaListaFuncionarios extends javax.swing.JInternalFrame
{
    private final TelaPrincipal telaPrincipal;
    private ArrayList<Funcionario> listaFuncionarios;
    private long ultimoIdFuncionario;    

    public TelaListaFuncionarios(TelaPrincipal tela)
    {
        initComponents();
        this.ultimoIdFuncionario = 0;
        telaPrincipal = tela;
        
        carregarFuncionarios();
        atualizarListaFuncionarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        botaoEditar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista de Funcionários");
        setToolTipText("");

        tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncionario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaFuncionario);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoRemover)
                    .addComponent(botaoEditar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public ArrayList<Funcionario> carregarFuncionarios()
    {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "SELECT * FROM funcionario ORDER BY id_func";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            ResultSet resultado = declaracao.getResultSet();
            
            while(resultado.next())
            {
                Funcionario funcionario = new Funcionario(resultado.getString("nome"));
                funcionario.setId(resultado.getInt("id_func") - 1);
                lista.add(funcionario);
            }
            
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listaFuncionarios = lista;
        return lista;
    }
    
    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        Funcionario funcionarioSelecionado;
        
        if(tabelaFuncionario.getSelectedRow() != -1)
        {
            if(telaPrincipal.abrirJanela(telaPrincipal.getTelaEditarFuncionario()))
            {
                funcionarioSelecionado = listaFuncionarios.get(tabelaFuncionario.getSelectedRow());
                telaPrincipal.getTelaEditarFuncionario().getLabelId().setText(String.valueOf(funcionarioSelecionado.getId()));
                telaPrincipal.getTelaEditarFuncionario().getCampoNome().setText(funcionarioSelecionado.getNome());
            }
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if(tabelaFuncionario.getSelectedRow() != -1)
            removerFuncionario((listaFuncionarios.get(tabelaFuncionario.getSelectedRow())));
    }//GEN-LAST:event_botaoRemoverActionPerformed
    
    public void adicionarFuncionario(Funcionario funcionario)
    {
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "SELECT last_value FROM funcionario_id_func_seq;";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            ResultSet resultado = declaracao.getResultSet();
            resultado.next();
            ultimoIdFuncionario = resultado.getInt("last_value");
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        funcionario.setId(ultimoIdFuncionario);
        ultimoIdFuncionario++;
        listaFuncionarios.add(funcionario);
        atualizarListaFuncionarios();
        
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "INSERT INTO funcionario (nome) VALUES ('" + funcionario.getNome() + "');";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarFuncionario(Funcionario funcionario)
    {
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "UPDATE funcionario SET nome = '" + funcionario.getNome() + "' WHERE id_func = " + (funcionario.getId() + 1) + ";";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        carregarFuncionarios();
        atualizarListaFuncionarios();
    }
    
    public void removerFuncionario(Funcionario funcionario)
    {
        try
        {
            int quantidadeDependencias = 0;
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "SELECT id_func FROM manutencao WHERE id_func = " + (funcionario.getId() + 1) + ";";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            ResultSet resultado = declaracao.getResultSet();
            
            while(resultado.next())
                quantidadeDependencias++;
            
            if(quantidadeDependencias > 0 && JOptionPane.showConfirmDialog(this, "Foram encontrados " + quantidadeDependencias + " registros que utilizam este funcionário, deseja removê-los?", "Confirmar Remoção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0)
            {
                sqlScript = "DELETE FROM manutencao_corretiva WHERE id_manu IN (SELECT id_manu FROM manutencao WHERE id_func = " + (funcionario.getId() + 1) + ");";
                declaracao = conexao.prepareStatement(sqlScript);
                declaracao.execute();
                sqlScript = "DELETE FROM manutencao_preventiva WHERE id_manu IN (SELECT id_manu FROM manutencao WHERE id_func = " + (funcionario.getId() + 1) + ");";
                declaracao = conexao.prepareStatement(sqlScript);
                declaracao.execute();
                sqlScript = "DELETE FROM manutencao WHERE id_func = " + (funcionario.getId() + 1) + ";";
                declaracao = conexao.prepareStatement(sqlScript);
                declaracao.execute();
                sqlScript = "DELETE FROM funcionario WHERE id_func = " + (funcionario.getId() + 1) + ";";
                declaracao = conexao.prepareStatement(sqlScript);
                declaracao.execute();
                telaPrincipal.carregarManutencoes();
                telaPrincipal.atualizarListaManutencoes();
            }
            
            conexao.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            Connection conexao = new Conexao().getConexao();
            String sqlScript = "DELETE FROM funcionario WHERE id_func = " + (funcionario.getId() + 1) + ";";
            PreparedStatement declaracao = conexao.prepareStatement(sqlScript);
            declaracao.execute();
            conexao.close();
            carregarFuncionarios();
            atualizarListaFuncionarios();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarListaFuncionarios()
    {
        ((DefaultTableModel) tabelaFuncionario.getModel()).setNumRows(0);
        
        for(Funcionario item : listaFuncionarios)
            ((DefaultTableModel) tabelaFuncionario.getModel()).addRow(new Object[]{ item.getId(), item.getNome() });
    }
    
    public ArrayList<Funcionario> getListaFuncionarios()
    {
        return listaFuncionarios;
    }

    public JTable getTabelaFuncionario()
    {
        return tabelaFuncionario;
    }

    public long getUltimoIdFuncionario()
    {
        return ultimoIdFuncionario;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaFuncionario;
    // End of variables declaration//GEN-END:variables
}