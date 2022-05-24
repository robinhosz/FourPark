package br.com.fourcamp.fourpark.model;

public class Registro {

	private int resgistro;
	private Veiculo veiculo;
	private String horaDeEntrada;
	private String horaDeSaida;
	private Double valor;
	private Integer vaga;
	
	public int getResgistro() {
		return resgistro;
	}
	public void setResgistro(int resgistro) {
		this.resgistro = resgistro;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public String getHoraDeEntrada() {
		return horaDeEntrada;
	}
	public String getHoraDeSaida() {
		return horaDeSaida;
	}
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
	public Integer getVaga() {
		return vaga;
	}
	public void setVaga(Integer vaga) {
		this.vaga = vaga;
	}
	
	
	@Override
	public String toString() {
		String valorStr = String.format("%.2f\n\n", this.valor);
		
		return "Registro n�mero " + resgistro + ": ve�culo com a placa " + veiculo.getPlaca() + " foi estacionado �s " + horaDeEntrada +
				", na vaga " + vaga + " e removido �s " + horaDeSaida + ", e pagou R$" + valorStr;
	}
	
}
