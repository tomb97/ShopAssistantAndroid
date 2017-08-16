package com.estimote.indoorapp;

import android.content.Context;
import android.util.Log;

import com.estimote.indoorapp.estimote.NearableID;
import com.estimote.indoorapp.estimote.Product;
import com.estimote.indoorapp.estimote.ShowroomManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tombarrett on 03/08/2017.
 */

public class StickerListen {
    private ShowroomManager showroomManager;
    private Context context;

    StickerListen(Context context){
        this.context=context;
    }

    public void sticker(){
        Log.d("test","sticker");
        Map<NearableID, Product> products = new HashMap<>();
        products.put(new NearableID("1b089cf2ccbf058b"), new Product("Running Shoes",
                "These running shoes are like, the best"));
        products.put(new NearableID("22aaab0c27180003"), new Product("Bike",
                "Lovely Bike, much fast"));

        showroomManager = new ShowroomManager(context, products);
        showroomManager.setListener(new ShowroomManager.Listener() {
            private Product product;
            @Override
            public void onProductPickup(Product product) {
                Log.d("product","pickup");
            }
            @Override
            public void onProductPutdown(Product product) {
            }
        });
    }
}
