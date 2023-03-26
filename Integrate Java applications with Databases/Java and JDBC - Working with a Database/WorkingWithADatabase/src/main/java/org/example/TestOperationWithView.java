package org.example;

import org.example.view.ProductCategoryFrame;

import javax.swing.JFrame;
import java.sql.SQLException;

public class TestOperationWithView {

	public static void main(String[] args) throws SQLException {
		ProductCategoryFrame productCategoryFrame = new ProductCategoryFrame();
		productCategoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
