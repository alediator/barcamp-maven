package com.emergya.barcamp2011.server.dao.impl;

import org.springframework.stereotype.Repository;

import com.emergya.barcamp2011.server.dao.DummyDAO;
import com.emergya.barcamp2011.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link com.emergya.barcamp2011.server.dao.impl.GenericHibernateDAOImpl} methods
 */
@Repository
public class DummyDAOImpl extends GenericHibernateDAOImpl<DummyEntity, Long> implements DummyDAO {
    
}
