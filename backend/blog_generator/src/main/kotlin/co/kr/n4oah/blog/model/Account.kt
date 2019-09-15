package co.kr.n4oah.blog.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Account(
	@Id
	var account_id: String,
	var name: String
)