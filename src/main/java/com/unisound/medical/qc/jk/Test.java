package com.unisound.medical.qc.jk;


import org.dom4j.DocumentException;
import org.dom4j.Node;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FastTestDocument document = new FastTestDocument(Test.class.getResourceAsStream("test.xml"));
			Node nameNode = document.selectSingleNode("//document//name");
			
			System.out.println("test.xml//document//name value is "+nameNode.getText());
			
			
			document = new FastTestDocument(Test.class.getResourceAsStream("/test.xml"));
			nameNode = document.selectSingleNode("//document//name");
			
			System.out.println("/test.xml//document//name value is "+nameNode.getText());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
