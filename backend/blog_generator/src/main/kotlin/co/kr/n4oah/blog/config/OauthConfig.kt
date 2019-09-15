package co.kr.n4oah.blog.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean
import javax.servlet.Filter
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client
import java.util.Arrays
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter
import org.springframework.web.filter.CompositeFilter
import co.kr.n4oah.blog.social.ClientResource
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter
import org.springframework.security.oauth2.client.OAuth2RestTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.oauth2.client.OAuth2ClientContext
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices
import org.springframework.boot.context.properties.EnableConfigurationProperties
import co.kr.n4oah.blog.social.handler.GoogleAuthenticationSuccessHandler

@Configuration
@EnableConfigurationProperties
@EnableOAuth2Client
class OauthConfig {
	@Autowired
	lateinit var oauth2ClientContext: OAuth2ClientContext;
	
	@Autowired
	lateinit var googleSucHander: GoogleAuthenticationSuccessHandler;
	
	@Bean
	fun ssoFilter(): Filter {
		var filter: CompositeFilter = CompositeFilter();
		var filterList = ArrayList<Filter>();
		var googleFilter: Filter = ssoFilter(google(), "/login/google");
		filterList.add(googleFilter);
		filter.setFilters(filterList);
		return filter;
	}
	
	private fun ssoFilter(client: ClientResource, path: String): Filter {
        var filter: OAuth2ClientAuthenticationProcessingFilter = OAuth2ClientAuthenticationProcessingFilter(path);
        var restTemplate: OAuth2RestTemplate = OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
        filter.setRestTemplate(restTemplate);
        var tokenServices: UserInfoTokenServices = UserInfoTokenServices(client.getResource().getUserInfoUri(), client.getClient().getClientId());
        tokenServices.setRestTemplate(restTemplate);
        filter.setTokenServices(tokenServices);
		filter.setAuthenticationSuccessHandler(googleSucHander);
        return filter;
    }
	
	@Bean
	fun oauth2ClientFilterRegistration(filter: OAuth2ClientContextFilter): FilterRegistrationBean<OAuth2ClientContextFilter> {
		var registration: FilterRegistrationBean<OAuth2ClientContextFilter> = FilterRegistrationBean();
		registration.setFilter(filter);
		registration.setOrder(-100);
		return registration;
	}
	
	@Bean
	@ConfigurationProperties(prefix="google")
	fun google(): ClientResource {
		return ClientResource();
	}
}