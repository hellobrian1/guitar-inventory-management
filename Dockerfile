FROM ubuntu:latest
LABEL authors="brilo"

ENTRYPOINT ["top", "-b"]