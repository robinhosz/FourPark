package br.com.fourcamp.fourpark.model;

public class Registro {

	private int resgistro;
	private Veiculo veiculo;
	private String horaDeEntrada;
	private String horaDeSaida;
	private Double valor;
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public void setHoraDeEntrada(String horaDeEntrada) {
		this.horaDeEntrada = horaDeEntrada;
	}
	public void setHoraDeSaida(String horaDeSaida) {
		this.horaDeSaida = horaDeSaida;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Double getValor() {
		return valor;
	}
	@Override
	public String toString() {
		return "Registro n�mero " + resgistro + ": ve�culo com a placa " + veiculo.getPlaca() + " estacionado �s " + horaDeEntrada +
				" e removido �s " + horaDeSaida;
	}
	
}
