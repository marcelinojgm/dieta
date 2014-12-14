
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
    public float calorias()
    {
        return this.calorias;
    }
    /**
     * retorna el nombre del usuario
     */
       public String nombre()
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
        if(this.calorias > usuario.calorias())
        {
            compara = "mas";
        }
        else if (this.calorias < usuario.calorias())
        {
            compara = "menos";
        }
        else
        {
            compara = "las mismas";
        }
        System.out.println(nombre() + " ha consumido " + compara + " calorias que " + usuario.nombre());
    }
    

    
}
