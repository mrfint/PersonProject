package dataStore;

import dataStore.DSFactory;
import dataStore.ADS;
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
				{ "csv", "DS_CSV" }, 
				{ "xml", "DS_XML" },
				{ "json", "DS_JSON" },
				{ "yaml", "DS_YAML" },
				{ "test.xaml", null },
                                { "d1xml", "DS_domXML1" },
                                { "d2xml", "DS_domXML2" },
                                { "mock", "DS_Mock" },
				};
		return Arrays.asList(data);
	}
	
	public DSFactoryTest(String file, String ds) {
		this.type = file;
		this.ds = ds;
	}
	
	@Test
	public void test() {
		ADS iDS = DSFactory.getInstance(type);
		assertEquals(ds, iDS == null ? null : iDS.getClass().getSimpleName());
	}

	@Test
	public void testSingleton() {
		assertEquals(DSFactory.getInstance(type), DSFactory.getInstance(type));
	}
}