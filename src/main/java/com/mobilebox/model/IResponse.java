package com.mobilebox.model;

/**
 * All classes that represents a response should implement this interface.
 *
 * @param <T> The response type.
 */
public interface IResponse<T> {

  /**
   * @return The implementing class for fluency.
   */
  T me();

}
