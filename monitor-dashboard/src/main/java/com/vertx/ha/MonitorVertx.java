package com.vertx.ha;

import io.vertx.blueprint.microservice.monitor.MonitorDashboardVerticle;
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
public class MonitorVertx {

    public static void main(String[] args) {

        final DeploymentOptions options = new DeploymentOptions()
                .setConfig(new JsonObject()
                        .put("monitor.http.port", 9110)
                        .put("monitor.http.host","0.0.0.0")
                        .put("monitor.metrics.interval",5000)
                ).setHa(true);

        Vertx.clusteredVertx(new VertxOptions().setHAEnabled(true), vertx ->
                vertx.result().deployVerticle(MonitorDashboardVerticle.class.getName(), options)
        );

    }

}
