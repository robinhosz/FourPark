package br.com.fourcamp.fourpark;

public class Veiculo {
	
	private String proprietario;
	private String modelo;
	private String placa;
	
	public Veiculo(String propriet�rio, String modelo, String placa) {
		this.proprietario = propriet�rio;
		this.modelo = modelo;
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Veiculo: " + modelo + ", com a placa " + placa + ", de " + proprietario;
	}
}
