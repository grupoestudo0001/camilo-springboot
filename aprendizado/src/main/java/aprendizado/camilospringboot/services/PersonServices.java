package aprendizado.camilospringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import aprendizado.camilospringboot.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll(){
		
		logger.info("Procurando tudo");
		List<Person> persons = new ArrayList<>();
		for (int i=0;i<8;i++) {
		Person person = mockPerson(i);
		persons.add(person);
		}
		return persons;
	}

public Person create(Person person) {
		
		logger.info("Criando pessoa");
		
		return person;
	
}

public Person update(Person person) {
	
	logger.info("Alterando pessoa");
	
	return person;

}

public void delete(String id) {
	
	logger.info("Deletando pessoa");
	

}
	public Person findByID(String id) {
		
		logger.info("Procurando a pessoa id = "+id);
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Fulano");
		person.setLastName("De Tal");
		person.setAddress("Rua ABCD");
		person.setGender("M");
		return person;
	}
	private Person mockPerson(int i) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Fulano "+i);
		person.setLastName("De Tal "+i);
		person.setAddress("Rua ABCD ");
		person.setGender("M");
		return person;
	}
}
