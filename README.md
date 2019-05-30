# Food-Ordering-Website
A food ordering website made using Java, JDBC, JSP and servlets.

I made this project during my 4th semester for my Advanced Java course. We were supposed to use JSP and Servlets for the same.
The website was on local host using Tomcat server. JDBC and MYSQL were used to create a database for the application.
<br>
<br>
I will now walk you through the different webpages and features of the website.
All the images used for the project were copyright free when I used them. If they do belong to someone let me know and I'll remove them.
<br>
<br>
### Login Page
This is a simple html page which has a form and uses 'post' method to pass on the form values to ***loginCheck.java*** for validating login.
One can also register a new account if they don't have an existing account.

![A screenshot of the login page](screen_shots/Screenshot%202019-05-29%20at%2012.08.00%20PM.png)

<br>

### Register Page
This page is again using a form to get information from the user using 'post' method to pass on the form values to ***registerInput.java*** for registering the new user and making a corresponding entry in the database. Certain constraints were put on values being entered for the email and password to verify they're in the correct format and adequate length using **regex**. 

![A screenshot of the register page](screen_shots/Screenshot%202019-05-30%20at%2012.13.34%20PM.png)

After entering the required information and clicking on the Register button the user is redirected back to the login page where they can login using their registered email id and password.

![A screenshot of the login page](screen_shots/Screenshot%202019-05-30%20at%2012.14.17%20PM.png)

### Welcome Page
Once the user has successfully logged in they will be taken to the menu page i.e. ***Welcome.jsp*** and the users session will start. This page has a navigation bar with a logout button and a button to go to the cart.
Further it has multiple containers with the images of various food items with buttons to add them to cart. If a user clicks on logout their session ends and they're redirected to the login page.
If a user clicks on the **Add to Cart** button a value is passed to ***addToCart.jsp*** this program adds the item to cart while the user is still on the menu page. A user can add multiple items to their cart.

![A screenshot of the Welcome page](screen_shots/2019-05-30%2013.02.58.gif)

### Cart Page
When the user clicks on **Cart** button on the navigation bar they're taken to ***cart.jsp*** where the added items are shown to the user.
![A screenshot of the Cart page](screen_shots/Screenshot%202019-05-30%20at%201.05.27%20PM.png)

From this page the user can either go back to the menu page to add more items by clicking on **Continue Shopping** button or click on **Checkout** Button. 
### Checkout Page
On clicking the checkout button the user is taken to ***Checkout.jsp*** page. On This page the user has only one option that is to logout.
![A screenshot of the Checkout page](screen_shots/Screenshot%202019-05-30%20at%201.05.39%20PM.png)

<br>
<br>
<br>
Now, coming to the database part of the application. I used MYSQL to create my database and tables. It was connected to my java code using JDBC.
The following are the tables which were created in the db.

![](screen_shots/Screenshot%202019-05-30%20at%2010.12.05%20PM.png)

### customer table
Schema is as follows

![](screen_shots/Screenshot%202019-05-30%20at%2010.20.37%20PM.png)

### drinks table
Schema is as follows

![](screen_shots/Screenshot%202019-05-30%20at%2010.21.38%20PM.png)

### food table
Schema is as follows

![](screen_shots/Screenshot%202019-05-30%20at%2010.21.48%20PM.png)

### drinkOrder table
Schema is as follows

![](screen_shots/Screenshot%202019-05-30%20at%2010.21.23%20PM.png)

### foodOrder table
Schema is as follows

![](screen_shots/Screenshot%202019-05-30%20at%2010.21.57%20PM.png)

### totalOrder table
Schema is as follows

![](screen_shots/Screenshot%202019-05-30%20at%2010.22.08%20PM.png)

