package org.lessons.java;

import java.time.LocalDate;

import org.lessons.java.pojo.Evento;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Evento e1 = null;
		
		try {
			
			e1 = new Evento("Concerto Lil Texas", LocalDate.parse("2023-12-25"), 100);
			
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
			
		}
		
		System.out.println(e1);
		
	}

}
