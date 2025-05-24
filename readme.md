# Your Car, Your Way Chat POC

## Description

This project is a proof of concept (POC) for a chat support application.

## Prerequisites

* **Frontend**:

  * Angular `19.1.0`

* **Backend**:

  * Spring Boot `3.4.3`
  * Java `21`
  * MongoDB
  * Spring WebSocket

 ## Clone the project 

```bash
git clone https://github.com/ay63/ay63-ocr-p-13.git
```
## Frontend

### Installation

1. Navigate to the `chat_front` folder:

   ```bash
   cd chat_front
   ```
2. Install dependencies:

   ```bash
   npm install
   ```
3. Start the application:

   ```bash
   npm run start
   ```

The app will be available at `http://localhost:4200`.

## Backend

### Installation

1. Navigate to the `chat_back` folder:

   ```bash
   cd chat_back
   ```
2. Build the project:

   ```bash
   mvn clean install
   ```
3. Start the application:

   ```bash
   mvn spring-boot:run
   ```

The backend will be available at `http://localhost:8080`.

## Database

### Using the dump

To restore the `ycyw` MongoDB database, run the following command in the `resources/database/dump` folder:

```bash
mongorestore dump
```

### Manual import with MongoDB Compass

Alternatively, you can create the `ycyw` database and import the JSON collection located in `resources/database/collections`.

## How to Use the POC

### As a client (with the imported data)
After importing the dump or the collections, you can directly go to the URL to be redirected to the chat.
Open your browser and go to `http://localhost:4200/chat/682f25d810f7723e6faab288`.

   ![Client home page](./resources/images/chat_client_with_data.png)


### As a client (without data import)
Open your browser and go to the following address: [http://localhost:4200/](http://localhost:4200/)

1. Open your browser and go to `http://localhost:4200/`.

   ![Client home page](./resources/images/chat_client_home.png)

1. Click on **Démarrer une conversation**.

   You will be redirected to the client chat interface:

   ![Client chat](./resources/images/chat_client.png)


### As an support employee

1. Open your browser and go to `http://localhost:4200/support`.

   ![Support list](./resources/images/chat_support_list.png)

2. Click on a chat in the list to access the support chat page :

   ![Support chat page](./resources/images/chat_support_page.png)
