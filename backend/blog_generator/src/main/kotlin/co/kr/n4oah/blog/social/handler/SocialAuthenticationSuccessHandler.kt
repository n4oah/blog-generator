package co.kr.n4oah.blog.social.handler

import org.springframework.stereotype.Component
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import co.kr.n4oah.blog.account.model.Account
import org.springframework.beans.factory.annotation.Autowired
import co.kr.n4oah.blog.account.service.AccountService
import javax.servlet.http.Cookie
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager
import co.kr.n4oah.blog.account.enumerate.AccountRedirectType
import co.kr.n4oah.blog.utils.CookieUtils

@Component
public class SocialAuthenticationSuccessHandler: SimpleUrlAuthenticationSuccessHandler {
	val log: Logger = LogManager.getLogger(this::class.java);
	
	@Autowired
	lateinit var accountService: AccountService;
	
	constructor(): super();
	
	override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
		var cookieUtils: CookieUtils = CookieUtils(request.getCookies());
		var redirectUrl: String = cookieUtils.getCookieValue(AccountRedirectType.LOGIN_SUCCESS_URL.value)!!;
		
		val account: Account = request.getAttribute("AuthenticationAccount")!! as Account;
		
		if (accountService.isDuplicated(account) == true) {
			accountService.signin(account);
		} else {
			accountService.signup(account);
		}
		
		super.clearAuthenticationAttributes(request);
		super.getRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}
}