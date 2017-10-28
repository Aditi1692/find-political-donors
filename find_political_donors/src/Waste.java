
public class Waste {
	public static void main(String[] args) {
		String s = "AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MA, MI, MN, MS, MO, MT, NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK, OR, PA, RI, SC, SD, TN, TX, UT, VT, VA, WA, WV, WI, WY, AS, DC, FM, GU, MH, MP, PW, PR, VI";
		System.out.println(s.replace(",", ""));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',') {
				sb.append("\"");
			}
			sb.append(s.charAt(i));
			if (s.charAt(i) == ' ') {
				sb.append("\"");
			}
		}
		
		System.out.println(sb.toString());
	}
}