package com.meleadr.Server.resource;

import com.meleadr.Server.model.Response;
import com.meleadr.Server.service.implementation.ServerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
    private final ServerServiceImpl serverService;

    @RequestMapping("/list")
    public ResponseEntity<Response> getServers() {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("servers", serverService.list(10)))
                        .message("Servers listed successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @RequestMapping("/ping")
    public ResponseEntity<Response> pingServer(@RequestParam String ipAddress) throws IOException {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("server", serverService.ping(ipAddress)))
                        .message("Server pinged successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @RequestMapping("/create")
    public ResponseEntity<Response> createServer(@RequestBody Server server) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("server", serverService.create(server)))
                        .message("Server created successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @RequestMapping("/update")
    public ResponseEntity<Response> updateServer(@RequestBody Server server) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("server", serverService.update(server)))
                        .message("Server updated successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @RequestMapping("/delete")
    public ResponseEntity<Response> deleteServer(@RequestParam Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("server", serverService.delete(id)))
                        .message("Server deleted successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
