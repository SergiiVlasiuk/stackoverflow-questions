# [Spring batch class loaders conflict issue](https://stackoverflow.com/q/56604367/5728095)
### starting:

```
/home/sergii/.sdkman/candidates/java/current/bin/java -javaagent:/home/sergii/IDE/idea-IC-191.7479.19/lib/idea_rt.jar=34191:/home/sergii/IDE/idea-IC-191.7479.19/bin -Dfile.encoding=UTF-8 -classpath /home/sergii/Development/projects/my/spring/spring-batch-class-loader-conflict/out/production/classes:/home/sergii/Development/projects/my/spring/spring-batch-class-loader-conflict/out/production/resources:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter-batch/2.2.0.M3/fe0bb4352d0c49d9b088db13c6a89fd9619bf2dc/spring-boot-starter-batch-2.2.0.M3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-devtools/2.2.0.M3/853cb206490a2946646d4bac02446b8dc564be30/spring-boot-devtools-2.2.0.M3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/com.thoughtworks.xstream/xstream/1.4.11.1/6c120c45a8c480bb2fea5b56502e3993ddd74fd2/xstream-1.4.11.1.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-oxm/5.1.7.RELEASE/5436d5d6d56b70768d296ca691d37c533429fea0/spring-oxm-5.1.7.RELEASE.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/com.h2database/h2/1.4.199/7bf08152984ed8859740ae3f97fae6c72771ae45/h2-1.4.199.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter-jdbc/2.2.0.M3/fbd92e6461e5e37186c360f0080af27719780811/spring-boot-starter-jdbc-2.2.0.M3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter/2.2.0.M3/d858f3131933381d6661c0f08b6bd9669f581123/spring-boot-starter-2.2.0.M3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.batch/spring-batch-core/4.2.0.M2/60b52cb2d85ead44ecf7b0bf47dfeb6e672316b6/spring-batch-core-4.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/mysql/mysql-connector-java/8.0.16/6088b7a25188ab4b3ab865422a8ec77ade29236/mysql-connector-java-8.0.16.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/xmlpull/xmlpull/1.1.3.1/2b8e230d2ab644e4ecaa94db7cdedbc40c805dfa/xmlpull-1.1.3.1.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/xpp3/xpp3_min/1.1.4c/19d4e90b43059058f6e056f794f0ea4030d60b86/xpp3_min-1.1.4c.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-jdbc/5.2.0.M2/ea5a41f2b01a2a5f88426e3a509f53479e2b6c41/spring-jdbc-5.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-autoconfigure/2.2.0.M3/3d990f3a7716875013570a1ddd9c79a5dc556390/spring-boot-autoconfigure-2.2.0.M3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot/2.2.0.M3/fc0b424da418b242c3d953bd6bbf06f03bfb1925/spring-boot-2.2.0.M3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/5.2.0.M2/c85d8095c7765d8d38b9b6a357aa347b617bab79/spring-context-5.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-aop/5.2.0.M2/8deb00a5c5e18b6c594877afe4e82b8b8d64ccb/spring-aop-5.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-tx/5.2.0.M2/7042f477e471796be677f71ec63575ac7c47a749/spring-tx-5.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.batch/spring-batch-infrastructure/4.2.0.M2/b522e7c7f1c5ebb575136f149b0408462d391e22/spring-batch-infrastructure-4.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.retry/spring-retry/1.2.4.RELEASE/e5a1e629b2743dc7bbe4a8d07ebe9ff6c3b816ce/spring-retry-1.2.4.RELEASE.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-beans/5.2.0.M2/c4aa2bb803602ebc26a7ee47628f6af106e1bf55/spring-beans-5.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-core/5.2.0.M2/9a84d456ad8d5151da06fc8a85540da9cc95d734/spring-core-5.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-expression/5.2.0.M2/cdf6909ed2decf704486ca85395e97177fd7535b/spring-expression-5.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter-logging/2.2.0.M3/ae4dc76f8f14327ca3a792584f666d484f21b5/spring-boot-starter-logging-2.2.0.M3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/jakarta.annotation/jakarta.annotation-api/1.3.4/a858ec3f0ebd2b8d855c1ddded2cde9b381b0517/jakarta.annotation-api-1.3.4.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/com.zaxxer/HikariCP/3.3.1/bb447db60818ecfdbb1b99e7bd096ba7a252d91a/HikariCP-3.3.1.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-databind/2.9.8/11283f21cc480aa86c4df7a0a3243ec508372ed2/jackson-databind-2.9.8.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/io.micrometer/micrometer-core/1.1.4/96eabfe2343a4a4676d215b2122cbbc4d4b6af9b/micrometer-core-1.1.4.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/javax.batch/javax.batch-api/1.0/65392d027a6eb369fd9fcd1b75cae150e25ac03c/javax.batch-api-1.0.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.yaml/snakeyaml/1.24/13a9c0d6776483c3876e3ff9384f9bb55b17001b/snakeyaml-1.24.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.codehaus.jettison/jettison/1.2/765a6181653f4b05c18c7a9e8f5c1f8269bf9b2/jettison-1.2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.2.3/7c4f3c474fb2c041d8028740440937705ebb473a/logback-classic-1.2.3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.apache.logging.log4j/log4j-to-slf4j/2.11.2/6d37bf7b046c0ce2669f26b99365a2cfa45c4c18/log4j-to-slf4j-2.11.2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.slf4j/jul-to-slf4j/1.7.26/8031352b2bb0a49e67818bf04c027aa92e645d5c/jul-to-slf4j-1.7.26.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.26/77100a62c2e6f04b53977b9f541044d7d722693d/slf4j-api-1.7.26.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.springframework/spring-jcl/5.2.0.M2/988d5bac4a51ed2675626378ee79f8447eda2002/spring-jcl-5.2.0.M2.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-annotations/2.9.0/7c10d545325e3a6e72e06381afe469fd40eb701/jackson-annotations-2.9.0.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-core/2.9.8/f5a654e4675769c716e5b387830d19b501ca191/jackson-core-2.9.8.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.hdrhistogram/HdrHistogram/2.1.9/e4631ce165eb400edecfa32e03d3f1be53dee754/HdrHistogram-2.1.9.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.latencyutils/LatencyUtils/2.0.3/769c0b82cb2421c8256300e907298a9410a2a3d3/LatencyUtils-2.0.3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-core/1.2.3/864344400c3d4d92dfeb0a305dc87d953677c03c/logback-core-1.2.3.jar:/home/sergii/.gradle/caches/modules-2/files-2.1/org.apache.logging.log4j/log4j-api/2.11.2/f5e9a2ffca496057d6891a3de65128efc636e26e/log4j-api-2.11.2.jar org.example.springbatchclassloaderconflict.ReadingHeroesFromXmlApplication
```

