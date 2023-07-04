package com.meleadr.Server.repo;

import com.meleadr.Server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);
}
