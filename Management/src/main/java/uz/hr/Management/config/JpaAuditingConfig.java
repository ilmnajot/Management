package uz.hr.Management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> userAuditorAware() {
        return () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            if (context != null && context.getAuthentication() != null) {
                return Optional.ofNullable(context.getAuthentication().getName());
            }
            return Optional.empty();
        };
    }

}
