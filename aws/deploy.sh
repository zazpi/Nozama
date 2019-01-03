#!/usr/bin/env bash

set -eu

CONTAINER=${1}

if [ "$(docker ps -q -f name=${CONTAINER})" ]
then
    docker container rm -f $CONTAINER
fi

docker login
docker pull devallday/nozama:latest
cd ~/app && ./nozama.sh

exit 0
