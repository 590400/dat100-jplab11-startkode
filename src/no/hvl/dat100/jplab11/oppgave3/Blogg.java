package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;

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
		int pos = 0;
		while (pos < nesteledig) {
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
		}
		else return false;
	}

	public boolean ledigPlass() {
		while(nesteledig < innleggtabell.length) {
			return true;
		}
			return false;

	}

	public boolean leggTil(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public String toString() {
		throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}