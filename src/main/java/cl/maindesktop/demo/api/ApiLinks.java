package cl.maindesktop.demo.api;

import cl.maindesktop.demo.entity.Links;
import cl.maindesktop.demo.service.ServicioLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/apiLinks")
public class ApiLinks {

    @Autowired
    @Qualifier("servicioLinks")
    private ServicioLinks servicioLinks;


    @GetMapping("/links")
    public List<Links> links(){
        return servicioLinks.getLinks();
    }

    @GetMapping("/links/{id}")
    public Links buscarLink(@PathVariable String id){
        return servicioLinks.buscarLink(Integer.parseInt(id));
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Links links){
        servicioLinks.insertarLinks(links);
        return "Ok";
    }

    @GetMapping("/linkLess/{valor}")
    public List<Links> linksLess(@PathVariable Integer valor){
        return servicioLinks.buscarLinksPuntuacionMenorA(valor);
    }

    @GetMapping("linkBetween/{start}/{end}")
    public List<Links> linksBetween(@PathVariable Integer start, @PathVariable Integer end){
        return servicioLinks.buscarLinksEntre(start,end);
    }

    @GetMapping("/linkLessNative/{valor}")
    public List<Links> linksLessNative(@PathVariable Integer valor){
        return servicioLinks.buscarLinksMenorAVersionNativa(valor);
    }

    @GetMapping("/linkLessJQL/{valor}")
    public List<Links> linksLessJQL(@PathVariable Integer valor){
        return servicioLinks.buscarLinksMenorAVersionJQL(valor);
    }


}
