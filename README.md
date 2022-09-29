# Retrofit with MVVM & RecyclerView

## How MVVM works ?
By using a ViewModel that get the Data from APIs , DataBase or other External resources and put them in the View by using DataBinding and LiveData .

## Model :
![Model View ViewModel ](https://i0.wp.com/resocoder.com/wp-content/uploads/2018/08/mvvm-architecture-complete-overview.png?w=492&ssl=1)


## Advantages of MVVM Pattern:
   - Enhance the reusability of code.
   - All modules are independent which improves the testability of each layer.
   - Makes project files maintainable and easy to make changes.

## Disadvantages of MVVM Pattern:
   - This design pattern is not ideal for small projects.
   - If the data binding logic is too complex, the application debug will be a little harder.


## What are Modules I used ??
   - module "pojo" : put all models of resources : local AND remote. 
   - repository : we can see the Repository serves as a mediator between the ViewModel and the sources of data , and it provides this data to the rest of the app
   - ui : contains my ViewModels / Screens
  
  
## What's the Importance of use Repository on MVVM ??
   - provide a clean API for accessing data.
   - gather data from different data sources(different REST APIs, cache, local database storage) and it provides this data to the rest of the app.
   -  serves as a single source of truth.
    keep the local database up to date with the newest fetched data from remote service so that the application can still provide its functionalities with bad Internet connection or no connection at all.
    
    
## Repository Functionalities:
![Repository Functions](https://digitalkraft-consulting.de/wp-content/uploads/2022/01/1-5.png)

## What's Retrofit :
   - Retrofit library developed by Square to handle REST API calls in our android application.
   - Retrofit is type-safe REST client for Android and Java which aims to make it easier to consume RESTful web services.
  
  
## What's the components of Retrofit ??
   - Base URL
   - API Inerface : to put all abstract methods of GET , POST , FETCH ...
   - Prerpare Retrofit Builder.
   - Converter : which convert the data from HTTP to JSON to finally Model Class .
   - CallBack to listen when the Call is received succefully OR failed.
   
   
 ## Why we use RetrofitClient ??
 to write our Retrofit Builder and all their components once , maintain our code and to follow MVVM .
 
 
 
 
