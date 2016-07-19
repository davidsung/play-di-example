package com.harborx.api.device

import com.google.inject.ImplementedBy

import javax.inject._

@ImplementedBy(classOf[DeviceServiceImpl])
trait DeviceService {
  def getDevice(id: Int): Device
}

/**
 * Impl with DeviceServiceImpl is not happy
 * If we forgot to extends, can compile, but run time error!!
 */
class DeviceServiceImpl @Inject() (deviceRepo: DeviceRepository) extends DeviceService {
  /**
   * simple proxy impl for testing
   */
  def getDevice(id: Int): Device = {
    deviceRepo.getDevice(id)
  }
}
