package com.mobilebox.service;

import org.aeonbits.owner.ConfigCache;

import com.mobilebox.configuration.Configuration;

/**
 * Consisting of a mixture of various things that are not necessarily connected with each other.
 */
public interface IMisc {

  /**
   * Gets the config.
   * 
   * @return An object implementing the {@link ServiceConfig}, that can be taken from the cache,
   *         which maps methods to property values.
   */
  default Configuration $() {
    return ConfigCache.getOrCreate(Configuration.class);
  }

  /**
   * Returns an Integer object holding the value of the specified String
   * 
   * @param value The string to be parsed.
   * @return An Integer object holding the value represented by the string argument.
   */
  default Integer toInt(Object value) {
    return Integer.valueOf(value.toString());
  }

  /**
   * Returns a Double object holding the double value represented by the argument string.If value is
   * null, 0 is returned.
   * 
   * @param value The string to be parsed.
   * @return An Double object holding the value represented by the string argument.
   */
  default Double toDouble(Object value) {
    return value == null ? 0 : Double.valueOf(value.toString());
  }

  /**
   * Returns a Boolean with a value represented by the specified string
   * 
   * @param value The string to be parsed.
   * @return The Boolean value represented by the string.
   */
  default boolean toBoolean(Object value) {
    return Boolean.valueOf(value.toString());
  }

  /**
   * Returns the string representation of the Object argument.
   * 
   * @param value An Object.
   * @return if the argument is null, then a string equal to "null"; otherwise, the value of
   *         obj.toString() is returned.
   */
  default String toString(Object value) {
    return String.valueOf(value);
  }
}
