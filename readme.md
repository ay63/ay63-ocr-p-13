# Your Car Your Way chat POC

## Description
This projet is POC a chat support 

## Prerequisites
- **Frontend**:
  - Angular  `19.1.0`
  
- **Backend**:
  - Spring boot `3.4.3` 
  - Java `21`
  - MongoDB 
  - Spring Websocket 
  
 ## Clone the project 
 > git clone https://github.com/ay63/ay63-ocr-p-13.git

## Frontend

### Installation Frontend 

Navigate to the `chat_front` folder
```
cd chat_front
```
Run to install dependencies
``` 
npm install
``` 

Start the application with
``` 
npm run start
``` 

The app will be available at `http://localhost:4200`.


### Installation Backend

Navigate to the `chat_back` folder
```
cd back
```

### Install
```
mvn clean install
```

### Start Backend
Start the application with
``` 
mvn spring-boot:run
``` 

The app will be available at `http://localhost:8080`.

## Database  

### Use the dump

To import MongoDB `ycyw` database use that command in folder database
> mongorestore dump

### Import manually 

You can also create databases `ycyw` and import the json collection in folder `database/collections`

## How to use the POC 

### As client 
> Go at `http://localhost:4200/` 

![client home page](./resources/images/chat_client_home.png)

> Click on "Démarrer une conversation"

You will be redirect to the client chat : 
![client chat](./resources/images/chat_client.png)

### As support 

> Go at `http://localhost:4200/support` 

![client chat](./resources/images/chat_support_list.png)

> Then click use chat and you will be redicted to chat page

![client chat](./resources/images/chat_support_page.png)
