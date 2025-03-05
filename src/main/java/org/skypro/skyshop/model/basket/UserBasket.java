package org.skypro.skyshop.model.basket;

import java.util.List;

    public final class UserBasket {

        List<BasketItem> basketItemList;
        int total;

        public UserBasket(List<BasketItem> basketItemList) {
            this.basketItemList = basketItemList;
        }

        public List<BasketItem> getBasketItemList() {
            return basketItemList;
        }

        public Integer getTotal() {
            return total;
        }
    }
