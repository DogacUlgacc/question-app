package com.dogac.questionapp.repo;

import com.dogac.questionapp.entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Likes,Long> {
    List<Likes> findByUserIdAndPostId(Long userId, Long postId);

    List<Likes> findByUserId(Optional<Long> userId);

    List<Likes> findByPostId(Optional<Long> postId);
}
