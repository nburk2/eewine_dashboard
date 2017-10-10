#deployment

##set the environment variables 
    1. MYSQL_USERNAME
    2. MYSQL_PASSWORD
    3. MYSQL_EEWINE_URL
    4. EEWINE_ADMIN_USERNAME
    5. EEWINE_ADMIN_PASSWORD

###use the text file from restartpp to deploy the latest changes to your server.

##The server will need:
1. git
2. mysql
3. java


## Extra notes
    1. for this app an ssl redirect plugin is used to reroute all
     http urls to https. This will interfere with some environment setups
     in the future.