package app;

public class OrdenaAlunos {
	private CadastroAlunos source;
	Aluno resposta[];
	String matricula1, matricula2;
	Aluno t;
	
	public OrdenaAlunos(CadastroAlunos source) {
		this.source = source;
	}
	
	Aluno[] computar() {
		resposta = new Aluno[source.alunos.length];
		//copia o vetor para o vetor de resposta
		for (int i=0; i < source.alunos.length; i++) {
			resposta[i] = source.alunos[i]; 
		}
		
		for (int i = 0; i < resposta.length - 1; i++) {
			for (int j = i; j < resposta.length; j++) {
				matricula1 = source.getMatriculaFormatada(resposta[i]);
				matricula2 = source.getMatriculaFormatada(resposta[j]);
				if (matricula1.compareTo(matricula2) > 0) {
					t = resposta[i]; 
					resposta[i] = resposta[j];
					resposta[j] = t;
				}
			}
		}
		
		return resposta;
	}

}
