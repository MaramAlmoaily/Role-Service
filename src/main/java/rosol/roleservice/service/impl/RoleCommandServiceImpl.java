package rosol.roleservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rosol.roleservice.model.AppRole;
import rosol.roleservice.repository.RoleRepository;
import rosol.roleservice.service.RoleCommandService;

import java.util.Date;

/**
 * Service implementation for command actions coming from the Client side. This implementation follows the CQRS pattern
 */
@Service
public class RoleCommandServiceImpl implements RoleCommandService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppRole createRole(String roleName, String roleDescription) {
        AppRole appRole = new AppRole(roleName, roleDescription);
        return this.roleRepository.save(appRole);
    }

    /**
     * This function considers the active attribute to operate
     * @param roleName role name
     * @param roleDescription role description
     * @return created role with id
     */
    @Override
    public AppRole createActiveRole(String roleName, String roleDescription) {
        AppRole appRole = new AppRole(roleName, roleDescription, new Date(), new Date(),  true);
        return this.roleRepository.save(appRole);
    }

    @Override
    public ResponseEntity<AppRole> updateRole(AppRole roleToEdit, long roleId) {
        return this.roleRepository.findByIdAndActiveTrue(roleId).map(r -> {
            r.setName(roleToEdit.getName());
            r.setDescription(roleToEdit.getDescription());
            r.setModificationDate(new Date());
            return ResponseEntity.ok(this.roleRepository.save(r));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public void deleteRole(long roleId) {
        AppRole appRole = this.roleRepository.findById(roleId).orElse(null);
        if (appRole != null){
            this.roleRepository.delete(appRole);
        }
    }

    /**
     * This function considers the active attribute to operate
     * @param roleId id of the role to be modified
     * @return role with the active attribute modified
     */
    @Override
    public ResponseEntity<AppRole> deleteActiveRole(long roleId) {
        return this.roleRepository.findById(roleId).map(r -> {
            r.setActive(false);
            r.setModificationDate(new Date());
            return ResponseEntity.ok(this.roleRepository.save(r));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
