package co.kr.n4oah.blog.social.handler

import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.security.oauth2.provider.OAuth2Authentication

@Component
public class GoogleAuthenticationSuccessHandler: AuthenticationSuccessHandler {
	override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
		getGoogleUser(authentication);
//		request.setAttribute("")
	}
	
	fun getGoogleUser(authentication: Authentication) {
//      OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
//      return objectMapper.convertValue(oAuth2Authentication.getUserAuthentication().getDetails(), GoogleUser.class);
		val oAuth2Authentication: OAuth2Authentication = authentication as OAuth2Authentication;
		println(oAuth2Authentication.getUserAuthentication().getDetails());
    }
}