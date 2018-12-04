package com.unisound.medical.qc.jk;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.DocumentException;

public class FastDocumentUtil {

	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static List<FastTestDocument> listByPath(File path){
		return listByPath(path, 0);
	}
	
	/**
	 * 
	 * @param path
	 * @param deepth
	 * @return
	 */
	public static List<FastTestDocument> listByPath(File path, int deepth){ 
		
		List<FastTestDocument> docs = new LinkedList<FastTestDocument>();
		
		try {
			if(!path.exists()) {
				throw new RuntimeException("文件/路径不存在");
			}
			
			//判断是否是文件
			if(path.isFile()) {
				try {
					FastTestDocument document = new FastTestDocument(path);
					docs.add(document);
				}catch(DocumentException e) { //不是xml文件
					System.err.println("解析文件失败："+path.getAbsolutePath());
					//e.printStackTrace();
				}
				return docs;
			}

			//如果不是文件，且超过深度，直接返回
			if(deepth < 0) {
				return docs;
			}
			
			//遍历目录下的所有文件、路径
			File[] files = path.listFiles();
			for(File file : files) {
				List<FastTestDocument> dlist = listByPath(file, --deepth);
				docs.addAll(dlist);
			}
			
		}catch(Exception e) {
			throw new RuntimeException("解析路径["+path+"]发生错误",e);
		}
		
		return docs;
	}
	
}
