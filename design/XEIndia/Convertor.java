public class Convertor{
	public static void main(String[] args){
		CurrencyConvertor currencyConvertor = new CurrencyConvertor(65,80,69);
		CurrencyChecker observer1 = new CurrencyChecker(currencyConvertor,13254);
		observer1.setINR(543);
		currencyConvertor.setUSD(66);
		currencyConvertor.setGBP(85);
		currencyConvertor.setEuro(75);
		CurrencyChecker observer2 = new CurrencyChecker(currencyConvertor,4322);
		observer2.setINR(435);
		currencyConvertor.setUSD(64);
		currencyConvertor.setGBP(81);
		currencyConvertor.setEuro(72);
		CurrencyChecker observer3 = new CurrencyChecker(currencyConvertor,543);
		observer3.setINR(432);
		currencyConvertor.setUSD(67);
		currencyConvertor.setGBP(82);
		currencyConvertor.setEuro(70);
		currencyConvertor.remove(2);
		currencyConvertor.setUSD(65);
		currencyConvertor.setGBP(80);
		currencyConvertor.setEuro(69);
		observer2.setINR(354);

	}
}