# Spring Profile Test

The other day I was working on an application that needed to be enabled for multiple deployment strategies. The default deployment is based on Weblogic. The alternative, new strategy leverages - amongst others - [Grizzly](https://javaee.github.io/grizzly/). The application architecture initially had some elements that specifically used services which were provided for by Weblogic/Java EE. The alternative however does not have these services. Because we wanted to still have a single code base, we needed a way to activate specific Spring components based on the actual deployment. For this purpose we investigated the use of [Spring Profiles](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html).

This project provides some insight of this actually works in practice. Basically we declare a 2 profiles (besides the already present `default` profile, provided for by Spring). We then use these profiles to individual tag specific Spring configuration assets. Then depending on which profile(s) is (are) activated - particular components are put into play.

The [AbstractProfileTest](src/test/java/AbstractProfileTest.java), would be a good point to start checking the code.
