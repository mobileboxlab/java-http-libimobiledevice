package com.mobilebox.executor;

import static com.dd.plist.PropertyListParser.parse;
import static java.lang.String.format;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Optional;

import org.buildobjects.process.ProcBuilder;
import org.buildobjects.process.ProcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dd.plist.NSDictionary;
import com.mobilebox.exception.InternalException;
import com.mobilebox.service.IMisc;

/**
 * Generic basic service implementation to inherit.
 */
public abstract class Service implements IMisc {

  private Logger log = LoggerFactory.getLogger(Service.class);
  protected final String OPTION_PLIST = "-x";
  private String name;

  /**
   * Sets the service name.
   * 
   * @param name The service name.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Gets the service full path.
   * 
   * @return The services full path. E.G: /usr/local/bin/ideviceinfo
   */
  public String getPath() {
    return $().libiPath() + name;
  }

  /**
   * Construct a new process for the service.
   * 
   * @return A {@link ProcBuilder} instance for this service.
   */
  public ProcBuilder getProcess() {
    return new ProcBuilder(getPath()).withTimeoutMillis($().timeout());
  }

  /**
   * Creates a new byte array output stream.
   * 
   * @return A new byte array output stream.
   */
  protected ByteArrayOutputStream getOutputStream() {
    return new ByteArrayOutputStream();
  }

  /**
   * Creates a ByteArrayInputStream so that it uses buf as its buffer array. The buffer array is not
   * copied. The initial value of pos is 0 and the initial value of count is the length of buf.
   * 
   * @param input The input buffer.
   * @return A new byte array input stream.
   */
  protected ByteArrayInputStream setInputStream(final String input) {
    return new ByteArrayInputStream(input.getBytes());
  }

  /**
   * Execute a given command of this service.
   * 
   * @param udid Target specific device by its 40-digit device UDID.
   * @param command The command to execute.
   * 
   * @return The command output.
   */
  protected String exec(final String udid, final Optional<String> command) {
    String param = command.isPresent() ? command.get() : "";
    String cmd = format("-u %s %s", udid, param);
    log.info(format("Command: [%s] Parameters: [%s]", name, cmd));
    ByteArrayOutputStream output = getOutputStream();
    ByteArrayInputStream input = setInputStream(cmd);

    getProcess().withInputStream(input).withOutputStream(output).run();
    return output.toString();
  }

  /**
   * Execute a given command of this service.
   * 
   * @param args The command line arguments
   * @return The command output.
   */
  protected String exec(String... args) {
    log.info(format("Command: [%s] Parameters: %s", name, Arrays.toString(args)));
    ProcResult result = new ProcBuilder(getPath(), args).withTimeoutMillis($().timeout()).run();
    return result.getOutputString();
  }

  /**
   * Parses a property list from a String.
   * 
   * @param value Property list string.
   * @return The root object in the property list.
   * @throws InternalException If any error occurs while parsing the string.
   */
  protected NSDictionary toNSDictionary(final String value) throws InternalException {
    log.info(format("Parser response:[%s]", value));
    try {
      return (NSDictionary) parse(value.getBytes());
    } catch (Exception e) {
      throw new InternalException(e.getMessage());
    }
  }

}
