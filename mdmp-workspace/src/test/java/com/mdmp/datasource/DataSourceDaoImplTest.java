package com.mdmp.datasource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-test.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class DataSourceDaoImplTest {
	@Resource(name="dataSourceDao")
	private DataSourceDao dsDAO;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateAndGet() {
		DataSource dsA = new DataSource();
		dsA.setId("dsId001");
		dsA.setName("aaa");
		dsA.setAid("appId1");
		dsA.setDescription("description");
		dsDAO.create(dsA);
		DataSource dsB = dsDAO.get("dsId001");
    	assertEquals(dsA.getAid(), dsB.getAid());
    	assertEquals(dsA.getId(), dsB.getId());
    	assertEquals(dsA.getName(), dsB.getName());
    	assertEquals(dsA.getDescription(), dsB.getDescription());
    	System.out.println(dsB.getCreatedTime());
	}

	@Test
	public void testListDataSourceByApp() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

}
