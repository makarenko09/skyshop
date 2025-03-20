package org.skypro.skyshop;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

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
    String stringRequest = ArgumentMatchers.anyString();
//    Mockito.when(mockRepo.searchSearchables(stringRequest)).thenReturn(null);
    }

}
