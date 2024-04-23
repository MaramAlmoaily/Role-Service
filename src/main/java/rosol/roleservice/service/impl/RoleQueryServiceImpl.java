package rosol.roleservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rosol.roleservice.model.AppRole;
import rosol.roleservice.repository.RoleRepository;
import rosol.roleservice.service.RoleQueryService;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for query actions coming from the Client side. This implementation follows the CQRS pattern
 */
@Service
public class RoleQueryServiceImpl implements RoleQueryService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<AppRole> getAllRoles() {
        return this.roleRepository.findByActiveTrue();
    }

    @Override
    public Optional<AppRole> getRoleById(Long id) {
        Optional<AppRole> role = this.roleRepository.findByIdAndActiveTrue(id);
        return (role.isPresent()) ? role : null;
    }

    @Override
    public Optional<AppRole> getRoleByName(String name) {
        Optional<AppRole> role = this.roleRepository.findByNameEqualsAndActiveTrue(name);
        return (role.isPresent()) ? role : null;
    }
}
