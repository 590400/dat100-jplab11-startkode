package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Scanner leser = new Scanner(mappe + filnavn);
		int lengde = leser.nextInt();
		Blogg blogg = new Blogg(lengde);
		
		for(int i = 0;  i < lengde; i++) {
			switch (leser.nextLine()) {
				case "BILDE": 
					int id = leser.nextInt();
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int likes = leser.nextInt();
					String tekst = leser.nextLine();
					String url = leser.nextLine();
					
					Bilde tmp = new Bilde(id, bruker, dato, likes, tekst, url);
					
					blogg.leggTil(tmp);
					break;
				
				case "TEKST":
					id = leser.nextInt();
					bruker = leser.nextLine();
					dato = leser.nextLine();
					likes = leser.nextInt();
					tekst = leser.nextLine();
					
					Tekst tmpT = new Tekst(id, bruker, dato, likes, tekst);
					
					blogg.leggTil(tmpT);
					break;
				}
			
		}
		leser.close();
		return blogg;

	}
}
