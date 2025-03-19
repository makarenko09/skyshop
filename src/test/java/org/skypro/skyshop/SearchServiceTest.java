package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;

import org.skypro.skyshop.service.StorageService;
import org.springframework.stereotype.Repository;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    //GWT
    @Mock
    Searchable searchable;
    @Mock
    StorageService storageService;
    @Mock
    SearchResult searchResult;
//    @InjectMocks
//    SearchService searchService;

    SearchService mockRepo = Mockito.mock(SearchService.class);

@Test
    public void givenAnyObject_whenAllObjectNotRecorded_thenDenied() {
Mockito.when(mockRepo.searchSearchables(anyString())).thenReturn(null);
    }

}
