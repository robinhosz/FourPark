package br.com.fourcamp.fourpark;

import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args)  {
		
		Vaga[] vagas = Servico.criarEstacionamento();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seja bem vindo ao Fourpark!\n");
		
		while(true) {
			System.out.println("1 - Estacionar" +
					"\n2 - Retirar" +
					"\n3 - Mostrar vagas livres" + 
					"\n4 - Mostrar vagas ocupadas" + 
					"\n5 - Buscar ve�culo" + 
					"\n6 - Sair");
			
			System.out.print("Digite a op��o desejada >>> ");
			int op = sc.nextInt();
			if (op == 6) {
				break;
			} else {
				Menu.escolherOpcaoMenu(op, vagas);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
