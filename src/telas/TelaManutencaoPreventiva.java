package telas;
import classes.Manutencao;
import classes.ManutencaoPreventiva;
import classes.Utils;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaManutencaoPreventiva extends javax.swing.JInternalFrame implements Utils
{
    private final TelaPrincipal telaPrincipal;
    
    public TelaManutencaoPreventiva(TelaPrincipal tela)
    {
        initComponents();
        telaPrincipal = tela;
    }
    
    @Override
    public void limparCampos(){
        
        campoDataAgendamento.setText("");
        campoHorarioAgendamento.setText("");
        campoDataInicio.setText("");
        campoHorarioInicio.setText("");
        campoDataConclusao.setText("");
        campoHorarioConclusao.setText("");
        campoPeriodicidade.setText("");
        campoDescricao.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelDataInicio = new javax.swing.JLabel();
        labelHorarioInicio = new javax.swing.JLabel();
        labelDataConclusao = new javax.swing.JLabel();
        labelHorarioConclusao = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoDataAgendamento = new javax.swing.JFormattedTextField();
        campoHorarioAgendamento = new javax.swing.JFormattedTextField();
        campoDataInicio = new javax.swing.JFormattedTextField();
        campoHorarioInicio = new javax.swing.JFormattedTextField();
        campoDataConclusao = new javax.swing.JFormattedTextField();
        campoHorarioConclusao = new javax.swing.JFormattedTextField();
        campoPeriodicidade = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        campoEquipamento = new javax.swing.JComboBox<>();
        campoResponsavel = new javax.swing.JComboBox<>();
        labelId = new javax.swing.JLabel();
        campoManutencaoIniciada = new javax.swing.JCheckBox();
        campoManutencaoConcluida = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Cadastrar Manutenção Preventiva");

        campoId.setText("Ordem de Serviço");

        jLabel2.setText("Equipamento:");

        jLabel3.setText("Responsável:");

        jLabel4.setText("Data de Agendamento:");

        jLabel5.setText("Horário de Agendamento:");

        labelDataInicio.setText("Data de Início:");
        labelDataInicio.setEnabled(false);

        labelHorarioInicio.setText("Horário de Início:");
        labelHorarioInicio.setEnabled(false);

        labelDataConclusao.setText("Data de Conclusão:");
        labelDataConclusao.setEnabled(false);

        labelHorarioConclusao.setText("Horário de Conclusão:");
        labelHorarioConclusao.setEnabled(false);

        jLabel10.setText("Periodicidade:");

        jLabel12.setText("Descrição:");

        campoDataAgendamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        campoDataAgendamento.setToolTipText("");

        campoHorarioAgendamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        campoDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        campoDataInicio.setEnabled(false);

        campoHorarioInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        campoHorarioInicio.setEnabled(false);

        campoDataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        campoDataConclusao.setEnabled(false);

        campoHorarioConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        campoHorarioConclusao.setEnabled(false);

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

        campoManutencaoIniciada.setText("Manutenção não iniciada");
        campoManutencaoIniciada.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoManutencaoIniciadaStateChanged(evt);
            }
        });

        campoManutencaoConcluida.setText("Manutenção não concluída");
        campoManutencaoConcluida.setEnabled(false);
        campoManutencaoConcluida.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoManutencaoConcluidaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCancelar)
                .addGap(18, 18, 18)
                .addComponent(botaoSalvar)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoManutencaoConcluida)
                    .addComponent(campoManutencaoIniciada)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelId))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoEquipamento, 0, 234, Short.MAX_VALUE)
                            .addComponent(campoResponsavel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(labelDataInicio))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoHorarioAgendamento, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(campoDataAgendamento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDataInicio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(labelHorarioInicio)
                            .addComponent(labelDataConclusao)
                            .addComponent(labelHorarioConclusao)
                            .addComponent(jLabel10))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoPeriodicidade)
                            .addComponent(campoHorarioInicio)
                            .addComponent(campoDataConclusao)
                            .addComponent(campoHorarioConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoHorarioAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoManutencaoIniciada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataInicio)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHorarioInicio)
                    .addComponent(campoHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoManutencaoConcluida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataConclusao)
                    .addComponent(campoDataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHorarioConclusao)
                    .addComponent(campoHorarioConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoPeriodicidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        if(campoDataAgendamento.getText() == null || campoDataAgendamento.getText().isEmpty() || campoDataAgendamento.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Erro! O campo Data de Agendamento precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
            formularioValido = false;
        }
        
        if(campoHorarioAgendamento.getText() == null || campoHorarioAgendamento.getText().isEmpty() || campoHorarioAgendamento.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Erro! O campo Horário de Agendamento precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
            formularioValido = false;
        }
        
        if(campoManutencaoIniciada.isSelected())
        {
            if(campoDataInicio.getText() == null || campoDataInicio.getText().isEmpty() || campoDataInicio.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Erro! Para registrar uma manutenção iniciada, o campo Data de Início precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
                formularioValido = false;
            }

            if(campoHorarioInicio.getText() == null || campoHorarioInicio.getText().isEmpty() || campoHorarioInicio.getText().isBlank())
            {
                JOptionPane.showMessageDialog(this, "Erro! Para registrar uma manutenção iniciada, campo Horário de Início precisa estar preenchido", "Erro!", JOptionPane.ERROR_MESSAGE);
                formularioValido = false;
            } 
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
            Manutencao manutencao = new ManutencaoPreventiva
            (
                telaPrincipal.getTelaListaEquipamentos().getListaEquipamentos().get(campoEquipamento.getSelectedIndex()),
                telaPrincipal.getTelaListaFuncionarios().getListaFuncionarios().get(campoResponsavel.getSelectedIndex()),
                campoDataInicio.getText() + " " + campoHorarioInicio.getText(),
                campoDataConclusao.getText() + " " + campoHorarioConclusao.getText(),
                campoDataAgendamento.getText() + " " + campoHorarioAgendamento.getText(),
                campoPeriodicidade.getText(),
                campoDescricao.getText(),
                campoManutencaoIniciada.isSelected(), campoManutencaoConcluida.isSelected()
            );

            telaPrincipal.adicionarManutencao(manutencao);
            telaPrincipal.fecharLimparJanela(this);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        telaPrincipal.fecharLimparJanela(this);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void campoManutencaoIniciadaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_campoManutencaoIniciadaStateChanged
        Calendar agora;
        
        if(campoManutencaoIniciada.isSelected())
        {
            campoManutencaoIniciada.setText("Manutenção iniciada");
            labelDataInicio.setEnabled(true);
            campoDataInicio.setEnabled(true);
            labelHorarioInicio.setEnabled(true);
            campoHorarioInicio.setEnabled(true);
            campoManutencaoConcluida.setEnabled(true);
        }
        else
        {
            campoManutencaoIniciada.setText("Manutenção não iniciada");
            labelDataInicio.setEnabled(false);
            campoDataInicio.setEnabled(false);
            labelHorarioInicio.setEnabled(false);
            campoHorarioInicio.setEnabled(false);
            campoManutencaoConcluida.setEnabled(false);
            campoManutencaoConcluida.setSelected(false);  
            agora = Calendar.getInstance();
            campoDataInicio.setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
            campoHorarioInicio.setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
        }
    }//GEN-LAST:event_campoManutencaoIniciadaStateChanged

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

    public JFormattedTextField getCampoDataAgendamento()
    {
        return campoDataAgendamento;
    }

    public JFormattedTextField getCampoHorarioAgendamento()
    {
        return campoHorarioAgendamento;
    }

    public JFormattedTextField getCampoDataInicio() {
        return campoDataInicio;
    }

    public JFormattedTextField getCampoHorarioInicio() {
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
    private javax.swing.JFormattedTextField campoDataAgendamento;
    private javax.swing.JFormattedTextField campoDataConclusao;
    private javax.swing.JFormattedTextField campoDataInicio;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JComboBox<String> campoEquipamento;
    private javax.swing.JFormattedTextField campoHorarioAgendamento;
    private javax.swing.JFormattedTextField campoHorarioConclusao;
    private javax.swing.JFormattedTextField campoHorarioInicio;
    private javax.swing.JLabel campoId;
    private javax.swing.JCheckBox campoManutencaoConcluida;
    private javax.swing.JCheckBox campoManutencaoIniciada;
    private javax.swing.JTextField campoPeriodicidade;
    private javax.swing.JComboBox<String> campoResponsavel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDataConclusao;
    private javax.swing.JLabel labelDataInicio;
    private javax.swing.JLabel labelHorarioConclusao;
    private javax.swing.JLabel labelHorarioInicio;
    private javax.swing.JLabel labelId;
    // End of variables declaration//GEN-END:variables
}