package co.kr.n4oah.blog.account.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.OneToOne
import javax.persistence.JoinColumn

@Entity
data class Account(
	@Id
	val accountId: String,
	@Column(name="email")
	val email: String? = null,
	@Column(name="name", nullable=false)
	val name: String,
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id", updatable = false, unique = true)
	val social: SocialAccount?
)