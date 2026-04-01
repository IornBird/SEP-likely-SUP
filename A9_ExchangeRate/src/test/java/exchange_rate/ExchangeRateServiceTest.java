package exchange_rate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Currency conversion service test")
public class ExchangeRateServiceTest {

	private ExchangeRateService service;
	private final String[] currencies = { "美元", "台幣", "日圓", "歐元", "人民幣" };
	private final double[] rates = { 1, 29.42, 124.819687, 0.913381, 6.347357 };

	@BeforeEach
	void setUp() {
		service = new ExchangeRateService(currencies, rates);
	}

	@Test
	@DisplayName("同貨幣轉換，應回傳相同數值")
	void testSameCurrencyConversion() {
		double result = service.convert(100, "美元", "美元");
		assertEquals(100.0, result, 0.0001, "同貨幣轉換，應回傳相同數值");
	}

	@Test
	@DisplayName("美元轉台幣")
	void testUsdToTwd() {
		double result = service.convert(1, "美元", "台幣");
		assertEquals(29.42, result, 0.0001, "1美元應該等於29.42台幣");
	}

	@Test
	@DisplayName("台幣轉美元")
	void testTwdToUsd() {
		double result = service.convert(29.42, "台幣", "美元");
		assertEquals(1.0, result, 0.0001, "29.42台幣應該等於1美元");
	}

	@Test
	@DisplayName("美元轉日圓")
	void testUsdToJpy() {
		double result = service.convert(1, "美元", "日圓");
		assertEquals(124.819687, result, 0.0001, "1美元應該等於124.819687日圓");
	}

	@Test
	@DisplayName("美元轉歐元")
	void testUsdToEur() {
		double result = service.convert(1, "美元", "歐元");
		assertEquals(0.913381, result, 0.0001, "1美元應該等於0.913381歐元");
	}

	@Test
	@DisplayName("美元轉人民幣")
	void testUsdToCny() {
		double result = service.convert(1, "美元", "人民幣");
		assertEquals(6.347357, result, 0.0001, "1美元應該等於6.347357人民幣");
	}

	@Test
	@DisplayName("轉換大金額")
	void testLargeAmountConversion() {
		double result = service.convert(1000, "美元", "台幣");
		assertEquals(29420.0, result, 0.0001, "1000美元應該等於29420台幣");
	}

	@Test
	@DisplayName("轉換小數金額")
	void testDecimalAmountConversion() {
		double result = service.convert(0.5, "美元", "台幣");
		assertEquals(14.71, result, 0.0001, "0.5美元應該等於14.71台幣");
	}

	@Test
	@DisplayName("轉換零金額")
	void testZeroAmountConversion() {
		double result = service.convert(0, "美元", "台幣");
		assertEquals(0.0, result, 0.0001, "0美元應該等於0台幣");
	}

	@Test
	@DisplayName("非直接轉換")
	void testIndirectConversion() {
		// 台幣轉歐元（不直接，需透過美元轉接）
		double result = service.convert(1, "台幣", "歐元");
		double expected = 1.0 * 0.913381 / 29.42; // 1台幣到美元再到歐元
		assertEquals(expected, result, 0.0001);
	}

	@Test
	@DisplayName("無效的來源貨幣應拋出例外")
	void testInvalidFromCurrency() {
		assertThrows(IllegalArgumentException.class, () -> service.convert(100, "無效貨幣", "美元"), "無效的來源貨幣應拋出例外");
	}

	@Test
	@DisplayName("無效的目標貨幣應拋出例外")
	void testInvalidToCurrency() {
		assertThrows(IllegalArgumentException.class, () -> service.convert(100, "美元", "無效貨幣"), "無效的目標貨幣應拋出例外");
	}

	@Test
	@DisplayName("getCurrencies應回傳所有支援的貨幣")
	void testGetCurrencies() {
		String[] result = service.getCurrencies();
		assertArrayEquals(currencies, result, "getCurrencies應回傳所有支援的貨幣");
	}

	@Test
	@DisplayName("getCurrencies應該回傳新的陣列副本")
	void testGetCurrenciesReturnsClo​​ne() {
		String[] result1 = service.getCurrencies();
		String[] result2 = service.getCurrencies();
		assertNotSame(result1, result2, "getCurrencies應該回傳新的陣列副本");
	}

	@Test
	@DisplayName("取得貨幣匯率")
	void testGetRate() {
		assertEquals(1.0, service.getRate("美元"), 0.0001);
		assertEquals(29.42, service.getRate("台幣"), 0.0001);
		assertEquals(124.819687, service.getRate("日圓"), 0.0001);
	}

	@Test
	@DisplayName("取得無效貨幣的匯率，應拋出例外")
	void testGetRateInvalidCurrency() {
		assertThrows(IllegalArgumentException.class, () -> service.getRate("無效貨幣"), "取得無效貨幣的匯率，應拋出例外");
	}

	@Test
	@DisplayName("建構子 - 貨幣數與匯率數不符，應拋出例外")
	void testConstructorMismatchedArrays() {
		String[] testCurrencies = { "美元", "台幣" };
		double[] testRates = { 1, 29.42, 124.819687 }; // 不同長度

		assertThrows(IllegalArgumentException.class, () -> new ExchangeRateService(testCurrencies, testRates),
				"貨幣數與匯率數不符，應拋出例外");
	}

	@Test
	@DisplayName("建構子 - 空數列要拋出例外")
	void testConstructorEmptyArrays() {
		String[] testCurrencies = {};
		double[] testRates = {};

		assertThrows(IllegalArgumentException.class, () -> new ExchangeRateService(testCurrencies, testRates),
				"空數列要拋出例外");
	}
}
