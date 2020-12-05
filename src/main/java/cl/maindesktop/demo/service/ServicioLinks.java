package cl.maindesktop.demo.service;

import cl.maindesktop.demo.entity.Links;

import java.util.List;
import java.util.Optional;

public interface ServicioLinks {

    void insertarLinks(Links links);
    List<Links> getLinks();
    Links buscarLink(int id);
    List<Links> buscarLinksPuntuacionMenorA(int valor);
    List<Links> buscarLinksEntre(int start, int end);

    List<Links> buscarLinksMenorAVersionNativa(int valor);
    List<Links> buscarLinksMenorAVersionJQL(int valor);
}
