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

	static String retornaRegistros(List<Registro> registros) {
		String txt = "";
		for (Registro registro : registros) {
			txt += registro;
		}
		if (registros.isEmpty()) {
			txt = "A lista de registros está vazia \n";
		}
		
		return txt;
	}

	static String retornaValorDoDia(List<Registro> registros) {
		Double valorTotal = 0.0;
		for (Registro registro : registros) {
			valorTotal += registro.getValor();
		}
		String txt = String.format("O valor total do dia é de R$%.2f", valorTotal);
		return txt;

	}
	
}
