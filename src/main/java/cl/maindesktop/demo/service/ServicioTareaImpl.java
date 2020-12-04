package cl.maindesktop.demo.service;

import cl.maindesktop.demo.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("servicioTarea")
public class ServicioTareaImpl implements ServicioTarea{

    @Override
    public Tarea buscarTarea(String id) {
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
}
