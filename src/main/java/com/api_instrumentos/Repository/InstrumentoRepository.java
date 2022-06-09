package com.api_instrumentos.Repository;

import com.api_instrumentos.Model.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer> {
    /*Metodo de búsqueda customizado (no se encuentra en el repositorio de JPA, por eso lo agrego en
    la interfaz para luego utilizarlo desde el servicio y el controlador)*/
    @Query(value = "SELECT * FROM instrumento WHERE instrumento.instrumento LIKE %:termino%",
            nativeQuery = true
    )
    List<Instrumento> buscarXtermino(@Param("termino") String instrumento);
}
