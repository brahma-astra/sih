package com.brahmastra.sih.enumeration.query;

public enum QueryComparator {

	EQUALS("="),

	LIKE("LIKE"),

	GREATER_THAN("gt"),

	LESS_THAN("lt"),

	NOT_EQUAL("ne"),

	GREATER_OR_EQUAL("ge"),

	LESS_OR_EQUAL("le"),

	BETWEEN("between"),

	IN("in"),

	IS_NULL("isNull"),

	IS_NOT_NULL("isNotNull"),

	SQL_STRING_RESTRICTION("sqlRestriction");

	private String value;

	private QueryComparator(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		String returnValue;
		switch (valueOf(name())) {
		case EQUALS:
			returnValue = "=";
			break;
		case GREATER_THAN:
			returnValue = ">";
			break;
		case LESS_THAN:
			returnValue = "<";
			break;
		case NOT_EQUAL:
			returnValue = "<>";
			break;
		case GREATER_OR_EQUAL:
			returnValue = ">=";
			break;
		case LESS_OR_EQUAL:
			returnValue = "<=";
			break;
		case BETWEEN:
		case IN:
		case LIKE:
			returnValue = getValue();
			break;
		case IS_NOT_NULL:
			returnValue = "is not null";
			break;
		case IS_NULL:
			returnValue = "is null";
			break;
		default:
			returnValue = getValue();
		}
		return returnValue;
	}
}
