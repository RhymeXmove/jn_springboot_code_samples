package org.javaboy.jpa.service;

import org.javaboy.jpa.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {
    @Autowired
    BookDao bookDao;

    public Integer updateBookByName(String author, String name) {
        return bookDao.updateBookByName(author, name);
    }
}
