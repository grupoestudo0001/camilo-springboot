package aprendizado.camilospringboot.estrutura;

import static aprendizado.camilospringboot.estrutura.Util.isNumeric;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aprendizado.camilospringboot.exceptions.OperacaoSemSuporte;

public class Util {

	public static boolean isNumeric(String number) {
		if (number == null)
			return false;
		number.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	public Double sum(Double numberOne, Double numberTwo) {

		return numberOne + numberTwo;
	}

	public Double less(Double numberOne, Double numberTwo) {

		return numberOne - numberTwo;
	}

	public Double mult(Double numberOne, Double numberTwo) {

		return numberOne * numberTwo;
	}

	public Double div(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}

	public Double mean(Double numberOne, Double numberTwo) {

		return (numberOne + numberTwo) / 2;
	}

}
