package mp3shyn

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Temp extends Simulation {

  val httpProtocol = http
    .baseUrl("https://challenge.flood.io")
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0")

  val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

  val headers_1 = Map(
    "Origin" -> "https://challenge.flood.io",
    "Upgrade-Insecure-Requests" -> "1")

  val headers_5 = Map(
    "Accept" -> "*/*",
    "If-None-Match" -> """"6480cebb76f3f0ce4f6c8d8e6f874580"""",
    "X-Requested-With" -> "XMLHttpRequest")



  val scn = scenario("Temp")
    .exec(http("Open main page")
      .get("/")
      .check(bodyString.saveAs( "RESPONSE_DATA" ) )
      .check(css("input[name='authenticity_token']", "value").find.saveAs("token"))
      .check(css("input[name='challenger[step_id]']", "value").find.saveAs("stepId"))
      .headers(headers_0))

//    .exec(session => {
//      println("TOKEN =  ")
//      println(session("token").as[String])
//      println("Step ID = ")
//      println(session("stepId").as[String])
//      session
//    })

    //.pause(8)

    .exec(http("Start quiz")
      .post("/start")
      .headers(headers_1)
      .formParam("utf8", "✓")

      //.check(header("authenticity_token").saveAs("token")
     //.check(regex("""(?<=authenticity_token: ).*=$""").find.saveAs("token"))
      .check(bodyString.saveAs( "RESPONSE_DATA" ) )
      .check(css("input[name='challenger[step_id]']", "value").find.saveAs("stepId"))
      .formParam("authenticity_token", "${token}")
      .formParam("challenger[step_id]", "${stepId}")
      .formParam("challenger[step_number]", "1")
      .formParam("commit", "Start"))
    //.pause(12)

    .exec(session => {
      println("RESPONSE_DATA st1 = ")
      println(session("RESPONSE_DATA").as[Any])
      session
    })

    .exec(http("Step 2 -> Select years")
      .post("/start")
      .headers(headers_1)
      .check( bodyString.saveAs( "RESPONSE_DATA" ) )
      .check(css("input[name='challenger[step_id]']", "value").find.saveAs("stepId"))

      .formParam("utf8", "✓")
      .formParam("authenticity_token", "${token}")
      .formParam("challenger[step_id]", "${stepId}")
      .formParam("challenger[step_number]", "2")
      .formParam("challenger[age]", "18")
      .formParam("commit", "Next"))

    .exec(session => {
      println("RESPONSE_DATA st2 = ")
      println(session("RESPONSE_DATA").as[Any])
      session
    })
  // Step 3
    .exec(http("Step 3 -> Select the biggest value")
      .post("/start")
      .headers(headers_1)
      // "(?<=label class=\"collection_radio_buttons\".*\">).*[0-9]{2,3}         >[0-9]{2,3}<
       .check(regex("(?<=>)[0-9]{2,3}").findAll.saveAs("OrderValue"))
      .check(bodyString.saveAs( "RESPONSE_DATA" ) )
      .check(css("input[name='challenger[step_id]']", "value").find.saveAs("stepId"))
      .formParam("utf8", "✓")
      .formParam("authenticity_token", "${token}")
      .formParam("challenger[step_id]", "${stepId}")
      .formParam("challenger[step_number]", "3")
      .formParam("challenger[largest_order]", "201")
      .formParam("challenger[order_selected]", "ZnNEZEZ2VkRmQkZRc09ibHk2aG91Zz09LS1KMDhLc0ZiTVRtY21SN2VDdXVHZ1dRPT0=--04bd7c9b48bee8862ee86ea98648b1875bf7fec3")
      .formParam("commit", "Next"))

    .exec(session => {
      println("RESPONSE_DATA st2 = ")
      println(session("RESPONSE_DATA").as[Any])
      println("OrderValue")
      println(session("OrderValue").as[Any])
      session
    })

   //Step 4
    .exec(http("Step 4 Confirm Click next when you're ready.")
      .post("/start")
      .headers(headers_1)
      .check( bodyString.saveAs( "RESPONSE_DATA" ) )
      .formParam("utf8", "✓")
      //.check(jsonPath("$..authenticity_token").optional.saveAs("authenticity_token"))
      .check(css("input[name='challenger[step_id]']", "value").find.saveAs("stepId"))
      .check(css("input[name='challenger_order_2']", "value").find.saveAs("chelOrder"))
      .formParam("authenticity_token", "${token}")
      .formParam("challenger[step_id]", "${stepId}")
      .formParam("challenger[step_number]", "4")
      .formParam("challenger[order_1]", "{$chelOrder}")
      .formParam("challenger[order_2]", "{$chelOrder}")
      .formParam("challenger[order_3]", "{$chelOrder}")
      .formParam("challenger[order_6]", "{$chelOrder}")
      .formParam("challenger[order_5]", "{$chelOrder}")
      .formParam("challenger[order_4]", "{$chelOrder}")
      .formParam("challenger[order_9]", "{$chelOrder}")
      .formParam("challenger[order_7]", "{$chelOrder}")
      .formParam("challenger[order_12]", "{$chelOrder}")
      .formParam("challenger[order_8]", "{$chelOrder}")
      .formParam("challenger[order_13]", "{$chelOrder}")
      .formParam("challenger[order_10]", "{$chelOrder}")
      .formParam("challenger[order_16]", "{$chelOrder}")
      .formParam("challenger[order_11]", "{$chelOrder}")
      .formParam("commit", "Next")
      .resources(http("request_5")
        .get("/code")
        .headers(headers_5)))

    .exec(session => {
      println("RESPONSE_DATA st4 = ")
      println(session("RESPONSE_DATA").as[Any])
      session
    })

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}