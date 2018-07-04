package com.mobilebox.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * There are two main types of response: common objects and collections. This
 * provides a list of response.
 * 
 * @param <T>
 *            The response type.
 * @see {@link Response}
 */
public class Responses<T extends IResponse<T>> {

	@SerializedName("items")
	private List<T> items = new ArrayList<T>();

	@SerializedName("size")
	private Integer size = 0;

	public Responses(List<T> items) {
		this.items = items;
		this.size = items.size();
	}

	public List<T> getItems() {
		return items;
	}

	public Integer getSize() {
		return size;
	}

}
