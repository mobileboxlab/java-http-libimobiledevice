package com.mobilebox.model;

import static com.google.common.base.Strings.isNullOrEmpty;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/**
 * This class represents a complete service response. Services API has one section: <b>data</b>.
 * <br>
 * <br>
 * <b>Data:</b> The data section will contain objects, which are abstractions of resources in the
 * system. There are two main types of resources: common objects and collections. Complete Response:
 * {
 * 	"data": 
 * 		{ ... Payload ... }
 * }
 * 
 * <br>
 * <b>Error:</b> If a request results in an error, the service API will respond with an HTTP status
 * code in the <code>4xx</code> class or <code>5xx</code> class, depending on the cause. Complete
 * error response:
 * 
 * { 
 *     "code": "INTERNAL_ERROR", 
 *     "message": "More information about the error" 
 * }
 * 
 */
public class Response {

  @SerializedName("data")
  private Object data;

  @SerializedName("code")
  private String code;

  @SerializedName("message")
  private String message;

  /**
   * Set the data payload. This can be: a common objects or a collections of {@link Response}.
   * 
   * @param code The error code.
   * @return {@link Response}
   */
  public Response withData(final Object data) {
    this.data = data;
    return this;
  }

  /**
   * Set the error code. In addition to the HTTP response code, the service report more detailed
   * application-specific error types. This is the code of these kind of errors.
   * 
   * @param code The error code.
   * @return {@link Response}
   */
  public Response withCode(final String code) {
    this.code = code;
    nullToEmptyMessage();
    return this;
  }

  /**
   * Set the error message. More information about the error, targeted to users.
   * 
   * @param message The error message.
   * @return {@link Response}
   */
  public Response withMessage(final String message) {
    this.message = message;
    nullToEmptyCode();
    return this;
  }

  public Object getData() {
    return data;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  private void nullToEmptyMessage() {
    if (!isNullOrEmpty(this.code) && (this.message == null)) {
      this.message = "";
    }
  }

  private void nullToEmptyCode() {
    if (!isNullOrEmpty(this.message) && (this.code == null)) {
      this.code = "";
    }
  }

  public String toJson() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this);
  }
}
