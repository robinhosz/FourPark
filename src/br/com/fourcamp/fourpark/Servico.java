package br.com.fourcamp.fourpark;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public interface Servico {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	static Vaga[] criarEstacionamento() {
	Vaga[] vagas = new Vaga[50];

	for(int x=1; x<=50; x++) {
		
		Vaga vaga = new Vaga(x);
		vagas[x - 1] = vaga;
	}
	
	return vagas;
	
	}
	
	static void mostrarTodasVagas(Vaga[] vagas) {
 
        for (int i = 0; i < vagas.length; i++) {
            if (!vagas[i].getOcupado()){
                System.out.println("A vaga " + vagas[i].getPosicao() + " está livre");
            } else {
                System.out.println("A vaga " + vagas[i].getPosicao() + " está ocupada pelo " + vagas[i].getVeiculo());
            }
        }
 
        
    }
	
	static void estacionar(Veiculo veiculo, Vaga[] vagas) {
		for(int x=0; x<=49; x++) {
			if (!vagas[x].getOcupado()) {
				vagas[x].setOcupado(true);
				vagas[x].setVeiculo(veiculo);
				vagas[x].setHoraEntrada(LocalDateTime.now());
				break;
			} else if (x==49) {
				System.out.println("Não há vagas disponíveis");
				break;
			}
		}
	}
	
	static void retirar(Veiculo veiculo, Vaga[] vagas) {
		for(int x=0; x<=49; x++) {
			if (vagas[x].getVeiculo().equals(veiculo)) {
				vagas[x].setHoraSaida(LocalDateTime.now());
				System.out.println(vagas[x].getVeiculo() + ", foi estacionado em " + dtf.format(vagas[x].getHoraEntrada()) + 
						" e retirado em " + dtf.format(vagas[x].getHoraSaida()));
				vagas[x].setOcupado(false);
				vagas[x].setVeiculo(null);
				break;
			} else if (x==49) {
				System.out.println("Este veiculo não está em nosso estacionamento");
				break;
			}
	}
	
	}
}
