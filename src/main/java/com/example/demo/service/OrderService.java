package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Book;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.OrderDetailId;
import com.example.demo.repository.IBookRepository;
import com.example.demo.repository.IOrderDetailRepository;
import com.example.demo.repository.IOrderRepository;

@Component
public class OrderService {

	@Autowired
	private IOrderRepository _orderRepo;
	@Autowired
	private IBookRepository _bookRepo;
	@Autowired
	private IOrderDetailRepository _orderDetailRepo;
	
	@Transactional
	public int newOrder(Order order) throws Exception {
		// Normal flow: Transaction
		// COMMIT
		// 1. Insert thông tin hóa đơn
		// => Save(Order)
		int orderId = _orderRepo.save(order).getOrderId();
		order.setOrderId(orderId);
		// 2. Insert thông tin các mặt hàng trong hóa đơn
		// => Duyệt các mặt hàng trong hóa đơn (List)
		//	 	=> Thêm từng mặt hàng = Save(OrderDetail)
		for(OrderDetail detail : order.getOrderDetails()) {
			//		Trong quá trình thêm, cần phải kiểm tra
			//			mặt hàng có còn đủ hay không?
			//		Ví dụ: 
			//		Kho: 10 cuốn, order 6 -> còn 4 cuốn
			//		Kho: 10 cuốn sách, order 20 -> lỗi
			//	=> Lỗi thì hóa đơn sẽ không được thêm vào DB
			
			Book book = _bookRepo.findById(
					detail.getBook().getBookId()).get();
			if (book.getQuantity() < detail.getQuantity()) {
				// ... Quăng lỗi => Tự động ROLLBACK
				throw new Exception("Order thất bại!");
			} else {
				// Trừ số lượng sản phẩm trong kho
				// = lượng hiện tại - lượng bán
				int bookLeft = book.getQuantity() - detail.getQuantity();
				book.setQuantity(bookLeft);
				_bookRepo.save(book);
				
				// Lưu Detail
				OrderDetailId detailId = OrderDetailId.builder()
					.orderId(orderId)
					.bookId(book.getBookId())
					.build();
				detail.setId(detailId);
				_orderDetailRepo.save(detail);
			}
			
		}
		// => Thành công, không có lỗi -> Save
		// ...
		return 1;
	}

	public Iterable<Order> getAll() {
		return _orderRepo.findAll();
	}
}
