package ups.icc.eva_developers.ModuloPerson.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ups.icc.eva_developers.ModuloPerson.Service.PersonService;
import ups.icc.eva_developers.ModuloPerson.dto.PersonDetailDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonProjectsDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonStatusDto;
import ups.icc.eva_developers.ModuloPerson.dto.PersonSummaryDto;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping
	public ResponseEntity<List<PersonSummaryDto>> getPersons(
			@RequestParam(name = "activeOnly", defaultValue = "false") Boolean activeOnly) {
		return ResponseEntity.ok(personService.getPersons(activeOnly));
	}

		@GetMapping("/{id}")
		public ResponseEntity<?> getPersonDetail(@PathVariable("id") Long id) {
			PersonDetailDto response = personService.getPersonDetail(id);
			if (response == null) {
				return ResponseEntity.status(404).body(Map.of("message", "Person not found"));
			}
			return ResponseEntity.ok(response);
		}

		@GetMapping("/{id}/projects")
		public ResponseEntity<?> getPersonProjects(
				@PathVariable("id") Long id,
				@RequestParam(name = "minCost", required = false) Double minCost) {
			PersonProjectsDto response = personService.getPersonProjects(id, minCost);
			if (response == null) {
				return ResponseEntity.status(404).body(Map.of("message", "Person not found"));
			}
			return ResponseEntity.ok(response);
		}

	@PatchMapping("/{id}/toggle-active")
	public ResponseEntity<?> toggleActive(@PathVariable("id") Long id) {
		PersonStatusDto response = personService.toggleActive(id);
		if (response == null) {
			return ResponseEntity.status(404).body(Map.of("message", "Person not found"));
		}
		return ResponseEntity.ok(response);
	}
}
