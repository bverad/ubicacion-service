package cl.devetel.test.ubicacionservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.devetel.test.ubicacionservice.domain.Ciudad;


@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer>  {
		
}
