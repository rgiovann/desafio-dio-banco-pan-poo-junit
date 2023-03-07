package br.com.dio.desafio.poo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.dio.desafio.poo.domain.Bootcamp;
import br.com.dio.desafio.poo.domain.Conteudo;
import br.com.dio.desafio.poo.domain.Curso;
import br.com.dio.desafio.poo.domain.Dev;
import br.com.dio.desafio.poo.domain.Mentoria;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DevTests {

    private Dev dev;
    private Curso curso1 = new Curso();
    private Curso curso2 = new Curso();
    private Mentoria mentoria = new Mentoria();
    private Bootcamp bootcamp;;
    private Set<Conteudo> conteudos;

    @BeforeAll // executa 1 vez no começo da execução dos testes
    void InicializaVariaveisAll()
	{
	    this.curso1.setTitulo("curso java");
	    this.curso1.setDescricao("descrição curso java");
	    this.curso1.setCargaHoraria(8);

	    this.curso2.setTitulo("curso js");
	    this.curso2.setDescricao("descrição curso js");
	    this.curso2.setCargaHoraria(4);

	    this.mentoria.setTitulo("mentoria de java");
	    this.mentoria.setDescricao("descrição mentoria java");
	    this.mentoria.setData(LocalDate.now());
	    this.conteudos = new HashSet<>(Arrays.asList(this.curso1, this.curso2, this.mentoria));

	}

    @BeforeEach // executa a cada teste
    void InicializaVariaveisEach()
	{
	    this.dev = new Dev();
	    this.bootcamp = new Bootcamp();
	    this.bootcamp.setNome("Bootcamp Java Developer");
	    this.bootcamp.setDescricao("Descrição Bootcamp Java Developer");
	    this.bootcamp.getConteudos().add(this.curso1);
	    this.bootcamp.getConteudos().add(this.curso2);
	    this.bootcamp.getConteudos().add(this.mentoria);

	}

    @Test
    void inscreverBootcampDeveAdicionarConteudosBootcamp()

	{
	    this.dev.inscreverBootcamp(this.bootcamp);
	    Assertions.assertEquals(this.conteudos, this.dev.getConteudosInscritos());
	}

    @Test
    void inscreverBootcampDeveAdicionarUmInscritoEmBootcamp()

	{
	    this.dev.inscreverBootcamp(this.bootcamp);
	    Assertions.assertEquals(1, this.bootcamp.getDevsInscritos().size());
	}

    @Test
    void progredirAdicionaUmConteudoConcluido()

	{ // não uso inscreverBootcamp() porque é um metodo a ser testado,
	  // populo diretamente usando um setter disponível para a classe
	    this.dev.setConteudosInscritos(new HashSet<>(Arrays.asList(this.curso1, this.curso2, this.mentoria)));
	    // identifico o primeiro conteúdo inscrito
	    Conteudo conteudo = this.dev.getConteudosInscritos().stream().findFirst().get();
	    // guardo tamanho da lista de concluidos, deve ser acrescentado de 1
	    int tamanhoOriginalConcluidos = this.dev.getConteudosConcluidos().size();

	    this.dev.progredir();

	    // verifico se lista de concluidos aumentou de 1
	    Assertions.assertEquals(tamanhoOriginalConcluidos + 1, this.dev.getConteudosConcluidos().size());
	    // verifico se o conteudo adicionado é o primeiro da lista de inscritos
	    Assertions.assertEquals(true, this.dev.getConteudosConcluidos().contains(conteudo));

	}

    @Test
    void progredirDiminuiUmConteudoInscrito()

	{
	    // não uso inscreverBootcamp() porque é um metodo a ser testado,
	    // populo diretamente usando um setter disponível para a classe
	    this.dev.setConteudosInscritos(new HashSet<>(Arrays.asList(this.curso1, this.curso2, this.mentoria)));
	    // identifico o primeiro conteúdo inscrito
	    Conteudo conteudo = this.dev.getConteudosInscritos().stream().findFirst().get();
	    // guardo tamanho da lista de concluidos, deve ser acrescentado de 1
	    int tamanhoOriginalInscritos = this.dev.getConteudosInscritos().size();

	    this.dev.progredir();

	    // verifico se lista de conteudos inscritos diminuiu de 1
	    Assertions.assertEquals(tamanhoOriginalInscritos - 1, this.dev.getConteudosInscritos().size());
	    // verifico se o conteudo excluido não existe mais na lista de conteudos
	    // inscritos
	    Assertions.assertEquals(false, this.dev.getConteudosInscritos().contains(conteudo));

	}

    @Test
    void progredirImprimeMenasagemDeErroSeNaoEncontraCurso()

	{
	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	    PrintStream originalOut = System.out;
	    PrintStream originalErr = System.err;

	    // direciona print.out e print.err para ouContent e errContent
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));

	    System.setOut(new PrintStream(outContent));

	    // @BeforeEach instancio Dev, logo lista inscritos deve estar vazia
	    this.dev.getConteudosInscritos().clear();

	    this.dev.progredir();

	    // elimina caracteres especiais \r e \n da string.
	    Assertions.assertEquals("Você não está matriculado em nenhum conteúdo!",
		    errContent.toString().replaceAll("(\\r|\\n)", ""));

	    // restaura print.out e print.err para o console.
	    System.setOut(originalOut);
	    System.setErr(originalErr);

	}

}