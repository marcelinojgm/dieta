import java.util.ArrayList;

/**
 * Simula un usuario con su nombre y los datos de macronutrientes y calorias que ha ingerido
 * 
 * @author Marcelino José Granda Muñoz
 * @version (a version number or a date)
 */
public class Usuario
{
    //nombre del usuario
    private String nombre;

    //macronutrientes que ha ingerido el usuario
    private float proteinas;
    private float carbohidratos;
    private float grasas;

    //numero de calorias ingeridas
    private float calorias;

    //guarda el alimento mas calorico por 100g consumido 
    private Alimento alimentoCalorico;

    //coleccion de alimentos que se van ingeriendo
    private ArrayList<Alimento> listaAlimentos;

    /**
     * Constructor for objects of class Usuario
     */
    public Usuario(String nombre)
    {
        //nombre del usuario
        this.nombre = nombre;
        // macronutrientes antes de empezar a comer 
        this.proteinas     = 0F;
        this.carbohidratos = 0F;
        this.grasas        = 0F;

        //calorias antes de empezar a comer
        this.calorias = 0F;

        this.alimentoCalorico = null;
    }

    /**
     * simula la accion de comer un alimento
     */
    public void comer (Alimento alimento , float gramosAlimento)
    {
        //macronutrientes ingeridos
        this.proteinas     = this.proteinas     + (gramosAlimento * (alimento.getProteinas()     / 100));
        this.carbohidratos = this.carbohidratos + (gramosAlimento * (alimento.getCarbohidratos() / 100));
        this.grasas        =  this.grasas       + (gramosAlimento * (alimento.getGrasas()        / 100));

        //calorias ingeridas
        this.calorias = this.calorias + (gramosAlimento * (alimento.getCalorias100g()/100));
        //agregado a la lista de alimentos consumidos
        listaAlimentos.add(alimento);

        //comparacion con el alimento mas calorico
        alimentoCalorico(alimento);
    }  

    /**
     * muestra los datos sobre macronutrientes y calorias ingeridas hasta el momento
     */
    public void estadisticas()
    {
        System.out.println("Nombre:                            " + this.nombre);
        System.out.println("Gramos de proteinas ingeridos:     " + this.proteinas);
        System.out.println("Gramos de carbohidratos ingeridos: " + this.carbohidratos);
        System.out.println("Grasas por cada 100 gramos:        " + this.grasas);
        System.out.println("Calorias ingeridas:                " + this.calorias);
    }

    /**
     * muestra los datos sobre macronutrientes y calorias ingeridas hasta el momento en porcentajes
     */
    public void estadisticasPorecentaje()
    {
        if(this.calorias == 0)
        {
            System.out.println("Nombre:                            " + this.nombre);
            System.out.println("Gramos de proteinas ingeridos:     " + this.proteinas);
            System.out.println("Gramos de carbohidratos ingeridos: " + this.carbohidratos);
            System.out.println("Grasas por cada 100 gramos:        " + this.grasas);
            System.out.println("Calorias ingeridas:                " + this.calorias);
        }
        else
        {
            float total;
            //total de macronutrientes
            total = this.proteinas + this.carbohidratos +this.grasas;

            System.out.println("Nombre:                            " + this.nombre);
            System.out.println("Gramos de proteinas ingeridos:     " + this.proteinas       + " (" + (this.proteinas     / total) + ")" );
            System.out.println("Gramos de carbohidratos ingeridos: " + this.carbohidratos   + " (" + (this.carbohidratos / total) + ")");
            System.out.println("Grasas por cada 100 gramos:        " + this.grasas          + " (" + (this.grasas        / total) + ")");
            System.out.println("Calorias ingeridas:                " + this.calorias);
        }
    }

    /**
     * retorna el numero de calorias consumidas
     */
    public float getCalorias()
    {
        return this.calorias;
    }

    /**
     * retorna el nombre del usuario
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * compara al usuario con otro y imprime por pantalla un mensaje con quien ha consumido mas calorias
     */
    public void compara(Usuario usuario)
    {
        String compara;
        compara = "";
        if(this.calorias > usuario.getCalorias())
        {
            compara = "mas";
        }
        else if (this.calorias < usuario.getCalorias())
        {
            compara = "menos";
        }
        else
        {
            compara = "las mismas";
        }
        System.out.println(getNombre() + " ha consumido " + compara + " calorias que " + usuario.getNombre());
    }

    /**
     * guarda el alimento mas calorico por 100g consumido hasta ahora
     */
    private void alimentoCalorico(Alimento alimento )
    {
        //si ya se a comido con anterioridad
        if (this.alimentoCalorico != null)
        {
            if(this.alimentoCalorico.getCalorias100g() <= alimento.getCalorias100g())
            {
                this.alimentoCalorico = alimento;
            }
        }
        //si todavia no ha comido nada
        else
        {
            this.alimentoCalorico = alimento;
        }
    }

    /**
     * imprime que alimmento ha sido el mas calorico por 100g hasta el momento
     */
    public void imprimeAliemntoCalorico()
    {
        System.out.print("Alimento más calórico ingerido por el usuario hasta el momento: " + this.alimentoCalorico.getNombre());
    }

    /**
     * imprime las estadisticas de un alimento introduciendo mediante un entero la posicion en la que se consumio
     */
    public void estadisticaAlimentoListado(int posicion)
    {
        // le damos a la posicion el valor del indice correspondiente
        posicion = posicion - 1;
        // si ya a comido
        if ( this.listaAlimentos.size() != 0)
        {
            //mensaje de error al introducir posicion no valida
            String error = "ERROR introduzaca un valor valido en el rango [1-" + listaAlimentos.size() + "]";
           
            if(posicion < listaAlimentos.size())
            {
                //impresion datos del alimento en la posicion indicada
                if(posicion >= 0)
                {
                    this.listaAlimentos.get(posicion).muestraDatos();
                }
                //posicion no valida
                else
                {
                    System.out.println(error);
                }
            }
            //posicion no valida
            else
            {
                System.out.println(error);
            }

        }
        //todavia no a comido nada
        else 
        {
            System.out.println("Por el momento no se ha comido nada");
        }

    }
}
