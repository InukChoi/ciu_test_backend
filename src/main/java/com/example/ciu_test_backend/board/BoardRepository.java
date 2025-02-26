package com.example.ciu_test_backend.board;

import com.example.ciu_test_backend.board.model.Board;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
