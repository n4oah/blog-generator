package co.kr.n4oah.blog.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import co.kr.n4oah.blog.social.SocialType
import org.springframework.context.annotation.Bean
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.Filter

@Configuration
@EnableWebSecurity
public class SecurityConfig(@Autowired private val ssoFilter: Filter) : WebSecurityConfigurerAdapter() {
	override fun configure(http: HttpSecurity) {
		http.antMatcher("/**")
			.authorizeRequests()
			.antMatchers("/login/**").permitAll()// 인증 권한이 필요없다
//			.antMatchers("/login/**").hasAnyRole("ADMIN", "USER")
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.anyRequest() // 그 외 요청은
				.authenticated() // 인증권한이 필요함
			.and()
			.exceptionHandling()
			.and()
			.addFilterBefore(ssoFilter, BasicAuthenticationFilter::class.java);
	}
}