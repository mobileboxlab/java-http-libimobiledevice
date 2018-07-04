package com.mobilebox.base;

import org.testng.annotations.BeforeClass;

public class BaseTest {

  protected String udid;

  @BeforeClass
  public void beforeClass() {
    udid = "C1C15247-A830-46C5-A101-04F18DFBA3C6";
  }

}
