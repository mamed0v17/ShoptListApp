package kg.example.shoplistapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.example.shoplistapp.R
import kg.example.shoplistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding()
    private  var shopListAdapter= ShopListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObservers()
        initListener()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.mainRv.run {
           adapter= shopListAdapter
        }
        setupSwipeListener(binding.mainRv)
    }

    private fun setupSwipeListener(mainRv:RecyclerView) {
        val callBack = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = shopListAdapter.shopList[viewHolder.absoluteAdapterPosition]
                viewModel.deleteShopItem(item)
            }

        }
        val itemTouchHelper= ItemTouchHelper(callBack)
        itemTouchHelper.attachToRecyclerView(mainRv)

    }

    private fun initObservers() {
        viewModel.shopListLD.observe(this){
            shopListAdapter.shopList = it
        }
    }

    private fun initListener() {
    }
}