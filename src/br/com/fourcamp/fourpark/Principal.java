package br.com.fourcamp.fourpark;

import java.time.LocalDateTime;
import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args)  {
		
		Vaga[] vagas = Servico.criarEstacionamento();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			for(Menu m : Menu.values()) {
				System.out.println("Opção " + m + " >>> " + m.getValor());
				
			}
			System.out.print("Digite a opção desejada >>> ");
			int op = sc.nextInt();
			if (op == 6) {
				break;
			} else {
				Menu.escolherOpcaoMenu(op, vagas);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
