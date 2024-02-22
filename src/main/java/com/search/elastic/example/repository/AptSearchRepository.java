package com.search.elastic.example.repository;

import com.search.elastic.example.document.AptDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AptSearchRepository extends ElasticsearchRepository<AptDocument, Long> {
    List<AptDocument> findAptDocumentsByAddressOrDp(String address, String dp);
}
