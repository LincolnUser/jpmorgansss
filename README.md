# jpmorgansss
<h1>Assignment &ndash; Super Simple Stocks</h1>
<h2>Requirements</h2>
<p>1.Provide working source code that will :-</p>
<p>a. For a given stock,</p>
<ol style="list-style-type: lower-roman;">
<li>calculate the dividend yield</li>
<li>calculate the P/E Ratio</li>
<li>record a trade, with timestamp, quantity of shares, buy or sell indicator and price</li>
<li>Calculate Stock Price based on trades recorded in past 15 minutes</li>
</ol>
<p>b. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks</p>
<p>&nbsp;</p>
<h1><span style="text-decoration: underline;">Constraints &amp; Notes</span></h1>
<ol style="list-style-type: upper-roman;">
<li>Written in one of these languages:
<ul>
<li>&nbsp;Java, C#, C++, Python</li>
</ul>
</li>
<li>No database or GUI is required, all data need only be held in memory</li>
<li>&nbsp;Formulas and data provided are simplified representations for the purpose of this exercise</li>
</ol>
<p>&nbsp;</p>
<h1><span style="text-decoration: underline;">Classes and Enums</span></h1>
<p>&nbsp;</p>
<ul>
<li>com.jpmorgan.sss.main.MainApp - The main test Class</li>
<li>com.jpmorgan.sss.model.GBCE</li>
<li>com.jpmorgan.sss.model.Stock</li>
<li>com.jpmorgan.sss.model.StockType</li>
<li>com.jpmorgan.sss.model.Trade</li>
<li>com.jpmorgan.sss.model.TradeType</li>
<li>com.jpmorgan.sss.model.Utils</li>
</ul>
<p>&nbsp;</p>
<h1><span style="text-decoration: underline;">How to use:</span></h1>
<p><br />The project was build using maven, so you can run these 2 goals:<br /><br />&nbsp;&nbsp;&nbsp; <strong>mvn test -&gt; to execute the unit tests.</strong><br /><strong>&nbsp;&nbsp;&nbsp; mvn package -&gt; to generate the executable jar.</strong><br /><br />To run the program just run:<br /><br />&nbsp;&nbsp;&nbsp; <strong>java -jar target/stocks-0.0.1-SNAPSHOT.jar</strong><br /><br /></p>
<p>&nbsp;</p>

