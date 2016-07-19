package com.harborx.api.device

import com.google.inject.ImplementedBy

/**
 * easy to forgot or make typo!
 */
@ImplementedBy(classOf[DeviceRepositoryImpl])
trait DeviceRepository {
  def getDevice(id: Int): Device
}

/**
 * Impl with DeviceRepositoryImpl is not happy!
 * If we forgot to extends, can compile, but run time error!!
 */
class DeviceRepositoryImpl extends DeviceRepository {
  def getDevice(id: Int) = Device(id)
}
