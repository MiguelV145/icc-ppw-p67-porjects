package ups.icc.eva_developers.ModuloPerson.mapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ups.icc.eva_developers.ModuloContactLink.Entities.ContactLink;
import ups.icc.eva_developers.ModuloPerson.Entities.Person;
import ups.icc.eva_developers.ModuloPerson.dto.PersonDetailDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonProjectsDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonStatusDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonSummaryDto;
import ups.icc.eva_developers.ModuloProject.Entities.Project;
import ups.icc.eva_developers.ModuloProjectLink.entity.ProjectLink;

@Component
public class PersonMapper {

	public PersonSummaryDto toSummaryDto(Person person) {
		if (person == null) {
			return null;
		}

		PersonSummaryDto dto = new PersonSummaryDto();
		dto.setId(person.getId());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setProfession(person.getProfession());
		dto.setLocation(person.getLocation());
		dto.setActive(person.getActive() != null && person.getActive() == 'S');

		List<PersonSummaryDto.ContactLinkSummaryDto> contactLinkDtos = person.getContactLinks().stream()
				.sorted(Comparator.comparing(ContactLink::getId))
				.map(link -> {
					PersonSummaryDto.ContactLinkSummaryDto linkDto = new PersonSummaryDto.ContactLinkSummaryDto();
					linkDto.setId(link.getId());
					linkDto.setName(link.getName());
					linkDto.setUrl(link.getUrl());
					return linkDto;
				})
				.collect(Collectors.toList());
		dto.setContactLinks(contactLinkDtos);

		int activeProjectCount = (int) person.getProjects().stream()
				.filter(project -> project.getActive() != null && project.getActive() == 'S')
				.count();
		dto.setProjectCount(activeProjectCount);
		return dto;
	}

	public List<PersonSummaryDto> toSummaryDtoList(List<Person> persons) {
		if (persons == null) {
			return new ArrayList<>();
		}

		return persons.stream()
				.map(this::toSummaryDto)
				.collect(Collectors.toList());
	}

	public PersonDetailDto toDetailDto(Person person) {
		if (person == null) {
			return null;
		}

		PersonDetailDto dto = new PersonDetailDto();
		dto.setId(person.getId());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setEmail(person.getEmail());
		dto.setBio(person.getBio());
		dto.setProfession(person.getProfession());
		dto.setLocation(person.getLocation());
		dto.setActive(person.getActive() != null && person.getActive() == 'S');

		List<PersonDetailDto.ContactLinkDto> links = person.getContactLinks().stream()
				.sorted(Comparator.comparing(ContactLink::getId))
				.map(link -> {
					PersonDetailDto.ContactLinkDto linkDto = new PersonDetailDto.ContactLinkDto();
					linkDto.setId(link.getId());
					linkDto.setName(link.getName());
					linkDto.setUrl(link.getUrl());
					return linkDto;
				})
				.collect(Collectors.toList());
		dto.setContactLinks(links);

		int activeProjectCount = (int) person.getProjects().stream()
				.filter(project -> project.getActive() != null && project.getActive() == 'S')
				.count();
		dto.setProjectCount(activeProjectCount);

		return dto;
	}

	public PersonProjectsDto toProjectsDto(Person person, Double minCost) {
		PersonProjectsDto dto = new PersonProjectsDto();
		dto.setPersonId(person.getId());
		dto.setPersonName(person.getFirstName() + " " + person.getLastName());
		dto.setActive(person.getActive() != null && person.getActive() == 'S');
		dto.setFilterApplied(minCost != null);
		dto.setMinCost(minCost);

		List<Project> filteredProjects = person.getProjects().stream()
				.filter(project -> project.getActive() != null && project.getActive() == 'S')
				.filter(project -> minCost == null || project.getCost() >= minCost)
				.sorted(Comparator.comparing(Project::getCost).reversed())
				.collect(Collectors.toList());

		List<PersonProjectsDto.ProjectItemDto> projectItems = filteredProjects.stream()
				.map(project -> {
					PersonProjectsDto.ProjectItemDto item = new PersonProjectsDto.ProjectItemDto();
					item.setId(project.getId());
					item.setName(project.getName());
					item.setDescription(project.getDescription());
					item.setTechnologies(project.getTechnologies());
					item.setStatus(project.getStatus());
					item.setCost(project.getCost());
					item.setStartDate(project.getStartDate());
					item.setEndDate(project.getEndDate());

					ProjectLink projectLink = project.getProjectLink();
					if (projectLink != null) {
						PersonProjectsDto.ProjectLinkDto linkDto = new PersonProjectsDto.ProjectLinkDto();
						linkDto.setName(projectLink.getName());
						linkDto.setUrl(projectLink.getUrl());
						item.setProjectLink(linkDto);
					}
					return item;
				})
				.collect(Collectors.toList());

		dto.setProjects(projectItems);
		dto.setProjectCount(projectItems.size());
		return dto;
	}

	public PersonStatusDto toStatusDto(Person person) {
		PersonStatusDto dto = new PersonStatusDto();
		dto.setId(person.getId());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setActive(person.getActive() != null && person.getActive() == 'S');
		dto.setMessage(person.getActive() == 'S' ? "Person activated successfully" : "Person deactivated successfully");
		return dto;
	}
}
