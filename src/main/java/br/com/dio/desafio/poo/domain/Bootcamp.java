package br.com.dio.desafio.poo.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = this.dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public String getNome()
	{
	    return this.nome;
	}

    public void setNome(String nome)
	{
	    this.nome = nome;
	}

    public String getDescricao()
	{
	    return this.descricao;
	}

    public void setDescricao(String descricao)
	{
	    this.descricao = descricao;
	}

    public LocalDate getDataInicial()
	{
	    return this.dataInicial;
	}

    public LocalDate getDataFinal()
	{
	    return this.dataFinal;
	}

    public Set<Dev> getDevsInscritos()
	{
	    return this.devsInscritos;
	}

    public void setDevsInscritos(Set<Dev> devsInscritos)
	{
	    this.devsInscritos = devsInscritos;
	}

    public Set<Conteudo> getConteudos()
	{
	    return this.conteudos;
	}

    public void setConteudos(Set<Conteudo> conteudos)
	{
	    this.conteudos = conteudos;
	}

    @Override
    public int hashCode()
	{
	    return Objects.hash(this.nome);
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
	    Bootcamp other = (Bootcamp) obj;
	    return Objects.equals(this.nome, other.nome);
	}

//

}
