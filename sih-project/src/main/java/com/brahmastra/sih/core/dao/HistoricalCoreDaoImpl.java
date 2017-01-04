package com.brahmastra.sih.core.dao;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.brahmastra.sih.common.vo.PaginatedResult;
import com.brahmastra.sih.core.domain.HistoricalCoreDomain;

public class HistoricalCoreDaoImpl<T extends HistoricalCoreDomain> extends
		HibernateDaoSupport implements CoreDao<T> {

	protected final Class<T> persistentClass;
	protected static final Log log = LogFactory
			.getLog(HistoricalCoreDaoImpl.class);
	private static final String DELETE_DATE = "deleteDate";
	private static final int ZERO = 0;
	private static final int ONE = 1;

	/**
	 * Constructor
	 * 
	 * @author viper
	 */
	@SuppressWarnings("unchecked")
	public HistoricalCoreDaoImpl() {
		super();
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Full Constructor
	 * 
	 * @author Cornelius
	 * @param persistentClass
	 */
	public HistoricalCoreDaoImpl(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}

	/**
	 * Persistent class getter
	 * 
	 * @author Cornelius
	 * @return
	 */
	public Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	@Override
	public Boolean remove(T persistentInstance) {
		log.debug("deleting " + this.persistentClass.getName() + " instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(int... rowStartIdxAndCount) {
		log.debug("finding all " + this.persistentClass.getName()
				+ " instances");
		try {
			String sqlString = "select model from "
					+ this.persistentClass.getName() + " model where model."
					+ DELETE_DATE + " is null";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(sqlString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > ONE) {
					int rowCount = Math.max(ZERO, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.list();
		} catch (RuntimeException re) {
			log.error("find all " + this.persistentClass.getName() + " failed",
					re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(T instance, int... rowStartIdxAndCount) {
		log.debug("finding " + this.persistentClass.getName()
				+ " instance by example");
		try {
			List<T> results = null;
			if (rowStartIdxAndCount.length > 0) {
				results = getHibernateTemplate().findByExample(instance,
						rowStartIdxAndCount[0], rowStartIdxAndCount[1]);
			} else {
				results = getHibernateTemplate().findByExample(instance);
			}
			log.debug("find " + this.persistentClass.getName()
					+ " by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find " + this.persistentClass.getName()
					+ " by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(String id) {
		log.debug("getting " + this.persistentClass.getName()
				+ " instance with id: " + id);
		try {
			T instance = (T) getHibernateTemplate().get(
					this.persistentClass.getName(), id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find " + this.persistentClass.getName()
					+ " by id failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		log.debug("finding " + this.persistentClass.getName()
				+ " instance with property: " + propertyName + ", value: "
				+ value);
		try {
			String queryString = "from " + this.persistentClass.getName()
					+ " as model where model." + propertyName
					+ "= :value and model." + DELETE_DATE + " is null";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			query.setParameter("value", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			// return getHibernateTemplate().find(queryString, value);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find " + this.persistentClass.getName()
					+ " by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLikeProperty(String propertyName, Object value,
			int... rowStartIdxAndCount) {
		log.debug("finding " + this.persistentClass.getName()
				+ " instance with property: " + propertyName + ", value: "
				+ value);
		try {
			String queryString = "from " + this.persistentClass.getName()
					+ " as model where model." + propertyName + " like '%"
					+ value + "%' and model." + DELETE_DATE + " is null";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			// return getHibernateTemplate().find(queryString, value);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find " + this.persistentClass.getName()
					+ " by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLikePropertyWithKasus(String idKasus,
			String propertyName, Object value, int... rowStartIdxAndCount) {
		log.debug("finding " + this.persistentClass.getName()
				+ " instance with property: " + propertyName + ", value: "
				+ value);
		try {
			String queryString = "from " + this.persistentClass.getName()
					+ " as model where model." + propertyName + " like '%"
					+ value + "%' and model.kasus.id = '" + idKasus + "'";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			// return getHibernateTemplate().find(queryString, value);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find " + this.persistentClass.getName()
					+ " by property name failed", re);
			throw re;
		}
	}

	@Override
	public T insert(T transientInstance) {
		log.debug("inserting " + this.persistentClass.getName() + " instance");
		try {
			transientInstance.setId((String) getHibernateTemplate().save(
					transientInstance));
			log.debug("insert successful");
			return transientInstance;
		} catch (RuntimeException re) {
			log.error("insert failed", re);
			throw re;
		}
	}

	@Override
	public T update(T detachedInstance) {
		log.debug("updating " + this.persistentClass.getName() + " instance");
		try {
			T result = getHibernateTemplate().merge(detachedInstance);
			log.debug("update successful");
			return result;
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	/**
	 * Removing a list of JenisDokumen entities.
	 * 
	 * @param list
	 *            List<JenisDokumen>
	 * @return Boolean
	 * @author viper
	 */
	public Boolean removeList(List<T> list) {
		log.debug("Removing a list of " + this.persistentClass.getName());
		int count = 0;
		try {
			for (T entity : list) {
				// getHibernateTemplate().delete(entity);
				((HistoricalCoreDomain) entity).setDeleteDate(new Date());
				this.update(entity);
				count++;
			}
			log.debug("Removing list of " + this.persistentClass.getName()
					+ " succeeded");
			return true;
		} catch (RuntimeException re) {
			log.error("Delete list failed " + count + " row has been deleted.",
					re);
			throw re;
		}
	}

	public Integer countAll() {
		log.debug("count all " + this.persistentClass.getName() + " instances");

		try {
			String queryString = "select count(*) from "
					+ this.persistentClass.getName() + " as model where model."
					+ DELETE_DATE + " is null";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);

			return Integer.valueOf(query.uniqueResult().toString());
		} catch (RuntimeException re) {
			log.error("count all failed", re);
			throw re;
		}
	}

	public Integer countLikeProperty(String propertyName, Object value) {
		log.debug("count like property " + this.persistentClass.getName()
				+ " instances");

		try {
			String queryString = "select count(*) from "
					+ this.persistentClass.getName() + " as model where model."
					+ propertyName + " like '%" + value + "%' and model."
					+ DELETE_DATE + " is null";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);

			return Integer.valueOf(query.uniqueResult().toString());
		} catch (RuntimeException re) {
			log.error("count like property failed", re);
			throw re;
		}
	}

	@Override
	public Integer countLikePropertyWithKasus(String idKasus,
			String propertyName, Object value) {
		log.debug("count like property " + this.persistentClass.getName()
				+ " instances");

		try {
			String queryString = "select count(*) from "
					+ this.persistentClass.getName() + " as model where model."
					+ propertyName + " like '%" + value
					+ "%' and model.kasus.id = '" + idKasus + "'";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);

			return Integer.valueOf(query.uniqueResult().toString());
		} catch (RuntimeException re) {
			log.error("count like property failed", re);
			throw re;
		}
	}

	public Integer countByProperty(String propertyName, Object value) {
		log.debug("count by property " + this.persistentClass.getName()
				+ " instances");

		try {
			String queryString = "select count(*) from "
					+ this.persistentClass.getName() + " as model where model."
					+ propertyName + "= :propertyValue and model."
					+ DELETE_DATE + " is null";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return Integer.valueOf(query.uniqueResult().toString());
		} catch (RuntimeException re) {
			log.error("count by property failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLikeMapOfProperties(Map<String, Object> propertiesMap,
			final int... rowStartIdxAndCount) {
		log.debug("finding " + this.persistentClass.getName()
				+ " instance with map of properties");
		try {
			int mapSize = propertiesMap.size();

			String[] keys = new String[mapSize];
			propertiesMap.keySet().toArray(keys);

			StringBuffer strBuffer = new StringBuffer("from "
					+ this.persistentClass.getName() + " as model");
			strBuffer.append(" where");

			for (int i = 0; i < mapSize; i++) {

				strBuffer.append(" model.");
				strBuffer.append(keys[i]);
				strBuffer.append(" like '%");
				strBuffer.append(propertiesMap.get(keys[i]));
				strBuffer.append("%'");
				if (i < mapSize) {
					strBuffer.append(" and");
				}
			}

			strBuffer.append(" model." + DELETE_DATE + " is null");

			String queryString = strBuffer.toString();

			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			// return getHibernateTemplate().find(queryString, value);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find like map of properties failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap, final int... rowStartIdxAndCount) {
		log.debug("finding " + this.persistentClass.getName()
				+ " instance with map of properties");
		try {
			int mapSize = propertiesMap.size();

			String[] keys = new String[mapSize];
			propertiesMap.keySet().toArray(keys);

			StringBuffer strBuffer = new StringBuffer("from "
					+ this.persistentClass.getName() + " as model");
			strBuffer.append(" where");
			strBuffer.append(" model.kasus.id = '");
			strBuffer.append(idKasus);
			strBuffer.append("' and");

			for (int i = 0; i < mapSize; i++) {

				strBuffer.append(" model.");
				strBuffer.append(keys[i]);
				strBuffer.append(" like '%");
				strBuffer.append(propertiesMap.get(keys[i]));
				strBuffer.append("%'");
				if (i < mapSize) {
					strBuffer.append(" and");
				}
			}

			String queryString = strBuffer.toString();

			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			// return getHibernateTemplate().find(queryString, value);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find like map of properties failed", re);
			throw re;
		}
	}

	@Override
	public Integer countLikeMapOfProperties(Map<String, Object> propertiesMap) {
		log.debug("count like map of properties "
				+ this.persistentClass.getName() + " instances");

		try {
			int mapSize = propertiesMap.size();

			String[] keys = new String[mapSize];
			propertiesMap.keySet().toArray(keys);

			StringBuffer strBuffer = new StringBuffer("select count(*) from "
					+ this.persistentClass.getName() + " as model");
			strBuffer.append(" where");

			for (int i = 0; i < mapSize; i++) {

				strBuffer.append(" model.");
				strBuffer.append(keys[i]);
				strBuffer.append(" like '%");
				strBuffer.append(propertiesMap.get(keys[i]));
				strBuffer.append("%'");
				if (i < mapSize) {
					strBuffer.append(" and");
				}
			}

			strBuffer.append(" model." + DELETE_DATE + " is null");

			String queryString = strBuffer.toString();

			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);

			return Integer.valueOf(query.uniqueResult().toString());
		} catch (RuntimeException re) {
			log.error("count like map of properties failed", re);
			throw re;
		}
	}

	@Override
	public Integer countLikeMapOfPropertiesWithKasus(String idKasus,
			Map<String, Object> propertiesMap) {
		log.debug("count like map of properties "
				+ this.persistentClass.getName() + " instances");

		try {
			int mapSize = propertiesMap.size();

			String[] keys = new String[mapSize];
			propertiesMap.keySet().toArray(keys);

			StringBuffer strBuffer = new StringBuffer("select count(*) from "
					+ this.persistentClass.getName() + " as model");
			strBuffer.append(" where");
			strBuffer.append(" model.kasus.id = '");
			strBuffer.append(idKasus);
			strBuffer.append("' and");

			for (int i = 0; i < mapSize; i++) {

				strBuffer.append(" model.");
				strBuffer.append(keys[i]);
				strBuffer.append(" like '%");
				strBuffer.append(propertiesMap.get(keys[i]));
				strBuffer.append("%'");
				if (i < mapSize) {
					strBuffer.append(" and");
				}
			}

			String queryString = strBuffer.toString();

			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);

			return Integer.valueOf(query.uniqueResult().toString());
		} catch (RuntimeException re) {
			log.error("count like map of properties failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedResult<T> paginateLikeMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		PaginatedResult<T> paginatedResult = new PaginatedResult<T>();

		List<T> resultList = this.findLikeMapOfProperties(propertiesMap,
				rowStartIdxAndCount);
		paginatedResult.setResultList(resultList);

		Integer rowCount = this.countLikeMapOfProperties(propertiesMap);
		paginatedResult.setRowCount(rowCount);

		return paginatedResult;
	}

	@Override
	public PaginatedResult<T> paginateAll(int... rowStartIdxAndCount) {
		PaginatedResult<T> paginatedResult = new PaginatedResult<T>();

		List<T> resultList = this.findAll(rowStartIdxAndCount);
		paginatedResult.setResultList(resultList);

		Integer rowCount = this.countAll();
		paginatedResult.setRowCount(rowCount);

		return paginatedResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByMapOfProperties(Map<String, Object> propertiesMap,
			final int... rowStartIdxAndCount) {
		log.debug("finding " + this.persistentClass.getName()
				+ " instance with map of properties");
		try {
			int mapSize = propertiesMap.size();

			String[] keys = new String[mapSize];
			propertiesMap.keySet().toArray(keys);

			StringBuffer strBuffer = new StringBuffer("from "
					+ this.persistentClass.getName() + " as model");
			strBuffer.append(" where");

			for (int i = 0; i < mapSize; i++) {

				strBuffer.append(" model.");
				strBuffer.append(keys[i]);
				strBuffer.append(" = '");
				strBuffer.append(propertiesMap.get(keys[i]));
				strBuffer.append("'");
				if (i < mapSize - 1) {
					strBuffer.append(" and");
				}
			}

			strBuffer.append(" model." + DELETE_DATE + " is null");

			String queryString = strBuffer.toString();

			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}
				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			// return getHibernateTemplate().find(queryString, value);
			return query.list();
		} catch (RuntimeException re) {
			log.error("find like map of properties failed", re);
			throw re;
		}
	}

	@Override
	public Integer countByMapOfProperties(Map<String, Object> propertiesMap) {
		log.debug("count by map of properties "
				+ this.persistentClass.getName() + " instances");

		try {
			int mapSize = propertiesMap.size();

			String[] keys = new String[mapSize];
			propertiesMap.keySet().toArray(keys);

			StringBuffer strBuffer = new StringBuffer("select count(*) from "
					+ this.persistentClass.getName() + " as model");
			strBuffer.append(" where");

			for (int i = 0; i < mapSize; i++) {

				strBuffer.append(" model.");
				strBuffer.append(keys[i]);
				strBuffer.append(" = '");
				strBuffer.append(propertiesMap.get(keys[i]));
				strBuffer.append("'");
				if (i < mapSize - 1) {
					strBuffer.append(" and");
				}
			}

			strBuffer.append(" model." + DELETE_DATE + " is null");

			String queryString = strBuffer.toString();

			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryString);

			return Integer.valueOf(query.uniqueResult().toString());
		} catch (RuntimeException re) {
			log.error("count by map of properties failed", re);
			throw re;
		}
	}

	@Override
	public PaginatedResult<T> paginateByMapOfProperties(
			Map<String, Object> propertiesMap, int... rowStartIdxAndCount) {
		PaginatedResult<T> paginatedResult = new PaginatedResult<T>();

		List<T> resultList = this.findByMapOfProperties(propertiesMap,
				rowStartIdxAndCount);
		paginatedResult.setResultList(resultList);

		Integer rowCount = this.countByMapOfProperties(propertiesMap);
		paginatedResult.setRowCount(rowCount);

		return paginatedResult;
	}
}
