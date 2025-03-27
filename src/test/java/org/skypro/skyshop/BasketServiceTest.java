package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.NoSuchProductException;
import org.skypro.skyshop.service.StorageService;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void addProducct_nonExistentProduct_throwsException() {
        UUID nonExistentProduct = UUID.randomUUID();
        when(storageService.getProductById(nonExistentProduct)).thenReturn(Optional.empty());
        assertThrows(NoSuchProductException.class, () -> basketService.addProductToBasket(nonExistentProduct));
    }

}
