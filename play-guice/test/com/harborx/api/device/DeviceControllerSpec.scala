package com.harborx.api.device

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
class DeviceControllerSpec extends PlaySpec with Results with MockFactory {
  "Example Page#index" should {
    "should be valid" in {
      val deviceService = stub[DeviceService]
      (deviceService.getDevice _).when(*).returns(Device(5))
      val controller: DeviceController = new DeviceController(deviceService)
      val result: Future[Result] = controller.get()(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "Device(5)"
    }
  }
}
