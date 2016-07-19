package com.harborx.api.system

import play.api.Configuration

/**
  * an example config object
  */
class SystemConfig(configuration: Configuration) {
  val EXAMPLE_CONFIG = configuration.getString("harborx.api.example").getOrElse("config DI fail!?")
}
