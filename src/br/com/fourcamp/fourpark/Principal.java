package br.com.fourcamp.fourpark;

import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args)  {
		
		Vaga[] vagas = Servico.criarEstacionamento();
		Scanner sc = new Scanner(System.in);
		Integer contador = 0;
		
		System.out.println("Seja bem vindo ao Fourpark!\n");
		
		while(true) {
			if (contador == 1) {
				System.out.println("=======================================\n");
			}
			contador = 1;
			
			System.out.println("1 - Estacionar" +
					"\n2 - Retirar" +
					"\n3 - Mostrar vagas livres" + 
					"\n4 - Mostrar vagas ocupadas" + 
					"\n5 - Buscar veículo" + 
					"\n6 - Sair" +
					"\n");
			
			System.out.print("Digite a opção desejada >>> ");
			int op = sc.nextInt();
			System.out.println();
			if (op == 6) {
				sc.close();
				break;
			} else {
				Menu.escolherOpcaoMenu(op, vagas);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
