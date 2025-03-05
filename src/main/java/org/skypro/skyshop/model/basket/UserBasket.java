package org.skypro.skyshop.model.basket;

import java.util.List;

    public final class UserBasket {

        List<BasketItem> basketItemList;
        int total;

        public UserBasket(List<BasketItem> basketItemList, int total) {
            this.basketItemList = basketItemList;
            this.total = total;
                    }

        public List<BasketItem> getBasketItemList() {
            return basketItemList;
        }

        public int getTotal() {
            return total;
        }
    }
