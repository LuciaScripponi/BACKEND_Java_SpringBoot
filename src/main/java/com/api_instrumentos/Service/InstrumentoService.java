package com.api_instrumentos.Service;

import com.api_instrumentos.Model.Instrumento;
import com.api_instrumentos.Repository.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstrumentoService {
    @Autowired
    InstrumentoRepository instrumentoRepository;

    public List<Instrumento> listarInstrumentos() {
        return instrumentoRepository.findAll();    //Muestro todos los instrumentos de la BD
    }

    public List<Instrumento> listarInstrumentosPorTermino(String termino) {
        return instrumentoRepository.buscarXtermino(termino);  //Muestros los instrumentos que coincidan con la busqueda
    }

    public Optional<Instrumento> listarInstrumentosPorId(int id) {
        return instrumentoRepository.findById(id);  //Muestro un instrumento por ID
    }

    public Instrumento guardarInstrumentos(Instrumento Instrumento) {
        return instrumentoRepository.save(Instrumento);  //Guardo un instrumento nuevo a la BD
    }

    public void borrarInstrumentos(int id) {
        instrumentoRepository.deleteById(id);  //Elimino un instrumento de la BD según el ID
    }

    public Instrumento modificarInstrumentos(Instrumento Instrumento) {
        return instrumentoRepository.save(Instrumento);   //Modifico un instrumento de ka BD según el ID
    }
}
