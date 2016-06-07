package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcConn;
import beans.Profit;

public class Service {
	
	private Connection dbconnection;
	private Statement st,st1,st2;
	private ResultSet rs,rs1,rs2;
	private String sql;
	private List list;
	private Profit pf;
	
	public List getProfit(){
		list = new ArrayList();
		dbconnection = JdbcConn.getConnection();
		try {
			st = dbconnection.createStatement();
			st1 = dbconnection.createStatement();
			st2 = dbconnection.createStatement();
			sql = "SELECT g.Good_Name,g.Selling_Price,g.Good_Price,g.Good_Id "
					+ "FROM Goods AS g , TradingInf AS t "
					+ "WHERE t.Trading_Goods_Id = g.Good_Id GROUP BY g.Good_Name;";
			
			rs = st.executeQuery(sql);
			int temp;
			while(rs.next()){
				pf = new Profit();
				pf.setGoodsName(rs.getString("Good_Name"));
				pf.setCostPrice(rs.getInt("Good_Price"));
				pf.setSellingPrice(rs.getInt("Selling_Price"));
				pf.setGoodsId(rs.getInt("Good_Id"));
				
				temp = 0;
				temp = pf.getSellingPrice() - pf.getCostPrice();
				sql = "SELECT SUM(t.Trading_Number) AS sumNum FROM TradingInf AS t WHERE t.Trading_Goods_Id =" + pf.getGoodsId();
				rs1 = st1.executeQuery(sql);
				while(rs1.next()){
					pf.setTradingNum(rs1.getInt("sumNum"));
				}
				pf.setProfit(temp * pf.getTradingNum());
				sql = "SELECT COUNT(t.Trading_Id) AS times FROM TradingInf AS t WHERE t.Trading_Goods_Id = " + pf.getGoodsId();
				rs2 = st2.executeQuery(sql);
				while(rs2.next()){
					pf.setTimes(rs2.getInt("times"));
				}
				list.add(pf);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
}
