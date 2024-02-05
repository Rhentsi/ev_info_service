package com.ev_info_service_backend.ev_info_service_backend.repository;

import com.ev_info_service_backend.ev_info_service_backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
