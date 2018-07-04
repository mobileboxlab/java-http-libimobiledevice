package com.mobilebox.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("file:ios-service.config")
public interface Configuration extends Config {

  @Key("service.port")
  @DefaultValue("5005")
  int serverPort();

  @Key("libimobiledevice.path")
  @DefaultValue("/usr/local/bin/")
  String libiPath();

  @Key("libimobiledevice.timeout")
  @DefaultValue("20000")
  int timeout();

}
