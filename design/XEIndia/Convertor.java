public class Convertor{
	public static void main(String[] args){
		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		currencyConvertor.setUSD(65);
		currencyConvertor.setGBP(80);
		currencyConvertor.setEuro(69);
		CurrencyChecker observer1 = new CurrencyChecker(currencyConvertor);
		currencyConvertor.setUSD(66);
		currencyConvertor.setGBP(85);
		currencyConvertor.setEuro(75);
		CurrencyChecker observer2 = new CurrencyChecker(currencyConvertor);
		currencyConvertor.setUSD(64);
		currencyConvertor.setGBP(81);
		currencyConvertor.setEuro(72);
		CurrencyChecker observer3 = new CurrencyChecker(currencyConvertor);
		currencyConvertor.setUSD(67);
		currencyConvertor.setGBP(82);
		currencyConvertor.setEuro(70);
		currencyConvertor.remove(observer2);
		currencyConvertor.setUSD(65);
		currencyConvertor.setGBP(80);
		currencyConvertor.setEuro(69);

	}
}