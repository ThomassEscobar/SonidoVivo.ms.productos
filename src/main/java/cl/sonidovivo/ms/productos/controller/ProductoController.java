package cl.sonidovivo.ms.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.sonidovivo.ms.productos.model.Producto;
import cl.sonidovivo.ms.productos.repository.ProductoRepository;



@RestController 
@RequestMapping("/api/productos")
public class ProductoController {


    @Autowired 
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }
    @PostMapping 
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }
    //Actualiza un producto 

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetalles){
        Producto producto = productoRepository.findById(id).orElseThrow();
        producto.setTitulo(productoDetalles.getTitulo());
        producto.setPrecio(productoDetalles.getPrecio());
        producto.setDescripcion(productoDetalles.getDescripcion());
        producto.setCategoria(productoDetalles.getCategoria());
        producto.setImagen(productoDetalles.getImagen());
        return productoRepository.save(producto);
    }

    //Delete: Elimina un producto

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id).orElseThrow();
        productoRepository.delete(producto);
    }



}
