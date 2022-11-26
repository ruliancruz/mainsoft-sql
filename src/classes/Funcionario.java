package classes;

import java.io.Serializable;

public class Funcionario implements Serializable
{
    private long id;
    private String nome;
       
    public Funcionario(String nome)
    {
        this.nome = nome;
    }
    
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }
}