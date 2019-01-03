#!/usr/bin/env bash

set -eu

cd ..

CONTAINER=appwebservice
export POSTGRES_DB=nozama
export POSTGRES_USER=postgres
export POSTGRES_PASSWORD=test
export POSTGRES_HOST=postgres
export POSTGRES_PORT=5432

if [ "$(docker ps -q -f name=${CONTAINER})" ]
then
    docker-compose stop $CONTAINER
fi

mvn test

exit 0
