package dataStore;

import dataStore.DSFactory;
import dataStore.ADS;
import except.ExtenException;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DSFactoryTest {
	private String type;
	private String ds;
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ "1.csv", "DS_CSV" }, 
				{ "1.xml", "DS_XML" },
				{ "1.json", "DS_JSON" },
				{ "1.yaml", "DS_YAML" },
				{ "1.db", "DS_DB" },
                                { "1.mock", "DS_Mock" },
                                { "1.net", "DS_Net_Client" },
				};
		return Arrays.asList(data);
	}
	
	public DSFactoryTest(String file, String ds) {
		this.type = file;
		this.ds = ds;
	}
	
	@Test
	public void test() throws ExtenException {
		ADS iDS = DSFactory.getInstance(type);
		assertEquals(ds, iDS == null ? null : iDS.getClass().getSimpleName());
	}

	@Test
	public void testSingleton() throws ExtenException {
		assertEquals(DSFactory.getInstance(type), DSFactory.getInstance(type));
	}
}