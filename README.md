# docker-mongo-service
docker service for mongodb

Youu should have pre-installed java, maven, docker

1. Run mongodb & java app.

   docker-compose up -d --build
   
   access link   
     http://docker-machine-ip:5008/api/v2/person/save  // save 10000 record to mongodb
     http://192.168.99.100:5008/api/v2/person/find/age?age=18
     
     http://192.168.99.100:5008/api/v2/person/find/age/range?startAge=11&endAge=100

#####################
How to scale mongoDB using docker !!!

2. Create mongodb service 

   docker service create --name mongodb mongo
  
3. Scale MongoDB

   docker service scale mongodb=3
   
4. docker services list

   docker service ls

5. remove docker service   

   docker service rm mongodb
   
6. create docker service replicas

   docker service create --name supermongo --replicas=5 mongo
   
7. Change replicas count:

   docker service update --replicas 3 supermongo

