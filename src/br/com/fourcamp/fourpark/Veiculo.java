package br.com.fourcamp.fourpark;

public class Veiculo {
	
	private String proprietario;
	private String modelo;
	private String placa;
	
	public Veiculo(String proprietário, String modelo, String placa) {
		this.proprietario = proprietário;
		this.modelo = modelo;
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Veiculo: " + modelo + ", com a placa " + placa + ", de " + proprietario;
	}
}
