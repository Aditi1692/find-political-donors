

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class User_Zipcode{
	String cmte_id;
	String zipcode;
	String id_zipCode;
	double amount;
	List<Double> list;
	CalculateMedian median;
	
	public User_Zipcode(String id, String zipcode, double amount) {
		this.cmte_id = id;
		this.zipcode = zipcode;
		this.amount = amount;
		this.id_zipCode = id+zipcode;
		list = new ArrayList<>();
		median = new CalculateMedian();
	}

	public void addAmount(double curr_amount){
		//list.add(curr_amount);
		median.addNum(curr_amount);
	}
	
	public void setTotalAmount(int amount) {
		this.amount = amount;		
	}

	public int getCount() {
		return median.getSize();
	}
	
	public int getMedian(){
		return median.findMedian();
	}
}
