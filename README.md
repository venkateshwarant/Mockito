# Mockito Tutorial

## Assumptions/Pre-requisites
1. Maven (v 3.6.2, or higher)
* Instructions to install here: https://maven.apache.org/download.cgi
* Check installation with the command `mvn --version`

2. Git (version 2.21.1)
* Instructions to install here: https://help.ubuntu.com/lts/serverguide/git.html
* Check installation with the command `git --version`

3. VirtualBox(v 6.0, or higher)
* Instructions to install here: https://www.virtualbox.org/wiki/Downloads 


4. Vagrant (v 2.2.5, or higher) 
* Instructions to install here: https://www.vagrantup.com/downloads.html
* (only if using Windows 10 or Windows 8 Pro) Disable Hyper-V, see instructions to disable here: https://www.poweronplatforms.com/enable-disable-hyper-v-windows-10-8/
* Check installation with the command `vagrant -v`'


## Set local working environment

1- Clone this repo

2- Import the given project into your favourite IDE

3- Build the project using Maven. Either you do it from within the IDE, or from a terminal. From the terminal you must:

3.1-  Get to the directory

```
cd ~/<git_root_folder>/Mockito_Tutorial
```

3.2- Run the comand.

```
mvn clean install
```

Running this command should shown (almost at the end of the output):

```
[INFO] BUILD SUCCESS
```


**Note**

* The project is ready to be imported on the Eclipse IDE as an existen Maven project.

## Check local testing environment setup and run the test on startup


1-  Get to the directory

```
cd ~/<git_root_folder>/Mockito_Tutorial
```

2- Start the virtual environment: 
```
 vagrant up
```


3- It will automatically install all the required dependencies and start our test. You can see the test result like below.

```
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.186 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

------------------------------------------------------------------------
[INFO] BUILD SUCCESS
------------------------------------------------------------------------
```


## Run the test manually

This is done by executing the following steps:


1-  Get to the directory

```
cd ~/<git_root_folder>/Mockito_Tutorial
```

2- Jump into the virtual environment (refered to also as *guest*) : 

```
 vagrant ssh
```

3- Jump inside the locally cloned Mockito_Tutorial 

4- Run the test:

```
mvn test
```


# Project details

## Maven dependencies

Following dependencies are used for our project 

1. junit for writing test cases
```
<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
```

2. Mockito for mocking our interfaces
```
    <dependency>
    	<groupId>org.mockito</groupId>
    	<artifactId>mockito-core</artifactId>
    	<version>1.10.19</version>
    	<scope>test</scope>
    </dependency>
```

## Creating mock objects

we have an interface named APIDataManagementInterface, which has two methods to be mocked and tested in our application. The mock object can be created in the following way.

```
APIDataManagementInterface dataAPI= Mockito.mock(APIDataManagementInterface.class);
```

## Assigning some functions to the mock objects

After creating mock objects, we should assign some mocking functionalities for it. It can be assigned as below-

```
when(dataAPI.Db_TEST_Insert("key", "value")).thenReturn(0);
```

After asssigning this mocking functionality, whenever we call the corresponding function with that exact values, it will return that corresponding mocked value.

We can return any type of object from the mock object and pass any type of objects to it.
