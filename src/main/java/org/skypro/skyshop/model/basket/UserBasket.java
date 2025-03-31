package org.skypro.skyshop.model.basket;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

    public final class UserBasket {

        private final List<BasketItem> basketItemList;
        private final int total;

        public UserBasket(List<BasketItem> basketItemList, int total) {
            this.basketItemList = basketItemList;
            this.total = total;
                    }

        public List<BasketItem> getBasketItemList() {
            return Collections.unmodifiableList(basketItemList);
        }

        public int getTotal() {
            return total;
        }
    }
