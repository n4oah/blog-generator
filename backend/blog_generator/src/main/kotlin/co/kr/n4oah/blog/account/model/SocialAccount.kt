package co.kr.n4oah.blog.account.model

import co.kr.n4oah.blog.social.SocialType
import javax.persistence.Entity
import javax.persistence.Id
import javax.annotation.Generated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column

@Entity(name = "social_account")
data class SocialAccount (
	@Id
	@Column(name = "provider_id")
	val providerId: String,
	@Column(name = "account_token", nullable=false)
	val accountToken: String,
	@Column(name = "social_type", nullable=false)
	val socialType: SocialType,
	@Column(name = "expire_time")
	var expireTime: Long? = null
)