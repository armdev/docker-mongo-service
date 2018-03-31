#!/usr/bin/env bash

set -e

eval $(docker-machine env default)

## add this in etc/envoronments
#export DOCKER_HOST_IP=192.168.99.100


echo "Docker Swarm IP" 
echo $DOCKER_HOST_IP
echo "Docker Host" 
echo $DOCKER_HOST

echo "Build the project and docker images"

cd mongoguru 
mvn clean package -U -Dmaven.test.skip=true
cd  ..


docker-compose down
echo "Start the config service first and wait for it to become available"
docker-compose up -d --build 

echo  "Attach to the log output of the cluster"
docker-compose logs
