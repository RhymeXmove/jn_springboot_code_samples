package org.javaboy.restful.Dao;

import org.javaboy.restful.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
//生成的JSON字符串中的集合名和单个item的名字可以自定义
@RepositoryRestResource(collectionResourceRel = "bs", itemResourceRel = "b", path = "bs")
public interface BookDao extends JpaRepository<Book,Long> {
    //自定义方法名
    @RestResource(rel = "byauthor", path = "byauthor")
    List<Book> findBookByAuthorContaining(@Param("author") String author);

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);
}
