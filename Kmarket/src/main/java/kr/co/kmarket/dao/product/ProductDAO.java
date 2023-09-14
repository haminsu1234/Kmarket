package kr.co.kmarket.dao.product;


import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL_product;
import kr.co.kmarket.dto.product.ProductDTO;


public class ProductDAO extends DBHelper{

	private static ProductDAO instace = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instace;
	}
	
	private ProductDAO() {
	
	}
	
	public void insertProduct(ProductDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_product.INSERT_PRODUCT);
			
			   	psmt.setInt(1, dto.getProdNo());
	            psmt.setInt(2, dto.getProdCate1());
	            psmt.setInt(3, dto.getProdCate2());
	            psmt.setString(4, dto.getProdName());
	            psmt.setString(5, dto.getDescript());
	            psmt.setString(6, dto.getSeller());
	            psmt.setString(7, dto.getCompany());
	            psmt.setInt(8, dto.getPrice());
	            psmt.setInt(9, dto.getDiscount());
	            psmt.setInt(10, dto.getPoint());
	            psmt.setInt(11, dto.getStock());
	            psmt.setInt(12, dto.getSold());
	            psmt.setInt(13, dto.getDelivery());
	            psmt.setInt(14, dto.getHit());
	            psmt.setInt(15, dto.getScore());
	            psmt.setInt(16, dto.getReview());
	            psmt.setString(17, dto.getThumb1());
	            psmt.setString(18, dto.getThumb2());
	            psmt.setString(19, dto.getThumb3());
	            psmt.setString(20, dto.getDetail());
	            psmt.setString(21, dto.getStatus());
	            psmt.setString(22, dto.getDuty());
	            psmt.setString(23, dto.getReceipt());
	            psmt.setString(24, dto.getBizType());
	            psmt.setString(25, dto.getOrigin());
	            psmt.setString(26, dto.getIp());
	            psmt.setString(27, dto.getRdate());
	            psmt.setInt(28, dto.getEtc1());
	            psmt.setInt(29, dto.getEtc2());
	            psmt.setString(30, dto.getEtc3());
	            psmt.setString(31, dto.getEtc4());
	            psmt.setString(32, dto.getEtc5());
	            
	            psmt.executeUpdate();
	            close();
	            
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ProductDTO selectProduct(int prodNo) {
		ProductDTO dto = new ProductDTO();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_product.SELECT_PRODUCT);
			psmt.setInt(1, prodNo);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
	            dto = new ProductDTO();
	            dto.setProdNo(rs.getInt("prodNo"));
	            dto.setProdCate1(rs.getInt("prodCate1"));
	            dto.setProdCate2(rs.getInt("prodCate2"));
	            dto.setProdName(rs.getString("prodName"));
	            dto.setDescript(rs.getString("descript"));
	            dto.setSeller(rs.getString("seller"));
	            dto.setCompany(rs.getString("company"));
	            dto.setPrice(rs.getInt("price"));
	            dto.setDiscount(rs.getInt("discount"));
	            dto.setPoint(rs.getInt("point"));
	            dto.setStock(rs.getInt("stock"));
	            dto.setSold(rs.getInt("sold"));
	            dto.setDelivery(rs.getInt("delivery"));
	            dto.setHit(rs.getInt("hit"));
	            dto.setScore(rs.getInt("score"));
	            dto.setReview(rs.getInt("review"));
	            dto.setThumb1(rs.getString("thumb1"));
	            dto.setThumb2(rs.getString("thumb2"));
	            dto.setThumb3(rs.getString("thumb3"));
	            dto.setDetail(rs.getString("detail"));
	            dto.setStatus(rs.getString("status"));
	            dto.setDuty(rs.getString("duty"));
	            dto.setReceipt(rs.getString("receipt"));
	            dto.setBizType(rs.getString("bizType"));
	            dto.setOrigin(rs.getString("origin"));
	            dto.setIp(rs.getString("ip"));
	            dto.setRdate(rs.getString("rdate"));
	            dto.setEtc1(rs.getInt("etc1"));
	            dto.setEtc2(rs.getInt("etc2"));
	            dto.setEtc3(rs.getString("etc3"));
	            dto.setEtc4(rs.getString("etc4"));
	            dto.setEtc5(rs.getString("etc5"));
	        }
			close();
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }
	    return dto;
	}
	
	public List<ProductDTO> selectProducts(String prodCate1, int start) {
		
		List<ProductDTO> product = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL_product.SELECT_PRODUCTS);
			psmt.setString(1, prodCate1);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
	            dto.setProdNo(rs.getInt(1));
	            dto.setProdCate1(rs.getInt(2));
	            dto.setProdCate2(rs.getInt(3));
	            dto.setProdName(rs.getString(4));
	            dto.setDescript(rs.getString(5));
	            dto.setSeller(rs.getString(6));
	            dto.setCompany(rs.getString(7));
	            dto.setPrice(rs.getInt(8));
	            dto.setDiscount(rs.getInt(9));
	            dto.setPoint(rs.getInt(10));
	            dto.setStock(rs.getInt(11));
	            dto.setSold(rs.getInt(12));
	            dto.setDelivery(rs.getInt(13));
	            dto.setHit(rs.getInt(14));
	            dto.setScore(rs.getInt(15));
	            dto.setReview(rs.getInt(16));
	            dto.setThumb1(rs.getString(17));
	            dto.setThumb2(rs.getString(18));
	            dto.setThumb3(rs.getString(19));
	            dto.setDetail(rs.getString(20));
	            dto.setStatus(rs.getString(21));
	            dto.setDuty(rs.getString(22));
	            dto.setReceipt(rs.getString(23));
	            dto.setBizType(rs.getString(24));
	            dto.setOrigin(rs.getString(25));
	            dto.setIp(rs.getString(26));
	            dto.setRdate(rs.getString(27));
	            dto.setEtc1(rs.getInt(28));
	            dto.setEtc2(rs.getInt(29));
	            dto.setEtc3(rs.getString(30));
	            dto.setEtc4(rs.getString(31));
	            dto.setEtc5(rs.getString(32));
	            product.add(dto);
			}
			
			close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public void updateProduct(ProductDTO dto) {
		
	}
	public void deleteProduct(int prodNo) {
		
	}
	
}