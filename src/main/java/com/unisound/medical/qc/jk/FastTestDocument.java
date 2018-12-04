package com.unisound.medical.qc.jk;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class FastTestDocument {

	private Document document;
	private String absolutePath;
	private String filename;
	
	public FastTestDocument(File file) throws DocumentException {
		
		this.absolutePath = file.getAbsolutePath();
		this.filename = file.getName();
		
		SAXReader reader = new SAXReader();
        Document document = reader.read(file);
		this.document = document;
	}
	
	/**
	 * @param xpath
	 * @return
	 */
	public List<Node> selectNodes(String xpath) {
		return this.document.selectNodes(xpath);
	}
	
	/**
	 * 
	 * @param xpath
	 * @return
	 */
	public Node selectSingleNode(String xpath) {
		return this.document.selectSingleNode(xpath);
	}
	
	public Document getDocument() {
		return document;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public String getFilename() {
		return filename;
	}

}
