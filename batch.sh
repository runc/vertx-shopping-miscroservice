#!/usr/bin/env bash

java -Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory -jar store-microservice-fat.jar -cluster -conf docker.json