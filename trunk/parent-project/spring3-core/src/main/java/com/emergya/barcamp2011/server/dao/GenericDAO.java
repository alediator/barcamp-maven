package com.emergya.barcamp2011.server.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Based on http://community.jboss.org/docs/DOC-13955
 * @param <T> entity type
 * @param <ID> primary key
 *
 * @see com.emergya.barcamp2011.server.dao.impl.GenericHibernateDAOImpl
 */
public interface GenericDAO<T, ID extends Serializable> {

    T findById(ID id, boolean lock);

    List<T> findAll();

    List<T> findByExample(T exampleInstance, String[] excludeProperty);

    T makePersistent(T entity);

    void makeTransient(T entity);
}
