package exchange_rate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* Currency conversion service class
* Responsible for the business logic of currency conversion, independent of the UI
*/
public class ExchangeRateService {

	private final String[] currencies;
	private final double[] rates;
	private final Map<String, Integer> currencyIndexMap;

	/**
	* Constructor, initializes currency types and exchange rates
	* @param currencies Array of currency names
	* @param rates Exchange rate relative to the base currency (the first one)
	*/
	public ExchangeRateService(String[] currencies, double[] rates) {
		if (currencies.length != rates.length) {
			throw new IllegalArgumentException("The number of currency types and the number of exchange rates must be the same");
		}
		if (currencies.length == 0) {
			throw new IllegalArgumentException("The number of currency types cannot be 0");
		}
		
		this.currencies = currencies;
		this.rates = rates;
		this.currencyIndexMap = new HashMap<>();
		
		for (int i = 0; i < currencies.length; i++) {
			currencyIndexMap.put(currencies[i], i);
		}
	}

	/**
	* Convert amount
	* @param amount Input amount
	* @param fromCurrency Source currency name
	* @param toCurrency Target currency name
	* @return Converted amount
	* @throws IllegalArgumentException If the currency name is invalid
	*/
	public double convert(double amount, String fromCurrency, String toCurrency) {
		Integer fromIndex = currencyIndexMap.get(fromCurrency);
		Integer toIndex = currencyIndexMap.get(toCurrency);
		
		if (fromIndex == null) {
			throw new IllegalArgumentException("Unknown source currency: " + fromCurrency);
		}
		if (toIndex == null) {
			throw new IllegalArgumentException("Unknown target currency: " + toCurrency);
		}
		
		// Conversion formula: Amount * Target exchange rate / Source exchange rate
		return amount * rates[toIndex] / rates[fromIndex];
	}

	/**
	* Get all supported currencies
	* @return array of currency names
	*/
	public String[] getCurrencies() {
		return currencies.clone();
	}

	/**
	* Get the exchange rate of a currency (relative to the base currency)
	* @param currency Currency name
	* @return exchange rate
	* @throws IllegalArgumentException if the currency name is invalid
	*/
	public double getRate(String currency) {
		Integer index = currencyIndexMap.get(currency);
		if (index == null) {
			throw new IllegalArgumentException("Unknown currency: " + currency);
		}
		return rates[index];
	}
}