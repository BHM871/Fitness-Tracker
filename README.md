<h1 align="center">Fitness Tracker</h1>

<h3 align="center">This application is used to calculate the body Coporal Mass Index (BMI) and Basal Métabolica Rate (TMB) and save this data in a RoomDatabase data collection, with the value and time it was saved.</h3>

<h2>Índice</h2>

<!--ts-->
  * [Utilities](#utilities)
  * [Activitys](#activitys)
<!--te-->

<section id="utilities">
 <h2 align="center">Utilities</h2>
 <p align="center"></p>
 <section id="aplication>
  <h2>Aplication</h2>
  <div id="objective-aplication">
   <h3>Objective</h3>
   <p>
    This class is intended to contain generic functionality that can be accessed by any Activity.
   </p>
  </div>
  <div id="functions-aplication">
   <h3>:hammer: Fetuares</h3>
   
- `TODO`: Ainda vou adicionar as funções.

  </div>
 </section>
</section>

<section id="activitys">
 <h2 align="center">Activitys</h2>
 <p align="center">In this topic I will describe all activities, such as their functions and objectives</p>
 <section id="main-activity">
  <h2>Main Activity</h2>
  <div id="objective-main">
   <h3>Objective</h3>
   <p>
    The main purpose of this class is to show the options of the application, to calculate the BMI and the calculation of the TMB.
   </p>
  </div>
  <div id="functions-main">
   <h3>:hammer: Fetuares</h3>
    
- `private inner class AdapterMain(val buttons: List<Button>, val listener: ((Button) -> Unit)?) : RecyclerView.Adapter<Holder>()`: 
     This class has the functionality of creating an adapter for Recycler View.
- `private class Holder(itemView: View, val onClick: ((Button) -> Unit)?) : RecyclerView.ViewHolder(itemView)`: 
     This class has the functionality of changing the attributes of each element to be created by the Adapter and shown by Recycler View.
 
  </div>
 </section>

 <section id="imc-activity">
  <h2>IMC Activity</h2>
  <div id="objective-imc">
   <h3>Objective</h3>
   <p>
    This class aims to receive the values for the BMI calculation and by consequence make the calculation, besides being responsible for saving the result in the database.
   </p>
  </div>
  <div id="functions-imc">
   <h3>:hammer: Fetuares</h3>
     
- `private fun calcuImc(): Double`: 
     This function aims to calculate the BMI value.
- `private fun response(imc: Double): Int`: 
     This function aims to verify the degree of obesity or thinness and returns a String saying the same.
- `private fun validate(): Boolean`: 
     This function is intended to verify that all fields have been filled in correctly.
     
  </div>
 </section>

 <section id="tmb-activity">
  <h2>TMB Activity</h2>
   <div id="objective-tmb">
    <h3>Objective</h3>
    <p>
     This class aims to receive the values for the TMB calculation and by consequence make the calculation, besides being responsible for saving the result in the database.
    </p>
   </div>
   <div id="functions-tmb">
    <h3>:hammer: Fetuares</h3>
     
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
  <h2>Open List</h2>
  <div id="objective-open">
   <h3>Objective</h3>
   <p>
    This class is intended to show the saved history, individually from the BMI and TMB. It may also be required to edit any data unless.
   </p>
  </div>
  <div id="functions-open">
   <h3>:hammer: Fetuares</h3>
   
- `fun openUpdate(id: Int, type: String)`: 
     This function is intended to inform which activity should be directed when editing an item is required.
- `private inner class AdapterList(val list: MutableList<ItemListCalcu>) : RecyclerView.Adapter<AdapterList.HolderList>(), OnClicks`: 
     This class has the functionality of creating an adapter for Recycler View.
- `private inner class HolderList(itemView: View) : RecyclerView.ViewHolder(itemView)`: 
     This class has the functionality of changing the attributes of each element to be created by the Adapter and shown by Recycler View.
  </div>
 </section>
</section>
