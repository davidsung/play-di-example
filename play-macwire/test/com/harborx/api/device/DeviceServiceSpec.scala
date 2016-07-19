package com.harborx.api.device

import com.harborx.api.modules.DeviceModule
import org.scalamock.scalatest.MockFactory
import org.scalatest.GivenWhenThen
import org.scalatestplus.play.PlaySpec

/**
  * We shall use our custom Spec instead of PlaySpec in real life
  * Test for service layer logic here, so we stub DeviceRepository
  * TODO: Test for DeviceRepository
  */
class DeviceServiceSpec extends PlaySpec with GivenWhenThen with MockFactory with DeviceModule {
  
  override lazy val deviceRepository = stub[DeviceRepository]

  "DeviceService" must {
    "forward what DeviceRepository give" in {
      (deviceRepository.getDevice _).when(*).returns(Device(2))
      deviceService.getDevice(10) mustBe Device(2)
    }
  }
}
