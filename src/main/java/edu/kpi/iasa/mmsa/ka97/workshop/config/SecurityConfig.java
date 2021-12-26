package edu.kpi.iasa.mmsa.ka97.workshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
    }

    /*protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Admin").password("P4ssword000").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("Surgeon").password("P4ssword111").roles("SURGEON");
        auth.inMemoryAuthentication().withUser("DonorDoctor").password("P4ssword222").roles("DONOR");
        auth.inMemoryAuthentication().withUser("RecipientDoctor").password("P4ssword333").roles("RECIPIENT");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        /*http.authorizeRequests().antMatchers("/organs/**").authenticated().anyRequest().hasRole("ADMIN")
                .and().formLogin();*/
        http.authorizeRequests()
                .antMatchers("/secured/**").hasAnyRole("ADMIN")
                .antMatchers("/delete/**").hasAnyRole("ADMIN")
                .antMatchers("/clinic_data/add/**", "/organs/add/**", "/clinic_data/update/**", "/organs/update/**", "/clinic_data/delete/**", "/organs/delete/**").hasAnyRole("ADMIN")
                .antMatchers("/donor_recipient_pair/update/**","/patient_organ_data/update/**","/surgeon_data/update/**","/surgeon_data/add/**").hasAnyRole("ADMIN","SURGEON")
                .antMatchers("/patient_organ_data/**").hasAnyRole("ADMIN","DONOR","RECIPIENT")
                .antMatchers("/get/**", "/getById/**").hasAnyRole()
                .and().formLogin().permitAll();
        http.logout().logoutUrl("/logout");
    }

    @Bean
    public static BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }
}
