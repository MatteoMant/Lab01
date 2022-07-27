package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private TextArea txtPerformance;

	@FXML
	private Button btnCancella;

	@FXML
	private Button btnReset;

	@FXML
	void doInsert(ActionEvent event) {
		String parola = txtParola.getText();
		
		if (parola == null || parola.equals("")) {
			txtResult.setText("Per favore inserire una parola");
			return;
		}
		
		txtResult.clear();
		txtParola.clear();
		txtPerformance.clear();

		double start = System.nanoTime();
		this.elenco.addParola(parola);
		double end = System.nanoTime();

		for (String p : this.elenco.getElenco()) {
			txtResult.appendText(p + "\n");
		}

		txtPerformance.setText("Tempo impiegato: " + (end - start) / 1e9 + "secondi");
	}

	@FXML
	void doReset(ActionEvent event) {

		double start = System.nanoTime();
		this.elenco.reset();
		double end = System.nanoTime();

		txtResult.clear();
		txtPerformance.clear();
		
		txtPerformance.setText("Tempo impiegato: " + (end - start) / 1e9 + "secondi");
	}

	@FXML
	void doCancellazione(ActionEvent event) {
		String parola = txtResult.getSelectedText();

		double start = System.nanoTime();
		this.elenco.rimuoviParola(parola);
		double end = System.nanoTime();

		txtResult.clear();
		txtParola.clear();
		txtPerformance.clear();

		for (String p : this.elenco.getElenco()) {
			txtResult.appendText(p + "\n");
		}

		txtPerformance.setText("Tempo impiegato: " + (end - start) / 1e9 + "secondi");
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

		elenco = new Parole();
	}
}
