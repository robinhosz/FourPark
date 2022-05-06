package br.com.fourcamp.fourpark;

import java.util.Scanner;

public interface Servico {
	
	public static void apresentaMenu(Vaga[] vagas, Scanner sc) {
		while(true) {			
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
				System.out.print("Digite o horário de entrada: ");
				String hora = sc.next();
				Servico.estacionar(veiculo, vagas, hora);
			}
			case 2 -> {
				System.out.print("Digite a placa do veiculo >>> ");
				String placa = sc.next();
				
				Integer posicao = Servico.buscaCarro(placa, vagas);
				if (posicao == 51) {
					System.out.println("\nCarro não encontrado\n");
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
					System.out.println("\nCarro da placa: " + placa + ", está na vaga: " + (posicao + 1) + "\n");
				} else {
					System.out.println("\nEste carro não foi encontrado.\n");
				} 
			}
				default -> System.err.println("OPÇÃO INVÁLIDA TENTE NOVAMENTE\n");
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
				System.out.println("A vaga " + vagas[i].getPosicao() + " está livre");
				imprimiu = true;
			} 
		}
		if (!imprimiu) {
			System.out.println("Não há nenhuma vaga livre!");
		}		
		System.out.println("");
	}

	static void mostrarVagasOcupadas(Vaga[] vagas) {
		boolean imprimiu = false;

		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getOcupado()) {
				System.out.println("A vaga " + vagas[i].getPosicao() + " está ocupada pelo " + vagas[i].getVeiculo());
				imprimiu = true;
			}
		}
		
		if (!imprimiu) {
				System.out.println("Não há nenhuma vaga ocupada!");
		}
		
		System.out.println("");
	}

	static void estacionar(Veiculo veiculo, Vaga[] vagas, String hora) {
		if (buscaCarro(veiculo.getPlaca(), vagas) != 51) {
			System.out.println("\nEste carro já está no estacionamento\n");
			return;
		}
		for (int x = 0; x <= 49; x++) {
			if (!vagas[x].getOcupado()) {
				vagas[x].setOcupado(true);
				vagas[x].setVeiculo(veiculo);
				vagas[x].setHoraEntrada(hora);
				System.out.println("\nEstacionado com sucesso ás " + hora + "\n");
				break;
			} else if (x == 49) {
				System.out.println("\nNão há vagas disponíveis\n");
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
		System.out.println("\n" + vagas[posicao].getVeiculo() + ", foi retirado da vaga " + (posicao + 1) + " às " + horaSaida + "\n");
		vagas[posicao].setOcupado(false);
		vagas[posicao].setVeiculo(null);
	}

	
}

