package aprendizado.camilospringboot.controllers;

import static aprendizado.camilospringboot.estrutura.Util.isNumeric;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aprendizado.camilospringboot.estrutura.Util;
import aprendizado.camilospringboot.exceptions.OperacaoSemSuporte;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();
	Util util = new Util();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoSemSuporte("Favor informar somente números");
		}

		return util.sum(Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
	}

	@RequestMapping(value = "/less/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double less(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoSemSuporte("Favor informar somente números");
		}

		return util.less(Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
	}

	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoSemSuporte("Favor informar somente números");
		}

		return util.mult(Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoSemSuporte("Favor informar somente números");
		}
		return util.div(Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
	}

	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new OperacaoSemSuporte("Favor informar somente números");
		}

		return util.mean(Double.parseDouble(numberOne), Double.parseDouble(numberTwo));
	}

}
