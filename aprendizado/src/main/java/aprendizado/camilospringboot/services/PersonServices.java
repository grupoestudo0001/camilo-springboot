package aprendizado.camilospringboot.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aprendizado.camilospringboot.data.vo.v1.PersonVO;
import aprendizado.camilospringboot.data.vo.v2.PersonVOV2;
import aprendizado.camilospringboot.exceptions.ResourceNotFoundException;
import aprendizado.camilospringboot.mapper.DozerMapper;
import aprendizado.camilospringboot.mapper.custom.PersonMapper;
import aprendizado.camilospringboot.model.Person;
import aprendizado.camilospringboot.repository.PersonRepository;

@Service
public class PersonServices {

	// private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;


	public List<PersonVO> findAll() {

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findByID(Long id) {

		logger.info("Procurando a pessoa id = " + id);
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Esse ID não existe"));

		return DozerMapper.parseObject(entity, PersonVO.class);
	}

	public PersonVO create(PersonVO person) {

		logger.info("Criando pessoa");
		var entity = DozerMapper.parseObject(person, Person.class);
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

		return vo;

	}
	public PersonVOV2 createV2(PersonVOV2 person) {

		logger.info("Criando pessoa V2");
		var entity = mapper.convertVOToEntity(person);
		var vo = mapper.convertEntityToVO(repository.save(entity));

		return vo;

	}

	public PersonVO update(PersonVO person) {

		logger.info("Alterando pessoa");

		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Esse ID não existe"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

		return vo;

	}

	public void delete(Long id) {

		logger.info("Deletando pessoa");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Esse ID não existe"));

		repository.delete(entity);
	}

}
