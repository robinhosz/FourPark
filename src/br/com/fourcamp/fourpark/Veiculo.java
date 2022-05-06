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
		
		System.out.print("Digite o modelo do ve�culo: ");
		modelo = sc.nextLine();
		
		System.out.print("Digite a placa do ve�culo: ");
		placa = sc.next();
		
		System.out.print("Digite o nome do propriet�rio: ");
		sc.nextLine();
		proprietario = sc.nextLine();
		
		System.out.print("Digite o documento do propriet�rio: ");
		documento = sc.next();
		
	}

	@Override
	public String toString() {
		return "ve�culo modelo " + modelo + ", de placa " + placa + ", de " + proprietario + ", portador(a) do documento "
				+ documento;
	}
	
}
