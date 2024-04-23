package rosol.roleservice.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

/**
 * AppRole class labeled as @Entity to be managed by Spring Data JPA to persist AppRole instances
 */
@Entity
public class AppRole {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private Date creationDate;
    private Date modificationDate;
    private boolean active;

    public AppRole() {
    }

    public AppRole(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AppRole(String name, String description, boolean active) {
        this.name = name;
        this.description = description;
        this.active = active;
    }

    public AppRole(String name, String description, Date creationDate, Date modificationDate, boolean active) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setDescription(String lastname) {
        this.description = lastname;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppRole appRole = (AppRole) o;
        return id == appRole.id && active == appRole.active && Objects.equals(name, appRole.name) && Objects.equals(description, appRole.description) && Objects.equals(creationDate, appRole.creationDate) && Objects.equals(modificationDate, appRole.modificationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, creationDate, modificationDate, active);
    }

    @Override
    public String toString() {
        return "AppRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", active=" + active +
                '}';
    }
}
