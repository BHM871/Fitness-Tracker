package co.tiagoaguiar.fitnesstracker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ImcActivity : AppCompatActivity() {

    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        editWeight = findViewById(R.id.edit_text_weight)
        editHeight = findViewById(R.id.edit_text_height)
        val btnCalcu: Button = findViewById(R.id.btn_calcu)
        btnCalcu.setOnClickListener {
            if (!validate()){
                Toast.makeText(this, R.string.fields_messages, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val weight = editWeight.text.toString().toDouble()
            val height = editHeight.text.toString().toDouble()
            val result = calcuImc(weight, height)

            AlertDialog.Builder(this).apply {
                setTitle(getString(R.string.result_imc, result))
                setMessage("Tá foda parceiro")
                setCancelable(false)
                setPositiveButton(android.R.string.ok) {_, _ -> }
                setNegativeButton(R.string.save) { _, _ -> Toast.makeText(this@ImcActivity, "Agora não", Toast.LENGTH_SHORT).show()}
                create()
                show()
            }
        }
    }

    private fun calcuImc(weight: Double, height: Double): Double {
        return weight / (height * height)
    }

    private fun validate(): Boolean{
        return(editWeight.text.toString().isNotEmpty()
                && editHeight.text.toString().isNotEmpty()
                && !editWeight.text.toString().startsWith("0")
                && !editHeight.text.toString().startsWith("0"))
    }
}