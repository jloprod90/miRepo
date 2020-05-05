import java.util.ArrayList;

public class Asignatura {
    private String nombre;
    private ArrayList<Alumno>alumnosAsignatura;
    private ArrayList<Indicador>indicadoresAsignatura;

    public Asignatura(String nombre, ArrayList<Alumno> alumnosAsignatura, ArrayList<Indicador> indicadoresAsignatura) {
        this.nombre = nombre;
        this.alumnosAsignatura = alumnosAsignatura;
        this.indicadoresAsignatura = indicadoresAsignatura;
    }

    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.alumnosAsignatura =new ArrayList<>();
        this.indicadoresAsignatura =new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Alumno> getAlumnosAsignatura() {
        return alumnosAsignatura;
    }

    public void setAlumnosAsignatura(ArrayList<Alumno> alumnosAsignatura) {
        this.alumnosAsignatura = alumnosAsignatura;
    }

    public ArrayList<Indicador> getIndicadoresAsignatura() {
        return indicadoresAsignatura;
    }

    public void setIndicadoresAsignatura(ArrayList<Indicador> indicadoresAsignatura) {
        this.indicadoresAsignatura = indicadoresAsignatura;
    }

    public void mostrarAlumnos(){
        for(Alumno alumno:alumnosAsignatura){
            System.out.println(alumno);
        }
    }

    public Boolean alumnoEstaMatriculado(Alumno alumno){
    Boolean loContiene;
        if(alumnosAsignatura.contains(alumno)){
           loContiene=true;
        }else{
            loContiene=false;
        }
        return loContiene;

    }
}
