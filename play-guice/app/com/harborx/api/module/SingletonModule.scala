package com.harborx.api.module

import com.google.inject.AbstractModule
import com.harborx.api.singleton._

class SingletonModule extends AbstractModule {
  def configure() = {
    bind(classOf[AppSingleton]).to(classOf[AppSingletonImpl]).asEagerSingleton
  }
}
