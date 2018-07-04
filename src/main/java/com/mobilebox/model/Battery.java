package com.mobilebox.model;

import com.dd.plist.NSDictionary;
import com.google.gson.annotations.SerializedName;

public class Battery extends Model<Battery> {

  @SerializedName("currentCapacity")
  int currentCapacity;

  @SerializedName("isCharging")
  boolean isCharging;

  @SerializedName("externalChargeCapable")
  boolean externalChargeCapable;

  @SerializedName("externalConnected")
  boolean externalConnected;

  @SerializedName("fullyCharged")
  boolean fullyCharged;

  @SerializedName("gasGaugeCapability")
  boolean gasGaugeCapability;

  /**
   * TODO: Hard-code properties values. We need to figure out how to get this information from
   * libimobiledevice.
   **/
  @SerializedName("health")
  String health = "good";
  
  @SerializedName("temp")
  double temp = 0;
  
  public Battery() {}

  @Override
  public Battery me() {
    return me();
  }

  /**
   * Create a new Battery given a NSDictionary with Battery information.
   * 
   * @param d A NSDictionary instance.
   */
  public Battery(final NSDictionary d) {
    this.currentCapacity = toInt(d.get("BatteryCurrentCapacity"));
    this.isCharging = toBoolean(d.get("BatteryIsCharging"));
    this.externalChargeCapable = toBoolean(d.get("ExternalChargeCapable"));
    this.externalConnected = toBoolean(d.get("ExternalConnected"));
    this.fullyCharged = toBoolean(d.get("FullyCharged"));
    this.gasGaugeCapability = toBoolean(d.get("GasGaugeCapability"));
  }

  public int getCurrentCapacity() {
    return currentCapacity;
  }

  public Battery setCurrentCapacity(int currentCapacity) {
    this.currentCapacity = currentCapacity;
    return me();
  }

  public boolean isCharging() {
    return isCharging;
  }

  public Battery setCharging(boolean isCharging) {
    this.isCharging = isCharging;
    return me();
  }

  public boolean isExternalChargeCapable() {
    return externalChargeCapable;
  }

  public Battery setExternalChargeCapable(boolean externalChargeCapable) {
    this.externalChargeCapable = externalChargeCapable;
    return me();
  }

  public boolean isExternalConnected() {
    return externalConnected;
  }

  public Battery setExternalConnected(boolean externalConnected) {
    this.externalConnected = externalConnected;
    return me();
  }

  public boolean isFullyCharged() {
    return fullyCharged;
  }

  public Battery setFullyCharged(boolean fullyCharged) {
    this.fullyCharged = fullyCharged;
    return me();
  }

  public boolean isGasGaugeCapability() {
    return gasGaugeCapability;
  }

  public Battery setGasGaugeCapability(boolean gasGaugeCapability) {
    this.gasGaugeCapability = gasGaugeCapability;
    return me();
  }

  public String health() {
    return health;
  }

  public Battery sethealth(String health) {
    this.health = health;
    return me();
  }

  public double getTemp() {
    return temp;
  }

  public Battery setTemp(double temp) {
    this.temp = temp;
    return me();
  }

  @Override
  public String toString() {
    return "Battery [currentCapacity=" + currentCapacity + ", isCharging=" + isCharging
        + ", externalChargeCapable=" + externalChargeCapable + ", externalConnected="
        + externalConnected + ", fullyCharged=" + fullyCharged + ", gasGaugeCapability="
        + gasGaugeCapability + ", health=" + health + ", temp=" + temp + "]";
  }

}
