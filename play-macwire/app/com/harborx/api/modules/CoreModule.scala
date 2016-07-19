package com.harborx.api.modules

import play.api.{Configuration, Environment}

trait CoreModule {
  // dependence
  // AppApplicationLoader and HxAppComponents will help to load(?) it.
  def configuration: Configuration
  def environment: Environment
}
