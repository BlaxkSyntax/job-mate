SHELL := bash

# clean: @ Cleans the build
clean:
	mvn clean
	docker-compose down

# compose: @ Starts Docker Compose
compose:
	docker-compose up -d

# test: @ Run all tests
test:
	mvn test

# run: @ Run the application locally
run: compose
	mvn exec:java -Dexec.mainClass="za.co.wethinkcode.web.WebServer"

get:
	git pull

add:
	git add .
	git commit -m ""
	git push