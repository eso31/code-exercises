public class Vaca {
    public int getPeso() {
        return peso;
    }

    public Vaca[] getBecerros() {
        return becerros;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setBecerros(Vaca[] becerros) {
        this.becerros = becerros;
    }

    public Vaca(){

    }

    public Vaca(int peso){
        this.peso = peso;
    }

    public int peso;
    public Vaca[] becerros;
}
