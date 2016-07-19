package com.harborx.api.device

import play.api.mvc.{Action, Controller}

class DeviceController(deviceService: DeviceService) extends Controller {
  def get() = Action {
    val d = deviceService.getDevice(1)
    Ok(d.toString)
  }
}
