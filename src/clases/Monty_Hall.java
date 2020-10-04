package clases;

// Hecho por @arhcoder.

public class Monty_Hall {
    
    public static void main(String[] args) {
        String coche = "  Coche  ";
        String nada = "   Nada  ";
        String abierta = " Abierta ";
        int election = 1;
        int newElection = 1;
        int repeticiones = 10000;
        int contador = 1;
        int victorias = 0;
        int derrotas = 0;
        double porcentajeVictorias = 0;
        double porcentajeDerrotas = 0;
        String resultado = "";
        int i;
        
        for (contador = 1; contador <= repeticiones; contador++)
        {
            // Vector que representa las puertas //
            String[] Puertas = new String[3];
            
            // Define la posición aleatoria del auto, entre 0 y 3 //
            int carPosition = (int) Math.floor(Math.random()* 3 + 1) - 1;
            
            // Asigna a todas las puertas, nada, y después, la posición del coche //
            for (i = 0; i <= 2; i++)
            {
                Puertas[i] = nada;
            }
            Puertas[carPosition] = coche;
            
            // El participante elige //
            election = (int) Math.floor(Math.random()* 3 + 1) - 1;
            
            // El presentador abre una puerta //
            boolean boolabiertas = false;
            for (i = 0; i <= 2; i++)
            {
                if(Puertas[i].equals(nada))
                {
                    if(election != i)
                    {
                        if (boolabiertas == false)
                        {
                            Puertas[i] = abierta;
                            boolabiertas = true;
                        }
                    }
                }
            }
            
            // Cambias de puerta. Es decir, eliges la otra puerta que está cerrada, la que no elegiste //
            for (i = 0; i <= 2; i++)
            {
                if((!Puertas[i].equals(abierta)) && (i != election))
                {
                    newElection = i;
                }
            }
            
            // Se abren las puertas, revelando el resultado y se suma la victoria o la derrota //
            if(Puertas[newElection].equals(coche))
            {
                resultado = "Ganado!";
                victorias++;
            }
            else
            {
                resultado = "Perdido!";
                derrotas++;
            }
            
            // Impresión de los resultados //
            // Se les suma 1 a las variables de elección, para que se muestren
            // del 1 al 3, en lugar de 0 a 2, como en el vector*
            election++; newElection++;
            for (i = 0; i <= 2; i++)
            {
                System.out.print("| "+ Puertas[i] + " |");
            }
            System.out.println("      Elección: Puerta " + election +
            "      Nueva Elección: Puerta " + newElection + "    "+resultado);
        }
        System.out.println("");
        System.out.println("______________________________________");
        System.out.println("RESULTADOS");
        System.out.println("______________________________________");
        System.out.println("VICTORIAS: " + victorias + " de " + repeticiones);
        System.out.println("DERROTAS:  " + derrotas + " de " + repeticiones);
        System.out.println("______________________________________");
        porcentajeVictorias = (double) (victorias * 100) / repeticiones;
        porcentajeDerrotas =  (double) (derrotas * 100) / repeticiones;
        System.out.println("VICTORIAS: " + porcentajeVictorias + "%");
        System.out.println("DERROTAS:  " + porcentajeDerrotas + "%");
        System.out.println("______________________________________");
    }
}