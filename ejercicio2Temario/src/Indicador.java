import java.util.HashMap;

public class Indicador {
    private IndicadorTipo tipo;
    private HashMap<Alumno,Integer>alumnosNotas;

    public Indicador(IndicadorTipo tipo, HashMap<Alumno, Integer> alumnosNotas) {
        this.tipo = tipo;
        this.alumnosNotas = new HashMap<>();
    }

    public IndicadorTipo getTipo() {
        return tipo;
    }

    public void setTipo(IndicadorTipo tipo) {
        this.tipo = tipo;
    }

    public HashMap<Alumno, Integer> getAlumnosNotas() {
        return alumnosNotas;
    }

    public void setAlumnosNotas(HashMap<Alumno, Integer> alumnosNotas) {
        this.alumnosNotas = alumnosNotas;
    }
}
