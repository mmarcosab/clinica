package br.com.clinica.app.config;


import br.com.clinica.app.adapters.service.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AutenticacaoService autenticacaoService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // configs de autorização

        http.authorizeRequests()                                                        // usado para autorizar requests
                .antMatchers(HttpMethod.GET, "/medicos/*").permitAll()
                .antMatchers(HttpMethod.GET,"/pacientes/*").permitAll()
                .antMatchers(HttpMethod.POST,"/auth").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable() // essa protecao serve para quando se usa sessao, por isso esta desabilitada
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // usado para gerar token
                //.and().formLogin(); // serve para usar sessao
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // usado para arquivos estáticos
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // colocando algoritmo para gerar hash da senha
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
