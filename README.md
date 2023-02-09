<h1 align="center">Fitness Tracker</h1>

<h3 align="center">This application is used to calculate the body Coporal Mass Index (BMI) and Basal Métabolica Rate (TMB) and save this data in a RoomDatabase data collection, with the value and time it was saved.</h3>

<h2>Índice</h2>

<!--ts-->
  * [Activitys](#activitys)
<!--te-->

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
 This class has the functionality of creating an adapter for Recycler View
- `private class Holder(itemView: View, val onClick: ((Button) -> Unit)?) : RecyclerView.ViewHolder(itemView)`: 
 This class has the functionality of changing the attributes of each element to be created by the Adapter and shown by Recycler View
 
    </div>
  </section>

  <section id="imc-activity">
    <h2>IMC Activity</h2>
    <div id="objective-imc">
    </div>
    <div id="functions-imc">
    </div>
  </section>

  <section id="tmb-activity">
    <h2>TMB Activity</h2>
    <div id="objective-tmb">
    </div>
    <div id="functions-tmb">
     <h3>:hammer: Fetuares</h3>
     
- `private fun calcuTmb(): Double`: TODO: Ainda vou terminar
- `private fun taxa(): Double`: TODO: Ainda vou terminar
- `private fun sex(): String`: TODO: Ainda vou terminar
- `private fun validate(): Boolean`: This block of code has the functionality to verify that all fields are filled in correctly
     
    </div>
  </section>
 
 <section id="open-list">
    <h2>Open List</h2>
    <p align="center">
      <a href="#functions-open">Functions</a> - 
    </p>
    <div id="functions-open">
    </div>
  </section>
</section>
