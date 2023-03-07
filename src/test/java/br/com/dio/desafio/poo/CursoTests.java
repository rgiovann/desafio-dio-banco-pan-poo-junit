package br.com.dio.desafio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import br.com.dio.desafio.poo.domain.Curso;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CursoTests {

    Curso curso = null;
    double valorEsperadoXps;
    final double XP_PADRAO = 10d;

    @BeforeAll
    void InicializaVariaveis()
	{
	    this.valorEsperadoXps = this.XP_PADRAO * 8;
	    this.curso = Mockito.spy(new Curso()); // cria um objeto real da classe curso
	    Mockito.doReturn(8).when(this.curso).getCargaHoraria(); // override metodo getCargaHoraria em um stub

	}

    @Test
    void calcularXpDeveRetornarONrDeXps()

	{
	    Assertions.assertNotNull(this.curso);
	    Assertions.assertEquals(this.valorEsperadoXps, this.curso.calcularXp());

	}
}
