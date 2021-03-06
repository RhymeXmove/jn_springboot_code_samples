package org.javaboy.jpa.dao;

import org.javaboy.jpa.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends JpaRepository<Book,Long> {
    List<Book> findBookByIdGreaterThanEqual(Long id);

    List<Book> findBookByIdGreaterThanEqualAndAuthorStartingWith(Long id, String author);

    @Query(value = "select count(*) from t_book",nativeQuery = true)
    Long totalCount();

//    @Query(value = "update t_book set author=?1 where book_name=?2",nativeQuery = true)
    @Query(value = "update t_book set author=:author where book_name=:name",nativeQuery = true)
    @Modifying
    Integer updateBookByName(@Param("author") String author, @Param("name") String name);
}
