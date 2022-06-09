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
        return instrumentoRepository.findAll();
    }

    public List<Instrumento> listarInstrumentosPorTermino(String termino) {
        return instrumentoRepository.buscarXtermino(termino);
    }

    public Optional<Instrumento> listarInstrumentosPorId(int id) {
        return instrumentoRepository.findById(id);
    }

    public Instrumento guardarInstrumentos(Instrumento Instrumento) {
        return instrumentoRepository.save(Instrumento);
    }

    public void borrarInstrumentos(int id) {
        instrumentoRepository.deleteById(id);
    }

    public Instrumento modificarInstrumentos(Instrumento Instrumento) {
        return instrumentoRepository.save(Instrumento);
    }
}
