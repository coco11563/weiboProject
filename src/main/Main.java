package main;

import java.util.HashMap;
import java.util.LinkedList;

import dataProcess.dataRead;
import dataProcess.dataStatistic;
import model.timeStatistic;
import model.userData;
import model.weibo;

public class Main {
public static void main(String args[])
{
	LinkedList<userData> li = dataRead.readFile(dataRead.getTrain_path());
	HashMap<Integer, timeStatistic> map = dataStatistic.processDate(li);

	  for (Integer key : map.keySet()) {
		   System.out.print("key= "+ key + " and value= ");
		    map.get(key).print_rate();
		  }
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		HashMap<Integer, weibo> map2 = dataStatistic.processContentnum(li);
	 for (Integer key : map2.keySet()) {
		   System.out.print("key= "+ key + " and value= ");
		    map2.get(key).print_rate();
		  }
	}
}
