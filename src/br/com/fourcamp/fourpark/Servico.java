package br.com.fourcamp.fourpark;

import java.time.format.DateTimeFormatter;

public interface Servico {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	static Vaga[] criarEstacionamento() {
		Vaga[] vagas = new Vaga[50];

		for (int x = 1; x <= 50; x++) {

			Vaga vaga = new Vaga(x);
			vagas[x - 1] = vaga;
		}

		return vagas;

	}

	static void mostrarVagasLivres(Vaga[] vagas) {

		for (int i = 0; i < vagas.length; i++) {
			if (!vagas[i].getOcupado()) {
				System.out.println("A vaga " + vagas[i].getPosicao() + " est� livre");
			}
		}
		
		System.out.println("");
	}

	static void mostrarVagasOcupadas(Vaga[] vagas) {

		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getOcupado()) {
				System.out.println("A vaga " + vagas[i].getPosicao() + " est� ocupada pelo " + vagas[i].getVeiculo());
			}
		}
		System.out.println("");
	}

	static void estacionar(Veiculo veiculo, Vaga[] vagas, String hora) {
		if (buscaCarro(veiculo.getPlaca(), vagas) != 51) {
			System.out.println("Este carro j� est� no estacionamento");
			return;
		}
		for (int x = 0; x <= 49; x++) {
			if (!vagas[x].getOcupado()) {
				vagas[x].setOcupado(true);
				vagas[x].setVeiculo(veiculo);
				vagas[x].setHoraEntrada(hora);
				System.out.println("Estacionado com sucesso �s " + hora + "\n");
				break;
			} else if (x == 49) {
				System.out.println("N�o h� vagas dispon�veis\n");
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
		System.out.println(vagas[posicao].getVeiculo() + ", foi retirado da vaga " + posicao + " �s" + horaSaida + "\n");
		vagas[posicao].setOcupado(false);
		vagas[posicao].setVeiculo(null);
		
		
	}

	
}

