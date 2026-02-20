package ups.icc.eva_developers.ModuloPerson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ups.icc.eva_developers.ModuloPerson.Entities.Person;

@Repository
public interface personRepository extends JpaRepository<Person, Long>{
    
}
