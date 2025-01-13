package gr.hua.lab.syst.totallab.config;


import gr.hua.lab.syst.totallab.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private UserService userService;

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig(UserService userService, UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/register", "/saveUser", "/images/**", "/js/**", "/css/**").permitAll()
                        .requestMatchers("/lawyer/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/case", true)
                        .permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

}
