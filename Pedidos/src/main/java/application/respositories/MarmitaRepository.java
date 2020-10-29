package application.respositories;

import org.springframework.data.repository.CrudRepository;
import application.models.Marmita;

public interface MarmitaRepository extends CrudRepository<Marmita, Integer>  {
    
}