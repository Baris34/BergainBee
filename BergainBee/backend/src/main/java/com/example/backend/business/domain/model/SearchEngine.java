package com.example.backend.business.domain.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchEngine {

    private List<BaseProduct> products;
    private Map<String, String> searchCriteria;

    public List<BaseProduct> search() {
        return new ArrayList<>();
    }

    public List<BaseProduct> applyFilters(List<BaseProduct> productList, Map<String, String> filters) {
        return productList;
    }

    public List<BaseProduct> sortResults(List<BaseProduct> productList, String sortBy) {
        return productList;
    }

    public List<BaseProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BaseProduct> products) {
        this.products = products;
    }

    public Map<String, String> getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(Map<String, String> searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
