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

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}
	
}
