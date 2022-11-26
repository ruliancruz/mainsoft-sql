package classes;

import java.io.Serializable;

public class Peca implements Serializable
{
    private long id;
    private String nome;
    private String modelo;
    private String fabricante;
    private Equipamento equipamento;
    
    public Peca(String nome, String modelo, String fabricante, Equipamento equipamento)
    {
        this.nome = nome;
        this.modelo = modelo;
        this.fabricante = fabricante;
        setEquipamento(equipamento);
    }

    public Equipamento getEquipamento()
    {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento)
    {
        this.equipamento = equipamento;
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
}