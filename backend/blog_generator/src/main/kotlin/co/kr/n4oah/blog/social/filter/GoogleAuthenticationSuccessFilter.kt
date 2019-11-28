package co.kr.n4oah.blog.social.filter

import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter
import javax.servlet.FilterChain
import org.codehaus.jackson.map.ObjectMapper
import co.kr.n4oah.blog.account.model.Account
import co.kr.n4oah.blog.account.model.SocialAccount
import co.kr.n4oah.blog.social.SocialType
import java.lang.Exception
import org.springframework.context.annotation.Configuration


class GoogleAuthenticationSuccessFilter: OAuth2ClientAuthenticationProcessingFilter {
	constructor(): super("/login/google")
	
	override protected fun successfulAuthentication(request: HttpServletRequest, response: HttpServletResponse,
			chain: FilterChain, authResult: Authentication) {
        val accessToken: OAuth2AccessToken = restTemplate.getAccessToken();
		val auth: OAuth2Authentication = authResult as OAuth2Authentication;
		val details: Any = auth.getUserAuthentication().getDetails();

		@Suppress("UNCHECKED_CAST")
		val map: HashMap<String, String> = details as HashMap<String, String>;
		
		val social: SocialAccount = SocialAccount(providerId=map.get("sub")?: "", accountToken=accessToken.getValue(), socialType=SocialType.GOOGLE);
		social.expireTime = accessToken.getExpiration().getTime();
		val account: Account = Account(accountId=map.get("sub")!!, name=map.get("name")!!, social=social);
		
		request.setAttribute("AuthenticationAccount", account);
		
		super.successfulAuthentication(request, response, chain, authResult);
    }
}
