package com.brahmastra.sih.common.vo;

import java.io.Serializable;

import com.brahmastra.sih.enumeration.query.QueryComparator;

public class PropCriteriaAndValue implements Serializable {

	private static final long serialVersionUID = 2214899919968643761L;
	private String propertyName;
	private QueryComparator comparator;
	private Object value;

	public PropCriteriaAndValue() {
		super();
	}

	public PropCriteriaAndValue(String propertyName,
			QueryComparator comparator, Object value) {
		if (propertyName == null || propertyName.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Property name cannot be null or empty.");
		}
		this.propertyName = propertyName.trim();
		this.comparator = comparator;
		this.value = value;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public QueryComparator getComparator() {
		return this.comparator;
	}

	public Object getValue() {
		return this.value;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public void setComparator(QueryComparator comparator) {
		this.comparator = comparator;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder(64);
		out.append("{").append(this.getPropertyName()).append(" ");
		out.append(this.getComparator().getValue()).append(" ");
		out.append(this.getValue()).append("}");
		return out.toString();
	}
}
