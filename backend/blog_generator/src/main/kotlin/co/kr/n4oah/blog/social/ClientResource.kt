package co.kr.n4oah.blog.social

import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties

public class ClientResource {
	@NestedConfigurationProperty
	private var client: AuthorizationCodeResourceDetails = AuthorizationCodeResourceDetails();
	
	@NestedConfigurationProperty
	private var resource: ResourceServerProperties = ResourceServerProperties();
	
	
	public fun getClient(): AuthorizationCodeResourceDetails {
		return this.client;
	}
	
	public fun getResource(): ResourceServerProperties {
		return this.resource;
	}
}
