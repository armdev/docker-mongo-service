# docker-mongo-service
docker service for mongodb

1. Run mongodb

   docker-compose up -d --build

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

