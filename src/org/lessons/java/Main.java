package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.lessons.java.pojo.Concerto;
import org.lessons.java.pojo.Evento;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
//		Concerto c1 = new Concerto("titolo", LocalDate.parse("2023-12-12"), 100, LocalTime.parse("18:00"), new BigDecimal("20"));
//		
//		System.out.println(c1);
		
		Evento e1 = null;
		
		System.out.println("Vuoi inserire un nuovo evento?");
		
		String ansUser = in.nextLine();
		
		if (ansUser.equals("si")) {
			
			System.out.println("L'evento è un concerto? si/no");
			
			ansUser = in.nextLine();
			
			System.out.println("Inserisci il nome dell'evento: ");
			
			String title = in.nextLine();
			
			System.out.println("Inserisci la data dell'evento: (yyyy-mm-dd) ");
			
			String date = in.nextLine();
			
			System.out.println("Inserisci il numero di posti disponiibili: ");
			
			String postiStr = in.nextLine();
			
			int posti = Integer.valueOf(postiStr);
			
			String orario = null;
			
			String prezzo = null;
			
			if (ansUser.equals("si")) {
				
				System.out.println("Inserisci l'orario dell'evento: hh:mm");
				
				orario = in.nextLine();
				
				System.out.println("inserisci il prezzo dell'evento");
				
				prezzo = in.nextLine();
				
			}
			
			try {
				
				if (ansUser.equals("si")) {
					
					e1 = new Concerto(title, LocalDate.parse(date), posti, LocalTime.parse(orario), new BigDecimal(prezzo));
					
					System.out.println(e1);
					
				} else {
					
					e1 = new Evento(title, LocalDate.parse(date), posti);
					
					System.out.println(e1);
					
				}

				
			} catch (Exception e) {
				
				System.err.println(e.getMessage());
				in.close();
				return;
				
			}
			
		} else {
			
			in.close();
			return;
		}
		
		//prenotazione posti
		
		System.out.println("Vuoi prenotare questo evento? si/no");
		
		ansUser = in.nextLine();
		
		if (ansUser.equals("si")) {
			
			//svolgimento della prenotazione
			System.out.println("Quanti posti vuoi prenotare?");
			
			String nPrenotazioniStr = in.nextLine();
			
			int nPrenotazioni = Integer.valueOf(nPrenotazioniStr);
			
			for (int x = 0; x < nPrenotazioni; x++) {
				
				try {
					
					e1.prenota();
					
				} catch (Exception e) {
					
					System.err.println(e.getMessage());
				}
				
			}
			
			System.out.println("Posti totali prenotati: " + e1.getPostiPrenotati());
			System.out.println("Posti disponibili: " + (e1.getPostiTotali() - e1.getPostiPrenotati()));
			
		}
		
		//annullare prenotazione
		
		System.out.println("Vuoi disidire una prenotazione? si/no");
		
		ansUser = in.nextLine();
		
		if (ansUser.equals("si")) {
			
			System.out.println("Quanti posti vuoi disdire? ");
			
			String nPrenotazioniAnnullateStr = in.nextLine();
			
			int nPrenotazioniAnnullate = Integer.valueOf(nPrenotazioniAnnullateStr);
			
			for (int x = 0; x < nPrenotazioniAnnullate; x++) {
				
				try {
					
					e1.disdici();
					
				} catch (Exception e) {
					
					System.err.println(e.getMessage());
					break;
					
				}
			}
			
			System.out.println("Posti totali prenotati: " + e1.getPostiPrenotati());
			System.out.println("Posti disponibili: " + (e1.getPostiTotali() - e1.getPostiPrenotati()));
			
		}
		
		in.close();
		
	}

}
