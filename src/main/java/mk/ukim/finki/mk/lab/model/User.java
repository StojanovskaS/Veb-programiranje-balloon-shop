package mk.ukim.finki.mk.lab.model;

import lombok.Data;
import lombok.NonNull;
import mk.ukim.finki.mk.lab.model.enumerations.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "ballon_users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy ="user",fetch = FetchType.EAGER )
    private List<ShoppingCart> carts;

    @Enumerated(value = EnumType.STRING)
    private Role role;


    public User(){}
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
//        this.id=(long)(Math.random()*1000);
    }
    public User(String name) {
        this.name = name;
        this.email = null;
        this.password = null;
//        this.id=(long)(Math.random()*1000);
    }
    public User(String name,String password) {
        this.name = name;
        this.email = null;
        this.password = password;
        this.role=Role.ROLE_USER;
//        this.id=(long)(Math.random()*1000);
    }


    public User(String name, String password,String email, Role role) {
        this.name = name;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
