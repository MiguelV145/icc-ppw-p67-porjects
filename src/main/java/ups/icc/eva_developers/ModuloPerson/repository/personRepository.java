package ups.icc.eva_developers.ModuloPerson.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ups.icc.eva_developers.ModuloPerson.Entities.Person;

@Repository
public interface personRepository extends JpaRepository<Person, Long>{
	@EntityGraph(attributePaths = { "contactLinks" })
	List<Person> findAllByOrderByIdAsc();

	@EntityGraph(attributePaths = { "contactLinks" })
	List<Person> findByActiveOrderByIdAsc(Character active);

	@EntityGraph(attributePaths = { "contactLinks" })
	Optional<Person> findWithContactLinksById(Long id);

	@EntityGraph(attributePaths = { "projects", "projects.projectLink" })
	Optional<Person> findWithProjectsById(Long id);
}
