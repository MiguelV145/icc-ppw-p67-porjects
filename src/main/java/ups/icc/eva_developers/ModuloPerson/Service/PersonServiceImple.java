package ups.icc.eva_developers.ModuloPerson.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ups.icc.eva_developers.ModuloPerson.Entities.Person;
import ups.icc.eva_developers.ModuloPerson.dto.PersonDetailDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonProjectsDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonStatusDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonSummaryDto;
import ups.icc.eva_developers.ModuloPerson.mapper.PersonMapper;
import ups.icc.eva_developers.ModuloPerson.repository.personRepository;

@Service
public class PersonServiceImple  implements PersonService{
	private final personRepository personRepository;
	private final PersonMapper personMapper;

	public PersonServiceImple(personRepository personRepository, PersonMapper personMapper) {
		this.personRepository = personRepository;
		this.personMapper = personMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersonSummaryDto> getPersons(Boolean activeOnly) {
		List<Person> persons;
		if (Boolean.TRUE.equals(activeOnly)) {
			persons = personRepository.findByActiveOrderByIdAsc('S');
		} else {
			persons = personRepository.findAllByOrderByIdAsc();
		}
		return personMapper.toSummaryDtoList(persons);
	}

	@Override
	@Transactional
	public PersonStatusDto toggleActive(Long personId) {
		Person person = personRepository.findById(personId).orElse(null);
		if (person == null) {
			return null;
		}

		person.setActive(person.getActive() != null && person.getActive() == 'S' ? 'N' : 'S');
		Person updated = personRepository.save(person);
		return personMapper.toStatusDto(updated);
	}

	@Override
	@Transactional(readOnly = true)
	public PersonDetailDto getPersonDetail(Long personId) {
		Person person = personRepository.findWithContactLinksById(personId).orElse(null);
		if (person == null) {
			return null;
		}
		return personMapper.toDetailDto(person);
	}

	@Override
	@Transactional(readOnly = true)
	public PersonProjectsDto getPersonProjects(Long personId, Double minCost) {
		Person person = personRepository.findWithProjectsById(personId).orElse(null);
		if (person == null) {
			return null;
		}
		return personMapper.toProjectsDto(person, minCost);
	}
}
