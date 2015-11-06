/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Shopify Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.shopify.buy.dataprovider;

import android.content.Context;

import com.shopify.buy.dataprovider.sqlite.BuyDatabase;
import com.shopify.buy.model.Cart;

public class CartManager {

    private static CartManager instance = new CartManager();

    public static CartManager getInstance() {
        return instance;
    }

    private BuyDatabase database;
    private Cart cart;

    private CartManager() {
    }

    public void loadCart(String userId, Context context) {
        if (database == null) {
            database = new BuyDatabase(context);
        }
        cart = database.getCart(userId);
    }

    public Cart getCart() {
        return cart;
    }

    public void saveCart(String userId, Context context) {
        if (database == null) {
            database = new BuyDatabase(context);
        }
        database.saveCart(cart, userId);
    }

}
