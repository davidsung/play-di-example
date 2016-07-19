package com.harborx.api.system

import javax.inject._

import play.api.Environment
import play.api.mvc.{Action, Controller}

class SystemController @Inject() (config: SystemConfig, env: Environment) extends Controller {

  def configExample() = Action {
    Ok(config.EXAMPLE_CONFIG)
  }

  def envExample() = Action {
    Ok(s"current mode is:${env.mode.toString}")
  }

}
