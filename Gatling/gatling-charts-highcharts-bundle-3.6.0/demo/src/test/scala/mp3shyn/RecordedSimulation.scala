package mp3shyn

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RecordedSimulation extends Simulation {

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



	val scn = scenario("mp3shyn.RecordedSimulation")
		.exec(http("Open main page")
			.get("/")
			.headers(headers_0))
		//.pause(8)

		.exec(http("Start quiz")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.check()
			//.check(header("$..authenticity_token").saveAs("authenticity_token"))
			//	.check(header("$..challenger[step_id]").saveAs("stepId"))
			.formParam("authenticity_token", "${authenticity_token}")
			.formParam("challenger[step_id]", "${stepId}")
			.formParam("challenger[step_number]", "1")
			.formParam("commit", "Start"))
		//.pause(12)

		.exec(http("Step 2 -> Select years")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.check(header("$..authenticity_token").optional.saveAs("authenticity_token"))
			.check(header("$..challenger[step_id]").optional.saveAs("stepId"))
			.formParam("authenticity_token", "${authenticity_token}")
			.formParam("challenger[step_id]", "${stepId}")
			.formParam("challenger[step_number]", "2")
			.formParam("challenger[age]", "18")
			.formParam("commit", "Next"))
		//.pause(6)
		.exec(http("Step 3 -> Select the biggest value")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.check(jsonPath("$..authenticity_token").optional.saveAs("authenticity_token"))
			.check(jsonPath("$..challenger[step_id]").optional.saveAs("stepId"))
			.formParam("authenticity_token", "${authenticity_token}")
			.formParam("challenger[step_id]", "${stepId}")
			.formParam("challenger[step_number]", "3")
			.formParam("challenger[largest_order]", "201")
			.formParam("challenger[order_selected]", "ZnNEZEZ2VkRmQkZRc09ibHk2aG91Zz09LS1KMDhLc0ZiTVRtY21SN2VDdXVHZ1dRPT0=--04bd7c9b48bee8862ee86ea98648b1875bf7fec3")
			.formParam("commit", "Next"))
		//.pause(2)
		.exec(http("Step 4")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.check(jsonPath("$..authenticity_token").optional.saveAs("authenticity_token"))
			.check(jsonPath("$..challenger[step_id]").optional.saveAs("stepId"))
			.formParam("authenticity_token", "${authenticity_token}")
			.formParam("challenger[step_id]", "${stepId}")
			.formParam("challenger[step_number]", "4")
			.formParam("challenger[order_2]", "1626275041")
			.formParam("challenger[order_6]", "1626275041")
			.formParam("challenger[order_4]", "1626275041")
			.formParam("challenger[order_9]", "1626275041")
			.formParam("challenger[order_13]", "1626275041")
			.formParam("challenger[order_8]", "1626275041")
			.formParam("challenger[order_13]", "1626275041")
			.formParam("challenger[order_10]", "1626275041")
			.formParam("challenger[order_16]", "1626275041")
			.formParam("challenger[order_10]", "1626275041")
			.formParam("commit", "Next")
			.resources(http("request_5")
			.get("/code")
			.headers(headers_5)))
	//	.pause(3)
		.exec(http("Step 5 -> Enter token")
			.post("/start")
			.headers(headers_1)
			.formParam("utf8", "✓")
			.check(jsonPath("$..authenticity_token").optional.saveAs("authenticity_token"))
			.check(jsonPath("$..challenger[step_id]").optional.saveAs("stepId"))
			.formParam("authenticity_token", "${authenticity_token}")
			.formParam("challenger[step_id]", "${stepId}")
			.formParam("challenger[step_number]", "5")
			.formParam("challenger[one_time_token]", "2481481516")
			.formParam("commit", "Next"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}