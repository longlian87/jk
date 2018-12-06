package com.unisound.medical.qc.jk;


import java.io.File;

import org.dom4j.DocumentException;
import org.dom4j.Node;

public class Test {

	public static void main(String[] args) {
		printXmlFile("/home/longlian/apps/work/docs");
	}
	
	private static void test1() {
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
	
	
	/**
	 * 打印一个目录（文件）下面的所有xml文档
	 * @param path
	 */
	public static void printXmlFile(String path) {
		File fpath = new File(path);
		if(fpath.isFile()) {
			printXmlFile(fpath);
			return;
		}
		
		File[] files = fpath.listFiles();
		if(files == null) {
			return;
		}
		
		for(File file : files) {
			printXmlFile(file.getPath());
		}
	}
	
	/**
	 * 打印一个xml文档
	 * @param file
	 */
	private static void printXmlFile(File file) {
		
		try {
			FastTestDocument document = new FastTestDocument(file);
			if(document!=null) {
				System.out.println("--------------------------"+document.getFilename()+"---------------------------");
				System.out.println();
				System.out.println();
				System.out.println(document.getDocument().asXML());
				System.out.println();
				System.out.println();
				
			}
		} catch (DocumentException e) {
//			e.printStackTrace();
			System.err.println("exception : " + e.getMessage());
		}
	}

}
