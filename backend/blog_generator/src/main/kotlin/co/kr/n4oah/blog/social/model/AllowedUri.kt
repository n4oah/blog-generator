package co.kr.n4oah.blog.social.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column

@Entity(name = "allowed_uri")
data class AllowedUri (
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val allowed_id: Long,
	val type: AllowedUriType
)

enum class AllowedUriType(val value: String) {
	ACCOUNT("ACCOUNT");
}