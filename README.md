ServiceTalk Demo
================

ServiceTalk: a JVM network application framework with APIs tailored to specific protocols (e.g. HTTP/1.x, HTTP/2.x, etc…​) and supports multiple programming paradigms.


# Http

* Text/Plain

```
responseFactory.ok().payloadBody("Hello World!", textSerializer())
```

* text/html

```
responseFactory.ok().addHeader("Content-Type","text/html").payloadBody(buffer)
```

* JSON

```
 HttpSerializationProvider httpSerializationProvider = jsonSerializer(new JacksonSerializationProvider());
 HttpSerializer<User> userHttpSerializer = httpSerializationProvider.serializerFor(User.class);
        
responseFactory.ok().payloadBody(new User(1, "Jackie"), userHttpSerializer)))
```

* Buffer

```
responseFactory.ok().payloadBody(Buffer payloadBody);
```

# gRPC

* Create a proto file under src/main/proto
* Use protobuf-maven-plugin to compile proto files
* Implement logic

# References

* ServiceTalk Docs: https://apple.github.io/servicetalk/servicetalk/SNAPSHOT/
* ServiceTalk Example: https://github.com/apple/servicetalk/tree/master/servicetalk-examples
