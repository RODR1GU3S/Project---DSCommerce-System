package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Aqui (readOnly = true) é para não dar um look no banco de dados, pois é uma operação somente de leitura.
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> result = repository.findById(id); // Aqui está buscando no banco de dados com o id de argumento
        Product product = result.get(); // Aqui pega o objeto product que está dentro do Optional
        ProductDTO dto = new ProductDTO(product); // Aqui está convertendo o objeto Product product "ou seja está copiando" para um novo objeto ProductDTO dto
        return dto;
    }
}
