package top.zhangekay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zhangekay.entity.Book;

import java.util.List;

public interface ReadingListRepo extends JpaRepository<Book,Long> {

    List<Book> findByreader(String reader);

}
