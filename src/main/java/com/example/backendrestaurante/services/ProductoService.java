package com.example.backendrestaurante.services;

import com.example.backendrestaurante.exceptions.NotFoundException;
import com.example.backendrestaurante.models.dto.CloudinaryResponse;
import com.example.backendrestaurante.models.entity.Producto;
import com.example.backendrestaurante.repository.ProductoRepository;
import com.example.backendrestaurante.repository.ProductoSpecification;
import com.example.backendrestaurante.utils.FileUploadUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CloudinaryService cloudinaryService;

    public ArrayList<Producto> getProducts(){
        return (ArrayList<Producto>) productoRepository.findAll();
    }

    public Optional<Producto> getProductById(String id){
        return productoRepository.findById(id);
    }

    public Producto saveProduct(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteProduct(String id){
        productoRepository.deleteById(id);
    }

    public Producto editarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> withFilters(String search, List<String> categorias){
        Specification<Producto> specification = ProductoSpecification.withFilters(categorias, search);
        return productoRepository.findAll(specification);
    }

    public List<Producto> withLimit(){
        Pageable pageable = PageRequest.of(0,10);
        return productoRepository.findAll();
    }

    @Transactional
    public void uploadImage(final String id, final MultipartFile file) {
        final Producto product = this.productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        FileUploadUtil.assertAllowed(file, FileUploadUtil.IMAGE_PATTERN);
        final String fileName = FileUploadUtil.getFileName(file.getOriginalFilename());
        final CloudinaryResponse response = this.cloudinaryService.uploadFile(file, fileName);
        product.setUrlImg(response.getUrl());
        product.setCloudinaryImageId(response.getPublic_id());
        this.productoRepository.save(product);
    }



}
