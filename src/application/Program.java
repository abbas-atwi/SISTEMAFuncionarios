package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratosEHoras;
import entities.Departamento;
import entities.Funcionarios;
import entities.enums.Level;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Funcionarios fun = new Funcionarios();
		List<Funcionarios> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o numero de fucionarios a serem registrados ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.print("Digite o id");
			int ids = sc.nextInt();
			Funcionarios fuId = list.stream().filter(x -> x.getId().equals(ids)).findFirst().orElse(null);
			while (fuId.equals(ids)) {
				System.out.println("Ja existe");
			}

			System.out.print("Entre com o nome do departamento ");
			String nomeDep = sc.nextLine();

			System.out.println("Dados do trabalhador");
			System.out.print("Nome ");
			String nomes = sc.nextLine();

			System.out.print("Idade");
			int idade = sc.nextInt();

			System.out.print("level : ");
			sc.nextLine();
			String levels = sc.nextLine();

			System.out.print("Salario ");
			double salario = sc.nextDouble();

			fun = new Funcionarios(ids, nomes, idade, Level.valueOf(levels), salario, new Departamento(nomeDep));

		}

		System.out.println("Quantos contratos deseja ?");
		int nu = sc.nextInt();

		for (int i = 0; i < nu; i++) {
			System.out.print("Data ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor horas");
			double valorHoras = sc.nextDouble();
			System.out.print("Duracao");
			int horas = sc.nextInt();
			ContratosEHoras contrato = new ContratosEHoras(data, valorHoras, horas);
			fun.addContratos(contrato);
		}
		System.out.println("Entre com o id que deseja ver o total");
		int id = sc.nextInt();

		System.out.println("Entre com o Mes e Ano");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));

		if (fun.getId() == id) {
			System.out.println("Nome " + fun.getNome());
			System.out.println("Departamento " + fun.getDepartamento().getNome());
			System.out.println("Level : " + fun.getLevel());
			System.out.println("Ganhos " + mesAno + ", " + fun.ganhos(ano, mes));
		} else {
			System.out.println("Este id nao existe");

		}

		sc.close();
	}

}
