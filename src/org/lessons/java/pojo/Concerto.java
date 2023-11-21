package org.lessons.java.pojo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime ora;
	
	private BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws Exception {
		
		super(titolo, data, postiTotali);
		
		setOra(ora);
		setPrezzo(prezzo);
		
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String formattaDataeOrario() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
		String ora = getOra().format(formatter);
		
		return super.getData() + " " +  ora;
	}
	
	public String formattaPrezzo() {
		
		DecimalFormat formato = new DecimalFormat("#0.00");
		
		String prezzoFormattato = formato.format(getPrezzo());
		
		return prezzoFormattato;
		
	}
	
	@Override
	public String toString() {
		
		return formattaDataeOrario() + " - " + super.getTitolo() + " - " + formattaPrezzo() + "€";
	}

}
