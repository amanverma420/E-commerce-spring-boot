package com.ecom.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.model.UserDtls;
import com.ecom.repository.CategoryRepository;
import com.ecom.repository.ProductRepository;
import com.ecom.repository.UserRepository;

@Component
public class DbSeeder implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		seedRoles();
		seedCategories();
		seedProducts();
	}

	private void seedRoles() {
		// Seed Admin
		if (!userRepository.existsByEmail("admin@gmail.com")) {
			UserDtls admin = new UserDtls();
			admin.setName("System Admin");
			admin.setEmail("admin@gmail.com");
			admin.setPassword(passwordEncoder.encode("admin"));
			admin.setMobileNumber("9876543210");
			admin.setRole("ROLE_ADMIN");
			admin.setIsEnable(true);
			admin.setAccountNonLocked(true);
			admin.setFailedAttempt(0);
			admin.setProfileImage("default.jpg");
			userRepository.save(admin);
			System.out.println("Seeded Default Admin: admin@gmail.com / admin");
		}

		// Seed Normal User
		if (!userRepository.existsByEmail("user@gmail.com")) {
			UserDtls user = new UserDtls();
			user.setName("John Doe");
			user.setEmail("user@gmail.com");
			user.setPassword(passwordEncoder.encode("user"));
			user.setMobileNumber("1234567890");
			user.setRole("ROLE_USER");
			user.setIsEnable(true);
			user.setAccountNonLocked(true);
			user.setFailedAttempt(0);
			user.setProfileImage("default.jpg");
			user.setAddress("123 Baker Street");
			user.setCity("London");
			user.setState("Greater London");
			user.setPincode("NW16XE");
			userRepository.save(user);
			System.out.println("Seeded Default User: user@gmail.com / user");
		}
	}

	private void seedCategories() {
		if (categoryRepository.count() == 0) {
			List<Category> categories = List.of(
				new Category(null, "Mobile", "mobile.png", true),
				new Category(null, "Laptop", "laptop.jpg", true),
				new Category(null, "Appliance", "appli.png", true),
				new Category(null, "Beauty", "beuty.png", true),
				new Category(null, "Groceries", "groccery.jpg", true)
			);
			categoryRepository.saveAll(categories);
			System.out.println("Seeded Default Categories");
		}
	}

	private void seedProducts() {
		if (productRepository.count() == 0) {
			List<Product> products = List.of(
				new Product(null, "iPhone 14 Pro", "Apple iPhone 14 Pro with Super Retina XDR display, Dynamic Island, and 48MP main camera.", "Mobile", 79999.0, 50, "iphone 14.jpg", 0, 79999.0, true),
				new Product(null, "OnePlus Nord 3", "OnePlus Nord 3 5G with fluid AMOLED 120Hz display, MediaTek Dimensity 9000, and 80W SuperVOOC charging.", "Mobile", 32999.0, 80, "oneplus mobile.jpg", 10, 29699.0, true),
				new Product(null, "HP Pavilion 15", "HP Pavilion 15 Laptop with AMD Ryzen 5 processor, 16GB DDR4 RAM, 512GB SSD, and backlit keyboard.", "Laptop", 55000.0, 30, "hp laptop.jpg", 5, 52250.0, true),
				new Product(null, "Front Load Washing Machine", "Fully-automatic front loading washing machine with EcoBubble technology and digital inverter motor.", "Appliance", 25000.0, 15, "washing_machine.png", 12, 22000.0, true),
				new Product(null, "Smart Mixer Grinder", "High-speed mixer grinder with 3 stainless steel jars, 750W copper motor, and overload protection.", "Appliance", 3500.0, 40, "grinder.jpg", 0, 3500.0, true)
			);
			productRepository.saveAll(products);
			System.out.println("Seeded Default Products");
		}
	}
}
