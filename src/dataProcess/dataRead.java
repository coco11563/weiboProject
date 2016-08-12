package dataProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import model.userData;

public class dataRead {
	private static String train_path = "./data/weibo_train_data.txt";
	private static String predict_data = "./data/weibo_predict_data.txt";
	/**
	 * 初始化时间大概需要11~12秒，属于可以接受，不需要使用数据库
	 * @param path
	 */
	
	public static LinkedList<userData> readFile(String path)
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
				long start = new Date().getTime();
				read = new InputStreamReader(new FileInputStream(f),encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
	            String lineTxt = null;
	            while((lineTxt = bufferedReader.readLine()) != null){
	            	
                    li.add(readLine(lineTxt));
                }
	            bufferedReader.close();
	            read.close();
	            System.gc();
	            long end = new Date().getTime();
	            System.out.println("初始化数据共用："+(-start + end)/1000+"'s");
			} catch (IOException e) {
				System.out.println("exception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return li;
		
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
	public static void main(String args[]){
	}
	/**
	 * @return the predict_data
	 */
	public static String getPredict_data() {
		return predict_data;
	}
	/**
	 * @param predict_data the predict_data to set
	 */
	public static void setPredict_data(String predict_data) {
		dataRead.predict_data = predict_data;
	}
	/**
	 * @return the train_path
	 */
	public static String getTrain_path() {
		return train_path;
	}
	/**
	 * @param train_path the train_path to set
	 */
	public static void setTrain_path(String train_path) {
		dataRead.train_path = train_path;
	}

}
