package ups.icc.eva_developers.ModuloContactLink.Entities;

import org.springframework.aot.generate.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import ups.icc.eva_developers.ModuloPerson.Entities.Person;

@Entity
@Table(name="contact_links")
public class ContactLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 255)
    private String url;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public ContactLink() {
    }

    public ContactLink(Long id, String name, String url, Person person) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}


    

