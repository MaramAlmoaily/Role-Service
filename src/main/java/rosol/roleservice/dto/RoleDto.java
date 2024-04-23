package rosol.roleservice.dto;

/**
 * Data Transfer Object to perform the conversions needed between the information coming from the Client side to the Service
 */
public class RoleDto {

    private String name;
    private String description;

    public RoleDto(String name, String description) {
        this.name = name;
        this.description = description;
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

}
