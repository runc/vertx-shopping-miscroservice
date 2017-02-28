package com.vertx.ha;

import io.vertx.blueprint.microservice.shopping.ui.ShoppingUIVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;

/**
 * Author: Rock.Stone
 * Date: 17/2/27
 * Dream:
 * ---------------------------------------------------------------------------------------------------------------------
 * I've heard tell of the existence of a legless bird in the real world.
 * A constant flutter in the space above constitutes its whole life.Prostrated with toil and strain,
 * it just takes repose in the wind. Throughout countless nights and days,
 * only once will its body brush the dust of the ground and that's the very time when it bids farewell to the world
 * ---------------------------------------------------------------------------------------------------------------------
 */
public class ShoppingVertx {

    public static void main(String[] args) {

//        {
//            "shopping.ui.http.port": 8080,
//                "ui-service": "shopping-spa"
//        }

        final DeploymentOptions options = new DeploymentOptions()
                .setConfig(new JsonObject()
                        .put("shopping.ui.http.port", 8080)
                        .put("ui-service","shopping-spa")
                ).setHa(true);

        Vertx.clusteredVertx(new VertxOptions().setHAEnabled(true), vertx ->
                vertx.result().deployVerticle(ShoppingUIVerticle.class.getName(), options)
        );

    }

}
