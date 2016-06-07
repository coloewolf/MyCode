package beans;

public class TradingInf {

	private int TradingId;
	private int TradingGoodsId;
	private int TradingUserId;
	private int TradingNumber;
	
	public TradingInf(){}

	public TradingInf(int tradingId, int tradingGoodsId, int tradingUserId,
			int tradingNumber) {
		TradingId = tradingId;
		TradingGoodsId = tradingGoodsId;
		TradingUserId = tradingUserId;
		TradingNumber = tradingNumber;
	}

	public int getTradingId() {
		return TradingId;
	}

	public void setTradingId(int tradingId) {
		TradingId = tradingId;
	}

	public int getTradingGoodsId() {
		return TradingGoodsId;
	}

	public void setTradingGoodsId(int tradingGoodsId) {
		TradingGoodsId = tradingGoodsId;
	}

	public int getTradingUserId() {
		return TradingUserId;
	}

	public void setTradingUserId(int tradingUserId) {
		TradingUserId = tradingUserId;
	}

	public int getTradingNumber() {
		return TradingNumber;
	}

	public void setTradingNumber(int tradingNumber) {
		TradingNumber = tradingNumber;
	}
	
	
	
}
