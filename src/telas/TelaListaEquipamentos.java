package telas;
import java.util.ArrayList;
import classes.Equipamento;
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

public class TelaListaEquipamentos extends javax.swing.JInternalFrame
{
    private final TelaPrincipal telaPrincipal;
    private final String caminhoPastaEquipamentos;
    private final String caminhoArquivoEquipamentos;
    private final String caminhoEquipamentos;
    private ArrayList<Equipamento> listaEquipamentos;
    private long ultimoIdEquipamento;
    
    public TelaListaEquipamentos(TelaPrincipal tela)
    {
        initComponents();
        this.caminhoPastaEquipamentos = "data";
        this.caminhoArquivoEquipamentos = "equipamentos.dat";
        this.caminhoEquipamentos = caminhoPastaEquipamentos + "/" + caminhoArquivoEquipamentos;
        this.ultimoIdEquipamento = 0;
        telaPrincipal = tela;
        
        try
        {
            listaEquipamentos = carregarEquipamentos();
        }
        catch (IOException ex)
        {
            Logger.getLogger(TelaListaEquipamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(TelaListaEquipamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    
    public void salvarEquipamentos() throws FileNotFoundException, IOException
    {
        File arquivo = new File("data");
        
        if(arquivo.exists() || arquivo.isDirectory())
            arquivo.mkdir();
        
        ObjectOutputStream registrador = new ObjectOutputStream(new FileOutputStream(caminhoEquipamentos));
        registrador.writeObject(listaEquipamentos);
        registrador.close();
    }
    
    public ArrayList<Equipamento> carregarEquipamentos() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ArrayList<Equipamento> lista = new ArrayList<Equipamento>();
        
        File arquivo = new File("data");
        
        if(!arquivo.exists() && !arquivo.isDirectory())
            arquivo.mkdir();
        
        arquivo = new File(caminhoEquipamentos);
        
        if(arquivo.exists())
        {
            ObjectInputStream carregador = new ObjectInputStream(new FileInputStream(caminhoEquipamentos));
            
            try
            {
                lista = (ArrayList<Equipamento>) carregador.readObject();
                carregador.close();
            }
            catch (Exception e)
            {
                carregador.close();
                return lista;
            }
            
            if(lista != null && lista.size() != 0)
                ultimoIdEquipamento = lista.get(lista.size() - 1).getId() + 1;
        }
        
        return lista;
    }
    
    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        // TODO add your handling code here:
        Equipamento equipamentoSelecionado;
        
        if(tabelaEquipamento.getSelectedRow() != -1)
        {
            if(telaPrincipal.abrirJanela(telaPrincipal.getTelaEditarEquipamento()))
            {
                equipamentoSelecionado = listaEquipamentos.get(tabelaEquipamento.getSelectedRow());
                telaPrincipal.getTelaEditarEquipamento().setPosicaoListaEquipamento(tabelaEquipamento.getSelectedRow());
                telaPrincipal.getTelaEditarEquipamento().getLabelId().setText(String.valueOf(equipamentoSelecionado.getId()));
                telaPrincipal.getTelaEditarEquipamento().getCampoNome().setText(equipamentoSelecionado.getNome());
                telaPrincipal.getTelaEditarEquipamento().getCampoModelo().setText(equipamentoSelecionado.getModelo());
                telaPrincipal.getTelaEditarEquipamento().getCampoFabricante().setText(equipamentoSelecionado.getFabricante());
                telaPrincipal.getTelaEditarEquipamento().getCampoDataAquisicao().setText(equipamentoSelecionado.getDataAquisicaoString());
            }
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        // TODO add your handling code here:
        if(tabelaEquipamento.getSelectedRow() != -1)
        {
            removerEquipamento((listaEquipamentos.get(tabelaEquipamento.getSelectedRow())));
            atualizarListaEquipamentos();
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed
    
    public void adicionarEquipamento(Equipamento equipamento)
    {
        equipamento.setId(ultimoIdEquipamento);
        ultimoIdEquipamento++;
        listaEquipamentos.add(equipamento);
        atualizarListaEquipamentos();
    }
    
    public void editarEquipamento(Equipamento equipamento, int posicao)
    {
        listaEquipamentos.remove(posicao);
        listaEquipamentos.add(posicao, equipamento);
        atualizarListaEquipamentos();
    }
    
    public void removerEquipamento(Equipamento equipamento)
    {
        listaEquipamentos.remove(equipamento);
        atualizarListaEquipamentos();
    }
    
    public void atualizarListaEquipamentos()
    {
        ((DefaultTableModel) tabelaEquipamento.getModel()).setNumRows(0);
        
        for(Equipamento item : listaEquipamentos)
            ((DefaultTableModel) tabelaEquipamento.getModel()).addRow(new Object[]{ item.getId(), item.getNome(), item.getModelo(), item.getFabricante(), item.getDataAquisicaoString() });
        
        try
        {
            salvarEquipamentos();
        }
        catch (IOException ex)
        {
            Logger.getLogger(TelaListaEquipamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
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