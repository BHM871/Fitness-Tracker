package co.tiagoaguiar.fitnesstracker

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class ImcActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    private lateinit var app: Application

    @RequiresApi(Build.VERSION_CODES.P)
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        app = (application as Application)

        editWeight = findViewById(R.id.edit_text_weight_imc)
        editHeight = findViewById(R.id.edit_text_height_imc)
        val btnCalcu: Button = findViewById(R.id.btn_calcu_imc)

        btnCalcu.setOnClickListener {
            if (!validate()) {
                app.toastGeneric(this, R.string.fields_messages)
                return@setOnClickListener
            }

            val updateId = intent.extras?.getInt("update_id")
            val result = calcuImc()
            app.dialog(
                activity = this,
                title = getString(R.string.result_imc, result),
                result = result,
                response = response(result),
                updateId = updateId,
                type = "imc"
            )

            app.closeKeyboard(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list_calcu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.open_listMenu -> {
                app.openListActivity(this, "imc")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun response(imc: Double): Int {
        return when {
            imc < 15 -> R.string.imc_severely_low_weight
            imc < 16 -> R.string.imc_very_low_weight
            imc < 18.5 -> R.string.imc_low_weight
            imc < 25 -> R.string.normal
            imc < 30 -> R.string.imc_high_weight
            imc < 35 -> R.string.imc_so_high_weight
            imc < 40 -> R.string.imc_severely_high_weight
            else -> R.string.imc_extreme_weight
        }

    }

    private fun calcuImc(): Double {
        val weight: Double = editWeight.text.toString().toDouble()
        val height: Double = editHeight.text.toString().toDouble()
        return weight / (height * height)
    }

    private fun validate(): Boolean {
        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && !editWeight.text.toString().startsWith("0")
                && !editHeight.text.toString().startsWith("0"))
    }
}