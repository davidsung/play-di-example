package com.harborx.api

import com.harborx.api.modules._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.routing.Router
import router.Routes
import com.softwaremill.macwire._

class AppApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application = new HxAppComponents(context).application
}

class HxAppComponents(context: Context) extends BuiltInComponentsFromContext(context) with AppComponents {
  LoggerConfigurator(context.environment.classLoader).foreach {
    _.configure(context.environment)
  }
}

trait AppComponents
extends BuiltInComponents
with SystemModule
with DeviceModule {
  lazy val router: Router = {
    // add the prefix string in local scope for the Routes constructor
    val prefix: String = "/"
    wire[Routes]
  }
}