package ups.icc.eva_developers.ModuloPerson.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonProjectsDto {
	private Long personId;
	private String personName;
	private Boolean active;
	private Boolean filterApplied;
	private Double minCost;
	private Integer projectCount;
	private List<ProjectItemDto> projects = new ArrayList<>();

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getFilterApplied() {
		return filterApplied;
	}

	public void setFilterApplied(Boolean filterApplied) {
		this.filterApplied = filterApplied;
	}

	public Double getMinCost() {
		return minCost;
	}

	public void setMinCost(Double minCost) {
		this.minCost = minCost;
	}

	public Integer getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(Integer projectCount) {
		this.projectCount = projectCount;
	}

	public List<ProjectItemDto> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectItemDto> projects) {
		this.projects = projects;
	}

	public static class ProjectItemDto {
		private Long id;
		private String name;
		private String description;
		private String technologies;
		private String status;
		private Double cost;
		private LocalDate startDate;
		private LocalDate endDate;
		private ProjectLinkDto projectLink;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTechnologies() {
			return technologies;
		}

		public void setTechnologies(String technologies) {
			this.technologies = technologies;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Double getCost() {
			return cost;
		}

		public void setCost(Double cost) {
			this.cost = cost;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		public ProjectLinkDto getProjectLink() {
			return projectLink;
		}

		public void setProjectLink(ProjectLinkDto projectLink) {
			this.projectLink = projectLink;
		}
	}

	public static class ProjectLinkDto {
		private String name;
		private String url;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
}
