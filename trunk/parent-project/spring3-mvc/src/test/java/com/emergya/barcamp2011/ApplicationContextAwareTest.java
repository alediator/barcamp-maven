package com.emergya.barcamp2011;


import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class fo unit tests with spring context.
 * <p>
 * Each method is run within a transaction which is rolled back when method is over.
 * Hibernate sessions which used in tests are have {@link org.hibernate.FlushMode#ALWAYS}
 *
 * @see org.springframework.test.context.transaction.TransactionConfiguration
 * @see org.springframework.transaction.annotation.Transactional
 * @see org.hibernate.Session#setFlushMode(org.hibernate.FlushMode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public abstract class ApplicationContextAwareTest {

    @Autowired
    public SessionFactory sessionFactory;

    @Before
    public void beforeMethod() {
        sessionFactory.getCurrentSession().setFlushMode(FlushMode.ALWAYS);
    }

    @After
    public void afterMethod() {
        // nothing
    }
    
}
