package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> searchSearchables(String searchText) {
        return this.storageService.getAllStorageValue().stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(searchText.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .toList();
    }
}
