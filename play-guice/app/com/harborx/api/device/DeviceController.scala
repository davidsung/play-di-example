package com.harborx.api.device

import javax.inject._

import play.api.mvc.{Action, Controller}

class DeviceController @Inject() (deviceService: DeviceService) extends Controller {

  def get() = Action {
    val d = deviceService.getDevice(1)
    Ok(d.toString)
  }

}
