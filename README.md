# add the following code in build.gradle to execute Main() in src/main/java/.../Testing.java
task(runTesting, dependsOn: 'classes', type: JavaExec) {
    main = 'com.backend.books.Testing'
    classpath = sourceSets.main.runtimeClasspath
    args 'starmap'
    systemProperty 'simple.message', 'Hello '
}

defaultTasks 'runTesting'

# run the following command to execute the Main() method of src/main/java/.../Testing.java
gradle

# the corresponding URL of the RESTful query: the query should return a JSON string
http://localhost:8080/api/v1/items/

# build and execute java in src/main/webapp/
gradle jettyRun

# Reload vagrant provision
vagrant reload --provision

# Start/Stop vagrant
vagrant up
vagrant destroy
