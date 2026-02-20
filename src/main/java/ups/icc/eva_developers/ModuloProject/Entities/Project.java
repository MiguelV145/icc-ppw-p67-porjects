package ups.icc.eva_developers.ModuloProject.Entities;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import ups.icc.eva_developers.ModuloPerson.Entities.Person;
import ups.icc.eva_developers.ModuloProjectLink.entity.ProjectLink;

@Entity
@Table(name = "projects")
public class Project {

    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String technologies;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(nullable = false)
    private Double cost;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(nullable = false, length = 1)
    private Character active = 'S';

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @OneToOne(mappedBy = "project")
    private ProjectLink projectLink;

    public Project() {
    }

    public Project(Long id, String name, String description, String technologies, String status, Double cost,
                   LocalDate startDate, LocalDate endDate, Character active, Person person) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.technologies = technologies;
        this.status = status;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.person = person;
    }

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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ProjectLink getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(ProjectLink projectLink) {
        this.projectLink = projectLink;
    }
}



