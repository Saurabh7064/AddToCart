package com.addtocart.controller;

import java.io.File;
import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.addtocart.dto.Product;
import com.addtocart.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("/productlist")
	public String productList(Map<String, Object> map, Principal principal) {
		map.put("productlist", productService.listProduct());
		if (principal != null) {
			String name = principal.getName();
			map.put("username", name);
		}
		return "products";
	}

	@RequestMapping("/product/{id}")
	public String product(Map<String, Object> map, @PathVariable("id") int productID) {

		map.put("product", productService.getProduct(productID));

		return "product";
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct,HttpServletRequest request) {
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				System.out.println(rootDirectory);
			if (productImage!=null && !productImage.isEmpty()) {
		       try {
		      	productImage.transferTo(new File(rootDirectory+"\\resources\\productimages\\"+newProduct.getProductImageID() + ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

		productService.saveProduct(newProduct);
		return "redirect:/productlist";
	}

}
