FROM bellsoft/liberica-openjdk-alpine:19

USER 1000

ENTRYPOINT ["/project_name.runner/bin/project_name.runner", "/config.json"]

ADD ./build/distributions/project_name.runner.tar /
