package kg.example.shoplistapp.presentation

import androidx.recyclerview.widget.DiffUtil
import kg.example.shoplistapp.domain.entities.ShopItem

class ShopListDiffCallBack (
    private val olbList: List<ShopItem>,
    private val newList:List<ShopItem>
    ):DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return olbList.size
    }

    override fun getNewListSize(): Int {
    return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
    val oldItem = olbList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = olbList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem == newItem
    }
}