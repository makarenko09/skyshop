package org.skypro.skyshop.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public interface Searchable {

    String getSearchTerm();
@JsonIgnore
    default String getStringRepresentation() {
        return this.getClass().getSimpleName() + "-" + getContentType();
    }

    String getContentType();

    UUID getId();
}
