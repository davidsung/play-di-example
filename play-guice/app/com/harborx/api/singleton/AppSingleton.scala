package com.harborx.api.singleton

import javax.inject._

import com.google.inject.ImplementedBy
import play.api.Logger
import play.api.inject.ApplicationLifecycle

import scala.concurrent.Future

@ImplementedBy(classOf[AppSingletonImpl])
trait AppSingleton {

}

@Singleton
class AppSingletonImpl @Inject() (lifecycle: ApplicationLifecycle) extends AppSingleton {
  protected val logger = Logger(getClass)
  logger.info("Application has started")
  lifecycle.addStopHook { () =>
    Future.successful(logger.info("Application has stopped"))
  }
}
