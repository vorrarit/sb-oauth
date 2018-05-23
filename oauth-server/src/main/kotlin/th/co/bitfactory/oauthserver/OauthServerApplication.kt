package th.co.bitfactory.oauthserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@SpringBootApplication
@EnableResourceServer
class OauthServerApplication

fun main(args: Array<String>) {
    runApplication<OauthServerApplication>(*args)
}
