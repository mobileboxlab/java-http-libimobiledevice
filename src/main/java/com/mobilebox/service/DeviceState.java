package com.mobilebox.service;

/**
 * All possible device status according to STF status.
 */
public enum DeviceState {
  ABSENT("absent"),
  PRESENT("present"),
  OFFLINE("offline"),
  UNAUTHORIZED("unauthorized"),
  PREPARING("preparing"),
  READY("ready"),
  AUTOMATION("automation"),
  USING("using"),
  BUSY("busy"),
  AVAILABLE("available");
  
  public String value;
  
  DeviceState(String value){
    this.value = value;
  }
  
  @Override
  public String toString(){
    return value;
  }
  
}
