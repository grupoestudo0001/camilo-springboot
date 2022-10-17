package aprendizado.camilospringboot.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperacaoSemSuporte extends RuntimeException{
	
	public OperacaoSemSuporte(String ex) {
		super(ex);
		
	}
	private static final long serialVersionUID = 1L;

}
