# Papa-s Pizzeria
<img width="320" height="200" alt="image" src="https://github.com/user-attachments/assets/2940e849-999b-4354-9cde-31d723e1cb99" />

  ## WELCOME TO PAPA'S PIZZERIA
 Papa's pizzeria is a ordering system that lets customers build their own pizza by choosing size, crust, sauce cheese and a variety of toppings.

 Customers can also add a drink and choose flavor plus add garlic knots to their order.

 Once customer is done they can checkout and a receipt is printed out that lists all the items they got plus the prices.
                        
                              ---------------------------------       Idea Structure          -------------------------------

 <img width="955" height="548" alt="image" src="https://github.com/user-attachments/assets/34748940-2c88-4a13-9105-af2ff4497098" />


 ## What each class does?
 -  OrderItem (interface) - A contract that says "anything orderable must have these 4 methods: getSize, getPrice, getQuantity, getDescription"
 - Product (abstract class) - Represents any item you can order. Implements the OrderItem interface. You never create a "Product" directly, only specific types.
-  Drink, GarlicKnots, Pizza - Specific types of products you can actually order. Each one extends Product.
-  Sauce, Crust, Topping - The ingredients/parts that make up a Pizza.
 
##  Why I seperated Sauce, Topping, Crust ? 
 - They use composition ("has-a") not inheritance ("is-a")
 - A Pizza has a Crust
 - A Pizza has a Sauce
 - A Pizza has Toppings

   ## Challenges / Approaches

   - Trying to use lambda expressions to display my array list of item ex all toppings, sauces, drink, drink flavors
   - Learned about intStream range and how it works
  
   -  Creating a seperate receipt for each order
   - I created a method inside the Order class called saveReceipt(), so all receipt-related logic stays organized in one place. I generated a unique filename using details like the date/time or order number (example: receipt_20251113_1823.txt).I created a folder named "Receipts/" and saved each receipt file inside it. I used FileWriter and BufferedWriter to write the receipt text into the new file.
  
   - How to display extra prices and where to implement them in
   - I created a switch statement inside the Topping class that determines the price of a topping based on the user’s selection. Each case matches a topping name or number and assigns the correct price.







   ### Resourceful websites I used/ learned about
   https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
   https://www.geeksforgeeks.org/java/intstream-range-java/
   https://stackoverflow.com/questions/1053467/how-do-i-save-a-string-to-a-text-file-using-java
   https://www.baeldung.com/java-write-to-file
   


