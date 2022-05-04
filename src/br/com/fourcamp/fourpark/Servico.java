package br.com.fourcamp.fourpark;

import java.util.List;
import java.util.Scanner;

public interface Servico {

	static Vaga[] criarEstacionamento() {
	Vaga[] vagas = new Vaga[50];

	for(int x=1; x<=50; x++) {
		
		Vaga vaga = new Vaga(x);
		vagas[x - 1] = vaga;
	}
	
	return vagas;
	
	}
}
