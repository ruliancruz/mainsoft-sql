package classes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Manutencao implements Serializable
{
    private long id;
    private Equipamento equipamento;
    private Funcionario responsavel;
    private final SimpleDateFormat formatadorDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private Calendar dataInicio = Calendar.getInstance();
    private Calendar dataConclusao = Calendar.getInstance();
    private boolean manutencaoIniciada;
    private boolean manutencaoConcluida;
    private String descricao;
    private String tipoManutencao;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Funcionario getResponsavel()
    {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel)
    {
        this.responsavel = responsavel;
    }

    public Equipamento getEquipamento()
    {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento)
    {
        this.equipamento = equipamento;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public SimpleDateFormat getFormatadorDataHora() {
        return formatadorDataHora;
    }
    
    public Calendar getDataInicio()
    {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio)
    {
        this.dataInicio = dataInicio;
    }
    
    public String getDataInicioString()
    {
        if(manutencaoIniciada)
            return String.format("%02d/%02d/%d %02d:%02d", dataInicio.get(Calendar.DAY_OF_MONTH), dataInicio.get(Calendar.MONTH) + 1, dataInicio.get(Calendar.YEAR), dataInicio.get(Calendar.HOUR_OF_DAY), dataInicio.get(Calendar.MINUTE));
        else
            return "";
    }
    
    public String getHorarioInicioString()
    {
        if(manutencaoIniciada)
            return String.format("%02d:%02d", dataInicio.get(Calendar.HOUR_OF_DAY), dataInicio.get(Calendar.MINUTE));
        else
            return "";
    }
    
    public String getDataCurtaInicioString()
    {
        if(manutencaoIniciada)
            return String.format("%02d/%02d/%d", dataInicio.get(Calendar.DAY_OF_MONTH), dataInicio.get(Calendar.MONTH) + 1, dataInicio.get(Calendar.YEAR));
        else
            return "";
    }
    
    public Calendar getDataConclusao()
    {
        return dataConclusao;
    }
    
    public void setDataConclusao(Calendar dataConclusao)
    {
        this.dataConclusao = dataConclusao;
    }
    
    public String getDataConclusaoString()
    {
        if(manutencaoConcluida && manutencaoIniciada)
            return String.format("%02d/%02d/%d %02d:%02d", dataConclusao.get(Calendar.DAY_OF_MONTH), dataConclusao.get(Calendar.MONTH) + 1, dataConclusao.get(Calendar.YEAR), dataConclusao.get(Calendar.HOUR_OF_DAY), dataConclusao.get(Calendar.MINUTE));
        else
            return "";
    }
    
    public String getDataCurtaConclusaoString()
    {
        if(manutencaoConcluida && manutencaoIniciada)
            return String.format("%02d/%02d/%d", dataConclusao.get(Calendar.DAY_OF_MONTH), dataConclusao.get(Calendar.MONTH) + 1, dataConclusao.get(Calendar.YEAR));
        else
            return "";
    }
    
    public String getHorarioConclusaoString()
    {
        if(manutencaoConcluida && manutencaoIniciada)
            return String.format("%02d:%02d", dataConclusao.get(Calendar.HOUR_OF_DAY), dataConclusao.get(Calendar.MINUTE));
        else
            return "";
    }
    
    public boolean getManutencaoIniciada()
    {
        return manutencaoIniciada;
    }

    public void setManutencaoIniciada(boolean manutencaoIniciada)
    {
        this.manutencaoIniciada = manutencaoIniciada;
    }
    
    public boolean getManutencaoConcluida()
    {
        return manutencaoConcluida;
    }

    public void setManutencaoConcluida(boolean manutencaoConcluida)
    {
        this.manutencaoConcluida = manutencaoConcluida;
    }
    
    public String getTipoManutencao()
    {
        return tipoManutencao;
    }

    public void setTipoManutencao(String tipoManutencao)
    {
        this.tipoManutencao = tipoManutencao;
    }
}