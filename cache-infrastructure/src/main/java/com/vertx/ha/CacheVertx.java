package com.vertx.ha;

import io.vertx.blueprint.microservice.cache.CacheComponentVerticle;
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
public class CacheVertx {

    public static void main(String[] args) {


//        "user.account.http.address": "0.0.0.0",
//        "user.account.http.port": 8081,
//        "api.name": "account",
//        "url": "jdbc:mysql://localhost/vertx_blueprint?characterEncoding=UTF-8&useSSL=false",
//        "driver_class": "com.mysql.cj.jdbc.Driver",
//        "user": "vbpdb1",
//        "password": "666666*",
//        "max_pool_size": 30

        final DeploymentOptions options = new DeploymentOptions()
                .setConfig(new JsonObject()
                        .put("redis.host", "172.16.1.155")
                ).setHa(true);

        Vertx.clusteredVertx(new VertxOptions().setHAEnabled(true), vertx ->
                vertx.result().deployVerticle(CacheComponentVerticle.class.getName(), options)
        );

    }

}
