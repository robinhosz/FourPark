package br.com.fourcamp.fourpark;

import java.util.Scanner;

public enum Menu {

	ESTACIONAR(1), RETIRAR(2), MOSTRAR_VAGAS_LIVRES(3), MOSTRAR_VAGAS_OCUPADAS(4), BUSCAR_VEICULO(5);

	private final int valor;

	private Menu(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}

	public static void escolherOpcaoMenu(int valorMenu, Vaga[] vagas) {
		Scanner sc = new Scanner(System.in);
		if (valorMenu == Menu.ESTACIONAR.getValor()) {
			Veiculo veiculo = new Veiculo();
			veiculo.cadastraVeiculo();
			
			System.out.print("Digite o horário de entrada: ");
			String hora = sc.next();
			Servico.estacionar(veiculo, vagas, hora);
		} else if (valorMenu == Menu.RETIRAR.getValor()) {
			System.out.print("Digite a placa do veiculo >>> ");
			String placa = sc.next();
			Integer posicao = Servico.buscaCarro(placa, vagas);
			if (posicao == 51) {
				System.out.println("Carro não encontrado");
				return;

			} else {
				Servico.retirar(posicao, vagas, placa);
			}
		} else if (valorMenu == Menu.MOSTRAR_VAGAS_LIVRES.getValor()) {
			Servico.mostrarVagasLivres(vagas);
		} else if (valorMenu == Menu.MOSTRAR_VAGAS_OCUPADAS.getValor()) {
			Servico.mostrarVagasOcupadas(vagas);
		} else if (valorMenu == Menu.BUSCAR_VEICULO.getValor()) {
			System.out.print("Digite a placa >> ");
			String placa = sc.next();
			Integer posicao = Servico.buscaCarro(placa, vagas);
			if (posicao != 51) {
				System.out.println("Carro da placa: " + placa + ", está na vaga: " + (posicao + 1) + "\n");
			} else {
				System.out.println("Este carro não foi encontrado.\n");
			}
		} 

		else
			System.err.println("OPÇÃO INVÁLIDA TENTE NOVAMENTE\n");
	}
}