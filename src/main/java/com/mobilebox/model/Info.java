package com.mobilebox.model;

import com.dd.plist.NSDictionary;

public class Info extends Model<Info> {

  String activationState;
  boolean activationStateAcknowledged;
  String basebandStatus;
  String bluetoothAddress;
  int boardId;
  boolean brickState;
  String buildVersion;
  String cPUArchitecture;
  String chipID;
  String deviceClass;
  String deviceColor;
  String deviceName;
  String ethernetAddress;
  String firmwareVersion;
  String hardwareModel;
  String hardwarePlatform;
  boolean hostAttached;
  String mLBSerialNumber;
  String modelNumber;
  String partitionType;
  boolean passwordProtected;
  String productType;
  String productVersion;
  String productionSOC;
  int protocolVersion;
  String sIMStatus;
  String serialNumber;
  String telephonyCapability;
  String timeZone;
  double uniqueChipID;
  String uniqueDeviceID;
  boolean uses24HourClock;
  String wiFiAddress;

  public Info() {}

  @Override
  public Info me() {
    return this;
  }

  /**
   * Create a new DiskUsage given a NSDictionary with Disk information.
   * 
   * @param d A NSDictionary instance.
   */
  public Info(final NSDictionary d) {
    this.activationState = toString(d.get("ActivationState"));
    this.activationStateAcknowledged = toBoolean(d.get("ActivationStateAcknowledged"));
    this.basebandStatus = toString(d.get("BasebandStatus"));
    this.bluetoothAddress = toString(d.get("BluetoothAddress"));
    this.boardId = toInt(d.get("BoardId"));
    this.brickState = toBoolean(d.get("BrickState"));
    this.buildVersion = toString(d.get("BuildVersion"));
    this.cPUArchitecture = toString(d.get("CPUArchitecture"));
    this.chipID = toString(d.get("ChipID"));
    this.deviceClass = toString(d.get("DeviceClass"));
    this.deviceColor = toString(d.get("DeviceColor"));
    this.deviceName = toString(d.get("DeviceName"));
    this.ethernetAddress = toString(d.get("EthernetAddress"));
    this.firmwareVersion = toString(d.get("FirmwareVersion"));
    this.hardwareModel = toString(d.get("HardwareModel"));
    this.hardwarePlatform = toString(d.get("HardwarePlatform"));
    this.hostAttached = toBoolean(d.get("HostAttached"));
    this.mLBSerialNumber = toString(d.get("MLBSerialNumber"));
    this.modelNumber = toString(d.get("ModelNumber"));
    this.partitionType = toString(d.get("PartitionType"));
    this.passwordProtected = toBoolean(d.get("PasswordProtected"));
    setProductType(toString(d.get("ProductType")));
    this.productVersion = toString(d.get("ProductVersion"));
    this.productionSOC = toString(d.get("ProductionSOC"));
    this.protocolVersion = toInt(d.get("ProtocolVersion"));
    this.sIMStatus = toString(d.get("SIMStatus"));
    this.serialNumber = toString(d.get("SerialNumber"));
    this.telephonyCapability = toString(d.get("TelephonyCapabilitye"));
    this.timeZone = toString(d.get("TimeZone"));
    this.uniqueChipID = toDouble(d.get("UniqueChipID"));
    this.uniqueDeviceID = toString(d.get("UniqueDeviceID"));
    this.uses24HourClock = toBoolean(d.get("Uses24HourClock"));
    this.wiFiAddress = toString(d.get("WiFiAddress"));
  }

  public String getActivationState() {
    return activationState;
  }

  public Info setActivationState(String activationState) {
    this.activationState = activationState;
    return this;
  }

  public boolean isActivationStateAcknowledged() {
    return activationStateAcknowledged;
  }

  public Info setActivationStateAcknowledged(boolean activationStateAcknowledged) {
    this.activationStateAcknowledged = activationStateAcknowledged;
    return this;
  }

  public String getBasebandStatus() {
    return basebandStatus;
  }

  public Info setBasebandStatus(String basebandStatus) {
    this.basebandStatus = basebandStatus;
    return this;
  }

  public String getBluetoothAddress() {
    return bluetoothAddress;
  }

  public Info setBluetoothAddress(String bluetoothAddress) {
    this.bluetoothAddress = bluetoothAddress;
    return this;
  }

  public int getBoardId() {
    return boardId;
  }

  public Info setBoardId(int boardId) {
    this.boardId = boardId;
    return this;
  }

  public boolean isBrickState() {
    return brickState;
  }

  public Info setBrickState(boolean brickState) {
    this.brickState = brickState;
    return this;
  }

  public String getBuildVersion() {
    return buildVersion;
  }

  public Info setBuildVersion(String buildVersion) {
    this.buildVersion = buildVersion;
    return this;
  }

  public String getcPUArchitecture() {
    return cPUArchitecture;
  }

  public Info setcPUArchitecture(String cPUArchitecture) {
    this.cPUArchitecture = cPUArchitecture;
    return this;
  }

  public String getChipID() {
    return chipID;
  }

  public Info setChipID(String chipID) {
    this.chipID = chipID;
    return this;
  }

  public String getDeviceClass() {
    return deviceClass;
  }

  public Info setDeviceClass(String deviceClass) {
    this.deviceClass = deviceClass;
    return this;
  }

  public String getDeviceColor() {
    return deviceColor;
  }

