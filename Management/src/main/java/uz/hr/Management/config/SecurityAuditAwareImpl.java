package uz.hr.Management.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.hr.Management.entity.User;

import java.util.Optional;

public class SecurityAuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser")) {
             User user = (User)authentication.getPrincipal();
            return Optional.of(user.getUsername());
        }
        return Optional.empty();
    }
}
