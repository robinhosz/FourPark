package br.com.fourcamp.fourpark;

import java.time.LocalDateTime;

public class Vaga {
	
	private Integer posicao;
	private LocalDateTime horaEntrada;
	private LocalDateTime horaSaida;
	private Veiculo veiculo;
	private Boolean ocupado;
	private String nome;
	
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

	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalDateTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalDateTime horaSaida) {
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
