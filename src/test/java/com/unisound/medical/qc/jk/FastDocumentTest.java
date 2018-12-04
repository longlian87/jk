package com.unisound.medical.qc.jk;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.junit.Test;

public class FastDocumentTest {

	@Test
	public void testRead() {
		File file = new File(FastDocumentTest.class.getResource("/test.xml").getFile());
		try {
			FastTestDocument document = new FastTestDocument(file);
			Node nameNode = document.selectSingleNode("//document//name");
			
			assertEquals("龙链", nameNode.getText());
			System.out.println("//document//name value is "+nameNode.getText());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		System.out.println("just a demo2");
	}
	
	@Test
	public void test3() {
		System.out.println("just a demo3");
	}
	
	@Test
	public void test4() {
		System.out.println("just a demo4");
	}
	
	@Test
	public void test5() {
		System.out.println("just a demo5");
	}
}
