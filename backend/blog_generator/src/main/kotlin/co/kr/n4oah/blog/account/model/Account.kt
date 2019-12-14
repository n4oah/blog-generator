package co.kr.n4oah.blog.account.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.OneToOne
import javax.persistence.JoinColumn
import javax.persistence.CascadeType

@Entity(name="account")
data class Account(
	@Id
	val accountId: String,
	val email: String? = null,
	@Column(nullable=false)
	val name: String,
	@OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id", updatable = false, unique = true)
	val social: SocialAccount?
)