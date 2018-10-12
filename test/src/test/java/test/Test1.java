package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import testMain.IsEven;

public class Test1 {

	@Test
	public void test() {
		IsEven isEven = new IsEven();
		assertEquals(false, isEven.isEven(4));
	}
}
