package classes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Equipamento implements Serializable
{
    private long id;
    private String nome;
    private String modelo;
    private String fabricante; //private Fabricante fabricante;
    private final SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar dataAquisicao = Calendar.getInstance();
    
    public Equipamento(String nome, String modelo, String fabricante, String dataAquisicaoString)
    {
        this.nome = nome;
        this.modelo = modelo;
        this.fabricante = fabricante;
        
        try
        {
            getDataAquisicao().setTime(getFormatadorData().parse(dataAquisicaoString));
        }
        catch (ParseException ex)
        {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
        this.fabricante = fabricante;
    }
    
    public SimpleDateFormat getFormatadorData()
    {
        return formatadorData;
    }
    
    public Calendar getDataAquisicao()
    {
        return dataAquisicao;
    }
    

    public void setDataAquisicao(Calendar dataAquisicao)
    {
        this.dataAquisicao = dataAquisicao;
    }
    
    public String getDataAquisicaoString()
    {
        return String.format("%02d/%02d/%d", dataAquisicao.get(Calendar.DAY_OF_MONTH), dataAquisicao.get(Calendar.MONTH) + 1, dataAquisicao.get(Calendar.YEAR));
    }
}