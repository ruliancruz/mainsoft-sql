package telas;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Calendar;
import classes.Manutencao;
import classes.Equipamento;
import classes.Funcionario;
import classes.ManutencaoPreventiva;
import classes.ManutencaoCorretiva;
import classes.Utils;
import java.io.File;
import javax.swing.JInternalFrame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPrincipal extends javax.swing.JFrame
{
    private final TelaManutencaoCorretiva telaManutencaoCorretiva;
    private final TelaManutencaoPreventiva telaManutencaoPreventiva;
    private final TelaEquipamento telaEquipamento;
    private final TelaFuncionario telaFuncionario;
    private final TelaPeca telaPeca;
    private final TelaListaPecas telaListaPecas;
    private final TelaListaFuncionarios telaListaFuncionarios;
    private final TelaListaEquipamentos telaListaEquipamentos;
    private final TelaEditarManutencaoCorretiva telaEditarManutencaoCorretiva;
    private final TelaEditarManutencaoPreventiva telaEditarManutencaoPreventiva;
    private final TelaEditarEquipamento telaEditarEquipamento;
    private final TelaEditarFuncionario telaEditarFuncionario;
    private final TelaEditarPeca telaEditarPeca;
    private final String caminhoPastaManutencoes;
    private final String caminhoArquivoManutencoes;
    private final String caminhoManutencoes;
    private Calendar agora;
    private ArrayList<Manutencao> manutencoes;
    private long ultimoIdManutencao;
    
    public TelaPrincipal()
    {
        initComponents();
        this.caminhoPastaManutencoes = "data";
        this.caminhoArquivoManutencoes = "manutencoes.dat";
        this.caminhoManutencoes = caminhoPastaManutencoes + "/" + caminhoArquivoManutencoes;
        this.ultimoIdManutencao = 0;
        this.telaListaPecas = new TelaListaPecas(this);
        this.telaListaFuncionarios = new TelaListaFuncionarios(this);
        this.telaFuncionario = new TelaFuncionario(telaListaFuncionarios, this);
        this.telaListaEquipamentos = new TelaListaEquipamentos(this);
        this.telaEquipamento = new TelaEquipamento(telaListaEquipamentos, this);
        this.telaManutencaoCorretiva = new TelaManutencaoCorretiva(this);
        this.telaManutencaoPreventiva = new TelaManutencaoPreventiva(this);
        this.telaPeca = new TelaPeca(telaListaPecas, telaListaEquipamentos, this);
        this.telaEditarManutencaoCorretiva = new TelaEditarManutencaoCorretiva(this);
        this.telaEditarManutencaoPreventiva = new TelaEditarManutencaoPreventiva(this);
        this.telaEditarEquipamento = new TelaEditarEquipamento(this);
        this.telaEditarFuncionario = new TelaEditarFuncionario(this);
        this.telaEditarPeca = new TelaEditarPeca(this);
        
        try
        {
            manutencoes = carregarManutencoes();
        }
        catch (IOException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        atualizarListaManutencoes();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botaoEditar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        cadastrarManutencaoCorretiva = new javax.swing.JMenuItem();
        cadastrarManutencaoPreventiva = new javax.swing.JMenuItem();
        cadastrarFuncionario = new javax.swing.JMenuItem();
        cadastrarEquipamento = new javax.swing.JMenuItem();
        cadastrarPeca = new javax.swing.JMenuItem();
        menuConsulta = new javax.swing.JMenu();
        consultarFuncionarios = new javax.swing.JMenuItem();
        consultarEquipamentos = new javax.swing.JMenuItem();
        consultarPecas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mainsoft - Sistema de Controle de Manutenção em Fabricas");

        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Lista de Ordens de Serviço");
        jInternalFrame1.setToolTipText("");
        jInternalFrame1.setAutoscrolls(true);
        jInternalFrame1.setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Equipamento", "Responsável", "Data de Início", "Data de Conclusão", "Data de Agendamento", "Periodicidade", "Causa da Falha", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

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

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoRemover)
                .addGap(18, 18, 18)
                .addComponent(botaoEditar)
                .addGap(20, 20, 20))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoEditar)
                    .addComponent(botaoRemover))
                .addGap(20, 20, 20))
        );

        painel.setLayer(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        menuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/application_edit.png"))); // NOI18N
        menuCadastro.setText("Cadastro");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jMenu1.setText("Cadastrar Manutenção");

        cadastrarManutencaoCorretiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/wrench.png"))); // NOI18N
        cadastrarManutencaoCorretiva.setText("Manutenção Corretiva");
        cadastrarManutencaoCorretiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarManutencaoCorretivaActionPerformed(evt);
            }
        });
        jMenu1.add(cadastrarManutencaoCorretiva);

        cadastrarManutencaoPreventiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/wrench.png"))); // NOI18N
        cadastrarManutencaoPreventiva.setText("Manutenção Preventiva");
        cadastrarManutencaoPreventiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarManutencaoPreventivaActionPerformed(evt);
            }
        });
        jMenu1.add(cadastrarManutencaoPreventiva);

        menuCadastro.add(jMenu1);

        cadastrarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        cadastrarFuncionario.setText("Cadastrar Funcionário");
        cadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarFuncionario);

        cadastrarEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        cadastrarEquipamento.setText("Cadastrar Equipamento");
        cadastrarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEquipamentoActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarEquipamento);

        cadastrarPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        cadastrarPeca.setText("Cadastrar Peça");
        cadastrarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPecaActionPerformed(evt);
            }
        });
        menuCadastro.add(cadastrarPeca);

        jMenuBar1.add(menuCadastro);

        menuConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/magnifier.png"))); // NOI18N
        menuConsulta.setText("Consulta");

        consultarFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page.png"))); // NOI18N
        consultarFuncionarios.setText("Funcionários");
        consultarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarFuncionariosActionPerformed(evt);
            }
        });
        menuConsulta.add(consultarFuncionarios);

        consultarEquipamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page.png"))); // NOI18N
        consultarEquipamentos.setText("Equipamentos");
        consultarEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarEquipamentosActionPerformed(evt);
            }
        });
        menuConsulta.add(consultarEquipamentos);

        consultarPecas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page.png"))); // NOI18N
        consultarPecas.setText("Peças");
        consultarPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarPecasActionPerformed(evt);
            }
        });
        menuConsulta.add(consultarPecas);

        jMenuBar1.add(menuConsulta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void salvarManutencoes() throws FileNotFoundException, IOException
    {
        File arquivo = new File("data");
        
        if(arquivo.exists() || arquivo.isDirectory())
            arquivo.mkdir();
        
        ObjectOutputStream registrador = new ObjectOutputStream(new FileOutputStream(caminhoManutencoes));
        registrador.writeObject(manutencoes);
        registrador.close();
    }
    
    public ArrayList<Manutencao> carregarManutencoes() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        ArrayList<Manutencao> lista = new ArrayList<Manutencao>();
        
        File arquivo = new File("data");
        
        if(!arquivo.exists() && !arquivo.isDirectory())
            arquivo.mkdir();
        
        arquivo = new File(caminhoManutencoes);
        
        if(arquivo.exists())
        {
            ObjectInputStream carregador = new ObjectInputStream(new FileInputStream(caminhoManutencoes));
            
            try
            {
               lista = (ArrayList<Manutencao>) carregador.readObject();
               carregador.close();
            }
            catch (Exception e)
            {
                carregador.close();
                return lista;
            }
            
            if(lista != null && lista.size() != 0)
                ultimoIdManutencao = lista.get(lista.size() - 1).getId() + 1;
        }
        
        return lista;
    }
    
    public void adicionarManutencao(Manutencao manutencao)
    {
        manutencao.setId(ultimoIdManutencao);
        ultimoIdManutencao++;
        manutencoes.add(manutencao);
        atualizarListaManutencoes();
    }
    
    public void editarManutencao(Manutencao manutencao, int posicao)
    {
        manutencoes.remove(posicao);
        manutencoes.add(posicao, manutencao);
        atualizarListaManutencoes();
    }
    
    public void removerManutencao (Manutencao manutencao)
    {
        manutencoes.remove(manutencao);
        atualizarListaManutencoes();
    }
    
    public void fecharJanela(JInternalFrame janela)
    {
        janela.setVisible(false);
        painel.remove(janela);
    }
    
    public void fecharLimparJanela(JInternalFrame janela)
    {
        ((Utils) janela).limparCampos();
        janela.setVisible(false);
        painel.remove(janela);
    }
    
    public void atualizarListaManutencoes()
    {
        ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
        
        for(Manutencao item : manutencoes)
        {
            if("Corretiva".equals(item.getTipoManutencao()))
            {
                ((DefaultTableModel) jTable1.getModel()).addRow(new Object[]{
                item.getId(),
                item.getEquipamento().getNome(),
                item.getResponsavel().getNome(),
                item.getDataInicioString(),
                item.getDataConclusaoString(),
                " ",
                " ",
                ((ManutencaoCorretiva) item).getCausaFalha(),
                item.getTipoManutencao()});
            }
            else
            {
                ((DefaultTableModel) jTable1.getModel()).addRow(new Object[]{
                item.getId(),
                item.getEquipamento().getNome(),
                item.getResponsavel().getNome(),
                item.getDataInicioString(),
                item.getDataConclusaoString(),
                ((ManutencaoPreventiva)item).getDataAgendamentoString(),
                ((ManutencaoPreventiva)item).getPeriodicidade(),
                " ",
                item.getTipoManutencao()});
            }
        }
        
        try
        {
            salvarManutencoes();
        }
        catch (IOException ex)
        {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean abrirJanela(JInternalFrame janela)
    {
        if(!janela.isVisible())
        {
            painel.add(janela);
            janela.setVisible(true);
            return true;
        }
        else
        {
            janela.moveToFront();
            return false;
        }
    }
    
    public ArrayList<Manutencao> getManutencoes()
    {
        return manutencoes;
    }

    public TelaListaEquipamentos getTelaListaEquipamentos()
    {
        return telaListaEquipamentos;
    }
    
    public TelaListaFuncionarios getTelaListaFuncionarios()
    {
        return telaListaFuncionarios;
    }

    public TelaListaPecas getTelaListaPecas()
    {
        return telaListaPecas;
    }

    public TelaEditarEquipamento getTelaEditarEquipamento()
    {
        return telaEditarEquipamento;
    }

    public TelaEditarFuncionario getTelaEditarFuncionario()
    {
        return telaEditarFuncionario;
    }

    public TelaEditarPeca getTelaEditarPeca()
    {
        return telaEditarPeca;
    }
    
    public long getUltimoIdManutencao()
    {
        ultimoIdManutencao++;
        return ultimoIdManutencao;
    }

    public void setUltimoIdManutencao(long ultimoIdManutencao)
    {
        this.ultimoIdManutencao = ultimoIdManutencao;
    }
    
    private void cadastrarManutencaoCorretivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarManutencaoCorretivaActionPerformed
        if(abrirJanela(telaManutencaoCorretiva))
        {
            telaManutencaoCorretiva.getCampoEquipamento().removeAllItems();
            
            for(Equipamento item : telaListaEquipamentos.getListaEquipamentos())
            {
                telaManutencaoCorretiva.getCampoEquipamento().addItem(item.getNome());
            }
            
            telaManutencaoCorretiva.getCampoResponsavel().removeAllItems();
            
            for(Funcionario item : telaListaFuncionarios.getListaFuncionarios())
            {
                telaManutencaoCorretiva.getCampoResponsavel().addItem(item.getNome());
            }
            
            agora = Calendar.getInstance();
            telaManutencaoCorretiva.getCampoDataInicio().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
            telaManutencaoCorretiva.getCampoHorarioInicio().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
            telaManutencaoCorretiva.getCampoDataConclusao().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
            telaManutencaoCorretiva.getCampoHorarioConclusao().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
        }
        
        telaManutencaoCorretiva.getLabelId().setText(String.valueOf(ultimoIdManutencao));
    }//GEN-LAST:event_cadastrarManutencaoCorretivaActionPerformed

    private void cadastrarManutencaoPreventivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarManutencaoPreventivaActionPerformed
        if(abrirJanela(telaManutencaoPreventiva))
        {
            telaManutencaoPreventiva.getCampoEquipamento().removeAllItems();
            
            for(Equipamento item : telaListaEquipamentos.getListaEquipamentos())
            {
                telaManutencaoPreventiva.getCampoEquipamento().addItem(item.getNome());
            }
            
            telaManutencaoPreventiva.getCampoResponsavel().removeAllItems();
            
            for(Funcionario item : telaListaFuncionarios.getListaFuncionarios())
            {
                telaManutencaoPreventiva.getCampoResponsavel().addItem(item.getNome());
            }
            
            agora = Calendar.getInstance();
            telaManutencaoPreventiva.getCampoDataAgendamento().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
            telaManutencaoPreventiva.getCampoHorarioAgendamento().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
            telaManutencaoPreventiva.getCampoDataInicio().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
            telaManutencaoPreventiva.getCampoHorarioInicio().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
            telaManutencaoPreventiva.getCampoDataConclusao().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
            telaManutencaoPreventiva.getCampoHorarioConclusao().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
        }
        
        telaManutencaoPreventiva.getLabelId().setText(String.valueOf(ultimoIdManutencao));
    }//GEN-LAST:event_cadastrarManutencaoPreventivaActionPerformed

    private void consultarEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarEquipamentosActionPerformed
        abrirJanela(telaListaEquipamentos);
    }//GEN-LAST:event_consultarEquipamentosActionPerformed

    private void cadastrarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPecaActionPerformed
        if(abrirJanela(telaPeca))
        {
            telaPeca.getCampoEquipamento().removeAllItems();
            
            for(Equipamento item : telaListaEquipamentos.getListaEquipamentos())
            {
                telaPeca.getCampoEquipamento().addItem(item.getNome());
            }
        }
        
        telaPeca.getLabelId().setText(String.valueOf(telaListaPecas.getUltimoIdPeca()));
    }//GEN-LAST:event_cadastrarPecaActionPerformed

    private void cadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarFuncionarioActionPerformed
        abrirJanela(telaFuncionario);
        telaFuncionario.getLabelId().setText(String.valueOf(telaListaFuncionarios.getUltimoIdFuncionario()));
    }//GEN-LAST:event_cadastrarFuncionarioActionPerformed

    private void cadastrarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEquipamentoActionPerformed
        abrirJanela(telaEquipamento);
        agora = Calendar.getInstance();
        telaEquipamento.getCampoDataAquisicao().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
        telaEquipamento.getLabelId().setText(String.valueOf(telaListaEquipamentos.getUltimoIdEquipamento()));
    }//GEN-LAST:event_cadastrarEquipamentoActionPerformed

    private void consultarPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarPecasActionPerformed
        abrirJanela(telaListaPecas);
    }//GEN-LAST:event_consultarPecasActionPerformed

    private void consultarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarFuncionariosActionPerformed
        abrirJanela(telaListaFuncionarios);
    }//GEN-LAST:event_consultarFuncionariosActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        Manutencao manutencaoSelecionada;
        int indiceLista = 0;
        
        if(jTable1.getSelectedRow() != -1)
        {
            manutencaoSelecionada = (manutencoes.get(jTable1.getSelectedRow()));
            
            if(manutencaoSelecionada.getTipoManutencao().contains("Corretiva"))
            {
                if(abrirJanela(telaEditarManutencaoCorretiva))
                {
                    telaEditarManutencaoCorretiva.setPosicaoListaManutencao(jTable1.getSelectedRow());
                    telaEditarManutencaoCorretiva.getLabelId().setText(String.valueOf(manutencaoSelecionada.getId()));
                    telaEditarManutencaoCorretiva.getCampoEquipamento().removeAllItems();

                    for(Equipamento item : telaListaEquipamentos.getListaEquipamentos())
                    {
                        telaEditarManutencaoCorretiva.getCampoEquipamento().addItem(item.getNome());

                        if(item == manutencaoSelecionada.getEquipamento())
                        {
                            telaEditarManutencaoCorretiva.getCampoEquipamento().setSelectedIndex(indiceLista);
                        }

                        indiceLista++;
                    }

                    telaEditarManutencaoCorretiva.getCampoResponsavel().removeAllItems();
                    indiceLista = 0;

                    for(Funcionario item : telaListaFuncionarios.getListaFuncionarios())
                    {
                        telaEditarManutencaoCorretiva.getCampoResponsavel().addItem(item.getNome());

                        if(item == manutencaoSelecionada.getResponsavel())
                        {
                            telaEditarManutencaoCorretiva.getCampoResponsavel().setSelectedIndex(indiceLista);
                        }

                        indiceLista++;
                    }
                    
                    telaEditarManutencaoCorretiva.getCampoDataInicio().setText(manutencaoSelecionada.getDataCurtaInicioString());
                    telaEditarManutencaoCorretiva.getCampoHorarioInicio().setText(manutencaoSelecionada.getHorarioInicioString());
                    telaEditarManutencaoCorretiva.getCampoManutencaoConcluida().setSelected(manutencaoSelecionada.getManutencaoConcluida());
                    telaEditarManutencaoCorretiva.atualizarManutencaoConcluida();
                    
                    if(manutencaoSelecionada.getManutencaoConcluida())
                    {
                        telaEditarManutencaoCorretiva.getCampoDataConclusao().setText(manutencaoSelecionada.getDataCurtaConclusaoString());
                        telaEditarManutencaoCorretiva.getCampoHorarioConclusao().setText(manutencaoSelecionada.getHorarioConclusaoString());
                    }
                    else
                    {
                        agora = Calendar.getInstance();
                        telaEditarManutencaoCorretiva.getCampoDataConclusao().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
                        telaEditarManutencaoCorretiva.getCampoHorarioConclusao().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
                    }
                    
                    telaEditarManutencaoCorretiva.getCampoCausaFalha().setText(((ManutencaoCorretiva) manutencaoSelecionada).getCausaFalha());
                    telaEditarManutencaoCorretiva.getCampoDescricao().setText(manutencaoSelecionada.getDescricao());
                }
            }
            else
            {
                if(abrirJanela(telaEditarManutencaoPreventiva))
                {
                    telaEditarManutencaoPreventiva.setPosicaoListaManutencao(jTable1.getSelectedRow());
                    telaEditarManutencaoPreventiva.getLabelId().setText(String.valueOf(manutencaoSelecionada.getId()));
                    telaEditarManutencaoPreventiva.getCampoEquipamento().removeAllItems();

                    for(Equipamento item : telaListaEquipamentos.getListaEquipamentos())
                    {
                        telaEditarManutencaoPreventiva.getCampoEquipamento().addItem(item.getNome());

                        if(item == manutencaoSelecionada.getEquipamento())
                        {
                            telaEditarManutencaoPreventiva.getCampoEquipamento().setSelectedIndex(indiceLista);
                        }

                        indiceLista++;
                    }

                    telaEditarManutencaoPreventiva.getCampoResponsavel().removeAllItems();
                    indiceLista = 0;

                    for(Funcionario item : telaListaFuncionarios.getListaFuncionarios())
                    {
                        telaEditarManutencaoPreventiva.getCampoResponsavel().addItem(item.getNome());

                        if(item == manutencaoSelecionada.getResponsavel())
                        {
                            telaEditarManutencaoPreventiva.getCampoResponsavel().setSelectedIndex(indiceLista);
                        }

                        indiceLista++;
                    }

                    telaEditarManutencaoPreventiva.getCampoDataAgendamento().setText(((ManutencaoPreventiva) manutencaoSelecionada).getDataCurtaAgendamentoString());
                    telaEditarManutencaoPreventiva.getCampoHorarioAgendamento().setText(((ManutencaoPreventiva) manutencaoSelecionada).getHorarioAgendamentoString());
                    telaEditarManutencaoPreventiva.getCampoManutencaoIniciada().setSelected(manutencaoSelecionada.getManutencaoIniciada());
                    telaEditarManutencaoPreventiva.atualizarManutencaoIniciada();
                    telaEditarManutencaoPreventiva.getCampoManutencaoConcluida().setSelected(manutencaoSelecionada.getManutencaoConcluida());
                    telaEditarManutencaoPreventiva.atualizarManutencaoConcluida();
                    
                    if(manutencaoSelecionada.getManutencaoIniciada())
                    {
                       telaEditarManutencaoPreventiva.getCampoDataInicio().setText(manutencaoSelecionada.getDataCurtaInicioString());
                       telaEditarManutencaoPreventiva.getCampoHorarioInicio().setText(manutencaoSelecionada.getHorarioInicioString());
                       
                       if(manutencaoSelecionada.getManutencaoConcluida())
                       {
                           telaEditarManutencaoPreventiva.getCampoDataConclusao().setText(manutencaoSelecionada.getDataCurtaConclusaoString());
                           telaEditarManutencaoPreventiva.getCampoHorarioConclusao().setText(manutencaoSelecionada.getHorarioConclusaoString());
                       }
                       else
                       {
                           agora = Calendar.getInstance();
                           telaEditarManutencaoPreventiva.getCampoDataConclusao().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
                           telaEditarManutencaoPreventiva.getCampoHorarioConclusao().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
                       }
                    }
                    else
                    {
                        agora = Calendar.getInstance();
                        telaEditarManutencaoPreventiva.getCampoDataInicio().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
                        telaEditarManutencaoPreventiva.getCampoHorarioInicio().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
                        telaEditarManutencaoPreventiva.getCampoDataConclusao().setText(String.format("%02d/%02d/%d", agora.get(Calendar.DAY_OF_MONTH), agora.get(Calendar.MONTH) + 1, agora.get(Calendar.YEAR)));
                        telaEditarManutencaoPreventiva.getCampoHorarioConclusao().setText(String.format("%02d:%02d", agora.get(Calendar.HOUR_OF_DAY), agora.get(Calendar.MINUTE)));
                    }
                    
                    telaEditarManutencaoPreventiva.getCampoPeriodicidade().setText(((ManutencaoPreventiva) manutencaoSelecionada).getPeriodicidade());
                    telaEditarManutencaoPreventiva.getCampoDescricao().setText(manutencaoSelecionada.getDescricao());
                }
            }
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        if(jTable1.getSelectedRow() != -1)
        {
            removerManutencao((manutencoes.get(jTable1.getSelectedRow())));
        }
        //abrirJanela(telaConfirmacao);
    }//GEN-LAST:event_botaoRemoverActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JMenuItem cadastrarEquipamento;
    private javax.swing.JMenuItem cadastrarFuncionario;
    private javax.swing.JMenuItem cadastrarManutencaoCorretiva;
    private javax.swing.JMenuItem cadastrarManutencaoPreventiva;
    private javax.swing.JMenuItem cadastrarPeca;
    private javax.swing.JMenuItem consultarEquipamentos;
    private javax.swing.JMenuItem consultarFuncionarios;
    private javax.swing.JMenuItem consultarPecas;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuConsulta;
    private javax.swing.JDesktopPane painel;
    // End of variables declaration//GEN-END:variables
}