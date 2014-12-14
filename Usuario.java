
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
    
    /**
     * simula la accion de comer un alimento
     */
    public void comer (Alimento aliemento , float gramosAlimento)
    {
        //macronutrientes ingeridos
        this.proteinas     = this.proteinas     + (gramosAlimento * (aliemento.getProteinas()     / 100));
        this.carbohidratos = this.carbohidratos + (gramosAlimento * (aliemento.getCarbohidratos() / 100));
        this.grasas        =  this.grasas       + (gramosAlimento * (aliemento.getGrasas()        / 100));
        
        //calorias ingeridas
        this.calorias = this.calorias + (gramosAlimento * (aliemento.getCalorias100g()/100));      
    }   
    
}
