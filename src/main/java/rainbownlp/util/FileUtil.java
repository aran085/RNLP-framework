
package rainbownlp.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class FileUtil {
	public static final String DEBUG_FILE = "debug.log";
	/**
	 * Create new file if not exists
	 * @param path
	 * @return true if new file created
	 */
	public static boolean createFileIfNotExists(String path) {
		boolean result = false;
		File file = new File(path);
		if (!file.exists()) {
			try {
				result = file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	 
	 public static void appendLine(String path, String line) throws UnsupportedEncodingException, FileNotFoundException
	 {
		 File file = new File(path);
		 Writer writer = new BufferedWriter(new OutputStreamWriter(
			        new FileOutputStream(file, true), "UTF-8"));
			
			try {
				writer.write(line+"\n");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	public static void createFilewithFormat(String path,
				List<String> contentLines,String format) throws UnsupportedEncodingException, FileNotFoundException {

			File file = new File(path);
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), format));
			
			try {
				
				for(int i=0;i<contentLines.size();i++)
				{
					String line = contentLines.get(i);
					out.write(line+"\n");
				}
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}

	
	public static void createFileIfNotExists(String path,
			List<String> contentLines) {

		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				for(int i=0;i<contentLines.size();i++)
				{
					String line = contentLines.get(i);
					writer.write(line+"\n");
				}
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void createFile(String path,
			List<String> contentLines) {
		System.out.println("Creating file: "+path);
		File file = new File(path);
		
		try {
			file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(int i=0;i<contentLines.size();i++)
			{
				String line = contentLines.get(i);
				writer.write(line+"\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 
	 * @param path
	 * @return true if created
	 */
	public static boolean createFolderIfNotExists(String path) {
		boolean result = false;
		File folder = new File(path);
		if (!folder.exists() || !folder.isDirectory()) {
			result = folder.mkdirs();
		}

		return result;
	}

	public static String deleteAndCreateFolder(String path) throws IOException {
		
		boolean success_del;
		File folder = new File(path);
		success_del = deleteDirectory(folder);
		if (!success_del) {
		    // Deletion failed
			throw new IOException();
		}
		File newFolder = new File(path);

		if (newFolder.mkdir()==true)
		{
			return path;
		}
		else{
			throw new IOException();
		}

	}
  static  boolean deleteDirectory(File path) {
	    if( path.exists() ) {
	      File[] files = path.listFiles();
	      for(int i=0; i<files.length; i++) {
	         if(files[i].isDirectory()) {
	           deleteDirectory(files[i]);
	         }
	         else {
	           files[i].delete();
	         }
	      }
	    }
	    return( path.delete() );
	  }
	
	public static void CopyFileToDirectory(String file_name, String from_directory, String to_directory)
	{
	  	InputStream inStream = null;
		OutputStream outStream = null;
	 
    	try{
 
    	    File afile =new File(from_directory+"/"+file_name);
    	    File bfile =new File(to_directory+"/"+file_name);
 
    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    System.out.println("File is copied successful!");
 
    	}catch(IOException e){
    	    e.printStackTrace();
    	}
	    
	}
	
	/**
	 * Read whole file content into a string
	 * @param filePath
	 * @return The File content
	 * @throws IOException