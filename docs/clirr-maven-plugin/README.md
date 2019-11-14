# MojoHaus Clirr Maven Plugin

This is the [clirr-maven-plugin](http://www.mojohaus.org/clirr-maven-plugin/).


## Releasing

* Make sure `gpg-agent` is running.
* Execute `mvn -B release:prepare release:perform`

For publishing the site do the following:

```
cd target/checkout
mvn verify site site:stage scm-publish:publish-scm
```
