package com.mobilebox.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.mobilebox.base.BaseTest;
import com.mobilebox.device.services.DeviceDiagnostics;
import com.mobilebox.device.services.DeviceDiagnostics.Diagnostics;
import com.mobilebox.device.services.DeviceDiagnostics.Keys;
import com.mobilebox.device.services.DeviceDiagnostics.Register;

public class IDeviceDiagnosticsSuite extends BaseTest {

  DeviceDiagnostics service = new DeviceDiagnostics();

  @Test
  public void getDiagnosticsTest() {
    for (Diagnostics diagnostic : Diagnostics.values()) {
      String actual = service.getDiagnostics(udid, diagnostic);
      assertThat(actual).isNotEmpty();
    }
  }

  @Test
  public void getKeysTest() {
    for (Keys key : Keys.values()) {
      String actual = service.getKey(udid, key);
      assertThat(actual).isNotEmpty();
    }
  }

  @Test
  public void getIORegisterTest() {
    for (Register register : Register.values()) {
      String actual = service.getIORegistry(udid, register);
      assertThat(actual).isNotEmpty();
    }
  }

}
