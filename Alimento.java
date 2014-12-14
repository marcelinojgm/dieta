
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
    private float carbohidratos;
    private float grasas;

    /**
     * Constructor indicando nombre y cantidad de cada macronutriente por cada 100 g del alimento
     */
    public Alimento(String nombre, float proteinas, float carbohidratos, float grasas)
    {
        //inicializacion del nombre del alimento
        this.nombre = nombre;

        //inicializacion de macronutrientes
        this.proteinas     = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas        = grasas;

    }

    /**
     * muestra los datos del alimento segun su composicion
     */
    public void muestraDatos()
    {
        System.out.println("Nombre:                            " + this.nombre);
        System.out.println("Proteinas por cada 100 gramos:     " + this.proteinas);
        System.out.println("Carbohidratos por cada 100 gramos: " + this.carbohidratos);
        System.out.println("Grasas por cada 100 gramos:        " + this.grasas);
        System.out.println("Calorias:                          " + calorias100g());
        System.out.println("Componente/s mayoritario/s:        " + mayoritario());

    }

    /**
     * retorna calorias en 100g del alimento segun sus macronutrientes
     */

    public float calorias100g()
    {
        float calorias;
        calorias = 0;
        calorias = calorias + (this.proteinas * 4);
        calorias = calorias + (this.carbohidratos * 4);
        calorias = calorias + (this.grasas * 9);
        return calorias;
    }

    /**
     * retorna string con el/los macronutrientes mayotiario/s
     */

    public String mayoritario()
    {
        String mayoritario; 
        mayoritario = "";
        //todos en la misma proporcion
        if (this.proteinas == this.carbohidratos && this.carbohidratos == this.grasas )
        {
            mayoritario = "todos los macronutruentes estan en la misma proporcion";
        }
        //misma proporcion proteinas y carbohidratos    
        else if (this.proteinas == carbohidratos)
        {
            if(this.proteinas > this.grasas)
            {
                mayoritario = "proteinas y carbohidratos";
            }
            else
            {
                mayoritario = "grasas";
            }
        }

        //misma proporcion proteinas y grasas
        else if (this.proteinas == this.grasas)
        {
            if (this.proteinas > this.carbohidratos)
            {
                mayoritario = "proteinas y grasas";
            }

            else
            {
                mayoritario = "carbohidratos";
            }

        }

        ////misma proporcion carbohidratos y grasas
        else if (this.carbohidratos == this.grasas)
        {
            if(this.carbohidratos > this.proteinas)
            {            
                mayoritario = "carbohidratos y grasas";
            }
            else
            {
                mayoritario = "proteinas";
            }
        }

        //distintas proporciones
        else
        {
            if (this.proteinas > this.carbohidratos)
            {
                if( this.proteinas > this.grasas)
                {
                    mayoritario = "proteinas";                 
                }
                else
                {
                    mayoritario = "grasas";
                }

            }
            else
            {
                if(this.carbohidratos > this.grasas)
                {
                     mayoritario = "carbohidratos";
                }
                else
                {
                    mayoritario = "grasas";
                }
            }
        }
        return mayoritario;
    }
}
