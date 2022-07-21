package co.tiagoaguiar.fitnesstracker

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.fitnesstracker.model.ItemListCalcu
import co.tiagoaguiar.fitnesstracker.util.OnClicks
import java.text.SimpleDateFormat
import java.util.*

class OpenList : AppCompatActivity() {

    private lateinit var rvList: RecyclerView
    private lateinit var app: Application

    @SuppressLint("NotifyDataSetChanged")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_list)
        app = application as Application

        val list: MutableList<ItemListCalcu> = mutableListOf()

        val adapterList = AdapterList(list)

        rvList = findViewById(R.id.recycler_list)
        rvList.adapter = adapterList
        rvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        Thread {
            val type =
                intent.extras?.getString("type") ?: throw IllegalStateException("type not found")
            list.addAll(app.db.listDao().getListCalcuByType(type))
            runOnUiThread {
                adapterList.notifyDataSetChanged()
            }
        }.start()

    }

    fun openUpdate(id: Int, type: String) {
        val intent = if (type == "imc") Intent(this, ImcActivity::class.java)
        else Intent(this, TmbActivity::class.java)

        intent.putExtra("update_id", id)
        finish()
        startActivity(intent)
    }

    private inner class AdapterList(
        val list: MutableList<ItemListCalcu>,
    ) : RecyclerView.Adapter<AdapterList.HolderList>(), OnClicks {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderList =
            HolderList(
                layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            )

        override fun onBindViewHolder(holder: HolderList, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int = list.size

        override fun onClick(item: ItemListCalcu) {
            AlertDialog.Builder(this@OpenList)
                .setTitle(R.string.atencao)
                .setMessage(R.string.update_message)
                .setCancelable(false)
                .setPositiveButton(R.string.update) { _, _ ->
                    openUpdate(item.id, item.type)
                }
                .setNegativeButton(android.R.string.cancel) { _, _ -> }
                .create()
                .show()
        }

        override fun onLongClick(item: ItemListCalcu) {
            AlertDialog.Builder(this@OpenList)
                .setTitle(R.string.atencao)
                .setMessage(R.string.delete_message)
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    Thread {
                        app.db.listDao().deleteItem(item)
                        runOnUiThread {
                            Toast.makeText(this@OpenList, R.string.calc_removed, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }.start()
                }
                .setNegativeButton(android.R.string.cancel) { _, _ -> }
                .create()
                .show()
        }

        private inner class HolderList(
            itemView: View,
        ) :
            RecyclerView.ViewHolder(itemView) {

            fun bind(item: ItemListCalcu) {

                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale("pt", "br"))
                val dateS = sdf.format(item.date)

                (itemView as TextView).text =
                    ((itemView.context).getString(R.string.result_list, item.res, dateS))

                itemView.setOnClickListener {
                    onClick(item)
                }
                itemView.setOnLongClickListener {
                    onLongClick(item)
                    return@setOnLongClickListener true
                }
            }
        }
    }
}