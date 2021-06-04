package com.pinokio.pino.api.wood;

import com.pinokio.pino.api.model.Wood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WoodRepo extends JpaRepository<Wood, Long> {
}
