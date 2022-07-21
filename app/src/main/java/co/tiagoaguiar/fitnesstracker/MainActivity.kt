package co.tiagoaguiar.fitnesstracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.fitnesstracker.model.Button

class MainActivity : AppCompatActivity() {

    private lateinit var adapterMain: AdapterMain
    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = mutableListOf<Button>()
        buttons.add(Button(1, R.drawable.ic_baseline_wb_sunny_24, R.string.label_imc))
        buttons.add(Button(2, R.drawable.ic_baseline_wb_sunny_24, R.string.label_tmb))

        adapterMain = AdapterMain(buttons) {
            when (it.id) {
                1 -> startActivity(Intent(this, ImcActivity::class.java))
                2 -> startActivity(Intent(this, TmbActivity::class.java))
            }
        }
        rvMain = findViewById(R.id.recycler_button)
        rvMain.adapter = adapterMain
        rvMain.layoutManager = GridLayoutManager(this, 2)

    }

    private inner class AdapterMain(val buttons: List<Button>, val listener: ((Button) -> Unit)?) :
        RecyclerView.Adapter<Holder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
            Holder(layoutInflater.inflate(R.layout.button_item, parent, false), listener)

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.bind(buttons[position])
        }

        override fun getItemCount(): Int = buttons.size
    }

    private class Holder(itemView: View, val onClick: ((Button) -> Unit)?) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(button: Button) {
            itemView.findViewById<ImageView>(R.id.img_btn).setImageResource(button.img)
            itemView.findViewById<TextView>(R.id.text_btn).setText(button.text)

            itemView.setOnClickListener {
                onClick?.invoke(button)
            }
        }
    }
}