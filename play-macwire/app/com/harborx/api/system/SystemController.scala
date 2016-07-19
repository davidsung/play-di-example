package com.harborx.api.system

import play.api.Environment
import play.api.mvc.{Action, Controller}

class SystemController(config: SystemConfig, environment: Environment) extends Controller {

  def configExample() = Action {
    Ok(config.EXAMPLE_CONFIG)
  }

  def envExample() = Action {
    Ok(s"current mode is:${environment.mode.toString}")
  }
}
