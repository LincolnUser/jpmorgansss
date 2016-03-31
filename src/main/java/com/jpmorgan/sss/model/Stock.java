/**
 * 
 */
package com.jpmorgan.sss.model;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * @author Tayo
 *
 */
public class Stock {

	private String symbol;
	private StockType type;
	private Double lastDividend;
	private Double fixedDividend;
	private Double parValue;
    private TreeMap<Date, Trade> trades;
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return the type
	 */
	public StockType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(StockType type) {
		this.type = type;
	}
	/**
	 * @return the lastDividend
	 */
	public Double getLastDividend() {
		return lastDividend;
	}
	/**
	 * @param lastDividend the lastDividend to set
	 */
	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}
	/**
	 * @return the fixedDividend
	 */
	public Double getFixedDividend() {
		return fixedDividend;
	}
	/**
	 * @param fixedDividend the fixedDividend to set
	 */
	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	/**
	 * @return the parValue
	 */
	public Double getParValue() {
		return parValue;
	}
	/**
	 * @param parValue the parValue to set
	 */
	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
	/**
	 * @return the trades
	 */
	public TreeMap<Date, Trade> getTrades() {
		return trades;
	}
	/**
	 * @param trades the trades to set (Trades per stock)
	 */
	public void setTrades(TreeMap<Date, Trade> trades) {
		this.trades = trades;
	}
    
	public Stock(String symbol, StockType type, Double lastDividend, Double fixedDividend, Double parValue) {
		this.setSymbol(symbol);
		this.setType(type);
		this.setLastDividend(lastDividend);
		this.setFixedDividend(fixedDividend);
		this.setParValue(parValue);
		this.trades = new TreeMap<Date, Trade>();
	}

	/**
	 * Calculate the dividend of a stock given the stock price
	 * 
	 * @param price The price to use as a base to calculate the dividend
	 * @return The dividend
	 */
	public Double dividend(Double tickerPrice) {
		switch(this.getType()) {
			case COMMON:
				return this.getLastDividend()/tickerPrice;
			case PREFERRED:
				return this.getFixedDividend()*this.getParValue()/tickerPrice;
			default:
				return 0.0;
		}
	}
	
	/**
	 * Calculate P/E Ratio based on the specified price
	 * 
	 * @param price The price to use as a base to calculate the P/E ratio
	 * @return The P/E Ratio
	 */
	public Double PERatio(Double price) {
		return price/this.getLastDividend();
	}

	/**
	 * Buy stock, specifying quantity and price
	 * 
	 * @param quantity The quantity of stock to BUY
	 * @param price The price of the stock
	 */

	public void buy(Integer quantity, Double price) {
		Trade trade = new Trade(TradeType.BUY, quantity, price);
		this.trades.put(new Date(), trade);
	}
	
	
	/**
	 * Sell stock, specifying quantity and price
	 * 
	 * @param quantity TYhe quantity of stock to SELL
	 * @param price The price of the stock
	 */
	public void sell(Integer quantity, Double price) {
		Trade trade = new Trade(TradeType.SELL, quantity, price);
		this.trades.put(new Date(), trade);		
	}
	
	/**
	 * Return the current price of the stock based on the last trade price
	 * 
	 * @return The last trade price
	 */
	public Double getPrice() {
		if (this.trades.size() > 0) {
			// Uses the last trade price as price
			return this.trades.lastEntry().getValue().getPrice();
		} else {
			// No trades = price 0? :)
			return 0.0;
		}
	}
	
	/**
	 * Calculate the Volume Weighted Stock Price 
	 * 
	 * @return The Volume Weighted Stock Price
	 */
	public Double calculateVolumeWeightedStockPrice() {
		Date now = new Date();
		// Date 15 minutes ago
		Date startTime = new Date(now.getTime() - (15 * 60 * 1000));
		// Get trades for the last 15 minutes
		SortedMap<Date, Trade> trades = this.trades.tailMap(startTime);
		// Calculate
		Double volumeWeigthedStockPrice = 0.0;
		Integer totalQuantity = 0;
		for (Trade trade: trades.values()) {
			totalQuantity += trade.getQuantity();
			volumeWeigthedStockPrice += trade.getPrice() * trade.getQuantity();
		}
		return volumeWeigthedStockPrice/totalQuantity;
	}
}
