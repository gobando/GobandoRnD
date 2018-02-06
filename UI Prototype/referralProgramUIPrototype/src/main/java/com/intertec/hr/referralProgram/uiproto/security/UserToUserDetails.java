package com.intertec.hr.referralProgram.uiproto.security;

import com.intertec.hr.referralProgram.uiproto.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerardoobando.arce on 2/21/2017.
 */
@Component
public class UserToUserDetails implements Converter<User, UserDetails> {
    @Override
    public UserDetails convert(User user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();

        if (user != null) {
            userDetails.setUsername(user.getEmail());
            userDetails.setPassword(user.getEncryptedPassword());
            //userDetails.setEnabled(user.getEnabled());
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoleList().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRoleType()));
            });
            userDetails.setAuthorities(authorities);
        }

        return userDetails;
    }
}
