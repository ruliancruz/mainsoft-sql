package classes;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManutencaoCorretiva extends Manutencao
{
    private String causaFalha;
    
    public ManutencaoCorretiva(Equipamento equipamento, Funcionario responsavel, String dataInicioString, String dataConclusaoString, String causaFalha, String descricao, boolean manutencaoConcluida)
    {
        setEquipamento(equipamento);
        setResponsavel(responsavel);
                
        try
        {
            getDataInicio().setTime(getFormatadorDataHora().parse(dataInicioString));
        }
        catch (ParseException ex)
        {
            Logger.getLogger(ManutencaoCorretiva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            getDataConclusao().setTime(getFormatadorDataHora().parse(dataConclusaoString));
        }
        catch (ParseException ex)
        {
            Logger.getLogger(ManutencaoCorretiva.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.causaFalha = causaFalha;
        setDescricao(descricao);
        setTipoManutencao("Corretiva");
        setManutencaoIniciada(true);
        setManutencaoConcluida(manutencaoConcluida);
    }

    public String getCausaFalha()
    {
        return causaFalha;
    }

    public void setCausaFalha(String causaFalha)
    {
        this.causaFalha = causaFalha;
    }
}