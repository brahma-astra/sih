package com.brahmastra.sih.core.domain;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;

import javax.persistence.FetchType;

import org.hibernate.LazyInitializationException;

public abstract class CoreDomain implements Serializable {

	/**
	 * @author viper serialVersionUID
	 */
	private static final long serialVersionUID = 6505143857902520060L;

	public abstract String getId();

	public abstract void setId(String id);

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName()).append("::");
		Method[] methods = this.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (method.getGenericParameterTypes().length == 0) {

				if (method.getName().equals("toString")) {
					continue;
				}

				if (method.getReturnType().equals(Collection.class)
						|| method.getReturnType().equals(Set.class)) {
					builder.append(":").append(method.getName())
							.append("=([COLLECTION])");
					continue;
				}
				builder.append(":").append(method.getName()).append("=(");
				try {
					if (method.getAnnotation(javax.persistence.ManyToOne.class) != null
							&& method
									.getAnnotation(
											javax.persistence.ManyToOne.class)
									.fetch().equals(FetchType.LAZY)) {
						builder.append("[LAZY]");
					} else if (method
							.getAnnotation(javax.persistence.OneToOne.class) != null
							&& method
									.getAnnotation(
											javax.persistence.OneToOne.class)
									.fetch().equals(FetchType.LAZY)) {
						builder.append("[LAZY]");
					} else {
						builder.append(method.invoke(this));
					}
				} catch (IllegalAccessException e) {
					builder.append("[ERROR_RETRIEVING]");
				} catch (InvocationTargetException e) {
					builder.append("[ERROR_RETRIEVING]");
				} catch (LazyInitializationException e) {
					builder.append("[LAZY]");
				} catch (NullPointerException e) {
					builder.append("[LAZY]");
				} finally {
					builder.append(") ");
				}
			}
		}
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CoreDomain other = (CoreDomain) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}

}
