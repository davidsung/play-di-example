package com.harborx.api.device

trait DeviceRepository {
  def getDevice(id: Int): Device
}

class DeviceRepositoryImpl extends DeviceRepository {
  def getDevice(id: Int): Device = Device(id)
}
