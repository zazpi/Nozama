#!/usr/bin/env bash

set -eu

NOZAMA_IMAGE="devallday/nozama:latest"
SIMULATOR_IMAGE="devallday/simulator:latest"
RUNNING_CONTAINERS=$(docker ps -a -q)

if [ ! -z $RUNNING_CONTAINERS ]; then

    for CONTAINER in $RUNNING_CONTAINERS
    do
   	docker container rm -f $CONTAINER
    done

fi

docker pull $NOZAMA_IMAGE
docker pull $SIMULATOR_IMAGE

cd app/

docker-compose up -d
