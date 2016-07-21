package com.harborx.api.system

import com.harborx.api.SimpleEnvConfigProvider
import com.harborx.api.modules.SystemModule
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
class SystemControllerSpec extends PlaySpec with Results with MockFactory with SystemModule with SimpleEnvConfigProvider {

  "System Controller" should {
    "return correct Mode" in {
      val result: Future[Result] = systemController.envExample()(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "current mode is:Test"
    }

    "return correct config" in {
      val result: Future[Result] = systemController.configExample()(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText mustBe "If you can see this, it means DI of Configuration is success!"
    }
  }

}
