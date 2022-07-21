package co.tiagoaguiar.fitnesstracker.util

import co.tiagoaguiar.fitnesstracker.model.ItemListCalcu

interface OnClicks {

    fun onClick(item: ItemListCalcu)

    fun onLongClick(item: ItemListCalcu)

}