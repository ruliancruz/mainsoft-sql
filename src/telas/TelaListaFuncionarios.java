package telas;

import java.util.ArrayList;
import classes.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaListaFuncionarios extends javax.swing.JInternalFrame
{
    private final TelaPrincipal telaPrincipal;
    private final String caminhoPastaFuncionarios;
    private final String caminhoArquivoFuncionarios;
    private final String caminhoFuncionarios;
    private ArrayList<Funcionario> listaFuncionarios;
    private long ultimoIdFuncionario;    

    public TelaListaFuncionarios(TelaPrincipal tela)
    {
        initComponents();
        this.caminhoPastaFuncionarios = "data";
        this.caminhoArquivoFuncionarios = "funcionarios.dat";
        this.caminhoFuncionarios = caminhoPastaFuncionarios + "/" + caminhoArquivoFuncionarios;
        this.ultimoIdFuncionario = 0;
        telaPrincipal = tela;
        
        try
        {
            listaFuncionarios = carregarFuncionarios();
        }
        catch (IOException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    
    public void salvarFuncionarios() throws FileNotFoundException, IOException
    {
        File arquivo = new File("data");
        
        if(arquivo.exists() || arquivo.isDirectory())
            arquivo.mkdir();
        
        ObjectOutputStream registrador = new ObjectOutputStream(new FileOutputStream(caminhoFuncionarios));
        registrador.writeObject(listaFuncionarios);
        registrador.close();
    }
    
    public ArrayList<Funcionario> carregarFuncionarios() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        
        File arquivo = new File("data");
        
        if(!arquivo.exists() && !arquivo.isDirectory())
            arquivo.mkdir();
        
        arquivo = new File(caminhoFuncionarios);
        
        if(arquivo.exists())
        {
            ObjectInputStream carregador = new ObjectInputStream(new FileInputStream(caminhoFuncionarios));
            
            try
            {
                lista = (ArrayList<Funcionario>) carregador.readObject();
                carregador.close();
            }
            catch (Exception e)
            {
                carregador.close();
                return lista;
            }
            
            if(lista != null && lista.size() != 0)
                ultimoIdFuncionario = lista.get(lista.size() - 1).getId() + 1;
        }
        
        return lista;
    }
    
    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        // TODO add your handling code here:
        Funcionario funcionarioSelecionado;
        
        if(tabelaFuncionario.getSelectedRow() != -1)
        {
            if(telaPrincipal.abrirJanela(telaPrincipal.getTelaEditarFuncionario()))
            {
                funcionarioSelecionado = listaFuncionarios.get(tabelaFuncionario.getSelectedRow());
                telaPrincipal.getTelaEditarFuncionario().setPosicaoListaFuncionario(tabelaFuncionario.getSelectedRow());
                telaPrincipal.getTelaEditarFuncionario().getLabelId().setText(String.valueOf(funcionarioSelecionado.getId()));
                telaPrincipal.getTelaEditarFuncionario().getCampoNome().setText(funcionarioSelecionado.getNome());
            }
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        // TODO add your handling code here:
        if(tabelaFuncionario.getSelectedRow() != -1)
        {
            removerFuncionario((listaFuncionarios.get(tabelaFuncionario.getSelectedRow())));
            atualizarListaFuncionarios();
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed
    
    public void adicionarFuncionario(Funcionario funcionario)
    {
        funcionario.setId(ultimoIdFuncionario);
        ultimoIdFuncionario++;
        listaFuncionarios.add(funcionario);
        atualizarListaFuncionarios();
    }
    
    public void editarFuncionario(Funcionario funcionario, int posicao)
    {
        listaFuncionarios.remove(posicao);
        listaFuncionarios.add(posicao, funcionario);
        atualizarListaFuncionarios();
    }
    
    public void removerFuncionario(Funcionario funcionario)
    {
        listaFuncionarios.remove(funcionario);
        atualizarListaFuncionarios();
    }
    
    public void atualizarListaFuncionarios()
    {
        ((DefaultTableModel) tabelaFuncionario.getModel()).setNumRows(0);
        
        for(Funcionario item : listaFuncionarios)
            ((DefaultTableModel) tabelaFuncionario.getModel()).addRow(new Object[]{ item.getId(), item.getNome() });
         
        try
        {
            salvarFuncionarios();
        }
        catch (IOException ex)
        {
            Logger.getLogger(TelaListaFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
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