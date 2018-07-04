package com.mobilebox.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobilebox.service.IMisc;

public abstract class Model<T> implements IMisc, IResponse<T> {

  /**
   * Serializes this into its equivalent Json representation.
   * 
   * @return Json representation of src.
   */
  public String toJson() {
    Gson gson = new GsonBuilder().serializeNulls().create();
    return gson.toJson(this);
  }

}
