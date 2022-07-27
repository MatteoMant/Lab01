package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {

	List<String> parole;

	public Parole() {
		// this.parole = new ArrayList<String>();
		this.parole = new LinkedList<String>();
	}

	public void addParola(String p) {
		this.parole.add(p);
	}

	public List<String> getElenco() {
		Collections.sort(this.parole);
		return this.parole;
	}

	public void reset() {
		this.parole.clear();
	}

	public void rimuoviParola(String p) {
		this.parole.remove(p);
	}

}
