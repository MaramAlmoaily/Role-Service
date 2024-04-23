package rosol.roleservice.controller.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rosol.roleservice.dto.RoleDto;
import rosol.roleservice.model.AppRole;
import rosol.roleservice.service.RoleCommandService;

/**
 * Controller class to handle all commands received from the Client side. This controller follows the CQRS pattern
 */
@Controller
public class RoleCommandController {

    @Autowired
    private RoleCommandService roleCommandService;

    @PostMapping("/new")
    public ResponseEntity<AppRole> createNewRole(@RequestBody RoleDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roleCommandService.createRole(dto.getName(), dto.getDescription()));
    }

    /**
     * This function considers the active attribute to operate
     * @param dto role object to be saved
     * @return role with an id assigned by the system
     */
    @PostMapping("/newactive")
    public ResponseEntity<AppRole> createNewActiveRole(@RequestBody RoleDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roleCommandService.createActiveRole(dto.getName(), dto.getDescription()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AppRole> updateRole(@RequestBody AppRole roleToEdit, @PathVariable Long id){
        return this.roleCommandService.updateRole(roleToEdit, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id){
        this.roleCommandService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * This function considers the active attribute to operate
     * @param id id of the role to be deleted
     * @return role with the active attribute set to false
     */
    @PutMapping("/deleteactive/{id}")
    public ResponseEntity<AppRole> deleteActiveRole(@PathVariable Long id){
        return this.roleCommandService.deleteActiveRole(id);
    }
}
