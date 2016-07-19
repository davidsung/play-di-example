package com.harborx.api.modules

import com.harborx.api.system._

trait SystemModule extends CoreModule {
  // it need to extends CoreModule to acquire the dependency on configuration and environment
  import com.softwaremill.macwire._

  lazy val systemController: SystemController = wire[SystemController]
  lazy val systemConfig: SystemConfig = wire[SystemConfig] // act as a config object, I can "inject" to anywhere I need
}
