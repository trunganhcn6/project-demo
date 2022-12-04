package com.example.project.service;


import com.example.project.model.dto.BrandProductDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StoreService {
    List<BrandProductDto> getAllProduct();
    void addBrandProduct(BrandProductDto brandProductDto);
    BrandProductDto updateBrandProduct(Integer id, BrandProductDto brandProductDto);
    //BrandProduct getBrandProduct(Integer id);
    Page<BrandProductDto> findBrandProductPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
