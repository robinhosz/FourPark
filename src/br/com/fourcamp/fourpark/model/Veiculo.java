package br.com.fourcamp.fourpark.model;

public class Veiculo {

	private String modelo;
	private String placa;
	private String proprietario;
	private String documento;
	
	public Veiculo() {
		
	}
	
	public String getPlaca() {
		return placa;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "veículo modelo " + modelo + ", de placa " + placa + ", de " + proprietario + ", portador(a) do documento "
				+ documento;
	}
	
}
