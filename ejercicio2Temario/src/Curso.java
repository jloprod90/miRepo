import java.util.ArrayList;
public class Curso { 
   private String nombre;
   private ArrayList<Asignatura>asignaturasDelCurso;
   private ArrayList<Alumno>alumnosCurso;

    public Curso(String nombre, ArrayList<Asignatura> asignaturasDelCurso, ArrayList<Alumno> alumnosCurso) {
        this.nombre = nombre;
        this.asignaturasDelCurso = asignaturasDelCurso;
        this.alumnosCurso = alumnosCurso;
    }

    public Curso(String nombre) {
        this.nombre = nombre;
        this.asignaturasDelCurso = new ArrayList<>();
        this.alumnosCurso = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Asignatura> getAsignaturasDelCurso() {
        return asignaturasDelCurso;
    }

    public void setAsignaturasDelCurso(ArrayList<Asignatura> asignaturasDelCurso) {
        this.asignaturasDelCurso = asignaturasDelCurso;
    }

    public ArrayList<Alumno> getAlumnosCurso() {
        return alumnosCurso;
    }

    public void setAlumnosCurso(ArrayList<Alumno> alumnosCurso) {
        this.alumnosCurso = alumnosCurso;
    }
    
    public void mostrarAsignaturas(){
        for (Asignatura asignatura :asignaturasDelCurso) {
            System.out.println(asignatura);
        }
    }

    public void listadoNotasAlumno(Alumno alumno){


        if(alumnosCurso.contains(alumno)==false){
            System.out.println("el alumno no pertenece a este curso");
        }else{
            for(Asignatura asignatura:asignaturasDelCurso){

                alumno.equals(asignatura);

                if(asignatura.alumnoEstaMatriculado(alumno)==true){
                    for(Indicador indicador:asignatura.getIndicadoresAsignatura()){
                        if(indicador.getAlumnosNotas().containsKey(alumno)){
                            System.out.println(indicador.getAlumnosNotas().get(alumno));
                        }
                    }
                }
            }
        }
    }
    
}
