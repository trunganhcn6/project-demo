/*
package com.example.project.service;

import com.example.project.model.dto.BrandProductDto;
import com.example.project.model.dto.BrandProductMapper;
import com.example.project.model.entity.BrandProduct;
import com.example.project.repository.BrandProductRepository;
import com.example.project.repository.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private BrandProductRepository brandProductRepository;

    @Autowired
    private BrandProductMapper brandProductMapper;

    */
/*@Override
    public List<BrandProductDto> getAllProduct() {
        List<BrandProduct> products = brandProductRepository.findAll();
        List<BrandProductDto> productDtos = products.stream().map(brandProduct -> brandProductMapper.brandProductToBrandProductDto(products))


        return brandProductMapper.brandProductToBrandProductDto(products);
    }*//*


    @Override
    public void addBrandProduct(BrandProduct brandProduct) {

    }

    @Override
    public Page<BrandProductDto> findBrandProductPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        return null;
    }
}
*/
