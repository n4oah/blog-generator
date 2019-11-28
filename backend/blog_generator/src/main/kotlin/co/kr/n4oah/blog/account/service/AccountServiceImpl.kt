package co.kr.n4oah.blog.account.service

import co.kr.n4oah.blog.account.model.Account
import org.springframework.beans.factory.annotation.Autowired
import co.kr.n4oah.blog.account.repository.AccountRepository
import co.kr.n4oah.blog.account.repository.SocialAccountRepository
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl (
	@Autowired val accountRepository: AccountRepository,
	@Autowired val socialRepository: SocialAccountRepository
	): AccountService {

	override fun isDuplicated(account: Account): Boolean {
		return accountRepository.existsById(account.accountId);
	}
	
	override fun signup(account: Account) {
		if (account.social != null) {
			socialRepository.save(account.social);
		}
		accountRepository.save(account);
	}
	
	override fun signin(account: Account): Account {
		
		
		TODO()
	}
}