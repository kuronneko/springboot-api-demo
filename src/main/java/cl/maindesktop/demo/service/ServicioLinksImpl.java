package cl.maindesktop.demo.service;


import cl.maindesktop.demo.entity.Links;
import cl.maindesktop.demo.repository.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("servicioLinks")
public class ServicioLinksImpl implements ServicioLinks {

    @Autowired
    @Qualifier("linksRepository")
    private LinksRepository crud;

    @Override
    public void insertarLinks(Links links) {
        crud.save(links);
    }

    @Override
    public List<Links> getLinks() {
        return crud.findAll();
    }

    @Override
    public Links buscarLink(int id) {
        Optional<Links> linksOptional = crud.findById(id); //select * from Links where id=?
        if(linksOptional.isPresent()){  //linksOptional != null
            return linksOptional.get();
        }
        return null;
    }

    @Override
    public List<Links> buscarLinksPuntuacionMenorA(int valor) {
        return crud.findByPuntuacionLessThan(valor);
    }

    @Override
    public List<Links> buscarLinksEntre(int start, int end) {
        return crud.findByPuntuacionBetween(start, end);

    }

    @Override
    public List<Links> buscarLinksMenorAVersionNativa(int valor) {
        return crud.buscarPorValorMenorANative(valor);
    }

    @Override
    public List<Links> buscarLinksMenorAVersionJQL(int valor) {
        return crud.buscarPorValorMenorAJQL(valor);
    }
}
