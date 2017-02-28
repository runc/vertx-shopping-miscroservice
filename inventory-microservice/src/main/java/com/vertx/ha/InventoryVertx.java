package com.vertx.ha;

import io.vertx.blueprint.microservice.inventory.InventoryRestAPIVerticle;
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
public class InventoryVertx {

    public static void main(String[] args) {


////        {
//        "api.name": "inventory",
//                "redis.host": "127.0.0.1",
//                "inventory.http.address": "0.0.0.0",
//                "inventory.http.port": 8086
        final DeploymentOptions options = new DeploymentOptions()
                .setConfig(new JsonObject()
                        .put("api.name", "inventory")
                        .put("redis.host","172.16.1.155")
                        .put("api.name","account")
                        .put("inventory.http.address","0.0.0.0")
                        .put("inventory.http.port",8086)
                ).setHa(true);

        Vertx.clusteredVertx(new VertxOptions().setHAEnabled(true), vertx ->
                vertx.result().deployVerticle(InventoryRestAPIVerticle.class.getName(), options)
        );

    }

}
