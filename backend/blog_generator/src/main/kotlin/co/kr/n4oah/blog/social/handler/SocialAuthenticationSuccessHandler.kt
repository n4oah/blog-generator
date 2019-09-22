package co.kr.n4oah.blog.social.handler

import org.springframework.stereotype.Component
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import co.kr.n4oah.blog.account.model.Account
import org.springframework.beans.factory.annotation.Autowired
import co.kr.n4oah.blog.account.service.AccountService

@Component
public class SocialAuthenticationSuccessHandler: SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	lateinit var accountService: AccountService;
	
	constructor(): super();
	
	override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {
		val account: Account = request.getAttribute("AuthenticationAccount")!! as Account;
		
		if (accountService.isDuplicated(account) == true) {
			
		} else {
			accountService.signup(account);
		}
		
		super.clearAuthenticationAttributes(request);
	}
}