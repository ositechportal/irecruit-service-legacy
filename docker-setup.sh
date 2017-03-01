#!/bin/bash

# build the irecruit-service container
docker build -t smadarpalle10/irecruit-service .

# create the network
docker network create irecruit-nw


# start the mongo container
 docker run --name irecruit-mongo --network=irecruit-nw -d -p 27017:27017 smadarpalle10/mongo mongod --smallfiles 

#smadarpalle10/irecruit-service

# start the ES container
docker run -d --net irecruit-nw -p 9200:9200 -p 9300:9300 --name irecruit-es elasticsearch


docker run -d --name irecruit-sevice --link=irecruit-mongo:mongodb --network=irecruit-nw -p 8080:8080 --name smadarpalle10/irecruit-service 


# docker run -it --rm --network=irecruit-nw smadarpalle10/uubuntu:version1


#### MYSQL ##########
docker run --name irecruit-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql

docker run -it --rm --link irecruit-mysql:mysql smadarpalle10/uubuntu:version1

docker run -it --link some-mysql:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'