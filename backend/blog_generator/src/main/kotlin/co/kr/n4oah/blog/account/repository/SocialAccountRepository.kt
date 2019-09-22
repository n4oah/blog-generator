package co.kr.n4oah.blog.account.repository

import org.springframework.data.repository.CrudRepository
import co.kr.n4oah.blog.account.model.SocialAccount

interface SocialAccountRepository: CrudRepository<SocialAccount, String> {
	
}