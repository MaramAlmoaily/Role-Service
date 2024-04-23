package rosol.roleservice.service;

import rosol.roleservice.model.AppRole;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<AppRole> getAllRoles();
    Optional<AppRole> getRoleById(Long id);
    Optional<AppRole> getRoleByName(String name);
}
