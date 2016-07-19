package com.harborx.api.device

import org.scalamock.scalatest.MockFactory
import org.scalatest.GivenWhenThen
import org.scalatestplus.play.PlaySpec

/**
  * We shall use our custom Spec instead of PlaySpec in real life
  * Test for service layer logic here, so we stub DeviceRepository
  * TODO: Test for DeviceRepository
  */
class DeviceServiceSpec extends PlaySpec with GivenWhenThen with MockFactory {

  "DeviceService" must {
    "forward what DeviceRepository give" in {
      val deviceRepo = stub[DeviceRepository]
      (deviceRepo.getDevice _).when(*).returns(Device(2))
      /**
        * any better way to not inject the params here?
        * Not a good way if we have tons of dependencies?
        */
      val deviceService: DeviceService = new DeviceServiceImpl(deviceRepo)
      deviceService.getDevice(10) mustBe Device(2)
    }
  }
}
