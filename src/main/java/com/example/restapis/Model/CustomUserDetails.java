package com.example.restapis.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.Objects;

public final class CustomUserDetails implements UserDetails {
    @Serial
    private static final long serialVersionUID = 0L;
    private final UserData userData;

    public CustomUserDetails(UserData userData) {
        this.userData = userData;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.userData.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userData.getName();
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CustomUserDetails) obj;
        return Objects.equals(this.userData, that.userData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userData);
    }

    @Override
    public String toString() {
        return "CustomUserDetails[" +
                "userData=" + userData + ']';
    }

}
