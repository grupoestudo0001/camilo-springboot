package aprendizado.camilospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aprendizado.camilospringboot.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
