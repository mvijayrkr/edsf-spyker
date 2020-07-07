package com.dbs.edsf.aerospike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {



	@Autowired ProductService productService;


	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", productService.listAllProducts());
		return "products";
	}

	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productshow";
	}

	@RequestMapping(value = "product/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productform";
	}

	@RequestMapping(value = "product/new", method = RequestMethod.GET)
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/product/" + product.getId();
	}

	@RequestMapping(value = "product/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}
/*
	@RequestMapping(value = "userbuprofile", method = RequestMethod.POST)
	public String saveUser(UserBuProfile userBuProfile) {
		userBuService.saveUser(userBuProfile);
		return "redirect:/user/" + userBuProfile.getUser();
	}*/
}
