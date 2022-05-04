package br.com.fourcamp.fourpark;

import java.time.LocalDateTime;
import java.util.Scanner;


public class Principal {
	
	public static void main(String[] args)  {
		
		Vaga[] vagas = Servico.criarEstacionamento();
		
		System.out.println(vagas[1]);
		
		Veiculo carro = new Veiculo();
		carro.cadastraVeiculo();
		
		Servico.estacionar(carro, vagas);
		Servico.retirar(carro, vagas);
	
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
