package com.women.health.repository;

import com.women.health.entity.Women;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WomenRepository extends JpaRepository<Women, Long>  {
    //  Women save(Women women);
    Women findByEmail(String email);

}
