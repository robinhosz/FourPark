package br.com.fourcamp.fourpark;

public class Vaga {
	
	private Integer posicao;
	private String horaEntrada;
	private String horaSaida;
	private Veiculo veiculo;
	private Boolean ocupado;
	
	public Vaga(Integer posicao) {
		this.ocupado = false;
		this.posicao = posicao;
	}

	@Override
	public String toString() {
		return "Vaga número " + posicao;
	}
	
	
	
}
