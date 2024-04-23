package rosol.roleservice.controller.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rosol.roleservice.model.AppRole;
import rosol.roleservice.service.RoleQueryService;

import java.util.List;
import java.util.Optional;

/**
 * Controller class to handle all queries received from the Client side. This controller follows the CQRS pattern
 */
@Controller
public class RoleQueryController {

    @Autowired
    private RoleQueryService roleQueryService;

    @GetMapping("/role/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id){
        Optional<AppRole> role = this.roleQueryService.getRoleById(id);
        if (role == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(role);
        }
    }

    @GetMapping("/roleByName/{name}")
    public ResponseEntity<?> getRoleByName(@PathVariable String name){
        Optional<AppRole> role = this.roleQueryService.getRoleByName(name);
        if (role == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(role);
        }
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getRoles(){
        List<AppRole> roles = this.roleQueryService.getAllRoles();
        if (roles.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(roles);
        }
    }
}
