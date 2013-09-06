Impulse
=======

Maven archetype that initiates a Java web application for real project, based on Spring (Core, JavaConfig, Profiles), Hibernate, JPA, DBUnit, etc.

How to use
==========
1) Retrieve the sources of the Maven archetype 

```
$ git clone https://github.com/AgileSpirit/JavaBackbone.git
```

2) Compile & deploy the archetype in your local Maven repository  

```
$ mvn clean install
```

3) Generate a [JavaBackbone](https://github.com/AgileSpirit/JavaBackbone "Link to JavaBackbone project on GitHub") based project thanks to the Impulse Maven Archetype plugin  

```
mvn archetype:generate \
  -DarchetypeGroupId=com.agile.spirit \
  -DarchetypeArtifactId=impulse-java-webapp \
  -DarchetypeVersion=1.0-SNAPSHOT \
  -DgroupId=<your.group.id> \
  -DartifactId=<YourArtifactId> \
  -Dversion=your.version-NUMBER
```
