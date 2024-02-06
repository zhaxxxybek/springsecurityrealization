package kz.myproject.techboot.springsecurity.Service;


import kz.myproject.techboot.springsecurity.model.User;
import kz.myproject.techboot.springsecurity.repository.UserRepostitory;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepostitory userRepostitory;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepostitory.findByEmail(username);
        if (user!=null){
            return user;
        }
        else {
            throw new UsernameNotFoundException("User Not Found");
        }
    }
    public User addUser(User user){
        User checkUser=userRepostitory.findByEmail(user.getEmail());
        if (checkUser==null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepostitory.save(user);
        }
        return null;
    }
    public User updatePassword(String newPassword ,String oldPassword){
        User currentUser=getCurrentSessionUser();
        if (passwordEncoder.matches(oldPassword,currentUser.getPassword())){
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            return userRepostitory.save(currentUser);

        }
        else {
            return null;
        }

    }
    public User getCurrentSessionUser(){
        Authentication authentication=
                SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User user=(User) authentication.getPrincipal();
            if (user!=null){
                return user;
            }
        }
        return null;
    }
    public List<User> getAllUsers() {
        return userRepostitory.findAll();
    }
    public User getUser(Long id){
        return userRepostitory.findById(id).orElse(null);

    }


}
