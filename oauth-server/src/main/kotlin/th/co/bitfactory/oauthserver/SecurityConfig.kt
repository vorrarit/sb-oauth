package th.co.bitfactory.oauthserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    override fun configure(http: HttpSecurity?) {
        http!!.requestMatchers()
                .antMatchers("/login", "/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.parentAuthenticationManager(authenticationManager)
                .inMemoryAuthentication()
                .withUser("john").password("123").roles("USER")
    }
}