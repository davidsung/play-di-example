package com.harborx.api.singleton

import play.api.{Configuration, Logger}
import play.api.inject.ApplicationLifecycle

import scala.concurrent.Future

class AppSingleton(configuration: Configuration, applicationLifecycle: ApplicationLifecycle) {
  protected val logger = Logger(getClass)

  // shall call appSingleton.init() to perform App onStart() hook and addStopHook
  def init() = {
    logger.info("Application has started")
    applicationLifecycle.addStopHook { () =>
      Future.successful(logger.info("Application has stopped"))
    }
  }

}
