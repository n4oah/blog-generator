package co.kr.n4oah.blog.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class WebMvcConfig : WebMvcConfigurer {
	companion object {
		private val MAX_AGE_SECS: Long = 3600;
	}
	
	override fun addCorsMappings(registry: CorsRegistry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
			.allowedHeaders("*")
			.allowCredentials(true)
			.maxAge(WebMvcConfig.MAX_AGE_SECS);
    }
}