package co.kr.n4oah.blog.account.service

import org.springframework.stereotype.Service
import co.kr.n4oah.blog.account.model.Account

interface AccountService {
	fun isDuplicated(account: Account): Boolean;
	fun signup(account: Account);
}