### Exception:
```
2019-06-19 15:13:35.745 ERROR 7680 --- [  restartedMain] o.s.batch.core.step.AbstractStep         : Encountered an error executing step step1 in job job

java.lang.ClassCastException: class org.example.springbatchclassloaderconflict.model.HeroXml cannot be cast to class org.example.springbatchclassloaderconflict.model.HeroXml (org.example.springbatchclassloaderconflict.model.HeroXml is in unnamed module of loader 'app'; org.example.springbatchclassloaderconflict.model.HeroXml is in unnamed module of loader org.springframework.boot.devtools.restart.classloader.RestartClassLoader @38d4e83)
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.doProcess(SimpleChunkProcessor.java:134) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.transform(SimpleChunkProcessor.java:319) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.step.item.SimpleChunkProcessor.process(SimpleChunkProcessor.java:210) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.step.item.ChunkOrientedTasklet.execute(ChunkOrientedTasklet.java:75) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:407) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.step.tasklet.TaskletStep$ChunkTransactionCallback.doInTransaction(TaskletStep.java:331) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.transaction.support.TransactionTemplate.execute(TransactionTemplate.java:140) ~[spring-tx-5.2.0.M2.jar:5.2.0.M2]
	at org.springframework.batch.core.step.tasklet.TaskletStep$2.doInChunkContext(TaskletStep.java:273) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.scope.context.StepContextRepeatCallback.doInIteration(StepContextRepeatCallback.java:82) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.repeat.support.RepeatTemplate.getNextResult(RepeatTemplate.java:375) ~[spring-batch-infrastructure-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.repeat.support.RepeatTemplate.executeInternal(RepeatTemplate.java:215) ~[spring-batch-infrastructure-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.repeat.support.RepeatTemplate.iterate(RepeatTemplate.java:145) ~[spring-batch-infrastructure-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.step.tasklet.TaskletStep.doExecute(TaskletStep.java:258) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.step.AbstractStep.execute(AbstractStep.java:207) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.job.SimpleStepHandler.handleStep(SimpleStepHandler.java:148) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.job.AbstractJob.handleStep(AbstractJob.java:410) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.job.SimpleJob.doExecute(SimpleJob.java:135) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.job.AbstractJob.execute(AbstractJob.java:319) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.batch.core.launch.support.SimpleJobLauncher$1.run(SimpleJobLauncher.java:144) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.core.task.SyncTaskExecutor.execute(SyncTaskExecutor.java:50) ~[spring-core-5.2.0.M2.jar:5.2.0.M2]
	at org.springframework.batch.core.launch.support.SimpleJobLauncher.run(SimpleJobLauncher.java:137) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344) ~[spring-aop-5.2.0.M2.jar:5.2.0.M2]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198) ~[spring-aop-5.2.0.M2.jar:5.2.0.M2]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163) ~[spring-aop-5.2.0.M2.jar:5.2.0.M2]
	at org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration$PassthruAdvice.invoke(SimpleBatchConfiguration.java:127) ~[spring-batch-core-4.2.0.M2.jar:4.2.0.M2]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.2.0.M2.jar:5.2.0.M2]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212) ~[spring-aop-5.2.0.M2.jar:5.2.0.M2]
	at com.sun.proxy.$Proxy44.run(Unknown Source) ~[na:na]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.execute(JobLauncherCommandLineRunner.java:197) ~[spring-boot-autoconfigure-2.2.0.M3.jar:2.2.0.M3]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.executeLocalJobs(JobLauncherCommandLineRunner.java:169) ~[spring-boot-autoconfigure-2.2.0.M3.jar:2.2.0.M3]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.launchJobFromProperties(JobLauncherCommandLineRunner.java:155) ~[spring-boot-autoconfigure-2.2.0.M3.jar:2.2.0.M3]
	at org.springframework.boot.autoconfigure.batch.JobLauncherCommandLineRunner.run(JobLauncherCommandLineRunner.java:149) ~[spring-boot-autoconfigure-2.2.0.M3.jar:2.2.0.M3]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:820) ~[spring-boot-2.2.0.M3.jar:2.2.0.M3]
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:804) ~[spring-boot-2.2.0.M3.jar:2.2.0.M3]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:327) ~[spring-boot-2.2.0.M3.jar:2.2.0.M3]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1275) ~[spring-boot-2.2.0.M3.jar:2.2.0.M3]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1263) ~[spring-boot-2.2.0.M3.jar:2.2.0.M3]
	at org.example.springbatchclassloaderconflict.ReadingHeroesFromXmlApplication.main(ReadingHeroesFromXmlApplication.java:12) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) ~[spring-boot-devtools-2.2.0.M3.jar:2.2.0.M3]
```
---
## Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)

### Guides
The following guides illustrate how to use some features concretely:

* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

