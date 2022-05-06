package br.com.fourcamp.fourpark;

import java.util.Scanner;

public interface Servico {
	
	public static void apresentaMenu(Vaga[] vagas, Scanner sc) {
		while(true) {			
			System.out.println("1 - Estacionar" +
					"\n2 - Retirar" +
					"\n3 - Mostrar vagas livres" + 
					"\n4 - Mostrar vagas ocupadas" + 
					"\n5 - Buscar ve�culo" + 
					"\n6 - Sair" +
					"\n");
			
			System.out.print("Digite a op��o desejada >>> ");
			int op = sc.nextInt();
			System.out.println();
			if (op == 6) {
				sc.close();
				break;
			} else {
				escolherOpcaoMenu(op, vagas, sc);
			}
			System.out.println("=======================================\n");
		}
	}

	public static void escolherOpcaoMenu(int valorMenu, Vaga[] vagas, Scanner sc) {
		switch (valorMenu) {
			case 1 -> { 
				Veiculo veiculo = new Veiculo();
				veiculo.cadastraVeiculo(sc);
				System.out.print("Digite o hor�rio de entrada: ");
				String hora = sc.next();
				Servico.estacionar(veiculo, vagas, hora);
			}
			case 2 -> {
				System.out.print("Digite a placa do veiculo >>> ");
				String placa = sc.next();
				
				Integer posicao = Servico.buscaCarro(placa, vagas);
				if (posicao == 51) {
					System.out.println("\nCarro n�o encontrado\n");
					return;
				} else {
					System.out.print("Digite a hora >> ");
					String hora = sc.next();
					Servico.retirar(posicao, vagas, hora);	
				}
			}
			case 3 -> Servico.mostrarVagasLivres(vagas);
			case 4 -> Servico.mostrarVagasOcupadas(vagas);
			case 5 -> {
				System.out.print("Digite a placa >> ");
				String placa = sc.next();
				Integer posicao = Servico.buscaCarro(placa, vagas);
				if (posicao != 51) {
					System.out.println("\nCarro da placa: " + placa + ", est� na vaga: " + (posicao + 1) + "\n");
				} else {
					System.out.println("\nEste carro n�o foi encontrado.\n");
				} 
			}
				default -> System.err.println("OP��O INV�LIDA TENTE NOVAMENTE\n");
			} 
	}
	
	static Vaga[] criarEstacionamento() {
		Vaga[] vagas = new Vaga[50];

		for (int x = 1; x <= 50; x++) {

			Vaga vaga = new Vaga(x);
			vagas[x - 1] = vaga;
		}
		return vagas;
	}

	static void mostrarVagasLivres(Vaga[] vagas) {
		boolean imprimiu = false;

		for (int i = 0; i < vagas.length; i++) {
			if (!vagas[i].getOcupado()) {
				System.out.println("A vaga " + vagas[i].getPosicao() + " est� livre");
				imprimiu = true;
			} 
		}
		if (!imprimiu) {
			System.out.println("N�o h� nenhuma vaga livre!");
		}		
		System.out.println("");
	}

	static void mostrarVagasOcupadas(Vaga[] vagas) {
		boolean imprimiu = false;

		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getOcupado()) {
				System.out.println("A vaga " + vagas[i].getPosicao() + " est� ocupada pelo " + vagas[i].getVeiculo());
				imprimiu = true;
			}
		}
		
		if (!imprimiu) {
				System.out.println("N�o h� nenhuma vaga ocupada!");
		}
		
		System.out.println("");
	}

	static void estacionar(Veiculo veiculo, Vaga[] vagas, String hora) {
		if (buscaCarro(veiculo.getPlaca(), vagas) != 51) {
			System.out.println("\nEste carro j� est� no estacionamento\n");
			return;
		}
		for (int x = 0; x <= 49; x++) {
			if (!vagas[x].getOcupado()) {
				vagas[x].setOcupado(true);
				vagas[x].setVeiculo(veiculo);
				vagas[x].setHoraEntrada(hora);
				System.out.println("\nEstacionado com sucesso �s " + hora + "\n");
				break;
			} else if (x == 49) {
				System.out.println("\nN�o h� vagas dispon�veis\n");
				break;
			}
		}
	}

	public static Integer buscaCarro(String placa, Vaga[] vagas) {
		Veiculo veiculo;
		Integer posicao = 51;
		for (int x = 0; x <= 49; x++) {
			veiculo = vagas[x].getVeiculo();
			if (vagas[x].getOcupado()) {
				if (veiculo.getPlaca().compareToIgnoreCase(placa) == 0) {
					posicao = x;
				}
			}
		}
		return posicao;
	}

	static void retirar(Integer posicao, Vaga[] vagas, String horaSaida) {
		vagas[posicao].setHoraSaida(horaSaida);
		System.out.println("\n" + vagas[posicao].getVeiculo() + ", foi retirado da vaga " + (posicao + 1) + " �s " + horaSaida + "\n");
		vagas[posicao].setOcupado(false);
		vagas[posicao].setVeiculo(null);
	}

	
}

