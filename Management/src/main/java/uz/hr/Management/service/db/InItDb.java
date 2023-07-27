package uz.hr.Management.service.db;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.hr.Management.entity.User;
import uz.hr.Management.enums.UserRole;
import uz.hr.Management.repository.UserRepository;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class InItDb {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void inItDeveloper(){
        if (!userRepository.existsByRole(UserRole.DEVELOPER)) {
            userRepository.save(User.builder()
                            .name("Elbekjon aka")
                            .username("bekaka")
                            .password(passwordEncoder.encode("123"))
                            .email("ilmnajot@gmail.com")
                            .confirmed(true)
                            .role(UserRole.DEVELOPER)
                            .phoneNumber("+998912223344")
                    .build());
        }
    }
}
