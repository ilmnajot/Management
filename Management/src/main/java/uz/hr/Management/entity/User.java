package uz.hr.Management.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import uz.hr.Management.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
@Data
public class User extends BaseEntity {
    private String name;
    private String username;
    private String password;
    private String email;
    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean confirmed = false;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String phoneNumber;
}
