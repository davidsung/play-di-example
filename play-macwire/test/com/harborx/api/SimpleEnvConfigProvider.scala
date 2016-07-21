package com.harborx.api

import com.harborx.api.modules.CoreModule
import play.api.{Configuration, Environment}

trait SimpleEnvConfigProvider {
  this: CoreModule =>

  // dependence
  override def configuration: Configuration = Configuration.load(environment)

  override def environment: Environment = Environment.simple()
}
