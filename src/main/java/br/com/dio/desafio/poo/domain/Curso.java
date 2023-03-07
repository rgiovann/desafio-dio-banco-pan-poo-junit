package br.com.dio.desafio.poo.domain;

public class Curso extends Conteudo {

    private int cargaHoraria;

    @Override
    public double calcularXp()
	{
	    int cargaHoraria = this.getCargaHoraria();
	    return XP_PADRAO * cargaHoraria;
	}

    public Curso()
	{
	}

    public int getCargaHoraria()
	{
	    // System.out.println("Passou pelo método getCargaHoraria...");
	    return this.cargaHoraria;
	}

    public void setCargaHoraria(int cargaHoraria)
	{
	    this.cargaHoraria = cargaHoraria;
	}

    @Override
    public String toString()
	{
	    return "Curso{" + "titulo='" + this.getTitulo() + '\'' + ", descricao='" + this.getDescricao() + '\''
		    + ", cargaHoraria=" + this.cargaHoraria + '}';
	}

}
