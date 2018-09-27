package onlinecompany;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author Mark Pendergast
 */
public class ShoppingCart {
    
    ArrayList<Item> itemlist = new ArrayList<Item>();  // list of Items in the cart
    // tao mang itemlist, de xu ly sau nay
    public ShoppingCart()
    {
        
    }
     public void empty()
     {
       itemlist.clear();
     }
    //
     // add an item to the cart
     // if its there already, just update the upc
     //   
    public void add(Item anitem)
    { // bien la anitem, kieu Item
    // lap theo kich thuoc mang itemlist
     for(int i = 0; i < itemlist.size(); i++)
     {
     Item item = itemlist.get(i); // lay phan tu thu i, cua mang itemlist,gan cho bien item.
     // neu thuoc tinh upc cua item nay giong 
     // neu upc cua anitem duoc gan vao, giong voi item.upc trong danh sach truoc do. 
      if(anitem.upc.equals(item.upc)) // already in the cart?
      { // so luong trong danh sach se duoc tang them = so luong cua bien gan vao. 
       item.quantity += anitem.quantity; // yes, just update the quantity
       return;
      }
     }// them doi tuong gan vao danh muc mang 1 chieu. 
     itemlist.add(anitem); // no, add it as a new item
    }
     
   //
   // Display the current contents of the cart as an html table
   // 
   public void display(JspWriter out)
     {
     try{
      java.text.DecimalFormat currency = new java.text.DecimalFormat("$ #,###,##0.00");
      //
      // start the table and output the header row
      //
      out.println("<h3>Cart contents</h3>");
      out.println("<table border=1>");
      out.println("<tr>"
      		+ "			<th>UPC</th>"
      		+ "			<th>Name</th>"
      		+ "			<th>Price</th>"
      		+ "			<th>Quantity</th>"
      		+ "			<th>Total</th>"
      		+ 	"</tr>");
    
      double total = 0;
      // 
      // output one item at a time from the cart, one item to a row table
      //
      for(int i = 0; i < itemlist.size(); i++)
      {
       Item item = (Item)itemlist.get(i);
       out.println("<tr>"
       		+ "			<td>"+item.upc+"</td>"+
                 		"<td>"+item.name+"</td>"+
                 		"<td align=right>"+ currency.format(item.price)+"</td>"+
                 		"<td align=right>"+ item.quantity+"</td>"+
                 		"<td align=right>"+ currency.format(item.price*item.quantity)+"</td>"
                 + "</tr>");
       total += item.price*item.quantity;
      }
      //
      // add summary information (total, tax, grand total)
      //
       out.println("<tr><td colspan = 4>Total purchase</td>");
       out.println("<td align=right>"+currency.format(total)+"</td></tr>");
       out.println("<tr><td colspan = 4>Sales tax @6%</td>"+
                  "<td align=right>"+ currency.format(total*.06)+"</td></tr>");
       out.println("<tr><td colspan = 4>Amount due</td>"+
                  "<td align=right>"+ currency.format(total*1.06)+"</td></tr>");
       out.println("</table>");

     }
     catch(IOException ex)
     {
      // exception was thrown by the out object, so we can't really report it to the client
      System.err.println(ex.toString());  // just send the exception to the error log
     }
   }
     
}
