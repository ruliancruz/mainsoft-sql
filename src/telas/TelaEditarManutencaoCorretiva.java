package telas;

import classes.Manutencao;
import classes.ManutencaoCorretiva;
import classes.Utils;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaEditarManutencaoCorretiva extends javax.swing.JInternalFrame implements Utils
{
    private final TelaPrincipal telaPrincipal;
    private int posicaoListaManutencao;
    
    public TelaEditarManutencaoCorretiva(TelaPrincipal tela)
    {
        initComponents();
        telaPrincipal = tela;
    }
    
    @Override
    public void limparCampos()
    {
        campoDataInicio.setText("");
        campoHorarioInicio.setText("");
        campoDataConclusao.setText("");
        campoHorarioConclusao.setText("");
        campoCausaFalha.setText("");
        campoDescricao.setText("");
    }
    
    public void atualizarManutencaoConcluida()
    {
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
    }
    
    public JComboBox<String> getCampoEquipamento()
    {
        return campoEquipamento;
    }

    public JComboBox<String> getCampoResponsavel()
    {
        return campoResponsavel;
    }

    public JTextField getCampoDataInicio()
    {
        return campoDataInicio;
    }

    public JTextField getCampoHorarioInicio()
    {
        return campoHorarioInicio;
    }

    public JTextField getCampoDataConclusao()
    {
        return campoDataConclusao;
    }

    public JTextField getCampoHorarioConclusao()
    {
        return campoHorarioConclusao;
    }

    public JCheckBox getCampoManutencaoConcluida()
    {
        return campoManutencaoConcluida;
    }

    public JTextArea getCampoDescricao()
    {
        return campoDescricao;
    }

    public JTextArea getCampoCausaFalha()
    {
        return campoCausaFalha;
    }

    public JLabel getLabelId()
    {
        return labelId;
    }

    public void setPosicaoListaManutencao(int posicaoListaManutencao)
    {
        this.posicaoListaManutencao = posicaoListaManutencao;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelOrdemServico = new javax.swing.JLabel();
        labelEquipamento = new javax.swing.JLabel();
        labelResponsavel = new javax.swing.JLabel();
        labelDataInicio = new javax.swing.JLabel();
        labelHorarioInicio = new javax.swing.JLabel();
        labelDataConclusao = new javax.swing.JLabel();
        labelHorarioConclusao = new javax.swing.JLabel();
        labelCausaFalha = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        campoEquipamento = new javax.swing.JComboBox<>();
        campoResponsavel = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoCausaFalha = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelId = new javax.swing.JLabel();
        campoManutencaoConcluida = new javax.swing.JCheckBox();
        campoDataInicio = new javax.swing.JFormattedTextField();
        campoHorarioInicio = new javax.swing.JFormattedTextField();
        campoDataConclusao = new javax.swing.JFormattedTextField();
        campoHorarioConclusao = new javax.swing.JFormattedTextField();

        setTitle("Editar Manutenção Corretiva");

        labelOrdemServico.setText("Ordem de Serviço");

        labelEquipamento.setText("Equipamento");

        labelResponsavel.setText("Responsável");

        labelDataInicio.setText("Data de Início");

        labelHorarioInicio.setText("Horário de Início");

        labelDataConclusao.setText("Data de Conclusão");
        labelDataConclusao.setEnabled(false);

        labelHorarioConclusao.setText("Horário de Conclusão");
        labelHorarioConclusao.setEnabled(false);

        labelCausaFalha.setText("Causa da Falha");

        labelDescricao.setText("Descrição");

        campoCausaFalha.setColumns(20);
        campoCausaFalha.setRows(5);
        jScrollPane1.setViewportView(campoCausaFalha);

        campoDescricao.setColumns(20);
        campoDescricao.setRows(5);
        jScrollPane2.setViewportView(campoDescricao);

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

        labelId.setText("0");

        campoManutencaoConcluida.setText("Manutenção não concluída");
        campoManutencaoConcluida.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                campoManutencaoConcluidaStateChanged(evt);
            }
        });

        campoDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        campoHorarioInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        campoDataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        campoHorarioConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelOrdemServico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelId))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelHorarioConclusao)
                                    .addComponent(labelCausaFalha)
                                    .addComponent(labelDescricao))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2)
                                    .addComponent(campoHorarioConclusao)))
                            .addComponent(campoManutencaoConcluida)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEquipamento)
                                    .addComponent(labelResponsavel)
                                    .addComponent(labelDataInicio)
                                    .addComponent(labelHorarioInicio)
                                    .addComponent(labelDataConclusao))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoResponsavel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoEquipamento, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoDataInicio)
                                    .addComponent(campoHorarioInicio)
                                    .addComponent(campoDataConclusao))))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOrdemServico)
                    .addComponent(labelId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEquipamento)
                    .addComponent(campoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelResponsavel)
                    .addComponent(campoResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataInicio)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelHorarioInicio)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCausaFalha)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDescricao))
                        .addGap(18, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoSalvar)
                            .addComponent(botaoCancelar))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        telaPrincipal.fecharLimparJanela(this);
    }//GEN-LAST:event_botaoCancelarActionPerformed

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

            manutencao.setId(Integer.parseInt(labelId.getText()));
            telaPrincipal.editarManutencao(manutencao, posicaoListaManutencao);
            telaPrincipal.fecharLimparJanela(this);
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void campoManutencaoConcluidaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_campoManutencaoConcluidaStateChanged
        atualizarManutencaoConcluida();
    }//GEN-LAST:event_campoManutencaoConcluidaStateChanged

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
    private javax.swing.JCheckBox campoManutencaoConcluida;
    private javax.swing.JComboBox<String> campoResponsavel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCausaFalha;
    private javax.swing.JLabel labelDataConclusao;
    private javax.swing.JLabel labelDataInicio;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelEquipamento;
    private javax.swing.JLabel labelHorarioConclusao;
    private javax.swing.JLabel labelHorarioInicio;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelOrdemServico;
    private javax.swing.JLabel labelResponsavel;
    // End of variables declaration//GEN-END:variables
}
