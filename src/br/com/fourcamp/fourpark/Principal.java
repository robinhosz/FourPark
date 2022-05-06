package br.com.fourcamp.fourpark;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args)  {
		
		Vaga[] vagas = Servico.criarEstacionamento();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seja bem vindo ao Fourpark!\n");
		
		Servico.apresentaMenu(vagas, sc);
	}
	
}
