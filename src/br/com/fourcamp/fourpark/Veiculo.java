package br.com.fourcamp.fourpark;

import java.util.Scanner;

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

	public void cadastraVeiculo(Scanner sc) {
		
		System.out.print("Digite o modelo do veículo: ");
		modelo = sc.nextLine();
		
		System.out.print("Digite a placa do veículo: ");
		placa = sc.next();
		
		System.out.print("Digite o nome do proprietário: ");
		sc.nextLine();
		proprietario = sc.nextLine();
		
		System.out.print("Digite o documento do proprietário: ");
		documento = sc.next();
		
	}

	@Override
	public String toString() {
		return "veículo modelo " + modelo + ", de placa " + placa + ", de " + proprietario + ", portador(a) do documento "
				+ documento;
	}
	
}
