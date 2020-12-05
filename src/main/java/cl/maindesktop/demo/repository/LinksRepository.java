package cl.maindesktop.demo.repository;

import cl.maindesktop.demo.entity.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("linksRepository")
public interface LinksRepository extends JpaRepository<Links, Serializable> {

    //SQL NATIVE: select * from Links where puntuacion < ?
    @Query(value = "SELECT * FROM Links WHERE puntuacion < ?1", nativeQuery = true)
    List<Links> buscarPorValorMenorANative(int valor);

    //JQL: select l from Links l where l.puntuacion <?
    @Query(value = "select l from Links l where l.puntuacion < :valor")
    List<Links> buscarPorValorMenorAJQL(@Param("valor") int valor);

    //QueryMethod
    List<Links> findByPuntuacionLessThan(int valor);
    List<Links> findByPuntuacionBetween(int start, int end);
}
