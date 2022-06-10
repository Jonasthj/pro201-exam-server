package no.kristiania.pro201examserver

import no.kristiania.pro201examserver.properties.Datasource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import java.util.*


@SpringBootApplication
@PropertySource("classpath:application.yml")
class Pro201ExamServerApplication

fun main(args: Array<String>) {

    var application = runApplication<Pro201ExamServerApplication>(*args)

    println(System.getProperties())

    val datasource = application.getBean("datasource", Datasource::class.java)
    println(datasource)

    val content = datasource.databaseUrl.replace("postgres://", "")

    val firstColon = content.indexOf(":")
    val firstAt = content.indexOf("@")
    val lastSlash = content.lastIndexOf("/")

    val username = content.substring(0, firstColon)
    val password = content.substring(firstColon + 1, firstAt)
    val url = "jdbc:postgresql://" + content.substring(firstAt + 1)

    val db = content.substring(lastSlash + 1)

    println("${username}, ${password}, ${url}, ${db}")

    application.close()

    System.setProperty("spring.datasource.url", url)
    System.setProperty("spring.datasource.username", username)
    System.setProperty("spring.datasource.password", password)
    System.setProperty("spring.sql.init.platform", db)

    application = runApplication<Pro201ExamServerApplication>(*args)

    val datasource1 = application.getBean("datasource", Datasource::class.java)
    println(datasource1)
}
