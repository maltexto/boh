# Makefile add deatch docker

build-war:
	mvn clean package

build-docker:
	docker build -t boh:test .

run-docker:
	docker run -p 8080:8080 --name vouContratarEsseCara boh:test

stop-container:
	docker stop vouContratarEsseCara
	docker rm vouContratarEsseCara

rm-image:
	docker rmi boh:test

rm-target:
	rm -r ./target


run: build-war build-docker run-docker

clean: stop-container rm-image rm-target

.PHONY: build-docker run-docker build-war stop-container remove-image all clean
