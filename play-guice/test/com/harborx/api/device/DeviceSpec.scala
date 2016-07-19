package com.harborx.api.device

import org.scalatest._
import org.scalatestplus.play.{PlaySpec, _}
import play.api.inject.bind
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc._
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.concurrent.Future

/**
  * Guice way to mock and do integration test
  */
class DeviceSpec extends PlaySpec with OneServerPerSuite with MustMatchers with BeforeAndAfterAll {
  override lazy val app = new GuiceApplicationBuilder()
    .overrides(bind[DeviceRepository].to[MockDeviceRepository])
    .build

  "Device controller" must {
    "return OK when call GET /device" in {
      val request = FakeRequest(GET, "/device")

      val response = route(app, request)
      response.isDefined mustEqual true

      val result: Future[Result] = response.get
      status(result) mustEqual OK
      contentAsString(result) mustEqual "Device(3)"
    }
  }
}

class MockDeviceRepository extends DeviceRepositoryImpl {
  override def getDevice(id: Int) = {
    Device(3)
  }
}
