package co.kr.n4oah.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogGeneratorApplication

fun main(args: Array<String>) {
	runApplication<BlogGeneratorApplication>(*args)
}
