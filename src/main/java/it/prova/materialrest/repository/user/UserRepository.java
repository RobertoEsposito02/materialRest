package it.prova.materialrest.repository.user;

import org.springframework.data.repository.CrudRepository;

import it.prova.materialrest.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
