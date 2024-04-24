package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.jclouds.blobstore.BlobStoreContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final BlobStoreContext blobStoreContext;

    @GetMapping
    public ResponseEntity<?> getBlobs() {
        return ResponseEntity.ok(blobStoreContext.getBlobStore().list().stream().toList());
    }
}
