package br.com.fourcamp.fourpark;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fourcamp.fourpark.model.Registro;
import br.com.fourcamp.fourpark.model.Vaga;
import br.com.fourcamp.fourpark.service.Menu;
import br.com.fourcamp.fourpark.service.ServicoVagas;

public class Principal {
	
	public static void main(String[] args)  {
		
		Vaga[] vagas = ServicoVagas.criarEstacionamento();
		List<Registro> registros = new ArrayList<Registro>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Seja bem vindo ao Fourpark!\n");
		
		Menu.apresentaMenu(vagas, sc, registros);
	}
	
}
