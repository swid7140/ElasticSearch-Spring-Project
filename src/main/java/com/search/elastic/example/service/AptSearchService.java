package com.search.elastic.example.service;

import com.search.elastic.example.controller.Apt;
import com.search.elastic.example.document.AptDocument;
import com.search.elastic.example.repository.AptSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AptSearchService {
    private final AptSearchRepository aptSearchRepository;

    public void indexItems(Apt apt) {
        aptSearchRepository.save(AptDocument.from(apt));
    }

    public List<AptDocument> searchByName(String address, String dp) {
        return aptSearchRepository.findAptDocumentsByAddressOrDp(address, dp);
    }
}
