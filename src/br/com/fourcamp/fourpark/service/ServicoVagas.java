package br.com.fourcamp.fourpark.service;

import java.awt.desktop.ScreenSleepEvent;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.fourcamp.fourpark.model.Registro;
import br.com.fourcamp.fourpark.model.Vaga;
import br.com.fourcamp.fourpark.model.Veiculo;

public interface ServicoVagas {

	public static Vaga[] criarEstacionamento() {
		Vaga[] vagas = new Vaga[50];
		for (int x = 1; x <= 50; x++) {
			Vaga vaga = new Vaga(x);
			vagas[x - 1] = vaga;
		}
		return vagas;
	}

	public static void cadastraVeiculo(Scanner sc, Veiculo veiculo) {

		System.out.print("Digite o modelo do ve�culo: ");
		sc.nextLine();
		veiculo.setModelo(sc.nextLine());

		System.out.print("Digite a placa do ve�culo: ");
		veiculo.setPlaca(sc.nextLine());

		System.out.print("Digite o nome do propriet�rio: ");
		veiculo.setProprietario(sc.nextLine());

		System.out.print("Digite o documento do propriet�rio: ");
		veiculo.setDocumento(sc.nextLine());

	}

	public static void mostrarVagasLivres(Vaga[] vagas) {
		boolean imprimiu = false;

		for (int i = 0; i < vagas.length; i++) {
			if (!vagas[i].getOcupado()) {
				System.out.println("A vaga " + vagas[i].getPosicao() + " est� livre");
				imprimiu = true;
			}
		}
		if (!imprimiu) {
			System.err.println("N�o h� nenhuma vaga livre!");
		}
		System.out.println("");
	}

	public static void mostrarVagasOcupadas(Vaga[] vagas) {
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

	public static void estacionar(Veiculo veiculo, Vaga[] vagas, String hora) {
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
				System.err.println("\nN�o h� vagas dispon�veis\n");
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

	public static void retirar(Integer posicao, Vaga[] vagas, String horaSaida, List<Registro> registros) {
		vagas[posicao].setHoraSaida(horaSaida);
		System.out.println("\n" + vagas[posicao].getVeiculo() + ", foi retirado da vaga " + (posicao + 1) + " �s "
				+ horaSaida + "\n");
		Double valorHora = ServicoRegistro.calcularValorHora(vagas[posicao]);
		System.out.print("O valor foi de R$");
		System.out.printf("%.2f\n\n", valorHora);
		ServicoRegistro.atualizaRegistro(registros, vagas[posicao], valorHora);
		vagas[posicao].setOcupado(false);
		vagas[posicao].setVeiculo(null);
	}

	static String validaHora(Scanner sc) {
		String regex = "\\b([0-2]{1})([0-9]{1})\\:([0-5]{1})([0-9]{1})";
		do {
			System.out.print("Digite o hor�rio: ");
			String hora = sc.next();
			String hr[] = hora.split(":");
			try {
				Integer hrs = Integer.parseInt(hr[0]);
				
				Pattern padrao = Pattern.compile(regex);

				Matcher match = padrao.matcher(hora);

				if (!match.find() || hora.length() > 5) {
					System.err.println("\nPor gentileza, Digite a HORA de acordo com o padr�o HH:MM! \n");
					try {
						Thread.sleep(1L);
					} catch (InterruptedException e) {
						System.out.println("Nunca vai cair aqui");
					}
				} else if (hrs >= 24) {
					System.err.println("\nERRO! Digite um hor�rio menor que 24 horas.\n");
				} else {
					return hora;
				}
			} catch (Exception e) {
				System.err.println("\nPor gentileza, Digite a HORA de acordo com o padr�o HH:MM! \n");
			}
			
		} while (true);
	}
}
