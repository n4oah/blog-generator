package co.kr.n4oah.blog.account.repository

import co.kr.n4oah.blog.account.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

public interface AccountRepository: CrudRepository<Account, String> {
	
}