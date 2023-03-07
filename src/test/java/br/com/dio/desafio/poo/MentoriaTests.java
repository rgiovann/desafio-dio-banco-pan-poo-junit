package br.com.dio.desafio.poo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.dio.desafio.poo.domain.Mentoria;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MentoriaTests {

    Mentoria mentoria = new Mentoria();
    double valorEsperadoXps;
    final double XP_PADRAO = 10d;

    @BeforeAll
    void InicializaVariaveis()
	{
	    this.valorEsperadoXps = this.XP_PADRAO + 20;
	    this.mentoria.setTitulo("Mentoria java");
	    this.mentoria.setDescricao("Mentoria curso java");
	}

    @Test
    void calcularXpDeveRetornarONrDeXps()

	{
	    Assertions.assertNotNull(this.mentoria);
	    Assertions.assertEquals(this.valorEsperadoXps, this.mentoria.calcularXp());

	}

}
