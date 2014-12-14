
/**
 * Simula un alimento con sus macronutrientes
 * 
 * @author Marcelino José Granda Muñoz
 * 
 */
public class Alimento
{
    //nombre del alimento
    private String nombre;
    // gramos de cada macronutrinte por cada 100 gramos de alimento
    private float proteinas;
    private float cabohidratos;
    private float grasas;

    /**
     * Constructor indicando nombre y cantidad de cada macronutriente por cada 100 g del alimento
     */
    public Alimento(String nombre, float proteinas, float cabohidratos, float grasas)
    {
        //inicializacion del nombre del alimento
        this.nombre = nombre;
        
        //inicializacion de macronutrientes
        this.proteinas     = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas        = grasas;
        
    }

    
}
