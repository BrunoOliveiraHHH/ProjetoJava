package repositorio.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import repositorio.DAO;

public class GenericDAO<PersistentObject, IDType extends Serializable> extends HibernateDaoSupport
		implements DAO<PersistentObject, IDType> {

	private Class<PersistentObject> persistentClass;

	public GenericDAO(Class<PersistentObject> clazz) {
		persistentClass = clazz;
	}

	public void update(PersistentObject obj) {
		getHibernateTemplate().update(obj);
	}

	public void insert(PersistentObject obj) {
		getHibernateTemplate().save(obj);
	}

	public void remove(PersistentObject obj) {
		getHibernateTemplate().delete(obj);
	}

	public void save(PersistentObject obj) {
		getHibernateTemplate().saveOrUpdate(obj);
	}

	@SuppressWarnings("unchecked")
	public PersistentObject get(IDType id) {
		return (PersistentObject) getHibernateTemplate().get(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	public PersistentObject getByNamedQuery(String queryName, Map<String, Object> params) {
		Session session = getSession();
		Query query = session.createQuery(queryName);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		PersistentObject result;
		result = (PersistentObject) query.uniqueResult();
		return result;
	}

	@SuppressWarnings("unchecked")
	public PersistentObject getByNamedQuery(String queryName) {
		Session session = getSession();
		Query query = session.createQuery(queryName);
		PersistentObject result;
		result = (PersistentObject) query.uniqueResult();
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PersistentObject> listByNamedQuery(String queryName, Map<String, Object> params) {
		Session session = getSession();
		Query query = session.createQuery(queryName);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof List) {
					query.setParameterList(key, (List) obj);
				} else {
					query.setParameter(key, obj);
				}
			}
		}
		List<PersistentObject> list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PersistentObject> listByNamedQueryWithMaxResults(String queryName, Map<String, Object> params,
			int maxResults) {
		Session session = getSession();
		Query query = session.createQuery(queryName);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);
				if (obj instanceof List) {
					query.setParameterList(key, (List) obj);
				} else {
					query.setParameter(key, obj);
				}
			}
		}
		List<PersistentObject> list = query.setMaxResults(maxResults).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<PersistentObject> listByNamedQuery(String queryName) {
		Session session = getSession();
		Query query = session.createQuery(queryName);
		List<PersistentObject> list = query.list();
		return list;
	}

	@Override
	public void flush() {
		getSession().flush();
	}

}