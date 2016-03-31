/**
 * 
 */
package com.jpmorgan.sss.model;

import java.util.Date;

/**
 * @author Tayo
 *
 */
public class Trade { 
			
		private TradeType type;
		private Integer quantity;
		private Double price;
        private Date timestamp;
        private String stock;
		

		public TradeType getType() {
			return type;
		}

		public void setType(TradeType type) {
			this.type = type;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}
		

		/**
		 * @return the timestamp
		 */
		public Date getTimestamp() {
			return timestamp;
		}

		/**
		 * @param timestamp the timestamp to set
		 */
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		
		
		/**
		 * @return the stock
		 */
		public String getStock() {
			return stock;
		}

		/**
		 * @param stock the stock to set
		 */
		public void setStock(String stock) {
			this.stock = stock;
		}

		public Trade(TradeType type, Integer quantity, Double price) {
			this.setType(type);
			this.setQuantity(quantity);
			this.setPrice(price);
		}

		public Trade(TradeType type, Integer quantity, Double price, Date timestamp) {
			this.setType(type);
			this.setQuantity(quantity);
			this.setPrice(price);
			this.setTimestamp(timestamp);
		}
		public Trade(TradeType type, Integer quantity, Double price, Date timestamp, String stock) {
			this.setType(type);
			this.setQuantity(quantity);
			this.setPrice(price);
			this.setTimestamp(timestamp);
			this.setStock(stock);
		}
		
		/**
		@Override
		public String toString() {
			return "Trade [type=" + type + ", quantity=" + quantity + ", price="
					+ price + "]";
		}
		*/
		
		@Override
		public String toString() {
			String pattern = "Trade Object [timeStamp: %tF %tT, stock: %s, indicator: %s, shares quantity: %7d, price: %8.2f]";
			return String.format(pattern, timestamp, stock, type, quantity, price);
		}
		
	}
