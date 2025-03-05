package org.skypro.skyshop.model.basket;

import java.util.List;

    public final class UserBasket {

        List<BasketItem> basketItemList;
        Integer total;

        public UserBasket(List<BasketItem> basketItemList) {
            this.basketItemList = basketItemList;
        }


    }
