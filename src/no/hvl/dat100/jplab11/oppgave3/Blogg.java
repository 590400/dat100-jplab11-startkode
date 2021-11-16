package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.common.TODO;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig = 0;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return this.nesteledig;
	}

	public Innlegg[] getSamling() {
		return this.innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		
		for (int pos = 0; pos < nesteledig; pos++) {
			if (innleggtabell[pos].getId() == innlegg.getId()) {
				return pos;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if (pos >= 0) {
			return true;
		} else
			return false;
	}

	public boolean ledigPlass() {
		while (nesteledig < innleggtabell.length) {
			return true;
		}
		return false;

	}

	public boolean leggTil(Innlegg innlegg) {

		if (ledigPlass() && !finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}

	public String toString() {
		String tmp = nesteledig + "\n";
		
		for (int i = 0; i < nesteledig; i++) {
		if (innleggtabell[i] instanceof Bilde) {
			tmp += "BILDE\n" + innleggtabell[i].getId() + "\n";
			tmp += innleggtabell[i].getBruker() + "\n";
			tmp += innleggtabell[i].getDato() + "\n";
			tmp += innleggtabell[i].getLikes() + "\n";
			tmp += ((Bilde) innleggtabell[i]).getTekst() + "\n";
			tmp += ((Bilde) innleggtabell[i]).getUrl() + "\n";
		}
		else{
		tmp += "TEKST\n" + innleggtabell[i].getId() + "\n";
		tmp += innleggtabell[i].getBruker() + "\n";
		tmp += innleggtabell[i].getDato() + "\n";
		tmp += innleggtabell[i].getLikes() + "\n";
		tmp += ((Tekst) innleggtabell[i]).getTekst() + "\n";
		
		}
	}
		
		return tmp;

		// 2\nTEKST\n1\nOle Olsen\n23-10\n0\nen tekst\nBILDE\n2\nOline
		// Olsen\n24-10\n0\net bilde\nhttp://www.picture.com/oo.jpg\n

	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] tmp = new Innlegg[innleggtabell.length * 2];

		for (int i = 0; i < nesteledig; i++) {
			tmp[i] = innleggtabell[i];
		}
		innleggtabell = tmp;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!ledigPlass())
			utvid();
		if (!finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;

	}

	public boolean slett(Innlegg innlegg) {

		if (finnes(innlegg)) { // flytter bakeste til aktuelle innlegg for å ikke skape hull i tabell
			innleggtabell[finnInnlegg(innlegg)] = innleggtabell[nesteledig - 1];
			innleggtabell[finnInnlegg(innlegg)] = null;
			nesteledig--;
			return true;
		}
		return false;

	}

	public int[] search(String keyword) {
int[] tmp = new int[innleggtabell.length];
int k = 0;
		for (int i = 0; i < nesteledig; i++) {
			if (((Tekst) innleggtabell[i]).getTekst() == keyword) {
				tmp[k] += innleggtabell[i].getId();
				k++;
			}
		}
		return tmp;
	}
}