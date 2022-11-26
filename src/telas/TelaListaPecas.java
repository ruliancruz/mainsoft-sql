package telas;

import classes.Equipamento;
import java.util.ArrayList;
import classes.Peca;
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

public class TelaListaPecas extends javax.swing.JInternalFrame
{
    private final TelaPrincipal telaPrincipal;
    private final String caminhoPastaPecas;
    private final String caminhoArquivoPecas;
    private final String caminhoPecas;
    private ArrayList<Peca> listaPecas;
    private long ultimoIdPeca;
    
    public TelaListaPecas(TelaPrincipal tela)
    {
        initComponents();
        this.caminhoPastaPecas = "data";
        this.caminhoArquivoPecas = "pecas.dat";
        this.caminhoPecas = caminhoPastaPecas + "/" + caminhoArquivoPecas;
        this.ultimoIdPeca = 0;
        telaPrincipal = tela;
        
        try
        {
            listaPecas = carregarPecas();
        }
        catch (IOException ex)
        {
            Logger.getLogger(TelaListaPecas.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(TelaListaPecas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        // TODO add your handling code here:
        Peca pecaSelecionada;
        int indiceLista = 0;
        
        if(tabelaPeca.getSelectedRow() != -1)
        {
            if(telaPrincipal.abrirJanela(telaPrincipal.getTelaEditarPeca()))
            {
                pecaSelecionada = listaPecas.get(tabelaPeca.getSelectedRow());
                telaPrincipal.getTelaEditarPeca().setPosicaoListaPeca(tabelaPeca.getSelectedRow());
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
        // TODO add your handling code here:
        if(tabelaPeca.getSelectedRow() != -1)
        {
            removerPeca((listaPecas.get(tabelaPeca.getSelectedRow())));
            atualizarListaPecas();
        }
    }//GEN-LAST:event_botaoRemoverActionPerformed
    
    public void salvarPecas() throws FileNotFoundException, IOException
    {
        File arquivo = new File("data");
        
        if(arquivo.exists() || arquivo.isDirectory())
            arquivo.mkdir();
        
        ObjectOutputStream registrador = new ObjectOutputStream(new FileOutputStream(caminhoPecas));
        registrador.writeObject(listaPecas);
        registrador.close();
    }
    
    public ArrayList<Peca> carregarPecas() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ArrayList<Peca> lista = new ArrayList<Peca>();
        
        File arquivo = new File("data");
        
        if(!arquivo.exists() && !arquivo.isDirectory())
            arquivo.mkdir();
        
        arquivo = new File(caminhoPecas);
        
        if(arquivo.exists())
        {
            ObjectInputStream carregador = new ObjectInputStream(new FileInputStream(caminhoPecas));
            
            try
            {
               lista = (ArrayList<Peca>) carregador.readObject(); 
               carregador.close();
            }
            catch (Exception e)
            {
                carregador.close();
                return lista;
            }
            
            if(lista != null && lista.size() != 0)
                ultimoIdPeca = lista.get(lista.size() - 1).getId() + 1;
        }
        
        return lista;
    }
    
    public void adicionarPeca(Peca peca)
    {
        peca.setId(ultimoIdPeca);
        ultimoIdPeca++;
        listaPecas.add(peca);
        atualizarListaPecas();
    }
    
    public void editarPeca(Peca peca, int posicao)
    {
        listaPecas.remove(posicao);
        listaPecas.add(posicao, peca);
        atualizarListaPecas();
    }
    
    public void removerPeca(Peca peca)
    {
        listaPecas.remove(peca);
        atualizarListaPecas();
    }
    
    public void atualizarListaPecas()
    {
        ((DefaultTableModel) tabelaPeca.getModel()).setNumRows(0);
        
        for(Peca item : listaPecas)
            ((DefaultTableModel) tabelaPeca.getModel()).addRow(new Object[]{ item.getId(), item.getNome(), item.getModelo(), item.getFabricante(), item.getEquipamento().getNome() });
        
        try
        {
            salvarPecas();
        }
        catch (IOException ex)
        {
            Logger.getLogger(TelaListaPecas.class.getName()).log(Level.SEVERE, null, ex);
        }
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