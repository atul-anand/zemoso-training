//: atul/assignment2/Vampire.java
// Vampire number: even no of digits formed by multiplying
// pair of numbers containing half the digits. Digits are
// from the original number on any order. Pair of trailing
// zeroes are not alllowed.

package vampire;
import java.util.*;
import java.lang.Math.*;
public class Vampire {
	static class VampComparator implements Comparator<Vamps>{
                        @Override
                public int compare(Vamps a, Vamps b) {
			return a.vamp().compareTo(b.vamp());
                    	}
                }
	static class Vamps {
		public Integer i;
		public Integer j;
		public Vamps(int i, int j){
			this.i=new Integer(i);
			this.j=new Integer(j);
		}
		public Integer vamp(){
			return new Integer(i*j);
		}
		public String toString(){
			return "("+i+","+j+"):"+(i*j);
		}
	}
	static Integer one = new Integer(1);
	static Set<Vamps> vamp = new TreeSet<Vamps>(new VampComparator());
	static Set<Integer> vamps= new TreeSet<Integer>();
        static void printSetVamps(Set<Vamps> set){
                for(Vamps i:set)
                        System.out.println(i+" ");
        }
	static void printSet(Set<Integer> set){
		for(Integer i:set)
			System.out.print(i+" ");
		System.out.println();
	}
	static boolean twoTrailingZeroes(int i){
		if(i%10==0&&((i%10)%10)==0)
			return true;
		return false;
	}
	static boolean equalDigits(int i, int j){
		int lenI = (int) Math.log10(i) + 1;
		int lenJ = (int) Math.log10(j) + 1;
		int lenT = (int) Math.log10(i*j) + 1;
		if(lenI+lenJ==lenT&&lenI==lenJ)
			return true;
		return false;
	}
	static boolean checkMapEquality(Map<Integer,Integer> map, Map<Integer,Integer> map2){
		if(map.size()!=map2.size())
			return false;
		if((map.toString()).equals(map2.toString())){
			return true;
		}
		return false;
	}
	static Map<Integer,Integer> digitsMap(Map<Integer,Integer> map, int i){
		while(i>0){
			Integer intI = new Integer(i%10);
			if(map.get(intI)!=null)
				map.put(intI,new Integer(map.get(intI)+1));
			else
				map.put(intI,one);
			i=i/10;
		}
		return map;
	}
	static void secondLevel(int j, int i){
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		map = digitsMap(map,i);
		map = digitsMap(map,j);
		Map<Integer,Integer> map2 = new TreeMap<Integer,Integer>();
		map2 = digitsMap(map2,i*j);
		if(twoTrailingZeroes(i*j))
			return;
		if(checkMapEquality(map,map2)){
			vamps.add(new Integer(i*j));
			vamp.add(new Vamps(i,j));
		}
	}
	static void listVamps(int d) {
		int llim = 1;
		int ulim = (int)Math.sqrt(Math.pow(10,d));
		for(int i=llim;i<ulim;i++){
			for(int j=i;j<ulim;j++)
				if(equalDigits(i,j))
					secondLevel(j,i);
		}
	}
	public static void main(String[] args){
		// Vampire numbers till 6 digits.
		listVamps(6);
		printSetVamps(vamp);
	}
}/* Output:
(15,93):1395 
(35,41):1435 
(21,87):1827 
(27,81):2187 
(204,516):105264 
(135,801):108135 
(158,701):110758 
(152,761):115672 
(161,725):116725 
(167,701):117067 
(231,534):123354 
(281,443):124483 
(152,824):125248 
(231,543):125433 
(201,627):126027 
(261,486):126846 
(179,725):129775 
(311,422):131242 
(315,423):133245 
(317,425):134725 
(231,588):135828 
(351,387):135837 
(215,635):136525 
(146,938):136948 
(351,414):145314 
(317,461):146137 
(156,942):146952 
(251,608):152608 
(261,585):152685 
(356,431):153436 
(269,581):156289 
(165,951):156915 
(176,926):162976 
(396,414):163944 
(221,782):172822 
(231,759):175329 
(225,801):180225 
(201,897):180297 
(216,864):186624 
(327,591):193257 
(395,491):193945 
(275,719):197725 
(252,801):201852 
(255,807):205785 
(216,981):211896 
(341,626):213466 
(323,671):216733 
(321,678):217638 
(248,881):218488 
(269,842):226498 
(276,822):226872 
(248,926):229648 
(338,692):233896 
(461,524):241564 
(422,581):245182 
(296,851):251896 
(323,806):260338 
(284,926):262984 
(437,602):263074 
(489,582):284598 
(468,612):286416 
(431,707):304717 
(431,725):312475 
(321,975):312975 
(534,591):315594 
(351,909):319059 
(336,951):319536 
(524,623):326452 
(342,963):329346 
(356,926):329656 
(392,863):338296 
(533,641):341653 
(366,948):346968 
(369,981):361989 
(392,926):362992 
(533,686):365638 
(381,969):369189 
(383,971):371893 
(431,878):378418 
(432,891):384912 
(465,831):386415 
(593,662):392566 
(446,908):404968 
(491,845):414895 
(468,891):416988 
(464,926):429664 
(476,941):447916 
(549,891):489159 
(545,899):489955 
(681,759):516879 
(572,926):529672 
(563,953):536539 
(588,951):559188 
(657,864):567648 
(788,926):729688 
(765,963):736695 
(843,876):738468 
(776,992):769792 
(825,957):789525 
(855,927):792585 
(807,984):794088 
(891,909):809919 
(894,906):809964 
(858,951):815958 
(896,926):829696 
(891,945):841995 
(953,986):939658
*///:~


