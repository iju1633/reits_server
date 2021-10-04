package com.example.test.repository;

import com.example.test.model.Reits;
import com.example.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReitsRepository extends JpaRepository<Reits, String>{
	
//	JpaRepository에 기본적인 CRUD 기능이 정의되어있다.

//    @Query("SELECT r from Reits r where r.price = ?1") // 명시화함, 없어도 되긴 함, ?1을 이해잘 못함..ㅠ
//    Optional<Reits> findReitsByPrice(String price);
}
