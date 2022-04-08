package kg.example.shoplistapp.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kg.example.shoplistapp.R
import kg.example.shoplistapp.domain.entities.ShopItem

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>(){
    var shopList= listOf<ShopItem>()
    @SuppressLint("NotifyDataSetChanged")
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        return ShopItemViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_shop_enabled, parent, false))
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.onBind(shopList[position])
    }

    override fun getItemCount()= shopList.size

   inner class ShopItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var productName: TextView = itemView.findViewById(R.id.tv_name)
        private var counter :TextView = itemView.findViewById(R.id.tv_count)
        fun onBind(shopItem: ShopItem) {
            productName.text = shopItem.name
            counter.text = shopItem.count.toString()
        }
    }
}
