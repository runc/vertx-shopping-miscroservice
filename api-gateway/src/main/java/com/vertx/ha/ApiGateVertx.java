package com.vertx.ha;

import io.vertx.blueprint.microservice.account.UserAccountVerticle;
import io.vertx.blueprint.microservice.gateway.APIGatewayVerticle;
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
public class ApiGateVertx {

    public static void main(String[] args) {


//        {
//            "api.gateway.http.port": 8787,
//                "api.gateway.http.address": "localhost",
//                "circuit-breaker": {
//            "name": "api-gateway-cb",
//                    "timeout": 10000,
//                    "max-failures": 5
//        },
//            "realm": "Vert.x",
//                "realm-public-key": "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkto9ZZm69cmdA9e7X4NUSo8T4CyvrYzlRiJdhr+LMqELdfN3ghEY0EBpaROiOueva//iUc/KViYGiAHVXEQ3nr3kytF6uZs9iwqkshKvltpxkOm2Qpj/FSRsCyHlB8Ahbt5xBmzH2mI1VDIxmVTdEBze4u6tLoi4ieo72b2q/dz09yrEokRm/sSYqzNgfE0i1JY6DI8C7FaKszKTK5DRGMIAib8wURrTyf8au0iiisKEXOHKEjo/g0uHCFGSOKqPOprNNIWYwedV+qaQa9oSah2IpwNgFNRLtHpvbcanftMLQOQIR0iufIJ+bHrNhH0RISZhTzcGX3pSIBw/HaERwQIDAQAB",
//                "auth-server-url": "http://127.0.0.1:8180/auth",
//                "ssl-required": "external",
//                "resource": "vertx-blueprint",
//                "credentials": {
//            "secret": "ea99a8e6-f503-4bdb-afbd-9ae322ee7089"
//        },
//            "use-resource-role-mappings": true
//        }

        final DeploymentOptions options = new DeploymentOptions()
                .setConfig(new JsonObject()
                        .put("api.gateway.http.port", 8787)
                        .put("api.gateway.http.address","localhost")
                        .put("circuit-breaker", new JsonObject()
                            .put("name", "api-gateway-cb")
                            .put("timeout",10000)
                            .put("max-failures",5))
                        .put("realm", "Vert.x")
                        .put("realm-public-key","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkto9ZZm69cmdA9e7X4NUSo8T4CyvrYzlRiJdhr+LMqELdfN3ghEY0EBpaROiOueva//iUc/KViYGiAHVXEQ3nr3kytF6uZs9iwqkshKvltpxkOm2Qpj/FSRsCyHlB8Ahbt5xBmzH2mI1VDIxmVTdEBze4u6tLoi4ieo72b2q/dz09yrEokRm/sSYqzNgfE0i1JY6DI8C7FaKszKTK5DRGMIAib8wURrTyf8au0iiisKEXOHKEjo/g0uHCFGSOKqPOprNNIWYwedV+qaQa9oSah2IpwNgFNRLtHpvbcanftMLQOQIR0iufIJ+bHrNhH0RISZhTzcGX3pSIBw/HaERwQIDAQAB")
                        .put("auth-server-url","http://127.0.0.1:8180/auth")
                        .put("ssl-required","external")
                        .put("resource","vertx-blueprint")
                        .put("credentials",new JsonObject()
                                .put("secret","ea99a8e6-f503-4bdb-afbd-9ae322ee7089")
                        )
                        .put("use-resource-role-mappings",true)
                ).setHa(true);

        Vertx.clusteredVertx(new VertxOptions().setHAEnabled(true), vertx ->
                vertx.result().deployVerticle(APIGatewayVerticle.class.getName(), options)
        );

    }

}
