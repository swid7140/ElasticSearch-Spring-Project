package com.search.elastic.example.service;

import com.search.elastic.example.document.AptDocument;
import com.search.elastic.example.repository.AptSearchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class AptSearchServiceTest {

//    @Autowired
//    ElasticsearchRestTemplate elasticsearchRestTemplate;
    @MockBean
    AptSearchRepository aptSearchRepository;
    @Autowired
    AptSearchService aptSearchService;

//    @BeforeEach
//    public void setup() {
//        // ElasticSearch 환경 설정을 초기화
//        elasticsearchRestTemplate.indexOps(AptDocument.class).create();
//        // 테스트 데이터를 색인화 (실제 데이터가 아닌 테스트 데이터 사용)
//        // 아래에서 테스트 데이터 생성 및 인덱싱 예제를 포함시킬 수 있음
//
//        AptDocument apt1 = new AptDocument(1L, "Address1", "Dp1");
//        AptDocument apt2 = new AptDocument(2L, "Address2", "Dp2");
//
//        elasticsearchRestTemplate.save(apt1);
//        elasticsearchRestTemplate.save(apt2);
//    }

    @Test
    public void testSearchByName() {
        // mock 데이터 설정
        when(aptSearchRepository.findAptDocumentsByAddressOrDp("Address1", "Dp1"))
                .thenReturn(List.of(new AptDocument(1L, "Address1", "Dp1")));

        List<AptDocument> result = aptSearchService.searchByName("Address1", "Dp1");

        // 검증
        assertEquals(1, result.size());
        assertEquals("Address1", result.get(0).getAddress());
        assertEquals("Dp1", result.get(0).getDp());
    }
}
