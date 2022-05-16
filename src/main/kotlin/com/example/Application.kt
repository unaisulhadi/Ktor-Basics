package com.example

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.*


/*
* to enable auto reload for every change
* use command ./gradlew -t build
* along with running server instance.
*
* */

/*
 Engine Main  - required application.conf
*/

fun main(args : Array<String>) : Unit = io.ktor.server.netty.EngineMain.main(args)


/*
*
* Embedded Server - no need for application.conf file
*
* */
//fun main() {
//    embeddedServer(Netty, port = 8080 ,watchPaths = listOf("classes","resources")) {
//        module()
//    }.start(wait = true)
//}

fun Application.module() {
    install(CallLogging)
    routing {
        static {
            /**
             * To use files directly from resources directly
             */
            //resource("facebook.html")
            //resource("brba.png")


            /**
             * If you need to access to the whole folder,
             * add resources("folder_name")
             */

            resources("static")

            /**
             * If you need to access to the whole folder, but not with folder name
             * add a remote path to static block like  static(remotePath = "something_here")
             *
             * eg: if static(remotePath = "assets") then API will be,
             * http://localhost:8080/assets/brba2.png
             */
        }
        get("/") {
            call.respondText("Hello World!!")
        }

        get("/welcome") {
            val name = call.request.queryParameters["name"]
            call.respondHtml {
                head {
                    title {
                        +"Custom Title"
                    }
                }
                body {
                    if (name.isNullOrEmpty()) {
                        h3 {
                            +"Welcome!"
                        }
                    }else{
                        h3 {
                            +"Welcome, $name!"
                        }
                    }
                    p {
                        +"Current directory = ${System.getProperty("user.dir")}"
                    }
                    img(src = "brba2.png")
                }
            }
        }
//        get("/get_started"){
//            call.respondText("Get Started")
//        }
    }
}