package kg.example.shoplistapp.domain.usecases

import androidx.lifecycle.LiveData
import kg.example.shoplistapp.domain.ShopListRepository
import kg.example.shoplistapp.domain.entities.ShopItem

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>>{
       return shopListRepository.getShopList()
    }
}