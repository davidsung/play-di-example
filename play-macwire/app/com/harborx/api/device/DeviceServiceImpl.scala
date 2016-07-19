package com.harborx.api.device

trait DeviceService {
  def getDevice(id: Int): Device
}

class DeviceServiceImpl(deviceRepository: DeviceRepository) extends DeviceService {
  /**
   * simple proxy impl for testing
   */
  def getDevice(id: Int): Device = {
    deviceRepository.getDevice(id)
  }
}
