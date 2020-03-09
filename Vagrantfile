# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/xenial64"
  config.vm.hostname = "helloworld"
  
  ENV['LC_ALL']="en_US.UTF-8"

  config.vm.network "private_network", ip: "192.168.33.15"

   config.vm.provider "virtualbox" do |vb|

        vb.memory = "8192"
    	vb.cpus = 4
   end

  
  config.vm.provision "shell", inline: <<-SHELL
     apt-get update
     sudo apt install default-jre -y
     sudo apt-get install openjdk-8-jdk -y
     sudo apt install maven  -y
     mvn -version
     java -version
     sudo apt install git -y
     git --version
     git clone https://github.com/venkateshwarant/Mockito_Tutorial.git
     cd Mockito_Tutorial/
     mvn test
     SHELL
end
