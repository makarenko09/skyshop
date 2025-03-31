package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.NoSuchProductException;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;
    @InjectMocks
    private BasketService basketService;
    @Mock
    private StorageService storageService;

    @Test
    void addProduct_nonExistentProduct_throwsException() {
        UUID nonExistentProduct = UUID.randomUUID();
        when(storageService.getProductById(nonExistentProduct)).thenReturn(Optional.empty());
        assertThrows(NoSuchProductException.class, () -> basketService.addProductToBasket(nonExistentProduct));
    }

    @Test
    void addSomeProduct_ProductsAreLocatedOnStorage_RedirectToProductBasketClass$ThisMethodIsAddToBasket$ThisActionIsPutProductOnMap() {
        UUID breadId = UUID.fromString("00000000-0000-0000-0000-000000000001");
        String breadNameString = "хлеб";
        Product bread = new SimpleProduct(85, breadNameString, breadId);

        when(storageService.getProductById(breadId)).thenReturn(Optional.of(bread));
        basketService.addProductToBasket(breadId);

        verify(productBasket).addToBasket(breadId);
    }

    @Test
    void getUserBasket_nonExistentProductBasketClass_ReturnEmptyCollection() {
        when(productBasket.getBasket()).thenReturn(Map.of());
        UserBasket userBasket = basketService.getUserBasket();
        assertTrue(userBasket.getBasketItemList().isEmpty());
    }

    @Test
    void getUserBasket_ExistentProduct_ReturnUserBasket() {
        UUID breadId = UUID.randomUUID();
        String breadNameString = "хлеб";
        Product bread = new SimpleProduct(95, breadNameString, breadId);

        Map<UUID, Integer> actualResultsMap = new HashMap<>();
        actualResultsMap.put(breadId, 1);
        actualResultsMap.put(breadId, 2);

        when(productBasket.getBasket()).thenReturn(actualResultsMap);
        when(storageService.getProductById(breadId)).thenReturn(Optional.of(bread));

        List<BasketItem> actualBasketItemList = new ArrayList<BasketItem>(actualResultsMap.get(breadId)+actualResultsMap.get(breadId));

        UserBasket userBasket = basketService.getUserBasket();
        List<BasketItem> expectedbasketItemList = userBasket.getBasketItemList();

        assertThat(expectedbasketItemList).isNotEmpty();
          for (BasketItem item : actualBasketItemList) {
            assertThat(item.getProduct()).isEqualTo(bread);
        }
    }

}

