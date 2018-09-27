
package onlinecompany;

/**
 *
 * @author Mark Pendergast
 */
public class Item {
// khoi tao mat hang dua vao mo ta, ten, gia , so luong
    String upc = "";
    String name = "";
    int quantity = 0;
    double price = 0;
    
    public Item()
    {
        
    }
    
    public Item(String upc, String name, int quantity, double price)
    {
     this.upc = upc;
     this.name = name;
     this.quantity= quantity;
     this.price = price;
    }
    
}