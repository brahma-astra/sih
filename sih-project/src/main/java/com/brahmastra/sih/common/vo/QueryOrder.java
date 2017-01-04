package com.brahmastra.sih.common.vo;

import java.io.Serializable;

import com.brahmastra.sih.enumeration.query.QueryOrderDirection;

public class QueryOrder implements Serializable {

	private static final long serialVersionUID = 2070749793749118252L;
	private final String propertyName;
	private final QueryOrderDirection direction;

	public QueryOrder(String propertyName, QueryOrderDirection direction) {
		if (propertyName == null || propertyName.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Property name cannot be null or empty.");
		}
		this.propertyName = propertyName.trim();
		this.direction = direction;
	}

	public QueryOrder(String propertyName) {
		this(propertyName, null);
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public QueryOrderDirection getDirection() {
		return (direction != null ? this.direction : QueryOrderDirection.ASC);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{").append(propertyName);
		if (direction != null) {
			sb.append(" ").append(direction);
		}
		sb.append("}");
		return sb.toString();
	}
}
