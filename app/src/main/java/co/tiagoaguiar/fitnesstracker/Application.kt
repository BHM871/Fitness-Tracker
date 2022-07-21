package co.tiagoaguiar.fitnesstracker

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import co.tiagoaguiar.fitnesstracker.model.ItemListCalcu
import co.tiagoaguiar.fitnesstracker.util.DatabaseList

class Application : Application() {

    lateinit var db: DatabaseList

    override fun onCreate() {
        super.onCreate()
        db = DatabaseList.getInstance(this)
    }

    fun dialog(
        activity: Activity,
        title: String,
        result: Double,
        response: Int? = null,
        updateId: Int?,
        type: String
    ) {
        AlertDialog.Builder(activity)
            .setTitle(title)
            .setMessage(response ?: R.string.vazio)
            .setCancelable(false)
            .setPositiveButton(android.R.string.ok) { _, _ -> }
            .setNegativeButton(R.string.save) { _, _ ->
                if (updateId != null) {
                    Thread {
                        db.listDao().updateItem(
                            ItemListCalcu(
                                id = updateId,
                                type = type,
                                res = result,
                                date = db.listDao().getCalcuById(updateId).date
                            )
                        )
                        toastGeneric(activity, R.string.calc_update)
                    }.start()
                } else {
                    Thread {
                        db.listDao().insert(ItemListCalcu(type = type, res = result))
                        toastGeneric(activity, R.string.calc_saved)
                        openListActivity(activity, type)
                    }.start()
                }
            }
            .create()
            .show()
    }

    fun closeKeyboard(activity: Activity) {
        val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        service.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
    }

    fun toastGeneric(context: Context, resId: Int) {
        val looperActivated = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Looper.myLooper()?.isCurrentThread
        } else {
            throw RuntimeException("SDK Version very low")
        }
        if (looperActivated != true) {
            Looper.prepare()
            Toast.makeText(context, resId, Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(context, resId, Toast.LENGTH_SHORT).show()
    }

    fun openListActivity(activity: Activity, type: String) {
        val intent = Intent(this, OpenList::class.java)
        intent.putExtra("type", type)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        activity.finish()
        startActivity(intent)
    }
}