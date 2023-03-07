package br.com.dio.desafio.poo.domain;

import java.util.Objects;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getTitulo()
	{
	    return this.titulo;
	}

    public void setTitulo(String titulo)
	{
	    this.titulo = titulo;
	}

    public String getDescricao()
	{
	    return this.descricao;
	}

    public void setDescricao(String descricao)
	{
	    this.descricao = descricao;
	}

    // incluindo hashcode e equals

    @Override
    public int hashCode()
	{
	    return Objects.hash(this.titulo);
	}

    @Override
    public boolean equals(Object obj)
	{
	    if (this == obj)
		{
		    return true;
		}
	    if (obj == null)
		{
		    return false;
		}
	    if (this.getClass() != obj.getClass())
		{
		    return false;
		}
	    Conteudo other = (Conteudo) obj;
	    return Objects.equals(this.titulo, other.titulo);


	}

}
