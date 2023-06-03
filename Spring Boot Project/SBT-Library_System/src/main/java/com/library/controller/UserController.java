package com.library.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.entites.Book;
import com.library.entites.Cart;
import com.library.entites.Orders;
import com.library.entites.User;
import com.library.repository.IssueBookRepository;
import com.library.repository.UserRepository;
import com.library.service.BookService;
import com.library.service.CartService;
import com.library.service.OrderService;
import com.library.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private IssueBookRepository issueBookRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@ModelAttribute
	public User addCommnData(Principal p, Model m) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
		return user;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/cart")
	public String cart(Model m, Principal p) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("cartList", cartService.getCartByUser(user.getId()));
		m.addAttribute("bookService", bookService);

		List<Cart> cart = cartService.getCartByUser(user.getId());
		int billAmount = 0;
		for (Cart ca : cart) {

			Book b = bookService.getBookById(ca.getBookId());
			int totalAmount = b.getPrice() * ca.getQuantity();
			billAmount = billAmount + totalAmount;
		}

		m.addAttribute("billAmount", billAmount);

		return "user/cart";
	}

	@GetMapping("/profile")
	public String profile() {
		return "user/profile";
	}

	@GetMapping("/password")
	public String password() {
		return "user/password";
	}

	@GetMapping("/orders")
	public String orders(Principal p, Model m) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);

		m.addAttribute("orders", orderService.getByUser(user.getId()));
		m.addAttribute("bookService", bookService);
		return "user/orders";
	}

	@GetMapping("/setting")
	public String setting() {
		return "user/setting";
	}

	@GetMapping("/addCart/{userid}/{bookid}")
	public String addCart(@PathVariable int userid, @PathVariable int bookid, HttpSession session) {
		Cart c = new Cart();
		c.setUserId(userid);
		c.setBookId(bookid);
		c.setQuantity(1);

		if (cartService.addCart(c) != null) {
			session.setAttribute("succMsg", "Book Added to cart");

		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
		}

		return "redirect:/viewBook/" + bookid;
	}

	@GetMapping("/cartIn/{bookid}/{quantity}/{sign}/{id}/{userid}")
	public String cartQuantity(@PathVariable int bookid, @PathVariable int quantity, @PathVariable String sign,
			@PathVariable int id, @PathVariable int userid, HttpSession session) {

		if ("add".equals(sign) && quantity >= 1) {
			quantity = quantity + 1;

		} else if ("neg".equals(sign) && quantity >= 1) {
			quantity = quantity - 1;

			if (quantity <= 0) {

				if (cartService.deleteCart(id)) {
					session.setAttribute("succMsg", "Item removed from cart");
					return "redirect:/user/cart";
				}

			}
		}

		Cart c = new Cart();
		c.setId(id);
		c.setBookId(bookid);
		c.setQuantity(quantity);
		c.setUserId(userid);

		cartService.addCart(c);

		return "redirect:/user/cart";
	}

	@GetMapping("/ordSucc")
	public String orderSuccess() {
		return "user/order_success";
	}

	@PostMapping("/saveOrders")
	public String saveOrder(@RequestParam("type") String type, @RequestParam("amt") int amount,
			@RequestParam("uid") int uid) {

		Random random = new Random();

		List<Orders> orderList = new ArrayList<Orders>();

		if ("COD".equals(type)) {

			List<Cart> list = cartService.getCartByUser(uid);

			for (Cart c : list) {

				Book b = bookService.getBookById(c.getBookId());

				Orders o = new Orders();
				o.setOrderId("ORD-" + random.nextInt(1000));
				o.setDate(LocalDate.now());
				o.setBookId(c.getBookId());
				o.setUserId(c.getUserId());
				o.setQuantity(c.getQuantity());
				o.setTotalAmount(b.getPrice() * c.getQuantity() + "");
				o.setPaymentType("COD");
				o.setStatus("Order Processing");
				o.setLibrary(b.getLibrary());
				orderList.add(o);
			}

			if (!orderService.saveOrder(orderList).isEmpty()) {
				return "redirect:/user/ordSucc";
			}
			return "redirect:/user/ordSucc";
		} else {
			return "user/cardpayment";
		}

	}

	@PostMapping("/updateprofile")
	public String updateProfile(@ModelAttribute User user, HttpSession session) {

		User oldUser = userService.getUserById(user.getId());
		user.setRole(oldUser.getRole());
		user.setPassword(oldUser.getPassword());
		user.setEmail(oldUser.getEmail());

		if (userService.updateUser(user) != null) {
			session.setAttribute("succMsg", "Profile update sucessfully");
		} else {
			session.setAttribute("errorMsg", "something wrong on server ");
		}

		return "redirect:/user/profile";
	}

	@PostMapping("/changePsw")
	public String changePasw(Principal p, HttpSession session, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {

		String email = p.getName();
		User currentUser = userRepo.findByEmail(email);

		if (passwordEncoder.matches(oldPassword, currentUser.getPassword())) {

			currentUser.setPassword(passwordEncoder.encode(newPassword));
			userRepo.save(currentUser);

			session.setAttribute("succMsg", "password change sucessfully");
		} else {
			session.setAttribute("errorMsg", "old password is incorrect");
		}

		return "redirect:/user/password";
	}

	@GetMapping("/issueBook")
	public String issueBook(Model m, Principal p) {

		User user = addCommnData(p, m);

		m.addAttribute("userList", issueBookRepo.findByUser(user));
		return "user/issued_book";
	}

}
