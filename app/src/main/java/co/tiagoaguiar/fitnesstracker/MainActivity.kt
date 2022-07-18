package co.tiagoaguiar.fitnesstracker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnImc: LinearLayout = findViewById(R.id.linear_btn)
        btnImc.setOnClickListener {
            startActivity(Intent(this, ImcActivity::class.java))
        }
    }
}