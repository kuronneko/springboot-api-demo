package cl.maindesktop.demo.api;


import cl.maindesktop.demo.component.HelloComponent;
import cl.maindesktop.demo.entity.Links;
import cl.maindesktop.demo.model.Tarea;
import cl.maindesktop.demo.service.ServicioLinks;
import cl.maindesktop.demo.service.ServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
//http://localhost:8080/api


public class ApiBasica {

    @Autowired
    @Qualifier("helloComponent")
    private  HelloComponent component;

    @Autowired
    @Qualifier("servicioTarea")
    private ServicioTarea service;


    @Autowired
    @Qualifier("servicioLinks")
    private ServicioLinks servicioLinks;

    // ------ CRUD LINKS --------------

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


    // -------- EJEMPLOS DE RECURSOS
    @GetMapping("/hello")
    public String hello(){
        return component.saludo();
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return component.saludo(name);
    }


    @GetMapping("/tarea")
    public Tarea tarea(){
        return new Tarea("T-01","Comprar x", "alta");
    }

    @GetMapping("/tareas")
    public List<Tarea> tareas(){
      return component.tareaList();
    }

    @GetMapping("/tareas/{id}")
    public Tarea tarea(@PathVariable String id){
          return service.buscarTarea(id);
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "Hola "+name+" Tu nombre es capturado mediante POST";
    }

    @PostMapping(path = "/hello2",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String helloFormUrlEncode(String name, String age){
        return "Hola "+name+" tu nombre es capturado con el formato urlencode y tu edad es "+age;
    }

    @PostMapping(path = "/mitarea", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String helloJsonFormat(@RequestBody Tarea tarea){
        return "Hola tarea "+tarea.toString();
    }

    @PostMapping(
                path = "/mitarea2",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Tarea helloJsonFormat2(@RequestBody Tarea tarea){
        return tarea;
    }



    /*
    //http://localhost:8080/api/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "Hello "+ name+ " Welcome to Spring Boot";
    }
    */
    /*
    @GetMapping("/tareas")
    public List<Tarea> tareas(){
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("T-01", "Tarea #1", "Media"));
        tareas.add(new Tarea("T-02", "Tarea #2", "Baja"));
        tareas.add(new Tarea("T-03", "Tarea #3", "Alta"));
        return tareas;
    }
    */
/*
    @GetMapping("/tareas/{id}")
    public Tarea tarea(@PathVariable String id){
        List<Tarea> tareaList = new ArrayList<>();
        tareaList.add(new Tarea("T-01", "Tarea #1", "Media"));
        tareaList.add(new Tarea("T-02", "Tarea #2", "Baja"));
        tareaList.add(new Tarea("T-03", "Tarea #3", "Alta"));

        for(Tarea tarea : tareaList){
            if(tarea.getId().equals(id)){
                return tarea;
            }
        }
        return null;
    }
*/

}
