package br.com.fourcamp.fourpark.service;

import java.util.List;
import java.util.Scanner;
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
		String modelo = sc.next();
		System.out.print("Digite a placa do ve�culo: ");
		String placa = sc.next();
		System.out.print("Digite o nome do propriet�rio: ");
		String proprietario = sc.next();
		System.out.print("Digite o documento do propriet�rio: ");
		String documento = sc.next();
		
		veiculo.setModelo(modelo);
		veiculo.setPlaca(placa);
		veiculo.setProprietario(proprietario);
		veiculo.setDocumento(documento);
	}

	public static String mostrarVagasLivres(Vaga[] vagas) {
		String txt = "";
		
		for (int i = 0; i < vagas.length; i++) {
			if (!vagas[i].getOcupado()) {
				txt += "A vaga " + vagas[i].getPosicao() + " est� livre\n";
			}
		}
		if (txt.equalsIgnoreCase("")) {
			txt = "N�o h� nenhuma vaga livre!";
		}
		return txt;
	}

	public static String mostrarVagasOcupadas(Vaga[] vagas) {
		String txt = "";

		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getOcupado()) {
				txt += "A vaga " + vagas[i].getPosicao() + " est� ocupada pelo " + vagas[i].getVeiculo() + "\n";
			}
		}
		if (txt.equalsIgnoreCase("")) {
			txt = "N�o h� nenhuma vaga ocupada!";
		}
		return txt;
	}

	public static String estacionar(Veiculo veiculo, Vaga[] vagas, String hora) {
		String txt = "";
		
		if (buscaCarro(veiculo.getPlaca(), vagas) != 51) {
			txt = "\nEste carro j� est� no estacionamento\n";
			return txt;
		}
		for (int x = 0; x <= 49; x++) {
			if (!vagas[x].getOcupado()) {
				vagas[x].setOcupado(true);
				vagas[x].setVeiculo(veiculo);
				vagas[x].setHoraEntrada(hora);
				txt = "\nEstacionado com sucesso �s " + hora + "\n";
				return txt;
			} else if (x == 49) {
				txt = "\nN�o h� vagas dispon�veis\n";
				return txt;
			}
		}
		return txt;
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

	public static String retirar(Integer posicao, Vaga[] vagas, String horaSaida, List<Registro> registros) {
		String txt = "";
		
		vagas[posicao].setHoraSaida(horaSaida);
		txt = "\n" + vagas[posicao].getVeiculo() + ", foi retirado da vaga " + (posicao + 1) + " �s "
				+ horaSaida + "\n";
		Double valorHora = ServicoRegistro.calcularValorHora(vagas[posicao]);
		txt += "O valor foi de R$";
		txt += String.format("%.2f\n\n", valorHora);
		ServicoRegistro.atualizaRegistro(registros, vagas[posicao], valorHora);
		vagas[posicao] = new Vaga(posicao);
		return txt;
	}

	static String validaHora(Scanner sc) {
		Pattern regex = Pattern.compile("^([0-1]{1})([0-9]{1})\\:([0-5]{1})([0-9]{1})$");
		Pattern regex2 = Pattern.compile("^([2]{1})([0-3]{1})\\:([0-5]{1})([0-9]{1})$");
		do {
			System.out.print("Digite o hor�rio: ");
			String hora = sc.next();
			if (regex.matcher(hora).matches() || regex2.matcher(hora).matches()) {
				return hora;
			} else {
				System.err.println("\nERRO! Digite um hor�rio dentro do padr�o HH:mm e menor que 24 horas!\n");
				ThreadDelay();
			}
		} while (true);
	}

	static void ThreadDelay() {
		try {
			Thread.sleep(1L);
		} catch (InterruptedException e) {
			System.out.println("Nunca vai cair aqui");
		}
	}
}
