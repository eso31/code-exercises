import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExercise {
    public static void main(String[] args) {

        List<Vaca> vacas = new ArrayList<>();
        Vaca vaca = new Vaca(10);
        vaca.setBecerros(new Vaca[]{new Vaca(10),new Vaca(10)});
        vacas.add(vaca);
        Vaca vaca2 = new Vaca(10);
        vaca2.setBecerros(new Vaca[]{new Vaca(10),new Vaca(10)});
        vacas.add(vaca2);

        int x = vacas.stream()
                .mapToInt(v->v.peso + Arrays.stream(v.becerros)
                        .mapToInt(b->b.peso)
                        .reduce(0, (a,b)->a+b))
                .reduce(0, (a,b) -> a+b);


        System.out.println(x);
    }
}
