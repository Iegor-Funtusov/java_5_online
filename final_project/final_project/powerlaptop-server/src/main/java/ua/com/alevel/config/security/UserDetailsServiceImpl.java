package ua.com.alevel.config.security;

import org.apache.commons.lang3.StringUtils;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.com.alevel.persistence.sql.entity.user.User;
import ua.com.alevel.persistence.sql.repository.user.UserRepository;

import java.util.Optional;

@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository<User> userRepository;
    private final AccountStatusUserDetailsChecker detailsChecker =
            new AccountStatusUserDetailsChecker();

    public UserDetailsServiceImpl(UserRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = getUserByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        detailsChecker.check(user.get());
        return user.get();
    }

    private Optional<User> getUserByUsername(String usernameValue) {
        String username = StringUtils.trimToNull(usernameValue);
        if (StringUtils.isBlank(username)) {
            return Optional.empty();
        }
        return userRepository.findActiveByUsername(username);
    }
}
