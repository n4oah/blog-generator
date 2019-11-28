package co.kr.n4oah.blog.utils

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.Cookie

class CookieUtils(val cookies: Array<Cookie>) {
	fun getCookieValue(key: String): String? {
		for (cookie in this.cookies) {
			if (cookie.getName().equals(key)) {
				return cookie.getValue();
			}
		}
		return null;
	}
}
