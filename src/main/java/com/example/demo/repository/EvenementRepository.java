package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long>  {

	// Long => type van de Id in de models
	/* kan ook CrudRepository gebruiken, dan voegt enkele extra methodes toe zoals paginatie, sortering,... (bron: HOGENT lessen)
	 * maar toch JpaRepository want die CrudRepository returneerd een Iterable en dan kan ik geen stream() gebruiken in de servicelaag*/

}
