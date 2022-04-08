package kg.example.shoplistapp.domain.usecases

import kg.example.shoplistapp.domain.ShopListRepository
import kg.example.shoplistapp.domain.entities.ShopItem

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem){
        shopListRepository.addShopItem(shopItem)
    }
}