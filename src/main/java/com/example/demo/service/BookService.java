package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.repository.IBookRepository;
import com.example.demo.utils.CommonConst;

@Component // Khai báo object này sẽ được khởi tạo theo kiểu... 
public class BookService {

	@Autowired
	private IBookRepository _bookRepo;
	
	public List<Book> getAll() {
		return _bookRepo.findAll();
	}
	
	public List<Book> getByName(String name) {
//		return _bookRepo.findByName(name);
		return _bookRepo.findByNameLike(name);
	}
	
	public Book getById(Integer id) {
		// Dùng Optional để tránh NULL
		Optional<Book> opt = _bookRepo.findById(id);
		if (opt.isPresent()) { // Trường hợp tồn tại bản ghi
			return opt.get(); // Dùng hàm get() để parse về kiểu Book
		}
		return null;
	}
	
	public int save(Book book) {
		try {
			// Id tồn tại thì UPDATE
			// Không tồn tại thì INSERT
			return _bookRepo.save(book).getId();
		} catch (Exception ex) {
			return CommonConst.ERROR;
		}
	}
	
	public int deleteById(Integer deleteId) {
		try {
			_bookRepo.deleteById(deleteId);
			return CommonConst.SUCCESS;
		} catch (Exception ex) {
			return CommonConst.ERROR;
		}
	}
	
//	public int add(Book book) {
//		try {
//			// Thêm thì đối tượng không có ID
//			// PK không tồn tại thì thêm mới
//			_bookRepo.save(book);
//			return CommonConst.SUCCESS;
//		} catch (Exception ex) {
//			return CommonConst.ERROR;
//		}
//	}
	
//	public int update(Book book) {
//		try {
//			// Update thì đối tượng có ID
//			// PK mà tồn tại thì Update
//			// Lấy đối tượng ra
//			// Set lại thuộc tính
//			// Lưu lại
//			_bookRepo.save(book);
//			return CommonConst.SUCCESS;
//		} catch (Exception ex) {
//			return CommonConst.ERROR;
//		}
//	}

}
