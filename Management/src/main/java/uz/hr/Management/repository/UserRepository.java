package uz.hr.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.hr.Management.entity.User;
import uz.hr.Management.enums.UserRole;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByRole(UserRole role);


    Optional<User> findByEmailAndDeletedFalse(String email);
}
