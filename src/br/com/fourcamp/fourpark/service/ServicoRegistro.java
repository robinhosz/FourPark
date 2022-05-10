package br.com.fourcamp.fourpark.service;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import br.com.fourcamp.fourpark.model.Registro;
import br.com.fourcamp.fourpark.model.Vaga;

public interface ServicoRegistro {

	static Double calcularValorHora(Vaga vaga) {
		LocalTime inicio = LocalTime.parse(vaga.getHoraEntrada());
		LocalTime fim = LocalTime.parse(vaga.getHoraSaida());
		Double taxa = 10.0;
		int diffMinutes = (int) ChronoUnit.MINUTES.between(inicio, fim);
		int horas = diffMinutes / 60;
		int minutos = diffMinutes % 60;
		Double resultado = (horas + (minutos * 0.017)) * taxa;
		return resultado;
	}

	static void atualizaRegistro(List<Registro> registros, Vaga vaga, Double valorHora) {
		Registro registro = new Registro();
		registro.setVeiculo(vaga.getVeiculo());
		registro.setHoraDeEntrada(vaga.getHoraEntrada());
		registro.setHoraDeSaida(vaga.getHoraSaida());
		registro.setValor(valorHora);
		registro.setResgistro(registros.size() + 1);
		registro.setVaga(vaga.getPosicao());
		registros.add(registro);
	}

	static void retornaRegistros(List<Registro> registros) {
		for (Registro registro : registros) {
			System.out.println(registro);
		}
		if (registros.isEmpty()) {
			System.err.println("A lista de registros está vazia \n");
		}

	}

	static void retornaValorDoDia(List<Registro> registros) {
		Double valorTotal = 0.0;
		for (Registro registro : registros) {
			valorTotal += registro.getValor();
		}
		System.out.print("O valor total do dia é de R$");
		System.out.printf("%.2f\n\n", valorTotal);

	}
	
}
