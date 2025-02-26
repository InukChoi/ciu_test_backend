package com.example.ciu_test_backend.board;

import com.example.ciu_test_backend.board.model.Board;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select b from Board b join fetch b.comments where b.idx = :idx")
    Optional<Board> findById(Long idx);
}
