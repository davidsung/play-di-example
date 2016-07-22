package com.harborx.api.modules

import com.harborx.api.singleton.AppSingleton
import play.api.inject.ApplicationLifecycle

trait AppSingletonModule extends CoreModule {
  import com.softwaremill.macwire._

  lazy val appSingleton: AppSingleton = wire[AppSingleton]
  def applicationLifecycle: ApplicationLifecycle

}
