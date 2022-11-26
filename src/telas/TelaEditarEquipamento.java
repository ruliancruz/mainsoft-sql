package telas;

import classes.Equipamento;
import classes.Manutencao;
import classes.Peca;
import classes.Utils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaEditarEquipamento extends javax.swing.JInternalFrame implements Utils
{
    private final TelaPrincipal telaPrincipal;
    private int posicaoListaEquipamento;
    
    public TelaEditarEquipamento(TelaPrincipal tela)
    {
        initComponents();
        telaPrincipal = tela;
    }
        
    @Override
    public void limparCampos()
    {
        campoNome.setText("");
        campoModelo.setText("");
        campoFabricante.setText("");
        campoDataAquisicao.setText("");
    }

    public JTextField getCampoNome()
    {
        return campoNome;
    }

    public JTextField getCampoModelo()
    {
        return campoModelo;
    }

    public JTextField getCampoFabricante()
    {
        return campoFabricante;
    }

    public JTextField getCampoDataAquisicao()
    {
        return campoDataAquisicao;
    }

    public JLabel getLabelId()
    {
        return labelId;
    }

    public void setPosicaoListaEquipamento(int posicaoListaEquipamento)
    {
        this.posicaoListaEquipamento = posicaoListaEquipamento;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoModelo = new javax.swing.JTextField();
        campoFabricante = new javax.swing.JTextField();
        campoDataAquisicao = new javax.swing.JTextField();

        setTitle("Editar Equipamento");

        jLabel1.setText("Equipamento");

        jLabel2.setText("Nome:");

        labelId.setText("0");

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo:");

        jLabel4.setText("Fabricante:");

        jLabel5.setText("Data de Aquisição:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(botaoSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelId))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(campoDataAquisicao))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(51, 51, 51)
                                    .addComponent(campoFabricante))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(73, 73, 73)
                                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(65, 65, 65)
                                    .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoDataAquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        boolean formularioValido = true;
        
        if(campoNome.getText() == null || campoNome.getText().isEmpty() || campoNome.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Erro! O campo Nome precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
            formularioValido = false;
        }
        
        if(campoDataAquisicao.getText() == null || campoDataAquisicao.getText().isEmpty() || campoDataAquisicao.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Erro! O campo Data de Aquisição precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(formularioValido == true)
        {
            Equipamento equipamento = new Equipamento(campoNome.getText(), campoModelo.getText(), campoFabricante.getText(), campoDataAquisicao.getText());
        
            equipamento.setId(Integer.parseInt(labelId.getText()));
            telaPrincipal.getTelaListaEquipamentos().editarEquipamento(equipamento, posicaoListaEquipamento);
        
            for(Manutencao item : telaPrincipal.getManutencoes())
            {
                if(item.getEquipamento().getId() == equipamento.getId())
               {
                   item.setEquipamento(equipamento);
               }
            }
        
            for(Peca item : telaPrincipal.getTelaListaPecas().getListaPecas())
            {
                if(item.getEquipamento().getId() == equipamento.getId())
                {
                    item.setEquipamento(equipamento);
                }
            }

            telaPrincipal.atualizarListaManutencoes();
            telaPrincipal.getTelaListaPecas().atualizarListaPecas();
            telaPrincipal.fecharLimparJanela(this);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // TODO add your handling code here:
        telaPrincipal.fecharLimparJanela(this);
    }//GEN-LAST:event_botaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoDataAquisicao;
    private javax.swing.JTextField campoFabricante;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelId;
    // End of variables declaration//GEN-END:variables
}
