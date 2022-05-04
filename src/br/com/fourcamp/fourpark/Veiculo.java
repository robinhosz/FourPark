package br.com.fourcamp.fourpark;

import java.util.Scanner;

public class Veiculo {

	private String modelo;
	private String placa;
	private String proprietario;
	private String documento;
	
	public Veiculo() {
		
	}

	public String getProprietario() {
		return proprietario;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public void cadastraVeiculo() {
		Scanner sc = new Scanner(System.in);
		
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
		return "Ve�culo [modelo: " + modelo + ", placa: " + placa + ", proprietario: " + proprietario + ", documento:"
				+ documento + "]";
	}
	
}
