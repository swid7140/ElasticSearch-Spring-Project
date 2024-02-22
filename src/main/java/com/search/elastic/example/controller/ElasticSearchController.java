package com.search.elastic.example.controller;

import com.search.elastic.example.service.AptSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ElasticSearchController {
    private final AptSearchService aptSearchService;

    @PostMapping("/index")
    public void indexDocument(@RequestBody Apt apt) {
        aptSearchService.indexItems(apt);
    }

    @GetMapping("/search")
    public ResponseEntity searchItems(@RequestParam(value = "search_condition") String searchCondition) {
        return new ResponseEntity(aptSearchService.searchByName(searchCondition, searchCondition), HttpStatus.OK);
    }
}
