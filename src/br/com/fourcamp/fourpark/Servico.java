package br.com.fourcamp.fourpark;

public interface Servico {

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
				System.out.println("A vaga " + vagas[i].getPosicao() + " está livre");
			} 
		}
		
		System.out.println("");
	}

	static void mostrarVagasOcupadas(Vaga[] vagas) {

		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getOcupado()) {
				System.out.println("A vaga " + vagas[i].getPosicao() + " está ocupada pelo " + vagas[i].getVeiculo());
			}
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

