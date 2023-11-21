package org.lessons.java.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {

	private String titolo;
	
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo, List<Evento> eventi) {
		
		setTitolo(titolo);
		
		setEventi(eventi);
	}
	
	//setter e getter

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	//altri metodi
	
	public void addEvento(Evento evento) {
		
		getEventi().add(evento);
		
	}
	
	public List<Evento> eventiInData(LocalDate data) {
		
		List<Evento> eventiFiltrati = new ArrayList<>();
		
		for (Evento evento: getEventi()) {
			
			if (evento.getData().equals(data)) {
				
				eventiFiltrati.add(evento);
			}
		}
		
		return eventiFiltrati;
		
	}
	
	public int nEventiProgramma() {
		
		return getEventi().size();
	}
	
	
	public void svuotaLista() {
		
		getEventi().clear();
	}
	
	public String ordinaEventi(List<Evento> eventi) {
		
		Collections.sort(eventi, Comparator.comparing(Evento::getData));
		
		String result = "";
		
        for (Evento evento : eventi) {
            result += (evento.getData()) + " - " + evento.getTitolo() + "\n";
        }
        
        return result;
		
	}
}
