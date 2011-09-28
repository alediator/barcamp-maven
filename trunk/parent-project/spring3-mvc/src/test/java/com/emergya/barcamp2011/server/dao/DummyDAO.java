package com.emergya.barcamp2011.server.dao;

import com.emergya.barcamp2011.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link com.emergya.barcamp2011.server.dao.impl.GenericHibernateDAOImpl} methods
 */
public interface DummyDAO extends GenericDAO<DummyEntity, Long> {
}
