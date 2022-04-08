package kg.example.shoplistapp.domain.usecases

import kg.example.shoplistapp.domain.ShopListRepository
import kg.example.shoplistapp.domain.entities.ShopItem

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem){
        shopListRepository.editShopItem(shopItem)
    }
}