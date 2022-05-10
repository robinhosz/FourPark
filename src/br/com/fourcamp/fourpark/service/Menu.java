package br.com.fourcamp.fourpark.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.fourcamp.fourpark.model.Registro;
import br.com.fourcamp.fourpark.model.Vaga;
import br.com.fourcamp.fourpark.model.Veiculo;

public interface Menu {

	public static void apresentaMenu(Vaga[] vagas, Scanner sc, List<Registro> registros) {

		while (true) {
			System.out.println("1 - Estacionar" + "\n2 - Retirar" + "\n3 - Mostrar vagas livres"
					+ "\n4 - Mostrar vagas ocupadas" + "\n5 - Buscar veículo" + "\n6 - Mostrar registro"
					+ "\n7 - Mostrar valor do dia" + "\n8 - Sair" + "\n");

			System.out.print("Digite a opção desejada >>> ");
			int op = 0;
			try {
				op = sc.nextInt();
				System.out.println();
				if (op == 8) {
					System.out.println("Obrigado por usar o sistema FourPark! Até breve.");
					sc.close();
					break;
				} else {
					escolherOpcaoMenu(op, vagas, sc, registros);
				}
			} catch (InputMismatchException e) {
				System.err.println("\n Digite apenas números inteiros! \n");
				sc.next();
			}
			System.out.println("=======================================\n");
		}
	}

	public static void escolherOpcaoMenu(int valorMenu, Vaga[] vagas, Scanner sc, List<Registro> registros) {
		switch (valorMenu) {
		case 1 -> {
			Veiculo veiculo = new Veiculo();
			ServicoVagas.cadastraVeiculo(sc, veiculo);
			String hora = ServicoVagas.validaHora(sc);
			ServicoVagas.estacionar(veiculo, vagas, hora);
		}
		case 2 -> {
			boolean horaValida = false;
			System.out.print("Digite a placa do veiculo >>> ");
			String placa = sc.next();

			Integer posicao = ServicoVagas.buscaCarro(placa, vagas);
			if (posicao == 51) {
				System.err.println("\nCarro não encontrado\n");
				return;
				
			} else {
				do {
					String hora = ServicoVagas.validaHora(sc);

					String hr[] = hora.split(":");
					Integer hrs = Integer.parseInt(hr[0]);

					String horaEntrada = vagas[posicao].getHoraEntrada();
					String hrEnt[] = horaEntrada.split(":");
					Integer hrsEnt = Integer.parseInt(hrEnt[0]);

					if (hrs < hrsEnt) {
						System.err.println("\nDigite um horário maior que o horário de entrada!\n");
					} else {
						horaValida = true;
						ServicoVagas.retirar(posicao, vagas, hora, registros);
					}

				} while (!horaValida);
			}

		}
		case 3 -> ServicoVagas.mostrarVagasLivres(vagas);
		case 4 -> ServicoVagas.mostrarVagasOcupadas(vagas);
		case 5 -> {
			System.out.print("Digite a placa >> ");
			String placa = sc.next();
			Integer posicao = ServicoVagas.buscaCarro(placa, vagas);
			if (posicao != 51) {
				System.out.println("\nCarro da placa: " + placa + ", está na vaga: " + (posicao + 1) + "\n");
			} else {
				System.err.println("\nEste carro não foi encontrado.\n");
			}
		}
		case 6 -> ServicoRegistro.retornaRegistros(registros);
		case 7 -> ServicoRegistro.retornaValorDoDia(registros);
		default -> System.err.println("OPÇÃO INVÁLIDA TENTE NOVAMENTE\n");
		}
	}

}
