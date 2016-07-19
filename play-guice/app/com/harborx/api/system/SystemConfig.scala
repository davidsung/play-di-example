package com.harborx.api.system

import javax.inject.Inject

import play.api.Configuration

/**
  * An example config object. I can "inject" to anywhere I need
  */
class SystemConfig  @Inject() (config: Configuration) {
  val EXAMPLE_CONFIG = config.getString("harborx.api.example").getOrElse("config DI fail!?")
}