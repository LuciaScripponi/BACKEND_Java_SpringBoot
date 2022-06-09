package com.api_instrumentos.Controller;

import com.api_instrumentos.Model.Instrumento;
import com.api_instrumentos.Service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController   //Controlador de la API REST, con todos los endpoints
public class InstrumentoController {
    @Autowired
    InstrumentoService instrumentoService;

    @GetMapping("/instrumentos")   //Listo todos los instrumentos de la BD
    public List<Instrumento> listarInstrumentos() {
        return instrumentoService.listarInstrumentos();
    }

    @GetMapping("/instrumentos/busqueda/{termino}")  //Listo todos los instrumentos de la BD que coincidan con el termino
    public List<Instrumento> listarInstrumentosPorId(@PathVariable("termino") String termino) {
        return instrumentoService.listarInstrumentosPorTermino(termino);
    }

    @GetMapping("/instrumentoxid/{id}")  //Muestro el instrumento que coincida con el ID que me pasan
    public Optional<Instrumento> listarInstrumentosPorId(@PathVariable("id") int id) {
        return instrumentoService.listarInstrumentosPorId(id);
    }

    @PostMapping("/guardarInstrumento")  //Creo un nuevo instrumento y lo agrego a la BD
    public Instrumento crearInstrumentos(@RequestBody Instrumento instrumento) {
        return instrumentoService.guardarInstrumentos(instrumento);
    }

    @DeleteMapping("/eliminarxid/{id}")  //Elimino un instrumento de la BD segun el ID que me pasan
    public void borrarInstrumentos(@PathVariable("id") int id) {
        instrumentoService.borrarInstrumentos(id);
    }

    @PutMapping("/actualizarInstrumento/{id}")  //Modifico un instrumento de la BD segun el ID que me pasan
    public Instrumento modificarInstrumentos(@RequestBody Instrumento instrumento, @PathVariable int id) {
        Instrumento instrumentoActual = instrumentoService.listarInstrumentosPorId(id).get();
        instrumentoActual.setInstrumento(instrumento.getInstrumento());
        instrumentoActual.setMarca(instrumento.getMarca());
        instrumentoActual.setModelo(instrumento.getModelo());
        instrumentoActual.setImagen(instrumento.getImagen());
        instrumentoActual.setPrecio(instrumento.getPrecio());
        instrumentoActual.setCostoEnvio(instrumento.getCostoEnvio());
        instrumentoActual.setCantidadVendida(instrumento.getCantidadVendida());
        instrumentoActual.setDescripcion(instrumento.getDescripcion());
        instrumentoService.guardarInstrumentos(instrumentoActual);
        return instrumentoService.modificarInstrumentos(instrumento);
    }
}
