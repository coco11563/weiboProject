package dataProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class dataRead {
	private static String train_path = "./data/weibo_train_data.txt";
	private static String predict_data = "./data/weibo_predict_data.txt";
	public static void readFile(String path)
	{
		LinkedList<userData> li = new LinkedList<userData>();
		File f = new File(path);
		String encoding = "UTF-8";
		if(!f.exists())
		{
			System.out.println("wrong path");
			}
		else
		{
			InputStreamReader read;
			try {
				read = new InputStreamReader(new FileInputStream(f));
				BufferedReader bufferedReader = new BufferedReader(read);
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	            	
                    li.add(readLine(lineTxt));
                }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public static userData readLine(String s){
		String[] ret = s.split("\t");
		SimpleDateFormat  sdf = new SimpleDateFormat ();
				sdf.applyPattern("yyyy-MM-dd HH:mm:ss"); 
				userData u = null;
				try {
					Date date = sdf.parse(ret[2]);
					u = new userData(ret[0],ret[1],date,Integer.parseInt(ret[3]),Integer.parseInt(ret[4]),Integer.parseInt(ret[5]),ret[6]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return u;
 	}
	public static void main(String args[])
	{
		readFile(train_path);
	}

}
