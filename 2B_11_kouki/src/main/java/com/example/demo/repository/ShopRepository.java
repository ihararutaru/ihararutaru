package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Shop;
public interface ShopRepository extends JpaRepository<Shop,Integer> {
											//<エンティティ名(テーブル名),主キーの型>
}
