package com.alex.library.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import com.alex.library.model.AppUser;

@Stateless
public class UserRepoImpl implements UserRepo {
	@PersistenceContext(unitName = "mysqlPU")
	private EntityManager em;
	static Logger logger = Logger.getLogger(UserRepoImpl.class);

	@Override
	public AppUser getUserById(Long id) {
		return em.find(AppUser.class, id);
	}

	@Override
	public AppUser saveUser(AppUser appUser) {
		logger.debug("User inserted : " + appUser);
		em.persist(appUser);
		return appUser;
	}

	@Override
	public void deleteUser(Long id) {
		AppUser appUser = em.find(AppUser.class, id);
		if (appUser == null)
			return;
		logger.info("User deleted : " + appUser);
		em.remove(appUser);
	}

	@Override
	public AppUser updateUser(AppUser appUser) {
		logger.debug("Updated user : " + appUser);
		em.merge(appUser);
		return appUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppUser> getAll() {
		javax.persistence.Query q = em.createQuery("SELECT a FROM AppUser a", AppUser.class);
		logger.debug("All users queried :" + q.getResultList());
		if (q.getResultList().isEmpty())
			return null;
		return (List<AppUser>) q.getResultList();
	}

	@Override
	public AppUser getUserByName(String name) {
		Query q = em.createQuery("SELECT a FROM AppUser a WHERE a.username = :name", AppUser.class);
		q.setParameter("name", name);
		if (q.getResultList().isEmpty())
			return null;
		return (AppUser) q.getSingleResult();
	}

	@Override
	public AppUser getUserByNameAndPassword(String name, String password) {
		Query q = em.createQuery("SELECT a FROM AppUser a WHERE a.username = :name AND a.password = :pass",
				AppUser.class);
		q.setParameter("name", name);
		q.setParameter("pass", password);
		if (q.getResultList().isEmpty())
			return null;
		return (AppUser) q.getSingleResult();
	}
}
