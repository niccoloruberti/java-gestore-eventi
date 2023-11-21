package org.lessons.java.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo;
	
	private LocalDate data;
	
	private int postiTotali;
	
	private int postiPrenotati;
	
	public Evento (String titolo, LocalDate data, int postiTotali) throws Exception {
		
		setTitolo(titolo);
		setData(data);
		setPostiTotali(postiTotali);
		setPostiPrenotati(0);
		
	}
	
	//getter e setter

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		
		if (data.isBefore(LocalDate.now())) {
			throw new Exception("Inserire una data futura");
		}
		
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	private void setPostiTotali(int postiTotali) throws Exception {
		
		if (postiTotali <= 0) {
			throw new Exception("Inserire un numero di posti maggiore di 0");
		}
		
		this.postiTotali = postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	private void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}
	
	//altri metodi
	
	public void prenota() throws Exception {
		
		if (getData().isBefore(LocalDate.now())) {
			
			throw new Exception("Non puoi prenotare eventi passati");
			
		} else if (getPostiPrenotati() == getPostiTotali()) {
			
			throw new Exception("Non ci sono più posti disponibili per questo evento");
		}
		
		setPostiPrenotati(getPostiPrenotati() + 1);
	}
	
	public void disdici() throws Exception {
		
		if (getData().isBefore(LocalDate.now())) {
			
			throw new Exception("Non puoi disdire eventi passati");
			
		} else if (getPostiPrenotati() == 0) {
			
			throw new Exception("Non risultano prenotazioni per questo evento");
			
		}
		
		setPostiPrenotati(getPostiPrenotati() - 1);
		
	}
	
	public String dataFormattata() {
		
		String dataFormattata = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		return dataFormattata;
	}
	
	@Override
	public String toString() {
		
		return dataFormattata() + " - " + titolo;
	}
	
}
