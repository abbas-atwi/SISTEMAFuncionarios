package entities;

import java.util.Date;

public class ContratosEHoras {
	private Date data;
	private double valorHoras;
	private Integer horas;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorHoras() {
		return valorHoras;
	}

	public void setValorHoras(double valorHoras) {
		this.valorHoras = valorHoras;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public ContratosEHoras() {
	}

	public ContratosEHoras(Date data, double valorHoras, Integer horas) {
		this.data = data;
		this.valorHoras = valorHoras;
		this.horas = horas;
	}

	public double total() {
		return valorHoras * horas;
	}

}
