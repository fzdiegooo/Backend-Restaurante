package com.example.backendrestaurante.controllers;

import com.example.backendrestaurante.models.entity.Categoria;
import com.example.backendrestaurante.models.entity.Producto;
import com.example.backendrestaurante.services.CategoriaService;
import com.example.backendrestaurante.services.CloudinaryService;
import com.example.backendrestaurante.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService ps;

    @Autowired
    CategoriaService cs;

    @Autowired
    CloudinaryService cloudinaryService;

    @GetMapping
    public List<Producto> getProductos() {
        return ps.getProducts();
    }

    @GetMapping(path = "/{id}")
    public Optional<Producto> getProductos(@PathVariable String id) {
        return ps.getProductById(id);
    }

    //@PostMapping
    //public Producto crearProductos(@RequestBody Producto producto) {
    //    return ps.saveProduct(producto);
    //}

    @PostMapping
    public Producto guardarProducto(@RequestParam("nombre") String nombre,
                                    @RequestParam("precio") Double precio,
                                    @RequestParam("descripcion") String descripcion,
                                    @RequestParam("categoriaId") Long categoriaId,
                                    @RequestParam(value = "imagen", required = false) MultipartFile imagen) {

        Categoria categoria = cs.getCategoriaById(categoriaId);

        // Crear un objeto Producto con los datos recibidos
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setCategoria(categoria); // Suponiendo que tienes una relación con Categoria

        // Guardar el producto sin la imagen primero
        Producto productoGuardado = ps.saveProduct(producto);

        // Subir la imagen y actualizar la URL en el producto
        if (imagen != null && !imagen.isEmpty()) {
            ps.uploadImage(productoGuardado.getId(), imagen);  // Llama a tu método de upload
        }else {
            productoGuardado.setUrlImg("https://res.cloudinary.com/dar3rtsty/image/upload/v1732330870/Polleria%20El%20Pollon/404image.png");
            ps.editarProducto(productoGuardado);
        }

        return productoGuardado;
    }
    @PatchMapping
    public Producto editarProductos(@RequestParam("nombre") String nombre,
                                    @RequestParam("id") String id,
                                    @RequestParam("precio") Double precio,
                                    @RequestParam("descripcion") String descripcion,
                                    @RequestParam("categoriaId") Long categoriaId,
                                    @RequestParam(value = "imagen", required = true) MultipartFile imagen) {

        Categoria categoria = cs.getCategoriaById(categoriaId);
        Producto producto = ps.getProductById(id).get();

        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setDescripcion(descripcion);
        producto.setCategoria(categoria);

        if (imagen != null && !imagen.isEmpty()) {
            ps.uploadImage(producto.getId(), imagen);  // Llama a tu método de upload
        }else {
            producto.setUrlImg("https://res.cloudinary.com/dar3rtsty/image/upload/v1732330870/Polleria%20El%20Pollon/404image.png");
        }

        return ps.editarProducto(producto);
    }

    @DeleteMapping(path = "/{id}")
    public void eliminarProductos(@PathVariable String id) {
        ps.deleteProduct(id);
    }

    @GetMapping("/filter")
    public List<Producto> buscarConFiltros(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) List<String> categorias) {
        return ps.withFilters(search, categorias);
    }

    @PostMapping("/image/{id}")
    public ResponseEntity<?> uploadImage(@PathVariable final String id, @RequestPart final MultipartFile file) {
        this.ps.uploadImage(id, file);
        return ResponseEntity.ok("Upload successfully");
    }

    @DeleteMapping("/image/{publicId}")
    public ResponseEntity<?> deleteImageProduct(@PathVariable String publicId) {
        try {
            cloudinaryService.deleteFile(publicId); // Eliminar imagen desde Cloudinary
            Map<String, String> response = new HashMap<>();
            response.put("message", "Imagen eliminada correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Error al eliminar la imagen");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
