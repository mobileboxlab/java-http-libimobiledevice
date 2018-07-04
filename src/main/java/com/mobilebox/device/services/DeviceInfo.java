package com.mobilebox.device.services;


import com.mobilebox.exception.InternalException;
import com.mobilebox.executor.Service;
import com.mobilebox.model.Battery;
import com.mobilebox.model.DiskUsage;
import com.mobilebox.model.Info;
import com.mobilebox.parser.IDeviceParser;

/**
 * Service that show information about an attached device.
 */
public class DeviceInfo extends Service {

  private final String OPTION_DOMAIN = "-q";

  public DeviceInfo() {
    setName("ideviceinfo");
  }

  /**
   * Known domains.
   */
  public enum Domains {
    DISKUSAGE("disk_usage"), 
    DISKUSAGEFACTORY("disk_usage.factory"), 
    BATTERY("mobile.battery"),
    IQAGENT("iqagent"), 
    PUERPLEBUDDY("purplebuddy"), 
    CHAPERONE("mobile.chaperone"), 
    THIRDPARTYTERMINATION("mobile.third_party_termination"), 
    LOCKDOWN("mobile.lockdownd"), 
    LOCKDOWNCACHE("mobile.lockdown_cache"),
    DEVELOPERDOMAIN("xcode.developerdomain"), 
    INTERNATIONAL("international"), 
    DATASYNC("mobile.data_sync"), 
    TETHEREDSYNC("mobile.tethered_sync"),
    APPLICATIONUSAGE("mobile.mobile_application_usage"),
    BACKUP("mobile.backup"), 
    NIKITA("mobile.nikita"), 
    RESTRICTION("mobile.restriction"),
    USERPREFERENCES("mobile.user_preferences"),
    SYNCDATACLASS("mobile.sync_data_class"),
    SOFTWAREBEHAVIOR("mobile.software_behavior"), 
    ITUNESACCESSORIES("mobile.iTunes.accessories"), 
    INTERNAL("mobile.internal"), 
    WIRELESSLOCKDOWN("mobile.wireless_lockdown"),
    FAIRPLAY("fairplay"),
    ITUNES("iTunes"),
    ITUNESSTORE("mobile.iTunes.store");

    private final String value;

    private Domains(final String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "com.apple." + value;
    }
  }

  /**
   * Gets information about an attached device.
   * 
   * @param udid Target specific device by its 40-digit device UDID
   * @return information about of the device.
   * @throws InternalException
   */
  public Info getInfo(final String udid) throws InternalException {
    String result = exec(new String[] {"-u", udid, OPTION_PLIST});
    return (Info) IDeviceParser.INFO.parser(toNSDictionary(result));
  }

  /**
   * Gets information of an attached device.
   * 
   * @param udid Target specific device by its 40-digit device UDID
   * @param domain The domain
   * @return information of an attached device.
   * @throws InternalException
   */
  public String getInfo(final String udid, Domains domain) throws InternalException {
    return exec(new String[] {"-u", udid, OPTION_DOMAIN, domain.toString(), OPTION_PLIST});
  }

  /**
   * Gets information about the battery of an attached device.
   * 
   * @param udid Target specific device by its 40-digit device UDID
   * @return information about the battery.
   * @throws InternalException
   */
  public Battery getBatteryInfo(final String udid) throws InternalException {
    String result = getInfo(udid, Domains.BATTERY);
    return (Battery) IDeviceParser.BATTERY.parser(toNSDictionary(result));
  }

  /**
   * Gets information about the disk usage of an attached device.
   * 
   * @param udid Target specific device by its 40-digit device UDID
   * @return information about the disk usage.
   * @throws InternalException
   */
  public DiskUsage getDiskUsageInfo(final String udid) throws InternalException {
    String result = getInfo(udid, Domains.DISKUSAGE);
    return (DiskUsage) IDeviceParser.DISKUSAGE.parser(toNSDictionary(result));
  }
  
}
