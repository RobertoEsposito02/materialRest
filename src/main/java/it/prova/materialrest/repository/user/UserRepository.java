package it.prova.materialrest.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.materialrest.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("from User u left join fetch u.ruolo r where u.id = :id")
	User findByIdEager(Long id);
	
	User findByUsernameAndPassword(String username, String password);
	
	Optional<User> findByUsername(String username);
}
