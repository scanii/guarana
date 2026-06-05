.PHONY: build package clean

build:
	mvn -q -DskipTests clean package

package:
	sam package \
		--s3-bucket scanii-assets \
		--s3-prefix sam/guarana \
		--template-file template.yml \
		--output-template-file guarana.yaml

clean:
	mvn -q clean
	rm -f guarana.yaml
