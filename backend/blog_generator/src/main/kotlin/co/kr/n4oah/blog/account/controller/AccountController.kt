package co.kr.n4oah.blog.account.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMethod
import java.security.Principal
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController("/login")
public class AccountController {
	@RequestMapping(value=["/naver"], method=[RequestMethod.GET]) // , method=[RequestMethod.GET]
	public fun naverLogin(): String {
		
		return "{\"a\":\"b\"}"
	}
}