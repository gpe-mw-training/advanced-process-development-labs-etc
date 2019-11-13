FROM node:stretch-slim

# Create app directory
WORKDIR /usr/src/app

# load test install
RUN npm install loadtest -g

# Install external app dependencies
COPY package*.json ./

RUN npm install

# Bundle app source
COPY . .

EXPOSE 8080

CMD [ "node", "server.js" ]