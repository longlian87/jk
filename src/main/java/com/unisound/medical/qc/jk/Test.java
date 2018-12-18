package com.unisound.medical.qc.jk;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.dom4j.DocumentException;
import org.dom4j.Node;

public class Test {

	public static void main(String[] args) {
		
		String path = args[0];
		String resultPath = args[1];
		String sysoutPath = args[2];
		
		File resultFile = new File(resultPath + "/result.txt");
		File sysoutFile = new File(sysoutPath + "/evaluate.log");
		
		try {
			
			PrintWriter out = new PrintWriter(resultFile, "utf-8");
			PrintStream sysout = new PrintStream(sysoutFile, "utf-8");
			System.setOut(sysout);
			
			printXmlFile(path, out); //("/home/longlian/apps/work/docs");
			
			out.flush();
			out.close();
			
			Thread.sleep(1000*8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end of main. " + new Date());
		
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
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void printXmlFile(String path, PrintWriter out) 
			throws FileNotFoundException, UnsupportedEncodingException {
		File fpath = new File(path);
		
		if(fpath.isFile()) {
			printXmlFile(fpath);
			out.append("找到文件："+fpath+"\n");
			return;
		}
		
		File[] files = fpath.listFiles();
		if(files == null) {
			return;
		}
		
		for(File file : files) {
			printXmlFile(file.getPath(), out);
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
