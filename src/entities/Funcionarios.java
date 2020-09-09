package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.Level;

public class Funcionarios {
	private Integer id;
	private String nome;
	private int idade;
	private Level level;
	private double baseSalario;

//	Associacoes
	private Departamento departamento;

	private List<ContratosEHoras> contratos = new ArrayList<>();

	public Funcionarios() {
	}

	public Funcionarios(Integer id,String nome, int idade,Level level,double baseSalario, Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.baseSalario = baseSalario;
		this.departamento = departamento;
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public double getBaseSalario() {
		return baseSalario;
	}

	public void setBaseSalario(double baseSalario) {
		this.baseSalario = baseSalario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratosEHoras> getContratos() {
		return contratos;
	}

	public void addContratos(ContratosEHoras contrato) {
		contratos.add(contrato);
	}

	public void removerContratos(ContratosEHoras contrato) {
		contratos.remove(contrato);
	}

	public double ganhos(int ano, int mes) {
		double soma = baseSalario;
		Calendar cal = Calendar.getInstance();
		for (ContratosEHoras c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.total();
			}
		}
		return soma;
	}


}
