package org.example.view;

import org.example.controller.CategoryController;
import org.example.controller.ProductController;
import org.example.model.Category;
import org.example.model.Product;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProductCategoryFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private JLabel labelName, labelDescription, labelCategory;
	private JTextField textName, textDescription;
	private JComboBox<Category> comboCategory;
	private JButton saveButton, updateButton, clearButton, deleteButton;
	private JTable table;
	private DefaultTableModel model;
	private ProductController productController;
	private CategoryController categoryController;

	public ProductCategoryFrame() throws SQLException {
		super();
		Container container = getContentPane();
		setLayout(null);

		this.categoryController = new CategoryController();
		this.productController = new ProductController();

		labelName = new JLabel("Product Name");
		labelDescription = new JLabel("Product Description");
		labelCategory = new JLabel("Product Category");

		labelName.setBounds(10, 10, 240, 15);
		labelDescription.setBounds(10, 50, 240, 15);
		labelCategory.setBounds(10, 90, 240, 15);

		labelName.setForeground(Color.BLACK);
		labelDescription.setForeground(Color.BLACK);
		labelCategory.setForeground(Color.BLACK);

		container.add(labelName);
		container.add(labelDescription);
		container.add(labelCategory);

		textName = new JTextField();
		textDescription = new JTextField();
		comboCategory = new JComboBox<Category>();

		comboCategory.addItem(new Category(0, "Select"));
		List<Category> categories = this.listCategory();
		for(Category category : categories) {
			comboCategory.addItem(category);
		}

		textName.setBounds(10, 25, 265, 20);
		textDescription.setBounds(10, 65, 265, 20);
		comboCategory.setBounds(10, 105, 265, 20);

		container.add(textName);
		container.add(textDescription);
		container.add(comboCategory);

		saveButton = new JButton("Save");
		clearButton = new JButton("Clear");

		saveButton.setBounds(10, 145, 80, 20);
		clearButton.setBounds(100, 145, 80, 20);

		container.add(saveButton);
		container.add(clearButton);

		table = new JTable();
		model = (DefaultTableModel) table.getModel();

		model.addColumn("Product Id");
		model.addColumn("Product Name");
		model.addColumn("Product Description");

		fillTable();

		table.setBounds(10, 185, 760, 300);
		container.add(table);

		deleteButton = new JButton("Delete");
		updateButton = new JButton("Update");

		deleteButton.setBounds(10, 500, 80, 20);
		updateButton.setBounds(100, 500, 80, 20);

		container.add(deleteButton);
		container.add(updateButton);

		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					save();
					clearTable();
					fillTable();
				} catch(SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					delete();
					clearTable();
					fillTable();
				} catch(SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});

		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					update();
					clearTable();
					fillTable();
				} catch(SQLException ex) {
					throw new RuntimeException(ex);
				}
			}
		});
	}

	private void clearTable() {
		model.getDataVector()
			 .clear();
	}

	private void update() {
		Object lineObject = model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
		if(lineObject instanceof Integer id) {
			String name = (String) model.getValueAt(table.getSelectedRow(), 1);
			String description = (String) model.getValueAt(table.getSelectedRow(), 2);
			this.productController.change(name, description, id);
		} else {
			JOptionPane.showMessageDialog(this, "Please, select the Id");
		}
	}

	private void delete() {
		Object lineObject = model.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
		if(lineObject instanceof Integer id) {
			this.productController.delete(id);
			model.removeRow(table.getSelectedRow());
			JOptionPane.showMessageDialog(this, "Successfully Deleted Item!");
		} else {
			JOptionPane.showMessageDialog(this, "Please select the ID");
		}
	}

	private void fillTable() throws SQLException {
		List<Product> products = listProduct();
		try {
			for(Product product : products) {
				model.addRow(new Object[]{ product.getId(), product.getName(), product.getDescription() });
			}
		} catch(Exception exception) {
			throw exception;
		}
	}

	private List<Category> listCategory() throws SQLException {
		return this.categoryController.list();
	}

	private void save() {
		if(!textName.getText()
					.equals("") && !textDescription.getText()
												   .equals("")) {
			Product product = new Product(textName.getText(), textDescription.getText());
			Category category = (Category) comboCategory.getSelectedItem();
			product.setCategoryId(category.getId());
			this.productController.save(product);
			JOptionPane.showMessageDialog(this, "Saved successfully!");
			this.clear();
		} else {
			JOptionPane.showMessageDialog(this, "Name and Description must be informed.");
		}
	}

	private List<Product> listProduct() throws SQLException {
		return this.productController.list();
	}

	private void clear() {
		this.textName.setText("");
		this.textDescription.setText("");
		this.comboCategory.setSelectedIndex(0);
	}
}
