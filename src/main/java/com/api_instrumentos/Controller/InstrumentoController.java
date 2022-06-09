package com.api_instrumentos.Controller;

import com.api_instrumentos.Model.Instrumento;
import com.api_instrumentos.Service.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class InstrumentoController {
    @Autowired
    InstrumentoService instrumentoService;

    @GetMapping("/instrumentos")
    public List<Instrumento> listarInstrumentos() {
        return instrumentoService.listarInstrumentos();
    }

    @GetMapping("/instrumentos/busqueda/{termino}")
    public List<Instrumento> listarInstrumentosPorId(@PathVariable("termino") String termino) {
        return instrumentoService.listarInstrumentosPorTermino(termino);
    }

    @GetMapping("/instrumentoxid/{id}")
    public Optional<Instrumento> listarInstrumentosPorId(@PathVariable("id") int id) {
        return instrumentoService.listarInstrumentosPorId(id);
    }

    @PostMapping("/guardarInstrumento")
    public Instrumento crearInstrumentos(@RequestBody Instrumento instrumento) {
        return instrumentoService.guardarInstrumentos(instrumento);
    }

    @DeleteMapping("/eliminarxid/{id}")
    public void borrarInstrumentos(@PathVariable("id") int id) {
        instrumentoService.borrarInstrumentos(id);
    }

    @PutMapping("/actualizarInstrumento/{id}")
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
