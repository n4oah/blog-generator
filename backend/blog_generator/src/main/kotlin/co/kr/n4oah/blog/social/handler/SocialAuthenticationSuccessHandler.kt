package co.kr.n4oah.blog.social.handler

import co.kr.n4oah.blog.account.enumerate.AccountRedirectType
import co.kr.n4oah.blog.account.model.Account
import co.kr.n4oah.blog.account.service.AccountService
import co.kr.n4oah.blog.utils.CookieUtils
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.util.UriComponentsBuilder
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
public class SocialAuthenticationSuccessHandler: SimpleUrlAuthenticationSuccessHandler {
	val log: Logger = LogManager.getLogger(this::class.java);
	
	@Autowired
	lateinit var accountService: AccountService;
	
	constructor(): super();
	
	override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
		val cookieUtils: CookieUtils = CookieUtils(request.getCookies());
		val redirectUrl: String = cookieUtils.getCookieValue(AccountRedirectType.LOGIN_SUCCESS_URL.value)!!;
		
		val account: Account = request.getAttribute("AuthenticationAccount")!! as Account;
		
		if (accountService.isDuplicated(account) == true) {
			accountService.signin(account);
		} else {
			accountService.signup(account);
		}

		val params: MultiValueMap<String, String> = LinkedMultiValueMap();
		params.add("access_token", account.social?.accountToken);

		super.clearAuthenticationAttributes(request);
		super.getRedirectStrategy().sendRedirect(request, response, determineTargetUrl(request, response, params));
	}

	protected fun determineTargetUrl(request: HttpServletRequest, response: HttpServletResponse, params: MultiValueMap<String, String>): String {
		val cookieUtils: CookieUtils = CookieUtils(request.getCookies());
		val redirectUrl: String = cookieUtils.getCookieValue(AccountRedirectType.LOGIN_SUCCESS_URL.value)!!;

		return UriComponentsBuilder.fromUriString(redirectUrl)
				.queryParams(params).build().toUriString();
	}

}