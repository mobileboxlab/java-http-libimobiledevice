package com.mobilebox.parser;

import com.dd.plist.NSDictionary;
import com.mobilebox.device.services.DeviceInfo;
import com.mobilebox.model.Battery;
import com.mobilebox.model.CPUArchitecture;
import com.mobilebox.model.DeviceModel;
import com.mobilebox.model.DiskUsage;
import com.mobilebox.model.Info;
import com.mobilebox.model.Model;
import com.mobilebox.service.IMisc;

/**
 * Parser for the {@link DeviceInfo} service response.
 */
@SuppressWarnings("unused")
public enum IDeviceParser implements IMisc {
 
  BATTERY {
    @Override
    public Battery parser(final NSDictionary response) {
      return new Battery(response);
    };
  },

  DISKUSAGE {
    @Override
    public DiskUsage parser(final NSDictionary response) {
      return new DiskUsage(response);
    };
  },

  MODELNUMBER {
    @Override
    public DeviceModel parser(final NSDictionary response) {
      return new DeviceModel((NSDictionary) response.get(GESTALT_KEY));
    };
  },

  CPUARCHITECTURE {
    @Override
    public CPUArchitecture parser(final NSDictionary response) {
      return new CPUArchitecture((NSDictionary) response.get(GESTALT_KEY));
    };
  },

  INFO {
    @Override
    public Info parser(final NSDictionary response) {
      return new Info(response);
    };
  };

  protected final String GESTALT_KEY = "MobileGestalt";

  public abstract Object parser(NSDictionary response);
}
