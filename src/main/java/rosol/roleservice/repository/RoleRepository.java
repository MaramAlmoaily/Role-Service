package rosol.roleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rosol.roleservice.model.AppRole;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface to communicate the Service with the corresponding database using Spring Data JPA
 */
@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {
    List<AppRole> findByActiveTrue();
    Optional<AppRole> findByIdAndActiveTrue(Long id);
    Optional<AppRole> findByNameEqualsAndActiveTrue(String name);
}
