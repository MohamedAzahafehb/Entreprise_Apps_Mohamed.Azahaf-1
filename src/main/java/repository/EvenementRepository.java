package repository;

import org.springframework.data.repository.CrudRepository;

import model.Evenement;

public interface EvenementRepository extends CrudRepository<Evenement, Long>  {

	/* kan ook JpaRepository gebruiken, deze interface extends de CrudRepository en voegt enkele extra methodes roe zoals paginatie, sortering,...*/

}
