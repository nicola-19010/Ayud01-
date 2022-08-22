import java.util.*;

public class BlackJack {

    public static void main(String[] args) {
        String[][] baraja = crearBaraja();
        //imprime la baraja creada
        mostrarMatrizString(baraja);

        String[] mano = crearMano();
        //imprime la mano
        mostrarArrayString(mano);

        barajar(baraja);
        //imprime la baraja ya desordenada
        mostrarMatrizString(baraja);

        repatir(baraja, mano);
        mostrarArrayString(mano);

        String cartafila1Pinta = baraja[0][(int) (Math.random() * baraja[0].length)];
        String cartafila2numero = baraja[1][(int) (Math.random() * baraja[0].length)];

        System.out.println("cartafila1Pinta = " + cartafila1Pinta);
        System.out.println("cartafila2numero = " + cartafila2numero);


        mostrarArrayString(mano);
        pedirCarta(baraja, mano);
        mostrarArrayString(mano);







    }

    public static String[][] crearBaraja() {
        var pintas = new String[]{"Corazon", "Diamante", "Trebol", "Pica"};
        var numerosCartas = new String[]{"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        return new String[][]{pintas, numerosCartas};
    }

    public static String[] crearMano() {
        return new String[2];
    }

    public static void barajar(String[][] baraja){
            for(int i = 0; i < baraja.length; i++){
                Random rnd = new Random();
                for (int o = baraja[i].length - 1; o > 0; o--)
                {
                    int index = rnd.nextInt(o + 1);
                    String a = baraja[i][index];
                    baraja[i][index] = baraja[i][o];
                    baraja[i][o] = a;
                }
            }

    }


    public static void repatir(String[][] baraja, String[] mano) {

        var carta = new String[2];

        for (var j = 0; j < mano.length; j++) {                                     //recorre la baraja y coge
            for (var i = 0; i < baraja.length; i++) {                               //en la primera vuelta: una pinta de una posicion al azar y la guarda en la posicion 0 de la mano
                carta[i] = baraja[i][(int) (Math.random() * baraja[i].length)];     //en la segunda vuelta: un numero de en una posicion al azar de la segunda fila de la matriz y la guarda en la posicion 1 de la mano
            }
            mano[j] = carta[0] + " " + carta[1];
        }
    }

    public static void pedirCarta(String[][] baraja, String[] manoActual){
        List <String> manoNewLista = new ArrayList<>();
        System.out.println("manoNewLista = " + manoNewLista);
        manoNewLista = Arrays.asList(manoActual);
        System.out.println("manoNewLista = " + manoNewLista);

        //Sacamos una nueva carta del mazo
        var carta = new String[2];
        for (var i = 0; i < baraja.length; i++) {                               //en la primera vuelta: una pinta de una posicion al azar y la guarda en la posicion 0 de la mano
            carta[i] = baraja[i][(int) (Math.random() * baraja[i].length)];     //en la segunda vuelta: un numero de en una posicion al azar de la segunda fila de la matriz y la guarda en la posicion 1 de la mano
        }

        String nuevaCarta =  carta[0] + " " + carta[1];
        //agregamos la nueva carta
        manoNewLista.add(nuevaCarta);

        //crear de nuevo la mano en formato array
        //String[] mano = new String[manoNewLista.size()];
        //mano = manoNewLista.toArray(mano);

    }


    //Metodos auxiliares, No forman parte de la solucion son para visualizar el proceso
    public static void mostrarMatrizString(String[][] matriz){
        for (String[] row : matriz)
            System.out.println(Arrays.toString(row));
        System.out.println();
    }

    public static void mostrarArrayString(String[] array){
        System.out.println(Arrays.toString(array));
    }

}
