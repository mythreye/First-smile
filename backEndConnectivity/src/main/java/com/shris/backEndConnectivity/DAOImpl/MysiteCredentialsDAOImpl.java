package com.shris.backEndConnectivity.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.MysiteCredentialsDAO;
import com.shris.backEndConnectivity.model.MySeller;
import com.shris.backEndConnectivity.model.MysiteCredentials;

@Repository
@Transactional
public class MysiteCredentialsDAOImpl implements MysiteCredentialsDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<MysiteCredentials> SelectAllSellerCredential() {
		try {
			List<MysiteCredentials> mysitecredential = (List<MysiteCredentials>) sessionFactory.getCurrentSession()
					.createQuery("from MysiteCredentials where credentialrole='ROLE_SELLER'").list();
			System.out.println(mysitecredential.get(0).getCredentialpassword());
			return mysitecredential;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public MysiteCredentials SelectPassword(String email) {
		try {
			MysiteCredentials mysitecredential = (MysiteCredentials) sessionFactory.getCurrentSession()
					.createQuery("from MysiteCredentials where credentialemail='" + email + "' ").uniqueResult();
			return mysitecredential;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updatepassword(MysiteCredentials mysitecredential) {
		try {
			sessionFactory.getCurrentSession().update(mysitecredential);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	@Override
	public MysiteCredentials SelectOneUser(String email) {
		try {
			MysiteCredentials mysiteCredentials = (MysiteCredentials) sessionFactory.getCurrentSession()
					.createQuery("from MysiteCredentials where credentialemail ='" + email+"'").uniqueResult();
			return mysiteCredentials;
		} catch (Exception e) {
			MysiteCredentials mysiteCredentials = new MysiteCredentials();
			return mysiteCredentials;
		}
	}

}
