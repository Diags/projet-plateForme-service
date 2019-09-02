FROM node:12.9.1-alpine as node
COPY package*.json ./
RUN npm set progress=false && npm config set depth 0 && npm cache clean --force
RUN npm install
RUN npm install -g @angular/cli
WORKDIR /usr/src/app
COPY . /usr/src/app
