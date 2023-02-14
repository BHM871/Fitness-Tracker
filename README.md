<h1 align="center">Fitness Tracker</h1>

<h3 align="center">This application is used to calculate the body Body Mass Index (BMI) and Basal Métabolica Rate (TMB) and save this data in a RoomDatabase data collection, with the value and time it was saved.</h3>

<div align="center">
 <img src="https://img.shields.io/static/v1?label=license&message=MIT&color=blue&style=flat">
</div>

<h2>Índice</h2>

<!--ts-->
  * [Utilities](#utilities)
  * [Models](#models)
  * [Activitys](#activitys)
<!--te-->

<article id="utilities">
 <h2 align="center">Utilities</h2>
 <p align="center">In this topic I will describe the class which has utilities for the other classes.</p>
 
 <section id="aplication">
  
## [Aplication](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/Application.kt)
  
  <div id="objective-aplication">
   <h3>Objective</h3>
   <p>
    This class is intended to contain generic functionality that can be accessed by any Activity.
   </p>
  </div>
  
  <div id="functions-aplication">
   <h3>:hammer: Features</h3>
   
- `fun dialog(activity: Activity, title: String, result: Double, response: Int? = null, updateId: Int?, type: String)`:
 This function aims to create an Alert Dialog that shows the value of the IMC or TMB and may or may not save or edit the value shown.
- `fun closeKeyboard(activity: Activity)`:
 This function aims to close the keyboard being shown in the activity passed in the
- `fun toastGeneric(context: Context, resId: Int)`:
 This function aims to create a Toast.
- `fun openListActivity(activity: Activity, type: String)`:
 This function aims to open the Open List activity by passing the type to define which values will be shown, those of the BMI or TMB.

  </div>
 </section>
 
 <section id="database-list">
  
## [Database List](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/util/DatabaseList.kt)
  
  <div id="objective-database">
   <h3>Objective</h3>
   <p>
    This class aims to create and manage the local database.
   </p>
  </div>
  
  <div id="functions-database">
   <h3>:hammer: Features</h3>
   
 - `fun getInstance(context: Context): DatabaseList`:
  This function is intended to create and instantiate the database, when the database already exists it only instantiates.
   
  </div>
 </section>
 
 <section id="date-converter">
  
## [Date Converter](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/util/DateConverter.kt)
  
  <div id="objective-converter">
   <h3>Objective</h3>
   <p>
    This class aims to convert data of type Long to Date and date type to Long.
   </p>
  </div>
  
  <div id="functions-converter">
  <h3>:hammer: Features</h3>
   
- `fun toDate(longDate: Long?): Date?`:
 This function aims to convert from Long to Date and return the Date value.
- `fun fromDate(date: Date?): Long?`:
 This function aims to convert from Date to Long and return the Long value.
   
  </div>
 </section>
 
 <section id="on_click">
  
## [On Click](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/util/OnClicks.kt)
  
  <div id="objective-converter">
   <h3>Objective</h3>
   <p>
    This interface creates two OnClicks functions
   </p>
  </div>
 </section>
</article>

<article id="models">
 <h2 align="center">Models</h2>
 <p align="center">In this topic I will describe the features of the models used.</p>
 
 <section id="list-dao">
  
## [List DAO](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/model/ListDao.kt)
  
  <div id="objective-dao">
   <h3>Objective</h3>
   <p>
    This interface aims to create the API that the database will use.
   </p>
  </div>
  
  <div id="functions-dao">
   <h3>:hammer: Features</h3>
   
- `@Insert fun insert(itemListCalcu: ItemListCalcu)`:
 This function defines the given type that will be added when the function is called.

- `@Query("SELECT * FROM ItemListCalcu WHERE type = :type") fun getListCalcuByType(type: String?): List<ItemListCalcu>`:
 This function defines the rules for fetching all items of one of the data types, the BMI and TMB.

- `@Query("SELECT * FROM ItemListCalcu WHERE id = :id") fun getCalcuById(id: Int?): ItemListCalcu`:
 This function defines the rules for searching for a specific item.

- `@Delete fun deleteItem(itemListCalcu: ItemListCalcu)`:
 This function defines the rules for deleting a specific item.

- `@Update fun updateItem(itemListCalcu: ItemListCalcu)`:
 This function defines the rules for updating the value of a specific item.
   
  </div>
 </section>
 
 <section id="lists">
  
## [Lists](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/model/Lists.kt)
  
  <div id="objective-lists">
   <h3>Objective</h3>
   <p>
    This file is intended to contain the definitions of models for objects used in the application.
   </p>
  </div>
  
  <div id="functions-lists">
   <h3>:hammer: Features</h3>
   
- `data class Button(val id: Int,m@DrawableRes val img: Int, @StringRes val text: Int)`:
 This data class aims to define the attributes for the Main Activty buttons.

- `@Entity data class ItemListCalcu(@PrimaryKey(autoGenerate = true) val id: Int = 0, @ColumnInfo(name = "type") val type: String, @ColumnInfo(name = "res")val res: Double, @ColumnInfo(name = "date")val date: Date = Date())`:
 This data class defines a database entity, defining its parameters as the attributes of the entity.
   
  </div>
 </section>
</article>

<article id="activitys">
 <h2 align="center">Activitys</h2>
 <p align="center">In this topic I will describe all activities, such as their functions and objectives</p>
 
 <section id="main-activity">
  
## [Main Activity](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/MainActivity.kt)
  
  <div id="objective-main">
   <h3>Objective</h3>
   <p>
    The main purpose of this class is to show the options of the application, to calculate the BMI and the calculation of the TMB.
   </p>
  </div>
  
  <div id="functions-main">
   <h3>:hammer: Features</h3>
    
- `private inner class AdapterMain(val buttons: List<Button>, val listener: ((Button) -> Unit)?) : RecyclerView.Adapter<Holder>()`: 
 This class has the functionality of creating an adapter for Recycler View.
- `private class Holder(itemView: View, val onClick: ((Button) -> Unit)?) : RecyclerView.ViewHolder(itemView)`: 
 This class has the functionality of changing the attributes of each element to be created by the Adapter and shown by Recycler View.
 
  </div>
 </section>

 <section id="imc-activity">
  
## [IMC Activity](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/ImcActivity.kt)
  
  <div id="objective-imc">
   <h3>Objective</h3>
   <p>
    This class aims to receive the values for the BMI calculation and by consequence make the calculation, besides being responsible for saving the result in the database.
   </p>
  </div>
  
  <div id="functions-imc">
   <h3>:hammer: Features</h3>
     
- `private fun calcuImc(): Double`:
 This function aims to calculate the BMI value.
- `private fun response(imc: Double): Int`: 
 This function aims to verify the degree of obesity or thinness and returns a String saying the same.
- `private fun validate(): Boolean`: 
 This function is intended to verify that all fields have been filled in correctly.
     
  </div>
 </section>

 <section id="tmb-activity">
  
## [TMB Activity](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/TmbActivity.kt)
  
   <div id="objective-tmb">
    <h3>Objective</h3>
    <p>
     This class aims to receive the values for the TMB calculation and by consequence make the calculation, besides being responsible for saving the result in the database.
    </p>
   </div>
   
   <div id="functions-tmb">
    <h3>:hammer: Features</h3>
     
- `private fun calcuTmb(): Double`: 
 This function aims to calculate the TMB value.
- `private fun taxa(): Double`: 
 This function verifies the value selected in Auto Complete and returns the related value for the calculation.
- `private fun sex(): String`: 
 This function checks which Radio Button was selected to return the value corresponding to the sex to perform the calculation.
- `private fun validate(): Boolean`: 
 This function is intended to verify that all fields have been filled in correctly.
     
  </div>
 </section>
 
 <section id="open-list">
  
## [Open List](https://github.com/BHM871/Fitness-Tracker/blob/master/app/src/main/java/co/tiagoaguiar/fitnesstracker/OpenList.kt)
  
  <div id="objective-open">
   <h3>Objective</h3>
   <p>
    This class is intended to show the saved history, individually from the BMI and TMB. It may also be required to edit any data unless.
   </p>
  </div>
  
  <div id="functions-open">
   <h3>:hammer: Features</h3>
   
- `fun openUpdate(id: Int, type: String)`: 
 This function is intended to inform which activity should be directed when editing an item is required.
- `private inner class AdapterList(val list: MutableList<ItemListCalcu>) : RecyclerView.Adapter<AdapterList.HolderList>(), OnClicks`: 
 This class has the functionality of creating an adapter for Recycler View.
- `private inner class HolderList(itemView: View) : RecyclerView.ViewHolder(itemView)`: 
 This class has the functionality of changing the attributes of each element to be created by the Adapter and shown by Recycler View.
  </div>
 </section>
</article>
