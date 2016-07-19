package com.harborx.api.system

import com.harborx.api.{HxAppComponents, OneAppPerTestWithComponents}
import org.scalamock.scalatest.MockFactory
import org.scalatest._
import org.scalatestplus.play.{PlaySpec, _}
import play.api.ApplicationLoader.Context
import play.api.mvc._
import play.api.test.FakeRequest
import play.api.test.Helpers._

import scala.concurrent.Future

class SystemSpec extends PlaySpec with OneAppPerTestWithComponents[HxAppComponents] with MustMatchers with MockFactory  {

  override def createComponents(context: Context) = new HxAppComponents(context)

  "System controller" must {
    "return OK when call GET /example" in {
      val request = FakeRequest(GET, "/example")

      val response = route(app, request)
      response.isDefined mustEqual true

      val result: Future[Result] = response.get
      status(result) mustEqual OK
      contentAsString(result) mustEqual "If you can see this, it means DI of Configuration is success!"
    }

    "return Test when call GET /env" in {
      val request = FakeRequest(GET, "/env")

      val response = route(app, request)
      response.isDefined mustEqual true

      val result: Future[Result] = response.get
      status(result) mustEqual OK
      contentAsString(result) mustEqual "current mode is:Test"
    }
  }
}
