package com.harborx.api.device

import com.harborx.api.modules.DeviceModule
import org.scalamock.scalatest.MockFactory
import org.scalatestplus.play.PlaySpec
import play.api.mvc._
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.concurrent.Future

/**
  * Test for controller logic
  * So we mock service here
  */
class DeviceControllerSpec extends PlaySpec with Results with MockFactory with DeviceModule {

  override lazy val deviceService = stub[DeviceService]

  "Device Controller" should {
    "should get something" in {
      (deviceService.getDevice _).when(*).returns(Device(5))
      val result: Future[Result] = deviceController.get()(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "Device(5)"
    }
  }
}
