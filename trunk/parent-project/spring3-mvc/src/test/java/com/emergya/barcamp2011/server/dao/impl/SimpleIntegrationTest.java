package com.emergya.barcamp2011.server.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.emergya.barcamp2011.ApplicationContextAwareTest;
import com.emergya.barcamp2011.server.dao.DummyDAO;
import com.emergya.barcamp2011.server.entity.DummyEntity;

import static org.junit.Assert.assertEquals;

/**
 * 
 */
public class SimpleIntegrationTest extends ApplicationContextAwareTest {

    @Resource
    private DummyDAO dummyDAO;

    /**
     * Tries to store {@link com.emergya.barcamp2011.server.entity.DummyEntity}.
     */
    @Test
    public void testPersistTestEntity() {
        int countBefore = dummyDAO.findAll().size();
        DummyEntity dummyEntity = new DummyEntity();
        dummyDAO.makePersistent(dummyEntity);

        int countAfter = dummyDAO.findAll().size();
        assertEquals(countBefore + 1, countAfter);
    }
}
