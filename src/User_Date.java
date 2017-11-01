import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class User_Date{
	String cmte_id;
	String date;
	String id_date;
	double amount;
	List<Double> list;
	CalculateMedian median;
	
	public User_Date(String id, String date, double amount) {
		this.cmte_id = id;
		this.date = date;
		this.amount = amount;
		this.id_date = id+date;
		list = new ArrayList<>();
		median = new CalculateMedian();
	}

	public void setTotalAmount(double d) {
		this.amount = d;		
	}
	
	public void addAmount(double curr_amount){
		//list.add(curr_amount);
		median.addNum(curr_amount);
	}
	
	public int getCount() {
		return median.getSize();
	}
	
	public int getMedian(){
		return median.findMedian();
	}
}

