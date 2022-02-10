package com.product.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.product.Exception.DataAccessException;

public class ProductDaoImpl implements ProductDao{

	private Connection connection=null;
	public ProductDaoImpl() {
		connection=ConnectionFactory.getConnection();
	}

	@Override
	public Product addProduct(Product product) {
		
		try {
			PreparedStatement pstmt = connection.prepareStatement
					("insert into product(prodname,prodprice,prodqty,mdate,idate) values(?,?,?,?,?)");
			
			pstmt.setString(1, product.getProductName());
			pstmt.setDouble(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductQty());
			pstmt.setDate(4, product.getManufacturedDate());
			pstmt.setDate(5, product.getInspectedDate());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return product;
	}

	@Override
	public Product deleteProduct(int id) {
		
		try {
			PreparedStatement pstmt=connection.prepareStatement("delete from product where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement
					("update product set prodname=?,prodprice=?, prodqty=?, mdate=?,idate=? where id=?");
			
			pstmt.setString(1, product.getProductName());
			pstmt.setDouble(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductQty());
			pstmt.setInt(6, id);
			pstmt.setDate(4, product.getManufacturedDate());
			pstmt.setDate(5, product.getInspectedDate());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		

		
		return product;
	}

	@Override
	public List<Product> getAll() throws DataAccessException {
		
		List<Product> items=new ArrayList<>();
		
		Product prod = null;

		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("select * from product");
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				prod = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),
						rs.getInt(4),rs.getDate(5),rs.getDate(6));
				
				items.add(prod);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}
	return items;
		
	}

	@Override
	public Product getById(int id) {
		Product items = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from product where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				items =  new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),
						rs.getInt(4),rs.getDate(5),rs.getDate(6));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return items;
	}
	
}
