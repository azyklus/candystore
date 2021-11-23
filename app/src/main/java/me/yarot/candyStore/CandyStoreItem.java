package me.yarot.candyStore;

public class CandyStoreItem
{
   private String product;
   private String size;
   private String packaging;
   private int noInStock;
   private double custCost;

   public CandyStoreItem(String product, String size, String packaging, String noInStock, String custCost)
   {
      setProduct(product);
      setSize(size);
      setPackaging(packaging);
      setNoInStock(Integer.parseInt(noInStock.trim()));
      setCustCost(Double.parseDouble(custCost.trim()));
   }

   public CandyStoreItem()
   {
      product = "BLANK";
      size = "BLANK";
      packaging = "BLANK";
      noInStock = 0;
      custCost = 0;
   }

   // Product setter + getter
   public void setProduct(String product)
   {
      this.product = product;
   }

   public String getProduct()
   {
      return product;
   }

   // Size setter + getter
   public void setSize(String size)
   {
      this.size = size;
   }

   public String getSize()
   {
      return size;
   }

   // Packaging setter + getter
   public void setPackaging(String packaging)
   {
      this.packaging = packaging;
   }

   public String getPackaging()
   {
      return packaging;
   }

   // Stock setter + getter
   public void setNoInStock(int noInStock)
   {
      this.noInStock = noInStock;
   }

   public int getNoInStock()
   {
      return noInStock;
   }

   // Cost setter + getter
   public void setCustCost(double custCost)
   {
      this.custCost = custCost;
   }

   public double getCustCost()
   {
      return custCost;
   }

   ///////////////////////////
}
