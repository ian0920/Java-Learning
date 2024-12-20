package com.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;


    //BCrypt加密方式
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        //傳入userDetailService物件：帳號、密碼、role等等
        authProvider.setUserDetailsService(userDetailsService);

        //設定加密的方法
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //disable csrf
        http.csrf(customizer -> customizer.disable());

        //針對每個request都要有驗證
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        //啟用登入表單
//        http.formLogin(Customizer.withDefaults());

        //Http彈窗登入
        http.httpBasic(Customizer.withDefaults());

        //改為無狀態登入 session id 會隨著每次請求而不同
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();
    }


    /*

    //HardCoding user in the system
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.withDefaultPasswordEncoder().username("ian").password("321").roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder().username("hsu").password("123").roles("ADMIN").build();


        return new InMemoryUserDetailsManager(user, admin);

    }

    */
}
