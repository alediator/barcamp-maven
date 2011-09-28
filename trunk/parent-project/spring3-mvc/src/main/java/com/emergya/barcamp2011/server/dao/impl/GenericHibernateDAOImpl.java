package com.emergya.barcamp2011.server.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.emergya.barcamp2011.server.dao.GenericDAO;

/**
 * Based on http://community.jboss.org/docs/DOC-13955
 * @param <T> entity type
 * @param <ID> primary key
 */
public abstract class GenericHibernateDAOImpl<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID> {

	private Class<T> persistentClass;

	@Autowired
    public void init(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @SuppressWarnings({"unchecked"})
    public GenericHibernateDAOImpl() {
        try {
            persistentClass = (Class<T>)
                    ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (ClassCastException e) {
            //can be raised when DAO is inherited twice
            persistentClass = (Class<T>)
                    ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }

	@SuppressWarnings("unchecked")
	public T findById(Long id, boolean lock) {
		T entity;
        if (lock) {
            entity = (T) getHibernateTemplate().get(persistentClass, id, LockMode.PESSIMISTIC_WRITE);
        } else {
            entity = (T) getHibernateTemplate().get(persistentClass, id);
        }

		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        DetachedCriteria crit = DetachedCriteria.forClass(persistentClass);
        Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return getHibernateTemplate().findByCriteria(crit);
	}

	@SuppressWarnings("unchecked")
	public T makePersistent(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	public void makeTransient(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... detachedCriterias) {
		DetachedCriteria crit = DetachedCriteria.forClass(persistentClass);
		for (Criterion c : detachedCriterias) {
			crit.add(c);
		}
		return getHibernateTemplate().findByCriteria(crit);
	}

}