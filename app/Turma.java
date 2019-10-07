package app;

import exceptions.DadosTurmaIncompletosException;

public class Turma {

	private char codigo;
	private int numVagas;
	private String descricao;

	public Turma(char codigo, int numVagas, String descricao) throws DadosTurmaIncompletosException {
		verificaDados(codigo, numVagas);
		
		this.codigo = codigo; 
		this.numVagas = numVagas;
		this.descricao = descricao;
	}

	private void verificaDados(char codigo, int numVagas) throws DadosTurmaIncompletosException {
		if (codigo == 0 || numVagas <= 0) {
			StringBuilder builder = criaMensagemErro(codigo, numVagas);
			throw new DadosTurmaIncompletosException( builder.toString() );
		}
	}

	private StringBuilder criaMensagemErro(char codigo, int numVagas) {
		StringBuilder builder = new StringBuilder(); 
		builder.append("Dados informados para turma estao incompletos. ");
		builder.append(codigo == 0 ? "Codigo: " + codigo : "");
		builder.append(numVagas <=0 ? "Numero de vagas: " + numVagas : "");
		return builder;
	}

	public static Turma obterTurma(char codigo, int numVagas, String descricao) throws DadosTurmaIncompletosException {
		Turma t = new Turma(codigo, numVagas, descricao);
			
		return t;
	}

	public char getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getNumVagas() {
		return numVagas;
	}

}
