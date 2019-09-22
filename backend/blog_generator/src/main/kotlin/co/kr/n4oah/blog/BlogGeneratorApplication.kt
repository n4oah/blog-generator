package co.kr.n4oah.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class BlogGeneratorApplication

fun main(args: Array<String>) {
	runApplication<BlogGeneratorApplication>(*args)
}
