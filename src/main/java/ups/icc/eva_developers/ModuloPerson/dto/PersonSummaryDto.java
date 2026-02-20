package ups.icc.eva_developers.ModuloPerson.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonSummaryDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String profession;
	private String location;
	private Boolean active;
	private List<ContactLinkSummaryDto> contactLinks = new ArrayList<>();
	private Integer projectCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<ContactLinkSummaryDto> getContactLinks() {
		return contactLinks;
	}

	public void setContactLinks(List<ContactLinkSummaryDto> contactLinks) {
		this.contactLinks = contactLinks;
	}

	public Integer getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(Integer projectCount) {
		this.projectCount = projectCount;
	}

	public static class ContactLinkSummaryDto {
		private Long id;
		private String name;
		private String url;

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

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
}
