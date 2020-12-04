package cl.maindesktop.demo.service;

import cl.maindesktop.demo.entity.Links;

import java.util.List;
import java.util.Optional;

public interface ServicioLinks {

    void insertarLinks(Links links);
    List<Links> getLinks();
    Links buscarLink(int id);
}
