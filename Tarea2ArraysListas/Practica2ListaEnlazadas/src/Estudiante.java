public class Estudiante {
    int matricula;
    String nombre;
    double indiceAcademico;

    public Estudiante(int matricula, String nombre, double indice) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.indiceAcademico = indice;
    }

    @Override
    public String toString(){
        return "Matrícula: " + matricula + " " + "Nombre: " + nombre + " " + "Indice: " + indiceAcademico;
    }
}