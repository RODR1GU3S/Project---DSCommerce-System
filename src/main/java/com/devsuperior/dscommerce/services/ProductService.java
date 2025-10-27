package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = repository.findById(id).get();
        return new ProductDTO(product);
    }

    /*
    //Esse Método busca todos os Serviços
    @Transactional(readOnly = true)
    public List<ProductDTO > findAll() {
        List<Product > result = repository.findAll();
        return result.stream().map(x -> new ProductDTO(x)).toList();
    }
    */


    // Esse Método faz uma busca páginada
    @Transactional(readOnly = true)
    public Page<ProductDTO > findAll(Pageable pageable) {
        Page<Product > result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }


}
