package com.green.project.compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

	 /**
	  * @param args
	  */
	 byte doc[]=null;
	 String Filename=null;
	 String unzipPath=null;
	 
	 public Unzip(String filename,String unzippath)
	 {
	  Filename=filename;
	  unzipPath=unzippath;
	  SetUnZipPath(unzipPath);
	 }
	 
	 public Unzip(String filename)
	 {
	  Filename=filename;
	  unzipPath=null;
	  SetUnZipPath(unzipPath);
	 }
	 
	 private void SetUnZipPath(String unzippath)
	 {
	  if(unzippath.endsWith("//"))   //String类的endsWith(char c)用与判断字符串最后一个字符是否与c相同
	   unzipPath=new String(unzippath);
	  else
	   unzipPath=new String(unzippath+"//");
	 }
	 
	 public void doUnZip()
	 {
	  try {
	   ZipInputStream zin=new ZipInputStream(new FileInputStream(Filename));
	   ZipEntry fentry;     //用于表示 ZIP 文件条目
	   while((fentry=zin.getNextEntry())!=null)   //ZipInputStream类的geNextEntry()读取下一个 ZIP 文件条目并将流定位到该条目数据的开始处。
	   {
	    if(fentry.isDirectory())  //判断文件条目是否目录条目
	     checkFilePath(unzipPath+fentry.getName());
	    else
	    {
	     String fname=new String(unzipPath+fentry.getName());
	     FileOutputStream out=new FileOutputStream(fname);
	     doc=new byte[512];
	     int n;
	     while((n=zin.read(doc, 0, 512))!=-1)out.write(doc,0,n);
	                    out.close();
	                    out=null;
	                    doc=null;
	    }
	   }//while
	   zin.close();
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  
	 }
	 
	 private void checkFilePath(String dirName)throws IOException
	 {
	  File dir=new File(dirName);
	  if(!dir.exists())
	   dir.mkdirs();
	 }
	 
	 public static void main(String[] args) {
	        Unzip myZip=new Unzip("d://phonemanage.zip","d://lib");
	        myZip.doUnZip();
	        System.out.println("压缩成功");
	 }
	 

	}