package kg.example.shoplistapp.presentation

import androidx.lifecycle.ViewModel
import kg.example.shoplistapp.data.ShopListRepositoryImpl
import kg.example.shoplistapp.domain.entities.ShopItem
import kg.example.shoplistapp.domain.usecases.AddShopItemUseCase
import kg.example.shoplistapp.domain.usecases.DeleteShopItemUseCase
import kg.example.shoplistapp.domain.usecases.EditShopItemUseCase
import kg.example.shoplistapp.domain.usecases.GetShopListUseCase

class MainViewModel: ViewModel() {

private val repository = ShopListRepositoryImpl()

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopListUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopListLD = getShopListUseCase.getShopList()

    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopListUseCase.editShopItem(newItem )
    }
}