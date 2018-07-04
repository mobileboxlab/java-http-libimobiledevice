package com.mobilebox.services;

import static org.assertj.core.api.Assertions.assertThat;
import static strman.Strman.rightTrim;

import org.testng.annotations.Test;

import com.mobilebox.base.BaseTest;
import com.mobilebox.device.services.DeviceName;

public class IDeviceNameSuite extends BaseTest {

  @Test
  public void getNameTest() {
    String actual = new DeviceName().getName(udid);
    assertThat(rightTrim(actual)).isNotEmpty();
  }
}
