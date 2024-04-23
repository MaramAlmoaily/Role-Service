package rosol.roleservice.service;

import org.springframework.http.ResponseEntity;
import rosol.roleservice.model.AppRole;

public interface RoleCommandService {
    AppRole createRole(String roleName, String roleDescription);
    AppRole createActiveRole(String roleName, String roleDescription);
    ResponseEntity<AppRole> updateRole(AppRole roleToEdit, long roleId);
    void deleteRole(long roleId);
    ResponseEntity<AppRole> deleteActiveRole(long roleId);
}
