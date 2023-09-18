package kr.co.kmarket.dao.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_Cart;
import kr.co.kmarket.db.SQL_product;
import kr.co.kmarket.dto.product.ProductCartDTO;

public class ProductCartDAO extends DBHelper{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	ProductCartDTO dto = null;
	// 싱글톤
	private static ProductCartDAO instance = new ProductCartDAO();
	
	public static ProductCartDAO getInstance() {
		return instance;
	}
	private ProductCartDAO() {}

	// 기본 CRUD
	public int insertCart(ProductCartDTO dto) {
		int result=0;

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_Cart.INSERT_PRODUCT_CART);
			psmt.setString(1, dto.getUid());
			psmt.setInt(2, dto.getProdNo());
			psmt.setInt(3, dto.getCount());
			psmt.setInt(4, dto.getPrice());
			psmt.setInt(5, dto.getDiscount());
			psmt.setInt(6, dto.getPoint());
			psmt.setInt(7, dto.getDelivery());
			
			result =psmt.executeUpdate();
			
			close();
		} catch (SQLException e) {
			logger.error("insertERROR : "+e.getMessage());
		}
		return result;
		
		
	}
	
	public ProductCartDTO selectCart(String uid) {
		return null;
	}
	
	public List<ProductCartDTO> selectCarts(String uid) {
		
		ProductCartDTO dto = null;
		List<ProductCartDTO> list = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_Cart.SELECT_CARTS);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				dto = new ProductCartDTO();
				dto.setCartNo(rs.getInt(1));
				dto.setUid(rs.getString(2));
				dto.setProdNo(rs.getInt(3));
				dto.setCount(rs.getInt(4));
				dto.setPrice(rs.getInt(5));
				dto.setDiscount(rs.getInt(6));
				dto.setPoint(rs.getInt(7));
				dto.setDelivery(rs.getInt(8));
				dto.setTotal(rs.getInt(9));
				dto.setRdate(rs.getString(10));
				dto.setProdName(rs.getString(11));
				dto.setDescript(rs.getString(12));
				list.add(dto);
			}
			
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateCart(ProductCartDTO dto) {
		
	}
	
	public void deleteCart(String cartNo) {
		
	}
	
}