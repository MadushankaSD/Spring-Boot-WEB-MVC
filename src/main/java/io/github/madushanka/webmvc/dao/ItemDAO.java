package io.github.madushanka.webmvc.dao;



import io.github.madushanka.webmvc.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemDAO extends JpaRepository<Item, String> {
    @Query(value = "SELECT code FROM Item ORDER BY code DESC LIMIT 1",nativeQuery = true)
    String getLastItemCode();
}
