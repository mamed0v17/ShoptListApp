package kg.example.shoplistapp.domain.usecases

import kg.example.shoplistapp.domain.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopItemId: Int) {
        shopListRepository.getShopItem(shopItemId)
    }
}

