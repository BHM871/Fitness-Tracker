package co.tiagoaguiar.fitnesstracker

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TmbActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText
    private lateinit var editAge: EditText

    private lateinit var autoComplete: AutoCompleteTextView

    private lateinit var radioManFem: RadioGroup

    private lateinit var app: Application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tmb)
        app = application as Application

        editWeight = findViewById(R.id.edit_text_weight_tmb)
        editHeight = findViewById(R.id.edit_text_height_tmb)
        editAge = findViewById(R.id.edit_text_age_tmb)

        autoComplete = findViewById(R.id.auto_complete_taxa)
        val item = resources.getStringArray(R.array.taxa)
        autoComplete.setText(item.first())
        autoComplete.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, item))

        radioManFem = findViewById(R.id.radio_mas_fem)

        val btnCalcu: Button = findViewById(R.id.btn_calcu_tmb)
        btnCalcu.setOnClickListener {
            if (!validate()) {
                app.toastGeneric(this, R.string.fields_messages)
                return@setOnClickListener
            }

            val updateId = intent.extras?.getInt("update_id")
            val result = calcuTmb()
            if (result == 0.0) return@setOnClickListener
            app.dialog(
                activity = this,
                title = getString(R.string.result_tmb, result),
                result = result,
                updateId = updateId,
                type = "tmb"
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
                app.    openListActivity(this, "tmb")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun calcuTmb(): Double {
        val weight = editWeight.text.toString().toDouble()
        val height = editHeight.text.toString().toDouble()
        val age = editAge.text.toString().toInt()

        val masculine = 66 + (13.8 * weight) + (5 * (height * 100)) - (6.8 * age)
        val feminine = 655 + (9.6 * weight) + (1.8 * (height * 100)) - (4.7 * age)

        return if (sex() == "mas") {
            masculine * taxa()
        } else {
            feminine * taxa()
        }
    }

    private fun taxa(): Double {
        val items = resources.getStringArray(R.array.taxa)

        when (autoComplete.text.toString()) {
            items[0].toString() -> {
                app.toastGeneric(this, R.string.taxa)
                return 0.0
            }

            items[1].toString() -> return 1.2

            items[2].toString() -> return 1.375

            items[3].toString() -> return 1.55

            items[4].toString() -> return 1.725

            else -> return 1.9
        }
    }

    private fun sex(): String {
        return when (radioManFem.checkedRadioButtonId) {
            R.id.radio_masculine -> "mas"
            else -> "fem"
        }
    }

    private fun validate(): Boolean {
        return (editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && editAge.text.toString().isNotEmpty()
                && !editWeight.text.toString().startsWith("0")
                && !editHeight.text.toString().startsWith("0")
                && !editAge.text.toString().startsWith("0"))
    }
}