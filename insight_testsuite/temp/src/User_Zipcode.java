

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class User_Zipcode{
	String cmte_id;
	String zipcode;
	String id_zipCode;
	double amount;
	List<Double> list;
	
	public User_Zipcode(String id, String zipcode, double amount) {
		this.cmte_id = id;
		this.zipcode = zipcode;
		this.amount = amount;
		this.id_zipCode = id+zipcode;
		list = new ArrayList<>();
	}

	public void addAmount(double curr_amount){
		list.add(curr_amount);
	}
	
	public void setTotalAmount(int amount) {
		this.amount = amount;		
	}

	public int getCount() {
		return list.size();
	}
	
	public int getMedian(){
		double median = 0;
		Collections.sort(list);
		int size = list.size();
		if(size == 1)
			return (int) Math.round(list.get(0));
		if(size%2 != 0)
			median = list.get(size/2);
		else{
			median = (double)(list.get(size/2) + list.get((size/2)-1))/2;
			
		}
		return (int) Math.round(median);
	}
}
