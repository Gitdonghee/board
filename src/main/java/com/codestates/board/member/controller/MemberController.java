package com.codestates.board.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(){
        return ResponseEntity.ok(null);
    }

    @PatchMapping
    public ResponseEntity patchMember(){
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity getMember(){
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity getMembers(){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity deleteMember(){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
