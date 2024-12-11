package set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PermisosManager {

    public static Permisos cargarPermisos(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("clase PermisosManager = " + mapper.readValue(json, Permisos.class));//borrar
            return mapper.readValue(json, Permisos.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}