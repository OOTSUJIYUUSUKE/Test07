package com.example.Test07;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class ProfileController {

    @GetMapping("/profiles")
    public String getProfiles(@RequestParam(value = "name") String value) {
        return switch (value) {
            case "Ootsuji" -> String.format("Name:%s Birthday:%s Club:%s", "Ootsuji", "1995/2/21", "tennis");
            case "Tanaka" -> String.format("Name:%s Birthday:%s Club:%s", "Tanaka", "2000/12/25", "basketball");
            default -> "登録されている名前を入力してください。";
        };
    }
    @PostMapping("/profiles")
    public ResponseEntity<String> create(@RequestBody @Validated CreateForm form) {
    //登録処理は省略
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/profiles/name")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("profile successfully created");
    }
    @PatchMapping("/profiles/{name}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("name") String name, @RequestBody @Validated UpdateForm form) {
    //更新処理は省略
        return ResponseEntity.ok(Map.of("message", "profile successfully updated"));
    }
    @DeleteMapping("/profiles/{name}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("name") String name) {
        return ResponseEntity.ok(Map.of("message", "profile successfully deleted"));
    }
}
