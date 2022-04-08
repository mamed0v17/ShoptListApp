package kg.example.shoplistapp.domain.usecases

import kg.example.shoplistapp.domain.ShopListRepository
import kg.example.shoplistapp.domain.entities.ShopItem

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem){
        shopListRepository.deleteShopItem(shopItem)
    }
}