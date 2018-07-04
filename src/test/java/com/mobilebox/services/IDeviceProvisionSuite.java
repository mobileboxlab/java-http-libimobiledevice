package com.mobilebox.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.mobilebox.base.BaseTest;
import com.mobilebox.device.services.DeviceProvision;

public class IDeviceProvisionSuite extends BaseTest {

  @Test
  public void getProvisioningProfiles() {
    String actual = new DeviceProvision().getProvisioningProfiles(udid);
    assertThat(actual).isNotEmpty();
  }
}
