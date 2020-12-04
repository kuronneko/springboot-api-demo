package cl.maindesktop.demo.component;

import cl.maindesktop.demo.model.Tarea;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("helloComponent")
public class HelloComponent {

    public String saludo(){
        return "Hola desde un component";
    }

    public String saludo(String nombre){
        return "Hola "+nombre+ ", desde un component";
    }

    public List<Tarea> tareaList(){
        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("T-01", "Tarea #1", "Media"));
        tareas.add(new Tarea("T-02", "Tarea #2", "Baja"));
        tareas.add(new Tarea("T-03", "Tarea #3", "Alta"));
        return tareas;
    }
}
