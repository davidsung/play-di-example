package com.harborx.api.device

import com.harborx.api.{HxAppComponents, OneAppPerTestWithComponents}
import org.scalamock.scalatest.MockFactory
import org.scalatest._
import org.scalatestplus.play.PlaySpec
import play.api.ApplicationLoader.Context
import play.api.mvc._
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.concurrent.Future

class DeviceSpec extends PlaySpec with OneAppPerTestWithComponents[HxAppComponents] with MustMatchers with MockFactory {

  lazy val stubDevice = stub[DeviceService]
  (stubDevice.getDevice _).when(*).returns(Device(5))

  override def createComponents(context: Context) = new HxAppComponents(context) {
    override lazy val deviceService = stubDevice
  }

  "Device controller" must {
    "return OK when call GET /device" in {
      val request = FakeRequest(GET, "/device")

      val response = route(app, request)
      response.isDefined mustEqual true

      val result: Future[Result] = response.get
      status(result) mustEqual OK
      contentAsString(result) mustEqual "Device(5)"
    }
  }
}
