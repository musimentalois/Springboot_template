package rw.lois.ne.binarysupermarket.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rw.lois.ne.binarysupermarket.enums.ERole;
import rw.lois.ne.binarysupermarket.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    private UUID id;
    private String firstName;
    private String phone;
    private String email;
    private ERole role;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user) {

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new UserPrincipal(
                user.getId(),
                user.getFirstName(),
                user.getPhone(),
                user.getEmail(),
                user.getRole(),
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
