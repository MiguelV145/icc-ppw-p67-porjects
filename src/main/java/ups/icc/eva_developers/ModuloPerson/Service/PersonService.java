package ups.icc.eva_developers.ModuloPerson.Service;

import java.util.List;

import ups.icc.eva_developers.ModuloPerson.dto.PersonDetailDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonProjectsDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonStatusDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonSummaryDto;

public interface PersonService {
	List<PersonSummaryDto> getPersons(Boolean activeOnly);

	PersonStatusDto toggleActive(Long personId);

	PersonDetailDto getPersonDetail(Long personId);

	PersonProjectsDto getPersonProjects(Long personId, Double minCost);
}
