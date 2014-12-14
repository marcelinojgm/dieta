
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
    }

    
}
