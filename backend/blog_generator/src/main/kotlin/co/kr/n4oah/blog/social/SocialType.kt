package co.kr.n4oah.blog.social

public enum class SocialType(val type: String) {
	GOOGLE("GOOGLE"),
	NAVER("NAVER");
	
	companion object {
		const val ROLE = "ROLE_";
	}
	
	fun getRoleType(): String {
		return SocialType.ROLE + this.type.toUpperCase();
	}
}
