/**
 * @author viper
 * @date May 12, 2011
 */
package com.brahmastra.sih.persistence.user.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brahmastra.sih.core.dao.HistoricalCoreDaoImpl;
import com.brahmastra.sih.persistence.user.domain.User;

/**
 * @author viper
 * 
 */
@Repository
public class UserDaoImpl extends HistoricalCoreDaoImpl<User> implements UserDao {
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);

	public UserDaoImpl() {
		super();
	}

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public User updateWithoutPassword(User user) {
		boolean isComma = false;

		StringBuilder sql = new StringBuilder("update user_tbl set ");
		if (user.getAktif() != null) {
			sql.append("aktif=:aktif");
			isComma = true;
		}
		if (user.getEmail() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("email=:email");
			isComma = true;
		}
		if (user.getEmail() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("lisensi=:lisensi");
			isComma = true;
		}
		if (user.getNamaLengkap() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("nama_lengkap=:namaLengkap");
			isComma = true;
		}
		if (user.getProfil() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("profil=:profil");
			isComma = true;
		}
		if (user.getUsername() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("username=:username");
			isComma = true;
		}
		if (user.getPangkat() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("pangkat=:pangkat");
			isComma = true;
		}
		if (user.getNrp() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("nrp=:nrp");
			isComma = true;
		}
		if (user.getJabatan() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("jabatan=:jabatan");
			isComma = true;
		}
		if (user.getDeleteDate() != null) {
			if (isComma) {
				sql.append(", ");
				isComma = false;
			}
			sql.append("delete_date=:deleteDate");
		}

		sql.append(" where id=:id ");

		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createSQLQuery(sql.toString());

		query.setString("aktif", user.getAktif());
		query.setString("email", user.getEmail());
		query.setString("lisensi", user.getLisensi());
		query.setString("namaLengkap", user.getNamaLengkap());
		query.setString("profil", user.getProfil());
		query.setString("username", user.getUsername());
		query.setString("pangkat", user.getPangkat());
		query.setString("nrp", user.getNrp());
		query.setString("jabatan", user.getJabatan());
		query.setString("id", user.getId());

		System.out.println(query.getQueryString());

		int countResult = query.executeUpdate();
		if (countResult <= 0) {
			throw new RuntimeException("Update gagal");
		}
		return this.findById(user.getId());
	}

	@Override
	public User updatePassword(User user) {
		StringBuilder sql = new StringBuilder(
				"update user_tbl set password=:password ");
		sql.append("where id=:id ");
		Query query = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createSQLQuery(sql.toString());
		query.setString("password", user.getPassword());
		query.setString("id", user.getId());
		int countResult = query.executeUpdate();
		if (countResult <= 0) {
			throw new RuntimeException("Update gagal");
		}
		return this.findById(user.getId());
	}
}
