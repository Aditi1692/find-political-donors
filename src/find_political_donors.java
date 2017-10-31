

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class find_political_donors {
	private static String[] state_name = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", "AS", "DC", "FM", "GU", "MH", "MP", "PW", "PR", "VI"};
	public static void main(String[] args) {
		String line = null;
		String fileName = args[0];
		//String fileName = "C:\\Users\\ADJJAIN\\workspace\\find_political_donors\\insight_testsuite\\tests\\your-own-test\\input\\your-own-test.txt";
		//String fileName = "C:\\Users\\ADJJAIN\\workspace\\find_political_donors\\insight_testsuite\\tests\\test_1\\input\\itcont.txt";
		HashMap<String, User_Zipcode> user_zipcode = new HashMap<>();
		HashMap<String, User_Date> user_date = new HashMap<>();
		
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

          //create an print writer for writing to a file
            PrintWriter medianvals_by_date = new PrintWriter(new FileWriter(args[1]));
            //PrintWriter medianvals_by_date = new PrintWriter(new FileWriter("C:\\Users\\ADJJAIN\\workspace\\find_political_donors\\insight_testsuite\\tests\\your-own-test\\output\\medianvals_by_date.txt"));
	    
          //create an print writer for writing to a file
            PrintWriter medianvals_by_zip = new PrintWriter(new FileWriter(args[2]));
            //PrintWriter medianvals_by_zip = new PrintWriter(new FileWriter("C:\\Users\\ADJJAIN\\workspace\\find_political_donors\\insight_testsuite\\tests\\your-own-test\\output\\medianvals_by_zip.txt"));
           
            
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                String[] input = line.split("\\|");
                //System.out.println("ID "+str[0]);
                
                // cmte_id:
                String cmte_id = input[0];
                String[] other_input = new String[3]; 
                int j=0;
                // zipcode
                String zipcode = null;
                for(j=1; j<input.length; j++){
                	if(isNumeric(input[j]) && Arrays.asList(state_name).contains(input[j-1])){
                		//System.out.println("ZIPCODE: " + input[j]);
                		zipcode = input[j++];
                		break;
                	}
                }
                String transaction_date = null;
                while(j<input.length){
                	String isDate = input[j].replace("/", "");
                	if(isNumeric(isDate)  && input[j].length() >= 8){
                		System.out.println("DATE: "+isDate);
                		transaction_date = isDate;
                		j++;
                		break;
                	}
                	j++;
                }
                
                // transaction_amt:
                String transaction_amt = null;
                while(j<input.length){
                	if(isNumeric(input[j])){
                		//System.out.println("AMOUNT: " + input[j]);
                		transaction_amt = input[j++];
                		break;
                	}
                	j++;
                }
                
                String other_id = j>=input.length?"":input[j];
                //System.out.println(" other_id: "+other_id);
            
				// if cmte_id or transaction_amt is empty or other_id is null,
				// ignore calculations in both files
				if ((cmte_id != null && cmte_id != "") && (transaction_amt!= null && transaction_amt != "") && other_id.length() == 0) {
					// check if zipcode is valid or not(empty or null)
					if (!(zipcode == null || zipcode.length() < 5)) {
						zipcode = zipcode.substring(0, 5);
						// ignore to write result in medianvals_by_zip
						// write result in medianvals_by_date
						medianvals_by_zip.print(cmte_id+"|"+zipcode+"|");
						// calculate median 
						double amount = Double.parseDouble(transaction_amt);
						double median = amount;
						int count = 1;
						// If same user with the same zipcode did the transaction 
						if (user_zipcode.containsKey(cmte_id+zipcode)){
							User_Zipcode sameUser = user_zipcode.get(cmte_id + zipcode);
							sameUser.addAmount(amount);
							amount = amount + sameUser.amount;
							count = sameUser.getCount();
							median = sameUser.getMedian();
						}else {
							User_Zipcode value = new User_Zipcode(cmte_id, zipcode, median);
							value.addAmount(amount);
							user_zipcode.put(cmte_id+zipcode, value);
						}
						medianvals_by_zip.print(median+"|"+ count+"|"+amount);
						medianvals_by_zip.println();
					}

					// check if transaction date is valid or not
					if(transaction_date != null){
						double amount = Double.parseDouble(transaction_amt);
						// If more than 1 transaction on a particular day by a user
						if(user_date.containsKey(cmte_id+transaction_date)){
							User_Date sameUser = user_date.get(cmte_id+transaction_date);
							sameUser.addAmount(amount);
							sameUser.setTotalAmount(amount+sameUser.amount);
						}else{
							User_Date user = new User_Date(cmte_id, transaction_date, amount);
							user.addAmount(amount);
							user_date.put(cmte_id+transaction_date, user);
						}
					}
				}
            }
            // sort the map lexicographically
            SortedSet<String> keys = new TreeSet<String>(user_date.keySet());
            for (String key : keys) { 
            	User_Date user = user_date.get(key);
            	medianvals_by_date.println(user.cmte_id+"|"+user.date+"|"+user.getMedian()+"|"+user.getCount()+"|"+user.amount);
                
            }
            // Always close files.
            bufferedReader.close();   
           
            medianvals_by_date.close();
            medianvals_by_zip.close();
        }
        catch(FileNotFoundException ex) {
            /*System.out.println(
                "Unable to open file '" + 
                fileName + "'");*/
        	ex.printStackTrace();
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
