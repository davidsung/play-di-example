package com.harborx.api.modules

import com.harborx.api.device._

trait DeviceModule {
  import com.softwaremill.macwire._

  lazy val deviceController: DeviceController = wire[DeviceController]
  lazy val deviceService: DeviceService       = wire[DeviceServiceImpl]
  lazy val deviceRepository: DeviceRepository = wire[DeviceRepositoryImpl]
}
