package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @InjectMocks
    private SearchService searchService;

    //    SearchService mockSearch = Mockito.mock(SearchService.class);
    @Spy
    private StorageService storageService;
    @Mock
    private SearchResult searchResult;
    //    @Mock
    //    private Searchable searchable;

    @Test
    void searchSomeAnyProducct_nonExistentProduct_returnEmptyList() {
        Mockito.when(searchService.searchSearchables("nonExistentProduct")).thenReturn(List.of());
        assertEquals(List.of(), searchService.searchSearchables("nonExistentProduct"));
    }

    //Поиск в случае, если объекты в
    //StorageService
    // есть, но нет подходящего.
    @Test
    void searchAnotherProduct_ProductsAreLocatedOnStorage_returnEmptyList() {
        UUID someId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        String anyProductName = "Неивестный продукт";

        Searchable someAnyProduct = new SimpleProduct(77, anyProductName, someId);

        Mockito.when(storageService.getAllStorageValue()).thenReturn(List.of());

        SearchResult expectedResult = searchResult.fromSearchable(someAnyProduct);

        List<SearchResult> actualResults = searchService.searchSearchables(anyProductName);

        assertEquals(List.of(), searchService.searchSearchables(anyProductName));
        assertNotEquals(List.of(someAnyProduct), expectedResult);
    }

    @Test
    void searchProduct_ProductsAreLocatedOnStorage_returnListOfProducts() {
        UUID breadId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        String breadNameString = "хлеб";
        Searchable bread = new SimpleProduct(45, breadNameString, breadId);

        Mockito.when(storageService.getAllStorageValue()).thenReturn(List.of(bread));

        SearchResult expectedResult = searchResult.fromSearchable(bread);
        List<SearchResult> actualResults = searchService.searchSearchables(breadNameString);

        assertThat(actualResults).isNotEmpty();

        assertThat(actualResults.get(0))
                .usingRecursiveComparison()
                .isEqualTo(expectedResult);
    }
}

