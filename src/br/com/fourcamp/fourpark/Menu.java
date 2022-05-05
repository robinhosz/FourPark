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
		switch (valorMenu) {
			case 1 -> { 
				Veiculo veiculo = new Veiculo();
				veiculo.cadastraVeiculo();
				System.out.print("Digite o horário de entrada: ");
				String hora = sc.next();
				Servico.estacionar(veiculo, vagas, hora);
			}
			case 2 -> {
				System.out.print("Digite a placa do veiculo >>> ");
				String placa = sc.next();
				System.out.print("Digite a hora >> ");
				String hora = sc.next();
				Integer posicao = Servico.buscaCarro(placa, vagas);
				if (posicao == 51) {
					System.out.println("\nCarro não encontrado\n");
					return;
				} else {
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
}