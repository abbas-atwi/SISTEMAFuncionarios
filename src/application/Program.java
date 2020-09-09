package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

import entities.ContratosEHoras;
import entities.Departamento;
import entities.Funcionarios;
import entities.enums.Level;

import javax.swing.*;

import static java.util.logging.Level.*;

public class Program {

	public static Logger logger = Logger.getLogger("Program");

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		List<Funcionarios> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Digite o numero de fucionarios a serem registrados ");
		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			Funcionarios fun;
			int ids = requestIntInput("Digite o ID");

//			Funcionarios fuId = list.stream().filter(x -> x.getId().equals(ids)).findFirst().orElse(null);
			while (temId(list, ids)) {
				ids = requestIntInput("ID Já Existente");
			}

			String nomeDep = requestStringInput("Entre com o nome do departamento");
			String nomes = requestStringInput("Dados do trabalhador, nome: ");

			System.out.print("Idade");
			int idade = requestIntInput(scanner);


			System.out.print("level : ");
			scanner.nextLine();
			String levels = scanner.nextLine();

			System.out.print("Salario ");
			double salario = scanner.nextDouble();

			fun = new Funcionarios(ids, nomes, idade, Level.valueOf(levels), salario, new Departamento(nomeDep));
			list.add(fun);
		}

		int idFuncionario = requestIntInput("Informe o funcionário para adicionar contratos");
		Funcionarios fun = list.stream().filter(funcionarios -> funcionarios.getId() == idFuncionario).findFirst().get();

		System.out.println("Quantos contratos deseja ?");
		int nu = scanner.nextInt();

		for (int i = 0; i < nu; i++) {
			System.out.print("Data ");
			Date data = sdf.parse(scanner.next());
			System.out.print("Valor horas");
			double valorHoras = scanner.nextDouble();
			System.out.print("Duracao");
			int horas = scanner.nextInt();
			ContratosEHoras contrato = new ContratosEHoras(data, valorHoras, horas);
			fun.addContratos(contrato);
		}
		System.out.println("Entre com o id que deseja ver o total");
		int id = scanner.nextInt();

		System.out.println("Entre com o Mes e Ano");
		String mesAno = scanner.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));

		Optional<Funcionarios> optinalFuncionario = list.stream()
				.filter(funcionario -> funcionario.getId() == id)
				.findFirst();

		if(!optinalFuncionario.isPresent()) {
			System.out.println("Funcionário não cadastrado");
		}

		Funcionarios itemFuncionario = optinalFuncionario.get();

		System.out.println("Nome " + itemFuncionario.getNome());
		System.out.println("Departamento " + itemFuncionario.getDepartamento().getNome());
		System.out.println("Level : " + itemFuncionario.getLevel());
		System.out.println("Ganhos " + mesAno + ", " + itemFuncionario.ganhos(ano, mes));

		scanner.close();
	}

	public static boolean temId(List<Funcionarios> list, int id) {
		Funcionarios funs = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return funs != null;
	}

	private static int requestIntInput(Scanner scanner) {
		return scanner.nextInt();
	}

	private static String requestStringInput(String mensagem, Scanner scanner) {
		System.out.println(mensagem);
		return scanner.next();
	}

	private static String requestStringInput(String mensagem) {
		return JOptionPane.showInputDialog(mensagem);
	}

	private static int requestIntInput(String mensagem) {
		return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
	}
}
