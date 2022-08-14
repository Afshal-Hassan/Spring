package com.example.restapis.config;

import com.example.restapis.Controllers.LoginAuthController;
import com.example.restapis.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginAuthController loginAuthController;
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    public void addResourceHandlers(
            ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**")
                .addResourceLocations("D:/RestApis/src/main/resources/static/static");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("D:/RestApis/src/main/resources/static");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("D:/RestApis/src/main/resources/static");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("D:/RestApis/src/main/resources/static");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("D:/RestApis/src/main/resources/static/index.html");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
               // .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
              //  .and()
                .cors()
                .and()
                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/signup/**","/token","/loginData/**","/resources/**","/static/**","/favicon.ico","/**","/dosignin").permitAll()
                .anyRequest()
                .authenticated().and().exceptionHandling().authenticationEntryPoint(loginAuthController)
                .and()
                .formLogin().usernameParameter("email").loginProcessingUrl("/login");

    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**").allowedOrigins("https://react-app-first-version.herokuapp.com").allowedMethods("GET","POST","DELETE","PUT").allowCredentials(true);
            }
       };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
   }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(Integer.parseInt("10"));}
}
