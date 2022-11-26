package telas;
import classes.Manutencao;
import classes.ManutencaoCorretiva;
import classes.Utils;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaManutencaoCorretiva extends javax.swing.JInternalFrame implements Utils
{
    private final TelaPrincipal telaPrincipal;
    
    public TelaManutencaoCorretiva(TelaPrincipal tela)
    {
        initComponents();
        telaPrincipal = tela;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelDataConclusao = new javax.swing.JLabel();
        labelHorarioConclusao = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoDataInicio = new javax.swing.JFormattedTextField();
        campoHorarioInicio = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoCausaFalha = new javax.swing.JTextArea();
        campoHorarioConclusao = new javax.swing.JFormattedTextField();
        campoDataConclusao = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        campoResponsavel = new javax.swing.JComboBox<>();
        campoEquipamento = new javax.swing.JComboBox<>();
        labelId = new javax.swing.JLabel();
        campoManutencaoConcluida = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Cadastrar Manutenção Corretiva");

        campoId.setText("Ordem de Serviço ");

        jLabel2.setText("Equipamento: ");

        jLabel3.setText("Responsável: ");

        jLabel5.setText("Data de Início:");

        jLabel6.setText("Horário de Início");

        labelDataConclusao.setText("Data de Conclusão:");
        labelDataConclusao.setEnabled(false);

        labelHorarioConclusao.setText("Horário de Conclusão:");
        labelHorarioConclusao.setEnabled(false);

        jLabel9.setText("Causa da Falha:");

        campoDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        campoHorarioInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        campoCausaFalha.setColumns(20);
        campoCausaFalha.setRows(5);
        jScrollPane1.setViewportView(campoCausaFalha);

        campoHorarioConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        campoHorarioConclusao.setEnabled(false);

        campoDataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        campoDataConclusao.setEnabled(false);

        jLabel10.setText("Descrição:");

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane2.setViewportView(campoDescricao);

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        labelId.setText("0");

        campoManutencaoConcluida.setText("Manutenção não concluída");
        campoManutencaoConcluida.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoManutencaoConcluidaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelId))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(botaoCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(botaoSalvar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelHorarioConclusao)
                                    .addComponent(labelDataConclusao))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoHorarioConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoManutencaoConcluida)
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(54, 54, 54)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoHorarioInicio)
                                    .addComponent(campoDataInicio)
                                    .addComponent(campoResponsavel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoId)
                    .addComponent(labelId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoManutencaoConcluida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataConclusao)
                    .addComponent(campoDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHorarioConclusao)
                    .addComponent(campoHorarioConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void limparCampos() {
        campoDataInicio.setText("");
        campoHorarioInicio.setText("");
        campoDataConclusao.setText("");
        campoHorarioConclusao.setText("");
        campoCausaFalha.setText("");
        campoDescricao.setText("");
    }
    
    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        boolean formularioValido = true;
        
        if(campoEquipamento.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this, "Erro! Não há nenhum equipamento cadastrado", "Erro!", JOptionPane.ERROR_MESSAGE);
            formularioValido = false;
        }
        
        if(campoResponsavel.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this, "Erro! Não há nenhum funcionário cadastrado", "Erro!", JOptionPane.ERROR_MESSAGE);
            formularioValido = false;
        }
        
        if(campoDataInicio.getText() == null || campoDataInicio.getText().isEmpty() || campoDataInicio.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Erro! O campo Data de Início precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
            formularioValido = false;
        }
        
        if(campoHorarioInicio.getText() == null || campoHorarioInicio.getText().isEmpty() || campoHorarioInicio.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Erro! O campo Horário de Início precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
            formularioValido = false;
        }
        
        if(campoManutencaoConcluida.isSelected())
        {
            if(campoDataConclusao.getText() == null || campoDataConclusao.getText().isEmpty() || campoDataConclusao.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Erro! Para registrar uma manutenção concluída, o campo Data de Conclusão precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
                formularioValido = false;
            }
        
            if(campoDataConclusao.getText() == null || campoHorarioConclusao.getText().isEmpty() || campoHorarioConclusao.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Erro! Para registrar uma manutenção concluída, o campo Horário de Conclusão precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        if(formularioValido == true)
        {
            Manutencao manutencao = new ManutencaoCorretiva
            (
                telaPrincipal.getTelaListaEquipamentos().getListaEquipamentos().get(campoEquipamento.getSelectedIndex()),
                telaPrincipal.getTelaListaFuncionarios().getListaFuncionarios().get(campoResponsavel.getSelectedIndex()),
                campoDataInicio.getText() + " " + campoHorarioInicio.getText(),
                campoDataConclusao.getText() + " " + campoHorarioConclusao.getText(),
                campoCausaFalha.getText(),
                campoDescricao.getText(),
                campoManutencaoConcluida.isSelected()
            );
        
            telaPrincipal.adicionarManutencao(manutencao);
            telaPrincipal.fecharLimparJanela(this);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        telaPrincipal.fecharLimparJanela(this);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void campoManutencaoConcluidaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_campoManutencaoConcluidaStateChanged
        Calendar agora;
        
        if(campoManutencaoConcluida.isSelected())
        {
            campoManutencaoConcluida.setText("Manutenção concluída");
            labelDataConclusao.setEnabled(true);
            campoDataConclusao.setEnabled(true);
            labelHorarioConclusao.setEnabled(true);
            campoHorarioConclusao.setEnabled(true);
        }
        else
        {
            campoManutencaoConcluida.setText("Manutenção não concluída");
            labelDataConclusao.setEnabled(false);
            campoDataConclusao.setEnabled(false);
            labelHorarioConclusao.setEnabled(false);
            campoHorarioConclusao.setEnabled(false);
            agora = Calendar.getInstance();
            campoDataConclusao.setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
            campoHorarioConclusao.setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
        }
    }//GEN-LAST:event_campoManutencaoConcluidaStateChanged

    public JComboBox<String> getCampoEquipamento()
    {
        return campoEquipamento;
    }
    
    public JComboBox<String> getCampoResponsavel()
    {
        return campoResponsavel;
    }

    public JFormattedTextField getCampoDataInicio()
    {
        return campoDataInicio;
    }

    public JFormattedTextField getCampoHorarioInicio()
    {
        return campoHorarioInicio;
    }

    public JFormattedTextField getCampoDataConclusao() {
        return campoDataConclusao;
    }

    public JFormattedTextField getCampoHorarioConclusao() {
        return campoHorarioConclusao;
    }
    
    public JLabel getLabelId()
    {
        return labelId;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextArea campoCausaFalha;
    private javax.swing.JFormattedTextField campoDataConclusao;
    private javax.swing.JFormattedTextField campoDataInicio;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JComboBox<String> campoEquipamento;
    private javax.swing.JFormattedTextField campoHorarioConclusao;
    private javax.swing.JFormattedTextField campoHorarioInicio;
    private javax.swing.JLabel campoId;
    private javax.swing.JCheckBox campoManutencaoConcluida;
    private javax.swing.JComboBox<String> campoResponsavel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDataConclusao;
    private javax.swing.JLabel labelHorarioConclusao;
    private javax.swing.JLabel labelId;
    // End of variables declaration//GEN-END:variables
}