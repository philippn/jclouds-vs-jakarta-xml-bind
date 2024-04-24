# Demo Application demonstrating compatibility issues between JClouds and Jakarta XML Bind

Start application with main method in `com.example.demo.DemoApplication`.

The application should fail with: 

    org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'demoController' defined in file [...\jclouds jakarta\demo\target\classes\com\example\demo\controller\DemoController.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'blobStoreContext' defined in class path resource [com/example/demo/config/JCloudsConfig.class]: Failed to instantiate [org.jclouds.blobstore.BlobStoreContext]: Factory method 'blobStoreContext' threw exception with message: com.google.common.util.concurrent.ExecutionError: com.google.common.util.concurrent.ExecutionError: java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
    ...
    Caused by: java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
    	at java.base/java.lang.Class.getDeclaredConstructors0(Native Method) ~[na:na]
    	at java.base/java.lang.Class.privateGetDeclaredConstructors(Class.java:3373) ~[na:na]
    	at java.base/java.lang.Class.getDeclaredConstructors(Class.java:2555) ~[na:na]
    	at com.google.inject.spi.InjectionPoint.forConstructorOf(InjectionPoint.java:299) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.ConstructorBindingImpl.create(ConstructorBindingImpl.java:121) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.createUninitializedBinding(InjectorImpl.java:737) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.createJustInTimeBinding(InjectorImpl.java:982) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.createJustInTimeBindingRecursive(InjectorImpl.java:902) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.getJustInTimeBinding(InjectorImpl.java:302) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.getBindingOrThrow(InjectorImpl.java:225) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.getInternalFactory(InjectorImpl.java:996) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.FactoryProxy.notify(FactoryProxy.java:48) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.lambda$createJustInTimeBinding$0(InjectorImpl.java:988) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.createImplementedByBinding(InjectorImpl.java:854) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.createUninitializedBinding(InjectorImpl.java:726) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.createJustInTimeBinding(InjectorImpl.java:982) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.createJustInTimeBindingRecursive(InjectorImpl.java:902) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.getJustInTimeBinding(InjectorImpl.java:302) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.getBindingOrThrow(InjectorImpl.java:225) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.createParameterInjector(InjectorImpl.java:1083) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.InjectorImpl.getParametersInjectors(InjectorImpl.java:1070) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.ConstructorInjectorStore.createConstructor(ConstructorInjectorStore.java:74) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.ConstructorInjectorStore.access$000(ConstructorInjectorStore.java:29) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.ConstructorInjectorStore$1.create(ConstructorInjectorStore.java:37) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.ConstructorInjectorStore$1.create(ConstructorInjectorStore.java:33) ~[guice-7.0.0.jar:na]
    	at com.google.inject.internal.FailableCache$1.load(FailableCache.java:48) ~[guice-7.0.0.jar:na]
    	at com.google.common.cache.LocalCache$LoadingValueReference.loadFuture(LocalCache.java:3570) ~[guava-32.0.0-jre.jar:na]
    	at com.google.common.cache.LocalCache$Segment.loadSync(LocalCache.java:2312) ~[guava-32.0.0-jre.jar:na]
    	at com.google.common.cache.LocalCache$Segment.lockedGetOrLoad(LocalCache.java:2189) ~[guava-32.0.0-jre.jar:na]
    	at com.google.common.cache.LocalCache$Segment.get(LocalCache.java:2079) ~[guava-32.0.0-jre.jar:na]
    	... 131 common frames omitted
    Caused by: java.lang.ClassNotFoundException: javax.xml.bind.JAXBException
    	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641) ~[na:na]
    	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188) ~[na:na]
    	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520) ~[na:na]
    	... 161 common frames omitted
