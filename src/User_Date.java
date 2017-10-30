import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class User_Date{
	String cmte_id;
	String date;
	String id_date;
	double amount;
	List<Double> list;
	
	public User_Date(String id, String date, double amount) {
		this.cmte_id = id;
		this.date = date;
		this.amount = amount;
		this.id_date = id+date;
		list = new ArrayList<>();
	}

	public void setTotalAmount(double d) {
		this.amount = d;		
	}
	
	public void addAmount(double curr_amount){
		list.add(curr_amount);
	}
	
	public int getCount() {
		return list.size();
	}
	
	public int getMedian(){
		Double median = (double) 0;
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

