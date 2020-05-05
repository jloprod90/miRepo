import java.util.Objects;

public class Alumno {
    private String numeroAlumnado;
    private String nombre;
    private Integer edad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(numeroAlumnado, alumno.numeroAlumnado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroAlumnado);
    }
}
