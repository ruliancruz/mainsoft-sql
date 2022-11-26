package classes;

import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManutencaoPreventiva extends Manutencao
{
    private Calendar dataAgendamento = Calendar.getInstance();
    private String periodicidade;

    public ManutencaoPreventiva(Equipamento equipamento, Funcionario responsavel, String dataInicio,  String dataConclusao, String dataAgendamento, String periodicidade, String descricao, boolean manutencaoIniciada, boolean manutencaoConcluida)
    {
        setEquipamento(equipamento);
        setResponsavel(responsavel);
        
        try
        {
            getDataInicio().setTime(getFormatadorDataHora().parse(dataInicio));
        }
        catch (ParseException ex)
        {
            Logger.getLogger(ManutencaoCorretiva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            getDataConclusao().setTime(getFormatadorDataHora().parse(dataConclusao));
        }
        catch (ParseException ex)
        {
            Logger.getLogger(ManutencaoCorretiva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            getDataAgendamento().setTime(getFormatadorDataHora().parse(dataAgendamento));
        }
        catch (ParseException ex)
        {
            Logger.getLogger(ManutencaoCorretiva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setDescricao(descricao);
        this.periodicidade = periodicidade;
        setTipoManutencao("Preventiva");
        setManutencaoIniciada(manutencaoIniciada);
        setManutencaoConcluida(manutencaoConcluida);
    }

    public Calendar getDataAgendamento()
    {
        return dataAgendamento;
    }
    
    public void setDataAgendamento(Calendar dataAgendamento)
    {
        this.dataAgendamento = dataAgendamento;
    }
    
    public String getDataAgendamentoString()
    {
        return String.format("%02d/%02d/%d %02d:%02d", dataAgendamento.get(Calendar.DAY_OF_MONTH), dataAgendamento.get(Calendar.MONTH) + 1, dataAgendamento.get(Calendar.YEAR), dataAgendamento.get(Calendar.HOUR_OF_DAY), dataAgendamento.get(Calendar.MINUTE));
    }
    
    public String getDataCurtaAgendamentoString()
    {
        return String.format("%02d/%02d/%d", dataAgendamento.get(Calendar.DAY_OF_MONTH), dataAgendamento.get(Calendar.MONTH) + 1, dataAgendamento.get(Calendar.YEAR));
    }
    
    public String getHorarioAgendamentoString()
    {
        return String.format("%02d:%02d", dataAgendamento.get(Calendar.HOUR_OF_DAY), dataAgendamento.get(Calendar.MINUTE));
    }
    
    public String getPeriodicidade()
    {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade)
    {
        this.periodicidade = periodicidade;
    }
}