  public Info setDeviceColor(String deviceColor) {
    this.deviceColor = deviceColor;
    return this;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public Info setDeviceName(String deviceName) {
    this.deviceName = deviceName;
    return this;
  }

  public String getEthernetAddress() {
    return ethernetAddress;
  }

  public Info setEthernetAddress(String ethernetAddress) {
    this.ethernetAddress = ethernetAddress;
    return this;
  }

  public String getFirmwareVersion() {
    return firmwareVersion;
  }

  public Info setFirmwareVersion(String firmwareVersion) {
    this.firmwareVersion = firmwareVersion;
    return this;
  }

  public String getHardwareModel() {
    return hardwareModel;
  }

  public Info setHardwareModel(String hardwareModel) {
    this.hardwareModel = hardwareModel;
    return this;
  }

  public String getHardwarePlatform() {
    return hardwarePlatform;
  }

  public Info setHardwarePlatform(String hardwarePlatform) {
    this.hardwarePlatform = hardwarePlatform;
    return this;
  }

  public boolean isHostAttached() {
    return hostAttached;
  }

  public Info setHostAttached(boolean hostAttached) {
    this.hostAttached = hostAttached;
    return this;
  }

  public String getmLBSerialNumber() {
    return mLBSerialNumber;
  }

  public Info setmLBSerialNumber(String mLBSerialNumber) {
    this.mLBSerialNumber = mLBSerialNumber;
    return this;
  }

  public String getModelNumber() {
    return modelNumber;
  }

  public Info setModelNumber(String modelNumber) {
    this.modelNumber = modelNumber;
    return this;
  }

  public String getPartitionType() {
    return partitionType;
  }

  public Info setPartitionType(String partitionType) {
    this.partitionType = partitionType;
    return this;
  }

  public boolean isPasswordProtected() {
    return passwordProtected;
  }

  public Info setPasswordProtected(boolean passwordProtected) {
    this.passwordProtected = passwordProtected;
    return this;
  }

  public String getProductType() {
    return productType;
  }

  public Info setProductType(String productType) {
    this.productType = productType;
    String[] candidate =  productType.split(",");
    
    //Remove the ",N" on the product type.
    if(candidate.length > 0){
      this.productType = candidate[0];
    }
    
    return this;
  }

  public String getProductVersion() {
    return productVersion;
  }

  public Info setProductVersion(String productVersion) {
    this.productVersion = productVersion;
    return this;
  }

  public String getProductionSOC() {
    return productionSOC;
  }

  public Info setProductionSOC(String productionSOC) {
    this.productionSOC = productionSOC;
    return this;
  }

  public int getProtocolVersion() {
    return protocolVersion;
  }

  public Info setProtocolVersion(int protocolVersion) {
    this.protocolVersion = protocolVersion;
    return this;
  }

  public String getsIMStatus() {
    return sIMStatus;
  }

  public Info setsIMStatus(String sIMStatus) {
    this.sIMStatus = sIMStatus;
    return this;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public Info setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  public String getTelephonyCapability() {
    return telephonyCapability;
  }

  public Info setTelephonyCapability(String telephonyCapability) {
    this.telephonyCapability = telephonyCapability;
    return this;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public Info setTimeZone(String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

  public double getUniqueChipID() {
    return uniqueChipID;
  }

  public Info setUniqueChipID(double uniqueChipID) {
    this.uniqueChipID = uniqueChipID;
    return this;
  }

  public String getUniqueDeviceID() {
    return uniqueDeviceID;
  }

  public Info setUniqueDeviceID(String uniqueDeviceID) {
    this.uniqueDeviceID = uniqueDeviceID;
    return this;
  }

  public boolean isUses24HourClock() {
    return uses24HourClock;
  }

  public Info setUses24HourClock(boolean uses24HourClock) {
    this.uses24HourClock = uses24HourClock;
    return this;
  }

  public String getWiFiAddress() {
    return wiFiAddress;
  }

  public Info setWiFiAddress(String wiFiAddress) {
    this.wiFiAddress = wiFiAddress;
    return this;
  }

  @Override
  public String toString() {
    return "Info [activationState=" + activationState + ", activationStateAcknowledged="
        + activationStateAcknowledged + ", basebandStatus=" + basebandStatus + ", bluetoothAddress="
        + bluetoothAddress + ", boardId=" + boardId + ", brickState=" + brickState
        + ", buildVersion=" + buildVersion + ", cPUArchitecture=" + cPUArchitecture + ", chipID="
        + chipID + ", deviceClass=" + deviceClass + ", deviceColor=" + deviceColor + ", deviceName="
        + deviceName + ", ethernetAddress=" + ethernetAddress + ", firmwareVersion="
        + firmwareVersion + ", hardwareModel=" + hardwareModel + ", hardwarePlatform="
        + hardwarePlatform + ", hostAttached=" + hostAttached + ", mLBSerialNumber="
        + mLBSerialNumber + ", modelNumber=" + modelNumber + ", partitionType=" + partitionType
        + ", passwordProtected=" + passwordProtected + ", productType=" + productType
        + ", productVersion=" + productVersion + ", productionSOC=" + productionSOC
        + ", protocolVersion=" + protocolVersion + ", sIMStatus=" + sIMStatus + ", serialNumber="
        + serialNumber + ", telephonyCapability=" + telephonyCapability + ", timeZone=" + timeZone
        + ", uniqueChipID=" + uniqueChipID + ", uniqueDeviceID=" + uniqueDeviceID
        + ", uses24HourClock=" + uses24HourClock + ", wiFiAddress=" + wiFiAddress + "]";
  }

}
